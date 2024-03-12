--liquibase formatted sql
--changeset kelsingazin:insert-table-products-05
INSERT INTO products(name, description, price)
VALUES ('laptop', 'technique', 12000),
       ('smartphone', 'calling device', 15000),
       ('monitor', 'screen', 10500);
