CREATE DEFINER=`kasyanka`@`localhost` PROCEDURE `selection_of_marked_books`(in book_name varchar(45))
BEGIN
if book_name ="" 
then
 SELECT  login , book.name FROM user_marked_book
 JOIN user on user.id=user_marked_book.user_id
 JOIN book on book.id=user_marked_book.book_id;
else
 SELECT login , book.name FROM user_marked_book
 JOIN user on user.id=user_marked_book.user_id
 JOIN book on book.id=user_marked_book.book_id
 Where book.name = book_name or book.name LIKE CONCAT("%",book_name,"%");
 END IF;
END