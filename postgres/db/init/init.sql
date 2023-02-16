CREATE SCHEMA example_schema;

CREATE TABLE example_schema.example_table
(
    id NUMERIC PRIMARY KEY,
    full_name character varying(255) NOT NULL UNIQUE,
    age int NOT NULL,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE SEQUENCE example_schema.example_sequence
    AS INTEGER
    INCREMENT BY 1
    START WITH 1
    OWNED BY example_schema.example_table.id
;



INSERT INTO example_schema.example_table (id, full_name, age)VALUES
                                             (nextVal('example_schema.example_sequence'), 'Bob Smith', 22),
                                             (nextVal('example_schema.example_sequence'), 'Dave Johnson', 36),
                                             (nextVal('example_schema.example_sequence'), 'Mark Thompson', 28);
