CREATE TABLE animal ( id INTEGER(50) NOT NULL PRIMARY KEY, specie VARCHAR(50) NOT NULL, name VARCHAR(50000) NOT NULL, code INTEGER NOT NULL);
INSERT INTO animal values(1,'Mamifero','Pepe',12);
INSERT INTO animal values(2,'Mamifero','Pepe',13);
INSERT INTO animal values(3,'Mamifero','Pepe',14);
INSERT INTO animal values(4,'Mamifero','Pepe',15);
INSERT INTO animal values(5,'Mamifero','Pepe',18);
INSERT INTO animal values(6,'Mamifero','Pepe',18);
INSERT INTO animal values(7,'Mamifero','Pepe1',18);

DELIMITER $$
CREATE PROCEDURE GET_ANIMALS(IN id INT, IN specie VARCHAR(50), IN name VARCHAR(50), IN code INT)
BEGIN
   INSERT INTO animal values(id,specie,name,code);
END $$
DELIMITER;
DELIMITER $$
CREATE PROCEDURE GET_ANIMAL(IN code_in INT, OUT count INT)
BEGIN
   SELECT COUNT(*) into count  from animal where code = code_in;
END $$
DELIMITER;