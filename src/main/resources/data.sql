INSERT INTO opportunity 
(O_ID,ACCOUNT,  	CLOSE_DATE,  	ESTIMATED_REVENUE,  	NAME,  	PRIMARY_CONTACT,  	PRIMARY_CONTACT_ID, 	RISK_LEVEL,	WIN_PERCENTAGE)
VALUES
	 (1,'XYZ Company',	'2021-11-12'	,'90000',	'XYZ Company - 10K Widgets',	'Karen', 2,1,	88.09),
	 (2,'ABC Elementary',	'2021-11-10',	'100000',	'ABC Elementary - New Classroom Equipment',	'Mike',1, 2,	90.09),
	 (3,'XYZ Elementary',	'2021-11-10',	'200000',	'XYZ Elementary - New Classroom Equipment',	'Kristi',1, 2,	90.09);
	 
INSERT INTO contact 
(C_ID , 	ACCOUNT , 	ADDRESS , 	EMAIL ,	MOBILE_PHONE , 	NAME  ,	TITLE  ,	WORK_PHONE  )
VALUES
	 (1,'XYZ Company',	'LB Streat 89'	,'abc@gmail.com',	'8908907865',	'Mike', 'Mr.',	'8908907865'),
	 (2,'XYZ Company',	'LB Streat 89'	,'abc@gmail.com',	'8908907865',	'Kinzi', 'Mrs.',	'8908907865'),
	 (3,'ABC Elementary',	'KL Streat 72',	'abc@gmail.com',	'8908907864',	'Karen', 'Ms.',	'8908907864');
	 
	insert into associated_contacts values ( 2,1), (1,2),(1,3),(2,2);;