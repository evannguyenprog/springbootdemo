DROP TABLE IF EXISTS dog;

CREATE TABLE dog (
  id SERIAL PRIMARY KEY,
    name VARCHAR(250),
    breed VARCHAR(250),
    gender VARCHAR(250),
    age INT
);

