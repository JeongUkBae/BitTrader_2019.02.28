
DROP SEQUENCE employee_id;
DROP SEQUENCE CATEGORY_ID;
DROP SEQUENCE PRODUCT_ID;
DROP SEQUENCE ORDER_ID;


drop table ORDERDETAILS;
drop table PRODUCTS;
drop table CATEGORIES;
drop table SUPPLIERS;
drop table ORDERS;
drop table SHIPPERS;
drop table EMPLOYEES;
drop table customers;


CREATE TABLE Customers(
    customer_id VARCHAR2(15) PRIMARY KEY,
    customer_name VARCHAR2(15) NOT NULL,
    password VARCHAR2(15) NOT NULL,
    ssn VARCHAR2(15) NOT NULL,
    phone VARCHAR2(15) NOT NULL,
    photo VARCHAR2(15) DEFAULT 'default_photo',
    city VARCHAR2(50) NOT NULL,
    address VARCHAR2(40) NOT NULL,
    postal_code VARCHAR2(15) NOT NULL
);

--*****
-- Create Employees
--*****
CREATE SEQUENCE employee_id
START WITH 1000
INCREMENT BY 1; 
CREATE TABLE Employees(
    employee_id VARCHAR2(15) PRIMARY KEY,
    manager VARCHAR2(15) NOT NULL,
    name VARCHAR2(15) NOT NULL,
    birth_date VARCHAR2(15) NOT NULL,
    photo VARCHAR2(15),
    notes VARCHAR2(15)
);

--*****
-- Create Shippers
--*****
CREATE TABLE Shippers(
    shipper_id VARCHAR2(15) PRIMARY KEY,
    shipper_name VARCHAR2(15) NOT NULL,
    phone VARCHAR2(15) NOT NULL
);

--*****
-- Create Orders
--*****
CREATE SEQUENCE order_id
START WITH 1000
INCREMENT BY 1; 
CREATE TABLE Orders(
order_id NUMBER PRIMARY KEY,
customer_id VARCHAR2(15),
employee_id VARCHAR2(15),
order_date DATE DEFAULT SYSDATE,
shipper_id VARCHAR2(15),
CONSTRAINT customers_fk_orders FOREIGN KEY(customer_id)
REFERENCES Customers(customer_id),
CONSTRAINT orders_fk_employees FOREIGN KEY(employee_id)
REFERENCES employees(employee_id),
CONSTRAINT shippers_fk_orders FOREIGN KEY(shipper_id)
REFERENCES Shippers(shipper_id)
);


--*****
-- Create Suppliers
--*****
create table Suppliers(
supplier_id varchar2(15) primary key,
supplier_name varchar2(15) not null,
contact_name varchar2(15) not null,
address varchar2(15) not null,
city varchar2(15) not null,
postal_code varchar2(15) not null,
country varchar2(15) not null,
phone varchar2(15) not null
);

--*****
-- Create Categories
--*****
CREATE SEQUENCE CATEGORY_ID
START WITH 1000
INCREMENT BY 1; 
create table Categories(
category_id number primary key,
category_name varchar2(15) not null,
description varchar2(15)
);

--*****
-- Create Products
--*****
CREATE SEQUENCE PRODUCT_ID
START WITH 1000
INCREMENT BY 1; 
create table Products(
product_id number primary key,
product_name varchar2(15) not null,
supplier_id varchar2(15),
category_id number,
unit varchar2(15),
price number not null,
constraint suppliers_fk_Products foreign key(supplier_id)
references Suppliers(supplier_id),
constraint categories_fk_produets foreign key(category_id)
references Categories(category_id)
);


--*****
-- Create OrderDetails
--*****
create table Orderdetails(
order_detail_id varchar2(15) primary key,
order_id number,
product_id number,
quantity number not null,
constraint orders_fk_orderdetails foreign key(order_id)
references Orders(order_id),
constraint products_fk_orderdetails foreign key(product_id)
references Products(product_id)
);


INSERT INTO EMPLOYEES(EMPLOYEE_ID, MANAGER, NAME, BIRTH_DATE, PHOTO, NOTES)
VALUES(EMPLOYEE_ID.NEXTVAL, 'MANAGER','김경민','900101','KIM.JPG','매니저');


INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME,PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE) 
        VALUES('jang','장영실','1111','940506-1','010-8765-4321',DEFAULT,'서울시 중구 중림동 244','삼성아파트상가','100-859'); 
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME,PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE) 
        VALUES('woo','전서우','2222','960905-1','010-5689-4789',DEFAULT,'서울시 서초구 방배동 424-28','방배롯데캐슬','06676');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE) 
        VALUES('jk55','남기호','3333','980203-1', '010-5986-7898',DEFAULT,'서울특별시 강서구 화곡동 1165','강서힐스테이트','07694');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME,  PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE) 
        VALUES('roll90','김태혁','2222','950909-1', '010-5989-5688',DEFAULT,'서울특별시 마포구 성산동 450','성산시영선아파트','03936');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME,  PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE) 
        VALUES('hahalo','김창하','1111','960405-1','010-6545-5566',DEFAULT,'서울특별시 마포구 백범로 10','현대벤쳐빌','04100');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME,  PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE) 
        VALUES('changjunzzang','이창준','2323','920606-1', '010-6334-5566',DEFAULT,'서울특별시 마포구 백범로 205','펜트리우스아파트','04194');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME,PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE) 
        VALUES('lalaland','서동준','090909','930106-1','010-0909-1190',DEFAULT,'서울특별시 용산구 한강대로10길 14','한강로쌍용스윗닷홈','04389');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PASSWORD, SSN, PHONE, PHOTO, CITY, ADDRESS, POSTAL_CODE) 
        VALUES('kimzzang','김이레','06078','950506-1','010-7859-5566',DEFAULT,'서울특별시 서초구 방배로19길 67','방배브라운가아파트','06681');
     
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('ronaldo','호날두','1234','850205-1','ronaldo.jpg','010-1234-5678','서울특별시 강남구 논현로 507','성지하이츠3차빌딩 101동 101호','06132');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('messi','메시','1234','870624-1','messi.jpg','010-2345-6789','서울특별시 강남구 선릉로18길 12','개포현대아파트 202동 202호','06325');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('modric','모드리치','1234','850909-1','modric.jpg','010-3456-7890','서울특별시 강남구 영동대로 740',' 더 리버스청담 303동 303호','06075');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('ramos','라모스','1234','860330-1','ramos.jpg','010-4567-8901','서울특별시 강남구 학동로64길 7','한솔아파트 404동 404호','06089');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('bruyne','브라위너','1234','910628-1','bruyne.jpg','010-5678-9012','서울특별시 강남구 선릉로90길 56','대우아이빌명문가 505동 505호','06194');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('degea','데헤아','1234','901107-1','degea.jpg','010-6789-0123','서울특별시 강남구 논현로157길 40','반도상사 606동 606호','06033');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('marcelo','마르셀로','1234','880512-1','marcelo.jpg','010-7890-1234','서울특별시 강남구 학동로11길 29','알파임하우스2 707동 707호','06043');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('neymar','네이마르','1234','920205-1','neymar.jpg','010-8901-2345','서울특별시 강남구 압구정로29길 72-1','신사상가 808동 808호','06004');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('kante','캉테','1234','910329-1','kante.jpg','010-9012-3456','서울특별시 강남구 자곡로 36','강남효성해링턴코트','06376');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('mbappe','음바페','1234','981220','mbappe.jpg','010-0123-4567','서울특별시 강남구 밤고개로21길 25','래미안포레 1000동 1000호','06370');
insert into CUSTOMERS(customer_id, customer_name, password, ssn, photo, phone, city, address, postal_code)
VALUES('varane','바란','1234','930425','varane.jpg','010-1234-5670','서울특별시 강남구 밤고개로24길 44-9','율현주택 1001동 1001호','06370');

INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('Gameing','배정욱','1234','901220-1','010-8452-6312','07728','서울특별시 강서구 강서로 142','삼화빌리지102호');           
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('Tomas','정서우','1234','900830-1','010-5245-8453','07727','서울특별시 강서구 화곡로 176-21','썬라인101호');                 
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('Rupi','이창준','1234','940234-1','010-3254-4512','07677','서울특별시 강서구 초록마을로11길 27','도원힐라이프');
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('Ourusa','김창하','1234','950425-1','010-5491-4425','07677','서울특별시 강서구 까치산로12길 57','케이앤와이빌리지');
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('Smoker','김태우','1234','940201-2','010-5598-7812','07679','서울특별시 강서구 까치산로 63','쉐보레강서바로서비스');
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('Oarora','김은정','1234','951112-2','010-8265-4455','07726','서울특별시 강서구 강서로26길 35-27','경민아트빌120호');
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('ting','이지은','1234','900512-2','010-7751-1513','07676','서울특별시 강서구 초록마을로21길 6','영산빌라202호');
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('skrad','김우석','1234','970118-1','010-5098-5412','07730','서울특별시 강서구 까치산로4길 98-10','햇빛애주택302호');
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('monga','고동영','1234','961211-1','010-5611-6312','07727','서울특별시 강서구 화곡로 176-19','성재센트리움아파트102호');
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('rion','김지연','1234','960422-2','010-5131-1123','07721','서울특별시 강서구 화곡로34길 22','프라임하우스102호');
INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,CITY,ADDRESS)
VALUES('tail','박은지','1234','940220-2','010-6151-8488','07730','서울특별시 강서구 까치산로4다길 21','아름아트빌102호');

SELECT * FROM TAB;
SELECT * FROM CUSTOMERS;
SELECT * FROM EMPLOYEES;