INSERT INTO ROLES VALUES ( 100, 'ROLE_ADMIN');
INSERT INTO ROLES VALUES ( 200, 'ROLE_USER');
INSERT INTO ROLES VALUES ( 300, 'ROLE_FACULTY');


INSERT INTO USERS VALUES ( 100, null, '$2a$10$fosL2fNiYHj3eOKQ6uLDrO0BIwiDXfum85M8VDZDLX8QdM2kG1T8u','admin');
INSERT INTO USERS VALUES ( 200, null, '$2a$10$fosL2fNiYHj3eOKQ6uLDrO0BIwiDXfum85M8VDZDLX8QdM2kG1T8u','user');
INSERT INTO USERS VALUES ( 300, null, '$2a$10$fosL2fNiYHj3eOKQ6uLDrO0BIwiDXfum85M8VDZDLX8QdM2kG1T8u','faculty');
INSERT INTO USERS VALUES ( 400, null, '$2a$10$fosL2fNiYHj3eOKQ6uLDrO0BIwiDXfum85M8VDZDLX8QdM2kG1T8u','KHUYAGAA');
INSERT INTO USERS VALUES ( 500, null, '$2a$10$fosL2fNiYHj3eOKQ6uLDrO0BIwiDXfum85M8VDZDLX8QdM2kG1T8u','ANKHAA');
INSERT INTO USERS VALUES ( 600, null, '$2a$10$fosL2fNiYHj3eOKQ6uLDrO0BIwiDXfum85M8VDZDLX8QdM2kG1T8u','BYAMBAA');
INSERT INTO USERS VALUES ( 700, null, '$2a$10$fosL2fNiYHj3eOKQ6uLDrO0BIwiDXfum85M8VDZDLX8QdM2kG1T8u','BAYA');
INSERT INTO USERS VALUES ( 800, null, '$2a$10$fosL2fNiYHj3eOKQ6uLDrO0BIwiDXfum85M8VDZDLX8QdM2kG1T8u','JOHN');
INSERT INTO USER_ROLES  VALUES ( 100, 100);
INSERT INTO USER_ROLES  VALUES ( 100, 200);
INSERT INTO USER_ROLES  VALUES ( 200, 200);
INSERT INTO USER_ROLES  VALUES ( 300, 300);
INSERT INTO USER_ROLES  VALUES ( 400, 200);
INSERT INTO USER_ROLES  VALUES ( 500, 200);
INSERT INTO USER_ROLES  VALUES ( 600, 200);
INSERT INTO USER_ROLES  VALUES ( 700, 200);
INSERT INTO USER_ROLES  VALUES ( 800, 200);

INSERT INTO STUDENT (STUDENT_ID, ENTRY, FIRST_NAME, LAST_NAME,USER_ID) VALUES (986979,'Nov-2018', 'KHUYAGAA', 'B',400);
INSERT INTO STUDENT (STUDENT_ID, ENTRY, FIRST_NAME, LAST_NAME,USER_ID) VALUES ( 986973, 'FEB-2019', 'ANKHAA', 'B' ,500);
INSERT INTO STUDENT (STUDENT_ID, ENTRY, FIRST_NAME, LAST_NAME,USER_ID) VALUES ( 986972, 'FEB-2019', 'BYAMBAA', 'B',600 );
INSERT INTO STUDENT (STUDENT_ID, ENTRY, FIRST_NAME, LAST_NAME,USER_ID)VALUES ( 108968, 'FEB-2019', 'BAYA', 'O',700 );
INSERT INTO STUDENT (STUDENT_ID, ENTRY, FIRST_NAME, LAST_NAME,USER_ID) VALUES ( 986970, 'NOV-2018', 'JOHN', 'B' ,800);
--
INSERT INTO TM_CHECK (ID, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY, CHECKED_DATE, TM_TYPE, STUDENT_ID) VALUES (100, PARSEDATETIME('2019-04-15 03:05:06',   'YYYY-MM-DD HH:mm:ss') , PARSEDATETIME('2019-04-16 03:05:06',   'YYYY-MM-DD HH:mm:ss'), 986979, 986979, TO_DATE('2019-06-10', 'YYYY-MM-DD'), 'TM-CHECK', 986979);
INSERT INTO TM_CHECK (ID, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY, CHECKED_DATE, TM_TYPE, STUDENT_ID) VALUES (200, PARSEDATETIME('2019-04-18 03:05:06',   'YYYY-MM-DD HH:mm:ss') , PARSEDATETIME('2019-05-15 03:05:06',   'YYYY-MM-DD HH:mm:ss'), 986973, 986973, TO_DATE('2019-06-09', 'YYYY-MM-DD'), 'TM-RETREAT', 986973);
INSERT INTO TM_CHECK (ID, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY, CHECKED_DATE, TM_TYPE, STUDENT_ID) VALUES (300, PARSEDATETIME('2019-04-16 03:05:06',   'YYYY-MM-DD HH:mm:ss'), PARSEDATETIME('2019-06-15 03:05:06',   'YYYY-MM-DD HH:mm:ss'), 986972, 986972, TO_DATE('2019-06-11', 'YYYY-MM-DD'), 'TM-CHECK', 986972);
INSERT INTO TM_CHECK (ID, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY, CHECKED_DATE, TM_TYPE, STUDENT_ID) VALUES (400, PARSEDATETIME('2018-11-14 03:05:06',   'YYYY-MM-DD HH:mm:ss') , PARSEDATETIME('2018-11-15 03:05:06',   'YYYY-MM-DD HH:mm:ss'), 108968, 108968, TO_DATE('2019-06-12', 'YYYY-MM-DD'), 'TM-CHECK', 108968);
INSERT INTO TM_CHECK (ID, CREATED_AT, UPDATED_AT, CREATED_BY, UPDATED_BY, CHECKED_DATE, TM_TYPE, STUDENT_ID) VALUES (500, PARSEDATETIME('2018-10-10 03:05:06',   'YYYY-MM-DD HH:mm:ss'), PARSEDATETIME('2018-10-15 03:05:06',   'YYYY-MM-DD HH:mm:ss'), 986970, 986970, TO_DATE('2019-06-13', 'YYYY-MM-DD'), 'TM-CHECK', 986970);


/* Attendance Records */
/*card_id 	date 		location	name			student_id	type*/
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-01', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-02', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-03', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-04', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-06', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-07', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-08', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-09', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-10', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-11', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-13', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values(11001000986979,TO_DATE('2019-05-14', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986979,TO_DATE('2019-05-15', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986979,TO_DATE('2019-05-16', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986979,TO_DATE('2019-05-17', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986979,TO_DATE('2019-05-18', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986979,TO_DATE('2019-05-20', 'YYYY-MM-DD'),'DB',null,986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-01', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-02', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-03', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-04', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-06', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-07', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-08', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-09', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-10', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-11', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-13', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-14', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-15', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-16', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-17', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-18', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986973,TO_DATE('2019-05-20', 'YYYY-MM-DD'),'DB',null,986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-01', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-02', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-03', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-04', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-06', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-07', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-08', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-09', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-10', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-11', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-13', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-14', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-15', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-16', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-17', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-18', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000986972,TO_DATE('2019-05-20', 'YYYY-MM-DD'),'DB',null,986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-01', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-02', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-03', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-04', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-06', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-07', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-08', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-09', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-10', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-11', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-13', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-14', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-15', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-16', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-17', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-18', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (11001000108968,TO_DATE('2019-05-20', 'YYYY-MM-DD'),'DB',null,108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-24','YYYY-MM-DD'),null,'Otgonbaasan Ikhbayar',108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-25','YYYY-MM-DD'),null,'Otgonbaasan Ikhbayar',108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-26','YYYY-MM-DD'),null,'Otgonbaasan Ikhbayar',108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-27','YYYY-MM-DD'),null,'Otgonbaasan Ikhbayar',108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-28','YYYY-MM-DD'),null,'Otgonbaasan Ikhbayar',108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-29','YYYY-MM-DD'),null,'Otgonbaasan Ikhbayar',108968,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-24','YYYY-MM-DD'),null,'Dulamsuren Byambadorj',986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-25','YYYY-MM-DD'),null,'Dulamsuren Byambadorj',986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-26','YYYY-MM-DD'),null,'Dulamsuren Byambadorj',986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-27','YYYY-MM-DD'),null,'Dulamsuren Byambadorj',986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-28','YYYY-MM-DD'),null,'Dulamsuren Byambadorj',986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-29','YYYY-MM-DD'),null,'Dulamsuren Byambadorj',986972,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-24','YYYY-MM-DD'),null,'Bold Ankh-Erdene',986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-25','YYYY-MM-DD'),null,'Bold Ankh-Erdene',986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-26','YYYY-MM-DD'),null,'Bold Ankh-Erdene',986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-27','YYYY-MM-DD'),null,'Bold Ankh-Erdene',986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-28','YYYY-MM-DD'),null,'Bold Ankh-Erdene',986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-29','YYYY-MM-DD'),null,'Bold Ankh-Erdene',986973,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-24','YYYY-MM-DD'),null,'Batkhuyag Ochirkhuyag',986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-25','YYYY-MM-DD'),null,'Batkhuyag Ochirkhuyag',986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-26','YYYY-MM-DD'),null,'Batkhuyag Ochirkhuyag',986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-27','YYYY-MM-DD'),null,'Batkhuyag Ochirkhuyag',986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-28','YYYY-MM-DD'),null,'Batkhuyag Ochirkhuyag',986979,'AM');
insert into TM_ATTENDANCE (CARD_ID,DATE,LOCATION,NAME,STUDENT_ID,TYPE) Values (null,TO_DATE('2019-05-29','YYYY-MM-DD'),null,'Batkhuyag Ochirkhuyag',986979,'AM');


/* Integer blockId, String name, String course, String professorName, LocalDate startDate, LocalDate endDate*/
insert into BLOCK (BlOCK_ID,NAME,COURSE,PROFESSOR_NAME,START_DATE,END_DATE,TOTAL_DATE) VALUES (100,'MWA','CS572','Asaad Saad',TO_DATE('2019-04-29','YYYY-MM-DD'),TO_DATE('2019-05-23','YYYY-MM-DD'),22);
insert into BLOCK (BlOCK_ID,NAME,COURSE,PROFESSOR_NAME,START_DATE,END_DATE,TOTAL_DATE) VALUES (200,'WAA','CS545','Rujuan Xing',TO_DATE('2019-05-27','YYYY-MM-DD'),TO_DATE('2019-06-20','YYYY-MM-DD'),22);

insert into STUDENT_BLOCKS (STUDENT_ID,BLOCK_ID) VALUES (986979,100);
insert into STUDENT_BLOCKS (STUDENT_ID,BLOCK_ID) VALUES (986979,200);
insert into STUDENT_BLOCKS (STUDENT_ID,BLOCK_ID) VALUES (986973,100);
insert into STUDENT_BLOCKS (STUDENT_ID,BLOCK_ID) VALUES (986973,200);
insert into STUDENT_BLOCKS (STUDENT_ID,BLOCK_ID) VALUES (986972,100);
insert into STUDENT_BLOCKS (STUDENT_ID,BLOCK_ID) VALUES (986972,200);
insert into STUDENT_BLOCKS (STUDENT_ID,BLOCK_ID) VALUES (108968,100);
insert into STUDENT_BLOCKS (STUDENT_ID,BLOCK_ID) VALUES (108968,200);
