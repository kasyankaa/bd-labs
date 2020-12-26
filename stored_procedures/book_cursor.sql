CREATE DEFINER=`kasyanka`@`localhost` PROCEDURE `creating_random_tables for books`()
BEGIN
   DECLARE table1  varchar(45);
   DECLARE table2 varchar(45);
   DECLARE done int DEFAULT false;
   DECLARE id int;
   DECLARE name varchar(45);
   DECLARE authors varchar(45);
   DECLARE udk_index int;
   DECLARE rate double;
   DECLARE directory_tree_id int;
   DECLARE BookCursor CURSOR
   FOR SELECT * FROM book;
   DECLARE CONTINUE HANDLER
   FOR NOT FOUND SET done = true;
   
   SET table1 = CONCAT("book1-",NOW());
   SET table2 = CONCAT("book2-",NOW());
   SET @temp_query =CONCAT ("Create table `",table1,"` (
    id int not null PRIMARY KEY,
	name varchar(45) not null,
    authors varchar(45) not null,
    udk_index int not null,
    rate double not null,
    directory_tree_id int not null
);");
PREPARE my_query from @temp_query;
EXECUTE my_query;
DEALLOCATE PREPARE my_query;
 SET @temp_query =CONCAT ("Create table `",table2,"` (
    id int not null PRIMARY KEY,
	name varchar(45) not null,
    authors varchar(45) not null,
    udk_index int not null,
    rate double not null,
    directory_tree_id int not null
);");
PREPARE my_query from @temp_query;
EXECUTE my_query;
DEALLOCATE PREPARE my_query;

OPEN BookCursor;
myLoop: LOOP
    FETCH BookCursor INTO id,name,authors, udk_index,rate, directory_tree_id;
        IF done = true THEN LEAVE myLoop;
        END IF;
        SET @rand = RAND();
        if @rand>0.5 then 
        BEGIN
        SET @temp_query =CONCAT ("insert into `",table1,"` VALUES (",id,",'",name,"','",authors,"',",udk_index,",",rate,",",directory_tree_id,");");
PREPARE my_query from @temp_query;
EXECUTE my_query;
DEALLOCATE PREPARE my_query;
        END;
        else  
        BEGIN
        SET @temp_query =CONCAT ("insert into `",table2,"` VALUES (",id,",'",name,"','",authors,"',",udk_index,",",rate,",",directory_tree_id,");");
        PREPARE my_query from @temp_query;
        EXECUTE my_query;
        DEALLOCATE PREPARE my_query;
        END;
        END if;
  END LOOP;
    CLOSE BookCursor;
END