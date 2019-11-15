package com.edu.mapper;

import com.edu.entity.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> listEmp();

    int saveEmp(Emp emp);

    List<Emp> listEmpDept();
   int  deleteEmp(Integer empId);

   List<Emp> listById(Integer empId);

   int deleteEmpById(Integer deptId);
}
