USE nominal_dev;

CREATE TRIGGER employee_contact AFTER INSERT 
ON nominal_dev.employee_contact FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.employee SET last_update = NOW() WHERE id = NEW.employee;
END

CREATE TRIGGER employee_information AFTER INSERT 
ON nominal_dev.employee_information FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.employee SET last_update = NOW() WHERE id = NEW.employee;
END

CREATE TRIGGER employee_contract AFTER INSERT 
ON nominal_dev.employee_contract FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.employee SET last_update = NOW() WHERE id = NEW.employee;
END