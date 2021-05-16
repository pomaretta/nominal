USE nominal_dev;

CREATE TRIGGER 'agreement_com_quotation' AFTER INSERT 
ON nominal_dev.agreement_com_quotation FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.agreement SET last_update = NOW() WHERE id = NEW.agreement;
END

CREATE TRIGGER 'agreement_emp_category' AFTER INSERT 
ON nominal_dev.agreement_emp_category FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.agreement SET last_update = NOW() WHERE id = NEW.agreement;
END

CREATE TRIGGER 'agreement_antiquity_values' AFTER INSERT 
ON nominal_dev.employee_antiquity_values FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.agreement SET last_update = NOW() WHERE id = NEW.agreement;
END

CREATE TRIGGER 'agreement_salary_values' AFTER INSERT 
ON nominal_dev.employee_salary_values FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.agreement SET last_update = NOW() WHERE id = NEW.agreement;
END