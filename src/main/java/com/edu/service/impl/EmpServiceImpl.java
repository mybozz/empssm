package com.edu.service.impl;

import com.edu.entity.Emp;
import com.edu.mapper.EmpMapper;
import com.edu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> listEmp() {
        return empMapper.listEmp();
    }

    @Override
    public int saveEmp(Emp emp) {
        return empMapper.saveEmp(emp);
    }

    @Override
    public List<Emp> listEmpDept() {
        return empMapper.listEmpDept();
    }

    @Override
    public int deleteEmp(Integer empId) {
        return empMapper.deleteEmp(empId);
    }

    @Override
    public List<Emp> listById(Integer empId) {

        return empMapper.listById(empId);
    }


}
