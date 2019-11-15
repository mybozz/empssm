package com.edu.controller;

import com.edu.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UpLoadController {

    @PostMapping("/upload")
    public ResultVO upLoad(MultipartFile file, HttpServletRequest request ) throws IOException {
        // file是获得的上传文件
        //获得项目部署的目录
        String projectPath = request.getServletContext().getRealPath("/");
        // 获得上传文件名
        String fileName = file.getOriginalFilename();
        //拼接唯一文件名
        String filePath = projectPath + UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
        //在这个目录下创建文件
        File outPutFile = new File(filePath);
        //将文件写入新建的文件
        file.transferTo(outPutFile);
        return ResultVO.success();
    }

}
