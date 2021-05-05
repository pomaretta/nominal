USE nominal_dev;

-- EMPLOYEE

INSERT INTO nominal_dev.employee (cif) VALUES
    ("99999999R")
    ,('53559315C')
    ,('45399445K')
    ,('83377533A')
    ,('73129711S')
    ,('84111929D')
    ,('81244291B')
    ,('41353917D')
    ,('16538499G')
    ,('53823675H')
    ,('18938831X');

INSERT INTO nominal_dev.employee_information (employee,name,name_2,lastname,lastname_2,active,apportion) VALUES
    (1,"Manolo","","Martinez","Cabrera",1,0)
    ,(2,"Manolo","","Martinez","Cabrera",1,0)
    ,(3,"Manolo","","Martinez","Cabrera",1,0)
    ,(4,"Manolo","","Martinez","Cabrera",1,0)
    ,(5,"Manolo","","Martinez","Cabrera",1,0)
    ,(6,"Manolo","","Martinez","Cabrera",1,0)
    ,(7,"Manolo","","Martinez","Cabrera",1,0)
    ,(8,"Manolo","","Martinez","Cabrera",1,0)
    ,(9,"Manolo","","Martinez","Cabrera",1,0)
    ,(10,"Manolo","","Martinez","Cabrera",1,0);

INSERT INTO nominal_dev.employee_contact (employee,email_address,street_address,phone_number) VALUES
    (1,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(2,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(3,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(4,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(5,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(6,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(7,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(8,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(9,"manolo@gmail.com","Calle Lopez, 23","634952395")
    ,(10,"manolo@gmail.com","Calle Lopez, 23","634952395");

INSERT INTO nominal_dev.employee_contract (employee,category,irpf,hourly,hired_hours) VALUES
    (1,5,12.50,0,25)
    ,(2,12,12.50,0,25)
    ,(3,56,12.50,0,25)
    ,(4,23,12.50,0,40)
    ,(5,54,12.50,0,25)
    ,(6,78,16.00,0,25)
    ,(7,34,12.00,0,40)
    ,(8,34,12.00,0,40)
    ,(9,10,12.00,0,40)
    ,(10,95,12.00,0,40);

INSERT INTO nominal_dev.employee_schedule (employee,nocturnal,turnicity,complementary_hours) VALUES
    (1,0,0,0)
    ,(2,0,0,0)
    ,(3,0,0,0)
    ,(4,0,0,0)
    ,(5,0,0,0)
    ,(6,0,0,0)
    ,(7,0,0,0)
    ,(8,0,0,0)
    ,(9,0,0,0)
    ,(10,0,0,0);

INSERT INTO nominal_dev.company_employee (company,employee,join_date) VALUES
    (1,1,DATE('2021-02-03'))
    ,(3,2,DATE('2013-02-03'))
    ,(2,3,DATE('2017-02-03'))
    ,(1,4,DATE('2010-02-03'))
    ,(2,5,DATE('2010-06-03'))
    ,(4,6,DATE('2013-06-03'))
    ,(5,7,DATE('2016-06-03'))
    ,(4,8,DATE('2020-06-03'))
    ,(2,9,DATE('2020-06-03'))
    ,(1,10,DATE('2014-06-03'));