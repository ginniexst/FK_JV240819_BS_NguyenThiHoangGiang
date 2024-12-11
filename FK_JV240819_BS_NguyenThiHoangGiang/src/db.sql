create database quanlynhansu;

use quanlynhansu;

create table Departments (
    department_id int primary key auto_increment,
    department_name varchar(50) not null unique,
    department_status bit default b'1'
);

create table Employees (
    employee_id int primary key auto_increment,
    employee_name varchar(50) not null unique,
    position varchar(50) not null,
    salary double not null check(salary > 0),
    hire_date DATE not null,
    department_id int not null,
    foreign key (department_id) references Departments(department_id)
);

DELIMITER &&
create procedure find_all_department()
begin
    select * from Departments;
end &&
DELIMITER &&;

DELIMITER &&
create procedure create_department(
    department_name_in varchar(50)
)
begin
    insert into Departments (department_name)
        value (department_name_in);
end &&
DELIMITER &&;

DELIMITER &&
create procedure update_department(
    department_id_in int,
    department_name_in varchar(50)
)
begin
    update Departments
        set department_name = department_name_in
    where department_id = department_id_in;
end &&
DELIMITER &&;

DELIMITER &&
create procedure delete_department(department_id_in int)
begin
    update Departments
        set department_status = 0
    where department_id = department_id_in;
end &&
DELIMITER &&;

DELIMITER &&
create procedure find_department_by_name(department_name_in varchar(50))
begin
    select * from Departments where department_name like department_name_in;
end &&
DELIMITER &&;

DELIMITER &&
create procedure find_department_by_id(department_id_in int)
begin
    select * from Departments where department_id = department_id_in;
end &&
DELIMITER &&;

DELIMITER &&
create procedure find_all_employee()
begin
    select * from Employees;
end &&
DELIMITER &&;

DELIMITER &&
create procedure create_employee(
    employee_name_in varchar(50),
    position_in varchar(50),
    salary_in double,
    hire_date_in DATE,
    department_id_in int
)
begin
    insert into Employees (employee_name, position, salary, hire_date, department_id)
        values (employee_name_in, position_in,salary_in,hire_date_in, department_id_in);
end &&
DELIMITER &&;

DELIMITER &&
create procedure update_employee(
    employee_id_in int,
    employee_name_in varchar(50),
    position_in varchar(50),
    salary_in double,
    hire_date_in DATE,
    department_id_in int
)
begin
    update Employees
    set employee_name = employee_name_in,
        position = position_in,
        salary = salary_in,
        hire_date = hire_date_in,
        department_id = department_id_in
    where employee_id = employee_id_in;
end &&
DELIMITER &&;

DELIMITER &&
create procedure delete_employee(employee_id_in int)
begin
    delete from Employees where employee_id = employee_id_in;
end &&
DELIMITER &&;

DELIMITER &&
create procedure find_employee_by_id(employee_id_in int)
begin
    select * from Employees where employee_id = employee_id_in;
end &&
DELIMITER &&;

DELIMITER &&
create procedure find_employee_by_name(employee_name_in varchar(50))
begin
    select * from Employees where employee_name = employee_name_in;
end &&
DELIMITER &&;