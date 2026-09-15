package com.korebit.mapper;

import com.korebit.model.Employee;

public class EmployeeMapper {
    public static Employee mapper(String name, int age, int id){
        return new Employee(name, age, id);
    }
}
