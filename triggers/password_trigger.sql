DROP TRIGGER IF EXISTS AfterDeletePassword;
DROP TRIGGER IF EXISTS AfterUpdatePassword;
DELIMITER //
CREATE TRIGGER AfterDeletePassword
After DELETE ON password For Each row 
Begin
	Declare value1 int;
	select count(password_id) into value1 from user where user.password_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in user).';
    end if;
End//
CREATE TRIGGER AfterUpdatePassword
After UPDATE ON password For Each row 
Begin
	Declare value1 int;
	select count(password_id) into value1 from user where user.password_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in user).';
    end if;
End//

DELIMITER ;