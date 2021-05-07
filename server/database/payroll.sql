USE nominal_dev;

INSERT INTO nominal_dev.payroll (company,agreement,employee,date_from,date_to,date_total_days,base_salary,employee_apportion,apportion,salary_kind,total_earned,cc_percentage,cc_value,unemployment_percentage,unemployment_value,training_percentage,training_value,oh_percentage,oh_value,eh_percentage,eh_value,total_aportations,irpf_percentage,irpf_value,advance_pays,sk_reduction,other_reduction,total_deduction,total_to_receive) VALUES 
    (1,1,1,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,1,0.00,1560.34,4.7,230.23,0.00,0,10.0,123.12,4.7,78.34,6.0,98.23,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34),
    (3,1,2,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,1,0.00,1560.34,4.7,230.23,0.00,0,10.0,123.12,4.7,78.34,6.0,98.23,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34),
    (4,1,6,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,1,0.00,1560.34,4.7,230.23,0.00,0,10.0,123.12,4.7,78.34,6.0,98.23,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34),
    (2,1,8,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,1,0.00,1560.34,4.7,230.23,0.00,0,10.0,123.12,4.7,78.34,6.0,98.23,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34);

INSERT INTO nominal_dev.payroll_complement (payroll,title,salarial,value_original,value_percentage,value) VALUES
    (1,"Antiguedad",1,234,4.7,286.45)
    ,(2,"Antiguedad",1,123,4.7,173.25)
    ,(2,"Complemento",0,123,4.7,173.25)
    ,(4,"Antiguedad",1,123,4.7,173.25);