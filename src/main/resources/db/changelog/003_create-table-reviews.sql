--liquibase formatted sql
--changeset kelsingazin:create-table-reviews-03
create table reviews
(
    id         bigserial PRIMARY KEY,
    rating     DOUBLE PRECISION NOT NULL,
    comment    TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    deleted_at TIMESTAMP,
    updated_at TIMESTAMP,
    user_id    BIGINT REFERENCES users (id),
    product_id BIGINT REFERENCES products (id)
);
