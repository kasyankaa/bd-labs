DROP TRIGGER IF EXISTS AfterDeleteDirectory;
DROP TRIGGER IF EXISTS AfterUpdateDirectory;
DROP TRIGGER IF EXISTS AfterInsertDirectory;
DELIMITER //
CREATE TRIGGER AfterDeleteDirectory
After DELETE ON directory_tree For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(directory_tree_id) into value1 from book where book.directory_tree_id = old.id;
    select count(directory_tree_id) into value2 from directory_tree where directory_tree.directory_tree_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in book).';
	end if;
	if value2 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in directory tree).';    
    end if;
End//
CREATE TRIGGER AfterUpdateDirectory
After UPDATE ON directory_tree For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(directory_tree_id) into value1 from book where book.directory_tree_id = old.id;
    select count(directory_tree_id) into value2 from directory_tree where directory_tree.directory_tree_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in book).';
	end if;
	if value2 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in directory tree).';    
    end if;
End//
CREATE TRIGGER AfterInsertDirectory
After INSERT ON directory_tree For Each row 
Begin
	Declare value1 int;
	select count(id) into value1 from directory_tree where directory_tree.id = new.directory_tree_id;
	if value1 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No directory for this directory).';
    end if;
End//


DELIMITER ;