DROP TRIGGER IF EXISTS AfterInsertMarkedBook;
DELIMITER //
CREATE TRIGGER AfterInsertMarkedBook
After INSERT ON user_marked_book For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(id) into value1 from book where book.id = new.book_id;
    select count(id) into value2 from user where user.id = new.user_id;
	if value1 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No book for this user).';
    end if;
	if value2 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No user for this book).';
    end if;
End//

DELIMITER ;