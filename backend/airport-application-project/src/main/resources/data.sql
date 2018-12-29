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
VALUES ('1994/11/12', null, '$2a$10$nqkopLGFNg/LdpPy/TfjWOVsaFi/zcYv/6dUGMrwsX24upEUfRv6W', '4400', 1, 1);

INSERT INTO employee (fire_date, hire_date, password, salary, function_fk, person_fk)
VALUES ('1996/11/12', null, '$2a$10$DuvURvIGYl.KgblNUpHUSuuVKRsJmxhv47.53h4T54uvgP0GdOpx2', '4400', 2, 2);


INSERT INTO role (role) VALUES ('ROLE_PILOT');

INSERT INTO employee_roles (user_id, employee_id) VALUES (1,1);
INSERT INTO employee_roles (user_id, employee_id) VALUES (2,2);

