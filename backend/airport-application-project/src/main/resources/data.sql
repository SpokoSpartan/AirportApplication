INSERT INTO role (role) VALUES ('ROLE_EMPLOYEE');
INSERT INTO role (role) VALUES ('ROLE_ADMIN');

INSERT INTO person (city, email, id_card_number, name, phone_number, surname)
VALUES ('Wroclaw', 'wojtekspoton@gmail.com', 'wer2224', 'Wojtek', '123456789', 'Spoton');

INSERT INTO person (city, email, id_card_number, name, phone_number, surname)
VALUES ('Wroclaw', 'stanisławdrelich@gmail.com', 'wer2324', 'Stanisław', '123456789', 'Drelich');

INSERT INTO function (minimum_salary, name)
VALUES ('2400', 'Pilot');

INSERT INTO function (minimum_salary, name)
VALUES ('1600', 'Admin');

INSERT INTO employee (fire_date, hire_date, password, salary, function_fk, person_fk)
VALUES ('2019-02-23 15:21:20.471804', null, '$2a$10$w0iOFqPmVyxznT9klwEg4.D2KZfS1GXbmQ2otqqXYGy9IuYVLsPBm', '4400', 1, 1);

INSERT INTO employee (fire_date, hire_date, password, salary, function_fk, person_fk)
VALUES ('2019-02-23 15:21:20.471804', null, '$2a$10$DuvURvIGYl.KgblNUpHUSuuVKRsJmxhv47.53h4T54uvgP0GdOpx2', '4400', 2, 2);

INSERT INTO employee_roles (user_id, employee_id) VALUES (1,1);
INSERT INTO employee_roles (user_id, employee_id) VALUES (2,2);

INSERT INTO airport (city, name) VALUES ('Wrocław', 'Wrocławskie Lotnisko');
INSERT INTO airport (city, name) VALUES ('Warszawa', 'Warszawskie Lotnisko');
INSERT INTO airport (city, name) VALUES ('Radom', 'Radomskie Lotnisko');
INSERT INTO airport (city, name) VALUES ('Lublin', 'Lublińskie Lotnisko');
INSERT INTO airport (city, name) VALUES ('Granowiec', 'Granowieckie Lotnisko');
INSERT INTO airport (city, name) VALUES ('Poznań', 'Poznańskie Lotnisko');
INSERT INTO airport (city, name) VALUES ('Kraków', 'Krakowskie Lotnisko');

INSERT INTO plane (capacity, manufacturer, number_of_hostess, number_of_pilots, version)
VALUES (54, 'Polonez', 2, 2, 'V2.1');

INSERT INTO plane (capacity, manufacturer, number_of_hostess, number_of_pilots, version)
VALUES (32, 'Fiat', 4, 2, 'V5.0');

INSERT INTO plane (capacity, manufacturer, number_of_hostess, number_of_pilots, version)
VALUES (30, 'Mercedes', 3, 2, 'V1.0');

INSERT INTO plane (capacity, manufacturer, number_of_hostess, number_of_pilots, version)
VALUES (50, 'Ursus', 3, 2, 'V1.0');

INSERT INTO plane (capacity, manufacturer, number_of_hostess, number_of_pilots, version)
VALUES (40, 'Samolotus', 3, 2, 'V2.0');

INSERT INTO plane (capacity, manufacturer, number_of_hostess, number_of_pilots, version)
VALUES (32, 'Drelichów', 2, 2, 'V4.3');

INSERT INTO course (arrival_date, available_places,
                    departure_date, price, end_fk, plane_fk, start_fk)
VALUES ('2019-02-23 15:21:20.471804', 45, '2019-02-23 15:21:20.471804', '92.80', 2, 1, 1);

INSERT INTO course (arrival_date, available_places,
                    departure_date, price, end_fk, plane_fk, start_fk)
VALUES ('2019-02-23 15:21:20.471804', 21, '2019-02-23 15:21:20.471804', '32.60', 1, 5, 4);

INSERT INTO course (arrival_date, available_places,
                    departure_date, price, end_fk, plane_fk, start_fk)
VALUES ('2019-02-23 15:21:20.471804', 12, '2019-02-23 15:21:20.471804', '54.40', 2, 4, 1);

INSERT INTO course (arrival_date, available_places,
                    departure_date, price, end_fk, plane_fk, start_fk)
VALUES ('2019-02-23 15:21:20.471804', 16, '2019-02-23 15:21:20.471804', '72.80', 2, 5, 2);

INSERT INTO course (arrival_date, available_places,
                    departure_date, price, end_fk, plane_fk, start_fk)
VALUES ('2019-02-23 15:21:20.471804', 29, '2019-02-23 15:21:20.471804', '67.29', 2, 4, 3);
