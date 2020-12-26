CREATE DEFINER=`kasyanka`@`localhost` PROCEDURE `insertion_values_to_users`( in login varchar(45),in surname varchar(45),
in name varchar(45),in middle_name varchar(45),in birth_date date,
in birth_place varchar(45), in home_place varchar(45),
in remark varchar(45),in rate int,in password_id int)
BEGIN
INSERT INTO user(`login`,`surname` , `name`, `middle_name` ,`birth_date` , `birth_place`, `home_place`, `remark`, `rate`, `password_id`) VALUES
(login, surname , name, middle_name , birth_date , birth_place, home_place, remark, rate, password_id);
END