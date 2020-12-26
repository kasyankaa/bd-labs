DROP TRIGGER IF EXISTS AfterInsertReference;
DELIMITER //
CREATE TRIGGER AfterInsertReference
After INSERT ON reference For Each row 
Begin
	Declare value1 int;
	select count(id) into value1 from book where book.id = new.id;
	if value1 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No book for this reference).';
    end if;
End//

DELIMITER ;