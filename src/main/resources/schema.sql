-- Drop table if it already exists to ensure a clean start for development
DROP TABLE IF EXISTS employees;

-- Create the employees table
CREATE TABLE employees (
    id BIGSERIAL PRIMARY KEY, -- BIGSERIAL for auto-incrementing long IDs in PostgreSQL
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL, -- Email should be unique
    position VARCHAR(255),
    department VARCHAR(255),
    age INT
);
