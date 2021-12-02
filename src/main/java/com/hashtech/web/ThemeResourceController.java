package com.hashtech.web;


import com.hashtech.businessframework.log.Logable;
import com.hashtech.businessframework.result.BusinessResult;
import com.hashtech.service.ThemeResourceService;
import com.hashtech.web.request.*;
import com.hashtech.web.result.ResourceResult;
import com.hashtech.web.result.ThemeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 主题资源表 前端控制器
 * </p>
 *
 * @author xujie
 * @since 2021-11-23
 */
@RestController
@RequestMapping("/theme")
public class ThemeResourceController {

    @Autowired
    private ThemeResourceService themeResourceService;

    @Logable
    @PostMapping("/hasExist")
    public BusinessResult<Boolean> hasExitTheme(@RequestBody ThemeSaveRequest request) {
        return themeResourceService.hasExitTheme(request);
    }

    @Logable
    @PostMapping("/save")
    BusinessResult<Boolean> saveTheme(@RequestHeader(value = "x-userid", defaultValue = "root") String userId, @RequestBody ThemeSaveRequest request) {
        return themeResourceService.saveTheme(userId, request);
    }

    @Logable
    @GetMapping("/info/{id}")
    BusinessResult<ThemeResult> getThemeInfo(@PathVariable("id") String id) {
        return themeResourceService.getThemeInfo(id);
    }

    @Logable
    @PostMapping("/update")
    BusinessResult<Boolean> updateTheme(@RequestHeader(value = "x-userid", defaultValue = "root") String userId, @RequestBody ThemeUpdateRequest request) {
        return themeResourceService.updateTheme(userId, request);
    }

    @Logable
    @PostMapping("/delete")
    BusinessResult<Boolean> deleteTheme(@RequestHeader(value = "x-userid", defaultValue = "root") String userId, @RequestBody ThemeDeleteRequest request) {
        return themeResourceService.deleteTheme(userId, request);
    }

    @Logable
    @PostMapping("/list")
    BusinessResult<List<ThemeResult>> list() {
        return themeResourceService.getList();
    }

    @Logable
    @PostMapping("/rearrangement")
    BusinessResult<Boolean> rearrangement(@RequestHeader(value = "x-userid", defaultValue = "root") String userId, @RequestBody Map<String, String[]> request) {
        return themeResourceService.rearrangement(userId, request);
    }

    @Logable
    @PostMapping("resource/hasExist")
    public BusinessResult<Boolean> hasExitResource(@RequestBody ResourceSaveRequest request) {
        return themeResourceService.hasExitResource(request);
    }

    @Logable
    @PostMapping("/resource/save")
    BusinessResult<Boolean> saveResource(@RequestHeader(value = "x-userid", defaultValue = "root") String userId, @RequestBody ResourceSaveRequest request) {
        return themeResourceService.saveResource(userId, request);
    }

    @Logable
    @GetMapping("/resource/info/{id}")
    BusinessResult<ResourceResult> getResourceInfo(@PathVariable("id") String id) {
        return themeResourceService.getResourceInfo(id);
    }

    @Logable
    @PostMapping("/resource/update")
    BusinessResult<Boolean> updateResource(@RequestHeader(value = "x-userid", defaultValue = "root") String userId, @RequestBody ResourceUpdateRequest request) {
        return themeResourceService.updateResource(userId, request);
    }

    @Logable
    @PostMapping("/resource/delete")
    BusinessResult<Boolean> deleteResource(@RequestHeader(value = "x-userid", defaultValue = "root") String userId, @RequestBody ResourceDeleteRequest request) {
        return themeResourceService.deleteResource(userId, request);
    }
}
