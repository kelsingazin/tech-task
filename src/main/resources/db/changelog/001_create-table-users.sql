--liquibase formatted sql
--changeset kelsingazin:create-table-users-01
create table users
(
    id                 bigserial PRIMARY KEY,
    username           varchar(255) NOT NULL,
    email              varchar(255) NOT NULL,
    encrypted_password varchar(255) NOT NULL,
    created_at         TIMESTAMP DEFAULT NOW(),
    deleted_at         TIMESTAMP,
    updated_at         TIMESTAMP
);
