--liquibase formatted sql
--changeset kelsingazin:insert-table-users-04
INSERT INTO users(username, email, encrypted_password)
VALUES ('danilkim', 'dkim@gmail.com', '$2a$10$6bnfFOAUHwoXn3T5Q/ND8OTk3/UVBEzVkQ.YntiHfg33gQrgw9X0m'),
       ('marina1', 'molegovna@gmail.com', '$2a$10$6bnfFOAUHwoXn3T5Q/ND8OTk3/UVBEzVkQ.YntiHfg33gQrgw9X0m'),
       ('timcook', 'timmy1@gmail.com', '$2a$10$6bnfFOAUHwoXn3T5Q/ND8OTk3/UVBEzVkQ.YntiHfg33gQrgw9X0m');
