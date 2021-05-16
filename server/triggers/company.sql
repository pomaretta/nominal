USE nominal_dev;

CREATE TRIGGER company_information AFTER INSERT 
ON nominal_dev.company_information FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.company SET last_update = NOW() WHERE id = NEW.company;
END

CREATE TRIGGER company_contact AFTER INSERT 
ON nominal_dev.company_contact FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.company SET last_update = NOW() WHERE id = NEW.company;
END

CREATE TRIGGER company_financial AFTER INSERT 
ON nominal_dev.company_financial FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.company SET last_update = NOW() WHERE id = NEW.company;
END

CREATE TRIGGER company_employee AFTER INSERT 
ON nominal_dev.company_employee FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.company SET last_update = NOW() WHERE id = NEW.company;
END

CREATE TRIGGER company_agreement AFTER INSERT 
ON nominal_dev.company_agreement FOR EACH ROW
BEGIN 
	UPDATE nominal_dev.company SET last_update = NOW() WHERE id = NEW.company;
END

CREATE PROCEDURE fire_employee(in companyId int, in employeeId int)
BEGIN
	UPDATE nominal_dev.company_employee e 
	SET e.expiration_date = NOW() 
	WHERE e.company = companyId AND e.employee = employeeId;
END