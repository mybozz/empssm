package com.edu.service.impl;

import com.edu.entity.Dept;
import com.edu.mapper.DeptMapper;
import com.edu.mapper.EmpMapper;
import com.edu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Dept> listDept() {
        return deptMapper.listDept();
    }

    @Override
    public void deleteById(Integer deptId){
        empMapper.deleteEmpById(deptId);
        deptMapper.deleteById(deptId);

    }
}
