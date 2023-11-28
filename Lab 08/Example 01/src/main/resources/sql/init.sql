CREATE TABLE users (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    delivery_address VARCHAR(255),
    company VARCHAR(255),
    address VARCHAR(255),
    role VARCHAR(255)
);