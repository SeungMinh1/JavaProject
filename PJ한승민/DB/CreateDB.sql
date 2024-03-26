CREATE TABLE center_member(
    id VARCHAR2(20) primary key,
    pwd VARCHAR2(20) NOT NULL,
    name VARCHAR2(20) NOT NULL,
    gender VARCHAR2(10) NOT NULL,
    birthdate Date NOT NULL,
    address VARCHAR2(100)
);


CREATE TABLE education_class(
    title VARCHAR2(20)
    
)