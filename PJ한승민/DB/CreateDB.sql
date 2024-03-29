
------------------------------------------------------
CREATE TABLE center_member(
    id VARCHAR2(20) PRIMARY KEY,
    pwd VARCHAR2(20) NOT NULL,
    name VARCHAR2(20) NOT NULL,
    gender VARCHAR2(10) NOT NULL,
    birthdate Date NOT NULL,
    address VARCHAR2(100)

);
------------------------------------------------------
ALTER TABLE center_member ADD COUNT_CLASS NUMBER(4,0) DEFAULT 0;
--------------------------------------------------------------------
COMMIT;

insert into center_member (id, pwd, name,gender, birthdate, address)
VALUES ('12', '21', '홍길동',  'man', '1999/01/13', 'adf');

insert into center_member (id, pwd, name,gender, birthdate, address)
VALUES ('oracle', '1234', '관리자',  'None', '9999-01-01', 'None');

SELECT *
FROM center_member;
DROP TABLE center_member;

------------------------------------------------------
CREATE TABLE education_class(
    classNum NUMBER(5,0) PRIMARY KEY, 
    title VARCHAR2(20) UNIQUE,
    professor VARCHAR(20),
    max_num NUMBER(4,0),
    current_num NUMBER(4,0) 
);
------------------------------------------------------

insert into education_class (classNum, title, professor, max_num)
VALUES (1, '국어', '김박사',  5);

insert into education_class (classNum, title, professor, max_num)
VALUES (2, '영어', '홍길동',  4);

insert into education_class (classNum, title, professor, max_num)
VALUES (3, '수학', '이박사',  5);


DROP TABLE education_class;


------------------------------------------------------
CREATE TABLE enrolment(
    member_id VARCHAR(20) NOT NULL,
    class_title VARCHAR(20) NOT NULL,
    FOREIGN KEY(member_id) REFERENCES center_member(id),
    FOREIGN KEY(class_title) REFERENCES education_class(title)
);
------------------------------------------------------

DROP TABLE enrolment;

SELECT COUNT(*) as cnt
FROM enrolment
WHERE MEMBER_ID = '12'
GROUP BY MEMBER_ID;


INSERT INTO enrolment (member_id, class_title)
VALUES('12', '영어');

SELECT *
FROM enrolment;

COMMIT;


DELETE FROM enrolment
WHERE member_id = 12 AND class_title = '국어';

UPDATE education_class
SET current_num = current_num+1;


SELECT *
FROM center_member;

SELECT *
FROM education_class;

SELECT max_num
FROM education_class
WHERE title = '국어';
-------------------------------------------
UPDATE education_class
SET current_num = 0
WHERE title = '수학';

UPDATE education_class
SET current_num = 0
WHERE title = '국어';

UPDATE education_class
SET current_num = 0
WHERE title = '영어';
---------------------------------------


SELECT  c.id,
        c.pwd, 
        c.name,
        c.gender,
        c.birthdate,
        c.address,
        e.class_title
FROM center_member c
    LEFT OUTER JOIN enrolment e
        ON c.id = e.member_id;




--------------------------------------------------------------
CREATE TABLE boardVO(
    board_title VARCHAR2(30),
    member_id VARCHAR2(20),
    content VARCHAR2(1000),
    write_date DATE DEFAULT SYSDATE,
    FOREIGN KEY(member_id) REFERENCES center_member(id)
);

----------------------------------------------------------------
DROP TABLE boardVO;
SELECT board_title, member_id, write_date;