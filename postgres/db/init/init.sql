CREATE SCHEMA example_schema;

CREATE TABLE example_schema.example_table
(
                       id SERIAL PRIMARY KEY,
                       full_name character varying(255) NOT NULL UNIQUE,
                       age int NOT NULL,
                       created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO example_schema.example_table (id, full_name, age)VALUES
                                                                         (1, 'Bob Smith', 22),
                                                                         (2, 'Dave Johnson', 36),
                                                                         (3, 'Mark Thompson', 28);
