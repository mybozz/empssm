package com.edu.controller;


import com.edu.service.DeptService;
import com.edu.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/deptlist",method = {RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public ResultVO deptList(){
        return ResultVO.success(deptService.listDept());
    }


    @RequestMapping(value = "/deleteId")
    @CrossOrigin
    @ResponseBody
    public ResultVO deleteById(Integer deptId){
        if (deptId == null){
            ResultVO.error(1,"id不能为空");
        }
            deptService.deleteById(deptId);
            return ResultVO.success();


    }
}
