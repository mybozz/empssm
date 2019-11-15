package com.edu.controller;


import com.edu.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class UserController {

    @PostMapping("/login")
    public ResultVO login(String username, String password, HttpSession session ){

        if ("admin".equals(username) && "1234".equals(password)){
            session.setAttribute("user",username);
            return ResultVO.success();
        }else {
            return ResultVO.error(1,"用户名或密码错误");
        }
    }
}
