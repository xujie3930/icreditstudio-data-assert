package com.hashtech.web;


import com.hashtech.common.BusinessResult;
import com.hashtech.entity.ResourcePicEntity;
import com.hashtech.service.ResourcePicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author xujie
 * @since 2022-06-02
 */
@RestController
@RequestMapping("/resource/pic")
public class ResourcePicController {

    @Autowired
    private ResourcePicService resourcePicService;

    @PostMapping("/upload")
    public BusinessResult<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Map<String, String> map = resourcePicService.upload(file);
        return BusinessResult.success(map);
    }

    @GetMapping("/list")
    public BusinessResult<List<ResourcePicEntity>> uploadFile() {
        List<ResourcePicEntity> list = resourcePicService.list();
        return BusinessResult.success(list);
    }

}
