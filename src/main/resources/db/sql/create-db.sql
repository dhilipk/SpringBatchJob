CREATE TABLE users (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);
CREATE TABLE PAYMENT_PROGRAM (
  id         INTEGER PRIMARY KEY,
  PROGRAM_NAME VARCHAR(30),
  PROGRAM_AMT  DOUBLE,
  TENURE  INTEGER
);