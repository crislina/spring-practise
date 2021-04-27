drop table employee;
drop table department;

CREATE TABLE `practise`.`department` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `practise`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `department_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `deparment_id_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `deparment`
    FOREIGN KEY (`department_id`)
    REFERENCES `practise`.`department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `department` (`name`)
VALUES
('Tech'),('Marketing'),('Sales'),('Finance');

INSERT INTO `employee` (`name`, `department_id`)
VALUES
("Thomas",1),
("Miller",1),
("Johnson",2),
("Mike",2),
("Vincent",3),
("Charles",3),
("Alex",4);