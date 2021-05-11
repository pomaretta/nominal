USE nominal_dev;

INSERT INTO nominal_dev.payroll (
    company
    ,agreement
    ,employee
    ,date_from
    ,date_to
    ,date_total_days
    ,base_salary
    ,employee_apportion
    ,apportion -- CHANGED
    ,salary_kind
    ,total_earned
    ,cc_percentage
    ,cc_value
    -- CHANGED %%%%%%%%%%%%%%
    ,benefits_and_compensations
    ,redundancy_payment
    ,other_benefits
    -- CHANGED %%%%%%%%%%%%%%
    ,unemployment_percentage
    ,unemployment_value
    ,training_percentage
    ,training_value
    ,oh_original_value -- CHANGED
    ,oh_percentage
    ,oh_value
    ,eh_original_value -- CHANGED
    ,eh_percentage
    ,eh_value
    ,total_aportations
    ,irpf_percentage
    ,irpf_value
    ,advance_pays
    ,sk_reduction
    ,other_reduction
    ,total_deduction
    ,total_to_receive
    -- CHANGED %%%%%%%%%%%%%%
    ,company_cc_percentage
    ,company_cc_value
    ,company_pc_at_percentage
    ,company_pc_at_value
    ,company_pc_unemployment_percentage
    ,company_pc_unemployment_value
    ,company_pc_training_percentage
    ,company_pc_training_value
    ,company_pc_fogasa_percentage
    ,company_pc_fogasa_value
    ,company_eh_percentage
    ,company_eh_value
    ,company_oh_percentage
    ,company_oh_value
    ,total_bccc
    ) VALUES 
    (3,1,2,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,184.56,0.00,1560.34,4.7,230.23
        -- CHANGED %%%%%%%%%%%%%%
        ,0,0,0
        -- CHANGED %%%%%%%%%%%%%%
        ,0.00,0,10.0,123.12
        -- CHANGED %%%%%%%%%%%%%%
        ,234.67,4.7,23.45
        -- CHANGED %%%%%%%%%%%%%%
        ,45.23,6.0,6.43
        -- CHANGED %%%%%%%%%%%%%%
        ,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34
        -- CHANGED %%%%%%%%%%%%%%
        ,23.60,345.23,1.55,45.23,4.7,34.45,0.10,4.32,0.20,7.23,4.7,12.32,6.0,23.23,1384.56),
    (4,1,6,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,184.56,0.00,1560.34,4.7,230.23
        -- CHANGED %%%%%%%%%%%%%%
        ,0,0,0
        -- CHANGED %%%%%%%%%%%%%%
        ,0.00,0,10.0,123.12
        -- CHANGED %%%%%%%%%%%%%%
        ,234.67,4.7,23.45
        -- CHANGED %%%%%%%%%%%%%%
        ,45.23,6.0,6.43
        -- CHANGED %%%%%%%%%%%%%%
        ,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34
        -- CHANGED %%%%%%%%%%%%%%
        ,23.60,345.23,1.55,45.23,4.7,34.45,0.10,4.32,0.20,7.23,4.7,12.32,6.0,23.23,1384.56),
    (2,1,8,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,184.56,0.00,1560.34,4.7,230.23
        -- CHANGED %%%%%%%%%%%%%%
        ,0,0,0
        -- CHANGED %%%%%%%%%%%%%%
        ,0.00,0,10.0,123.12
        -- CHANGED %%%%%%%%%%%%%%
        ,234.67,4.7,23.45
        -- CHANGED %%%%%%%%%%%%%%
        ,45.23,6.0,6.43
        -- CHANGED %%%%%%%%%%%%%%
        ,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34
        -- CHANGED %%%%%%%%%%%%%%
        ,23.60,345.23,1.55,45.23,4.7,34.45,0.10,4.32,0.20,7.23,4.7,12.32,6.0,23.23,1384.56);
    -- (3,1,2,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,1,0.00,1560.34,4.7,230.23,0.00,0,10.0,123.12,4.7,78.34,6.0,98.23,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34),
    -- (4,1,6,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,1,0.00,1560.34,4.7,230.23,0.00,0,10.0,123.12,4.7,78.34,6.0,98.23,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34),
    -- (2,1,8,DATE('2021-05-01'),DATE('2021-05-30'),30,1200.00,1,1,0.00,1560.34,4.7,230.23,0.00,0,10.0,123.12,4.7,78.34,6.0,98.23,456.94,16.23,323.45,0.00,0.00,23.55,45.32,980.34);

INSERT INTO nominal_dev.payroll_complement (payroll,title,salarial,value_original,value_percentage,value) VALUES
    (1,"Antiguedad",1,234,4.7,286.45)
    ,(2,"Antiguedad",1,123,4.7,173.25)
    ,(2,"Complemento",0,123,4.7,173.25)
    -- ,(4,"Antiguedad",1,123,4.7,173.25);