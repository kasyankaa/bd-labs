CREATE DEFINER=`kasyanka`@`localhost` FUNCTION `book_from_reference`(reference_id int) RETURNS varchar(100) CHARSET latin1
BEGIN
RETURN (SELECT CONCAT('"',name,'"'," ",authors) AS book FROM reference
JOIN book on book.id=reference.book_id
WHERE reference_id = reference.id );

END