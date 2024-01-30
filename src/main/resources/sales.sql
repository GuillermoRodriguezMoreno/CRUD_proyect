DROP DATABASE IF EXISTS sales;
CREATE DATABASE sales CHARACTER SET utf8mb4;
USE sales;

CREATE TABLE client (
                         id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         lastname1 VARCHAR(100) NOT NULL,
                         lastname2 VARCHAR(100),
                         city VARCHAR(100),
                         category INT UNSIGNED,
                         email varchar(100)
);

CREATE TABLE commercial (
                           id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           lastname1 VARCHAR(100) NOT NULL,
                           lastname2 VARCHAR(100),
                           commission FLOAT
);

CREATE TABLE `order` (
                        id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                        total DOUBLE NOT NULL,
                        date DATE,
                        client_id INT UNSIGNED NOT NULL,
                        commercial_id INT UNSIGNED NOT NULL,
                        FOREIGN KEY (client_id) REFERENCES client(id),
                        FOREIGN KEY (commercial_id) REFERENCES commercial(id)
);

INSERT INTO client VALUES(1, 'Aarón', 'Rivero', 'Gómez', 'Almería', 100, 'some@example.es');
INSERT INTO client VALUES(2, 'Adela', 'Salas', 'Díaz', 'Granada', 200, 'some@example.es');
INSERT INTO client VALUES(3, 'Adolfo', 'Rubio', 'Flores', 'Sevilla', NULL, 'some@example.es');
INSERT INTO client VALUES(4, 'Adrián', 'Suárez', NULL, 'Jaén', 300, 'some@example.es');
INSERT INTO client VALUES(5, 'Marcos', 'Loyola', 'Méndez', 'Almería', 200, 'some@example.es');
INSERT INTO client VALUES(6, 'María', 'Santana', 'Moreno', 'Cádiz', 100, 'some@example.es');
INSERT INTO client VALUES(7, 'Pilar', 'Ruiz', NULL, 'Sevilla', 300, 'some@example.es');
INSERT INTO client VALUES(8, 'Pepe', 'Ruiz', 'Santana', 'Huelva', 200, 'some@example.es');
INSERT INTO client VALUES(9, 'Guillermo', 'López', 'Gómez', 'Granada', 225, 'some@example.es');
INSERT INTO client VALUES(10, 'Daniel', 'Santana', 'Loyola', 'Sevilla', 125, 'some@example.es');

INSERT INTO commercial VALUES(1, 'Daniel', 'Sáez', 'Vega', 0.15);
INSERT INTO commercial VALUES(2, 'Juan', 'Gómez', 'López', 0.13);
INSERT INTO commercial VALUES(3, 'Diego','Flores', 'Salas', 0.11);
INSERT INTO commercial VALUES(4, 'Marta','Herrera', 'Gil', 0.14);
INSERT INTO commercial VALUES(5, 'Antonio','Carretero', 'Ortega', 0.12);
INSERT INTO commercial VALUES(6, 'Manuel','Domínguez', 'Hernández', 0.13);
INSERT INTO commercial VALUES(7, 'Antonio','Vega', 'Hernández', 0.11);
INSERT INTO commercial VALUES(8, 'Alfredo','Ruiz', 'Flores', 0.05);

INSERT INTO `order` VALUES(1, 150.5, '2017-10-05', 5, 2);
INSERT INTO `order` VALUES(2, 270.65, '2016-09-10', 1, 5);
INSERT INTO `order` VALUES(3, 65.26, '2017-10-05', 2, 1);
INSERT INTO `order` VALUES(4, 110.5, '2016-08-17', 8, 3);
INSERT INTO `order` VALUES(5, 948.5, '2017-09-10', 5, 2);
INSERT INTO `order` VALUES(6, 2400.6, '2016-07-27', 7, 1);
INSERT INTO `order` VALUES(7, 5760, '2015-09-10', 2, 1);
INSERT INTO `order` VALUES(8, 1983.43, '2017-10-10', 4, 6);
INSERT INTO `order` VALUES(9, 2480.4, '2016-10-10', 8, 3);
INSERT INTO `order` VALUES(10, 250.45, '2015-06-27', 8, 2);
INSERT INTO `order` VALUES(11, 75.29, '2016-08-17', 3, 7);
INSERT INTO `order` VALUES(12, 3045.6, '2017-04-25', 2, 1);
INSERT INTO `order` VALUES(13, 545.75, '2019-01-25', 6, 1);
INSERT INTO `order` VALUES(14, 145.82, '2017-02-02', 6, 1);
INSERT INTO `order` VALUES(15, 370.85, '2019-03-11', 1, 5);
INSERT INTO `order` VALUES(16, 2389.23, '2019-03-11', 1, 5);
insert into `order` (total, date, client_id, commercial_id)
values (100, '2024-01-2', 1, 1);
insert into `order` (total, date, client_id, commercial_id)
values (200, '2023-08-2', 1, 1);
insert into `order` (total, date, client_id, commercial_id)
values (300, '2023-03-2', 1, 2);
insert into `order` (total, date, client_id, commercial_id)
values (400, '2021-01-2', 1, 3);