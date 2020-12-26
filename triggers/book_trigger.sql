DROP TRIGGER IF EXISTS AFterDeleteBook;
DROP TRIGGER IF EXISTS AfterUpdateBook;
DROP TRIGGER IF EXISTS AfterInsertBook;
DELIMITER //
CREATE TRIGGER AFterDeleteBook
After DELETE ON book For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(book_id) into value1 from user_marked_book where user_marked_book.book_id = old.id;
    select count(book_id) into value2 from reference where reference.book_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in user_marked_book).';
	end if;
	if value2 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in reference).';    
    end if;
End//
CREATE TRIGGER AfterUpdateBook
After UPDATE ON book For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(book_id) into value1 from user_marked_book where user_marked_book.book_id = old.id;
	select count(book_id) into value2 from reference where reference.book_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in user_marked_book).';
	end if;
	if value2 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in reference).';    
    end if;
End//
CREATE TRIGGER AfterInsertBook
After INSERT ON book For Each row 
Begin
	Declare value1 int;
	select count(id) into value1 from directory_tree where directory_tree.id = new.directory_tree_id;
	if value1 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No directory for this book).';
    end if;
End//

DELIMITER ;