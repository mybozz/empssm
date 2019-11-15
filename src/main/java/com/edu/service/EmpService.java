package com.edu.service;

import com.edu.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> listEmp();
    int saveEmp(Emp emp);
    List<Emp> listEmpDept();
    int  deleteEmp(Integer empId);
    List<Emp> listById(Integer empId);

}
