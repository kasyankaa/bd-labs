DROP TRIGGER IF EXISTS AfterDeleteUser;
DROP TRIGGER IF EXISTS AfterUpdateUser;
DROP TRIGGER IF EXISTS AfterInsertUser;
DROP TRIGGER IF EXISTS UserCardinality;

DELIMITER //
CREATE TRIGGER AfterDeleteUser
After DELETE ON user For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(user_id) into value1 from user_marked_book where user_marked_book.user_id = old.id;
    select count(*) into value2 from user;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in user_marked_book).';
    end if;
    if value2 < 2 then
		signal sqlstate '45000' set message_text = 'Error Cardinality (Should be at least 2 users).';
    end if;
    
End//
CREATE TRIGGER AfterUpdateUser
After UPDATE ON user For Each row 
Begin
	Declare value1 int;
	select count(user_id) into value1 from user_marked_book where user_marked_book.user_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in user_marked_book).';
    end if;
End//
CREATE TRIGGER AfterInsertUser
After INSERT ON user For Each row 
Begin
	Declare value1 int;
    Declare value2 varchar(45);
    Declare value3 int;

	select count(id) into value1 from password where password.id = new.password_id;
	select login into value2 from user where user.login = new.login;
    select rate into value3 from user where user.rate= new.rate;
    
	if new.login  RLIKE "^[0-9].+" then
			signal sqlstate '45000' set message_text = "INSERT Error (login can't start with number).";
	end if;
	if length(new.login)<6 then
			signal sqlstate'45000' set message_text = "INSERT Error (login is too short).";
	end if;
    if new.rate  not between 1 and 10 then
			signal sqlstate'45000' set message_text = "INSERT Error (rate should be between 1 and 10).";
	end if;
        
	if value1 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No password for this user).';
    end if;
End//
 