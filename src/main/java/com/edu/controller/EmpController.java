package com.edu.controller;

import com.edu.entity.Emp;
import com.edu.service.EmpService;
import com.edu.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

//    @RequestMapping(value = "/emplist")
//    public String empList(){
//        System.out.println(empService.listEmp());
//
//        return "";
//    }

//    @RequestMapping(value = "/emplist")
//    @ResponseBody
//    @CrossOrigin
//    public ResultVO empList(){
//
//        return ResultVO.success(empService.listEmp());
//    }

    @RequestMapping(value = "/addemp")
    @ResponseBody
    @CrossOrigin
    public ResultVO addEmp(Emp emp){
        empService.saveEmp(emp);
        return  ResultVO.success();
    }

    @RequestMapping(value = "/emplist")
    @ResponseBody
    @CrossOrigin
    public ResultVO empDeptList(){
        return ResultVO.success(empService.listEmpDept());
    }

    @RequestMapping(value = "/deleteemp")
    @ResponseBody
    @CrossOrigin
    public ResultVO deleteEmp(Integer empId){
        empService.deleteEmp(empId);
        return ResultVO.success();
    }
    @Transactional
    @RequestMapping(value = "/updateemp")
    @ResponseBody
    @CrossOrigin
    public ResultVO updateById(Integer empId){
        return ResultVO.success(empService.listById(empId));
    }
}
