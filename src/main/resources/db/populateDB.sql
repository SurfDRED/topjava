DELETE FROM users;
DELETE FROM user_roles;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (user_id, date_time, description, calories)
VALUES (100000, TIMESTAMP '2020-01-30 09:50:00', 'Завтрак пользователя', 259),
       (100000, TIMESTAMP '2020-01-30 12:25:00', 'Обед пользователя', 678),
       (100000, TIMESTAMP '2020-01-30 20:35:00', 'Ужин пользователя', 300),
       (100000, TIMESTAMP '2020-01-31 00:00:00', 'Еда на граничное значение пользователя', 150),
       (100000, TIMESTAMP '2020-01-31 09:55:00', 'Завтрак пользователя', 345),
       (100000, TIMESTAMP '2020-01-31 13:25:00', 'Обед пользователя', 1500),
       (100000, TIMESTAMP '2020-01-31 20:35:00', 'Ужин пользователя', 550),
       (100001, TIMESTAMP '2020-01-30 10:00:00', 'Завтрак админа', 150),
       (100001, TIMESTAMP '2020-01-30 13:00:00', 'Обед админа', 1000),
       (100001, TIMESTAMP '2020-01-30 20:00:00', 'Ужин админа', 250),
       (100001, TIMESTAMP '2020-01-31 00:00:00', 'Еда на граничное значение админа', 390),
       (100001, TIMESTAMP '2020-01-31 10:00:00', 'Завтрак админа', 350),
       (100001, TIMESTAMP '2020-01-31 13:25:00', 'Обед админа', 1500),
       (100001, TIMESTAMP '2020-01-31 20:00:00', 'Ужин админа', 560);