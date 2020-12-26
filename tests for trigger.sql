DELETE FROM password where id =1;
UPDATE password SET password.password="1234" WHERE id=2;
DELETE FROM user where id between 2 and 4;
UPDATE user SET user.login="kikita" WHERE id=1;
DELETE FROM book where id =2;
UPDATE book SET book.name="IT" WHERE id=4;
DELETE FROM directory_tree where id =2;
UPDATE directory_tree SET directory_tree.rubric="random" WHERE id=1;
