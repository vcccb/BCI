-------------------------------------------------------------------
DROP TABLE IF EXISTS TESTBCIPHONES;
CREATE TABLE TESTBCIPHONES(
                              ID UUID PRIMARY KEY ,
                              IDUSER UUID,
                              NUMBER VARCHAR(255),
                              CITYCODE VARCHAR(255),
                              COUNTRYCODE VARCHAR(255)
);

INSERT INTO TESTBCIPHONES VALUES('550e8400-e29b-41d4-a716-446655440000','550e8400-e29b-41d4-a716-446655440000','1234567','1','57');

select * from TESTBCIPHONES ;
------------------------------------------------------------------

DROP TABLE IF EXISTS TESTBCIUSER;
CREATE TABLE TESTBCIUSER(
                            UUIDUSER UUID PRIMARY KEY,
                            NAME VARCHAR(255),
                            EMAIL VARCHAR(255),
                            PASSWORD VARCHAR(255),
                            ISACTIVE Boolean,
                            CREATED DATE,
                            LASTMODIFIED DATE,
                            LASTLOGIN DATE
);


INSERT INTO TESTBCIUSER VALUES('550e8400-e29b-41d4-a716-446655440000', 'VICTOR','a@a.cl','1234567',true,'2022-09-30','2022-09-30','2022-09-30');
SELECT * FROM TESTBCIUSER ;
--------------------------------------------------------------------