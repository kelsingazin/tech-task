--liquibase formatted sql
--changeset kelsingazin:create-table-products-02
create table products
(
    id          bigserial PRIMARY KEY,
    name        varchar(255) NOT NULL,
    description varchar(255),
    price       NUMERIC(10, 2),
    created_at  TIMESTAMP DEFAULT NOW(),
    deleted_at  TIMESTAMP,
    updated_at  TIMESTAMP
);
