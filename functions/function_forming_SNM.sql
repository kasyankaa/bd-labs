CREATE DEFINER=`kasyanka`@`localhost` FUNCTION `forming_snm_for_user`(user_id int) RETURNS varchar(45) CHARSET latin1
BEGIN
RETURN (SELECT CONCAT(substring(name,1,1),substring(surname,1,1),substring(middle_name,1,1)) AS smn 
FROM user 
WHERE id=user_id);
END