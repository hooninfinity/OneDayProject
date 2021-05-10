-- 여기는 다이어트 접속
-- 가공식품 영양정보 엑셀 파일을 참조하여 테이블 생성

DROP TABLE tbl_foods;
CREATE TABLE tbl_foods(
    fd_fcode	VARCHAR2(10)		PRIMARY KEY,
    fd_name	NVARCHAR2(125)	NOT NULL,	
    fd_year	NUMBER	NOT NULL,	
    fd_ccode	VARCHAR2(10)	NOT NULL,
    fd_tcode	VARCHAR2(10)	NOT NULL,	
    fd_serving	NUMBER,		
    fd_total	NUMBER,		
    fd_energy	NUMBER,		
    fd_protein	NUMBER,		
    fd_fat	NUMBER,		
    fd_carbo	NUMBER,		
    fd_sugar	NUMBER		
);

CREATE TABLE tbl_company(
    cp_code	VARCHAR2(10)		PRIMARY KEY,
    cp_name	NVARCHAR2(125)	NOT NULL	
);

CREATE TABLE tbl_items(
    it_code	VARCHAR2(10)		PRIMARY KEY,
    it_name	NVARCHAR2(125)	NOT NULL	
);

-- 데이터 import 후에 확인
SELECT COUNT(*) FROM tbl_foods;
SELECT COUNT(*) FROM tbl_company;
SELECT COUNT(*) FROM tbl_items;


-- tbl_foods 테이블의 제조사코드와 tbl_company 간에 외래키 관계 선언
ALTER TABLE tbl_foods -- FK를 설정할 TABLE
ADD CONSTRAINT fk_ccode -- FK 이름 설정
FOREIGN KEY(fd_ccode) -- FK를 설정할 칼럼, child의 칼럼
REFERENCES tbl_company(cp_code); -- 누구하고, parent table(칼럼)

--  tbl_foods 테이블의 분류코드와 tbl_items 간에 외래키 관계 선언
ALTER TABLE tbl_foods -- FK를 설정할 TABLE
ADD CONSTRAINT fk_tcode -- FK 이름 설정
FOREIGN KEY(fd_tcode) -- FK를 설정할 칼럼, child의 칼럼
REFERENCES tbl_items(it_code); -- 누구하고, parent table(칼럼)


DROP VIEW view_식품정보;
--  식품정보, 제조사정보, 식품분류 테이블을 JOIN하여 VIEW를 생성 : view_식품정보
CREATE VIEW view_식품정보 AS
(
    SELECT *
    FROM tbl_foods F
        LEFT JOIN tbl_company C
            ON f.fd_ccode = C.cp_code
        LEFT JOIN tbl_items I
            ON f.fd_tcode = I.it_code
);

SELECT * FROM view_식품정보;


CREATE TABLE tbl_myfoods(
    my_seq	VARCHAR2(10)		PRIMARY KEY,
    my_date	VARCHAR2(10)	NOT NULL,	
    my_fcode	VARCHAR2(10)	NOT NULL,	
    my_eat	NUMBER	NOT NULL	
);

















