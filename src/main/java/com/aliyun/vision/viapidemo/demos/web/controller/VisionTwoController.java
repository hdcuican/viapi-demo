package com.aliyun.vision.viapidemo.demos.web.controller;


import com.aliyun.vision.viapidemo.demos.service.VisionService;
import com.aliyun.vision.viapidemo.demos.vo.VO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@Api(tags = "视觉AI应用作业2demo相关接口")
@RequestMapping("/demo2")
public class VisionTwoController {

    @Autowired
    private VisionService visionService;

    @ApiOperation(value = "驾驶证识别调用测试", notes = "驾驶证识别调用测试")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/recognizeDriverLicense")
    public Object recognizeDriverLicense(@ApiParam(value="文件",required=true)
                                         @RequestParam(value = "file") MultipartFile file)  {
        //判断文件是否为空
        if(!file.isEmpty()) {
            //创建输入输出流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                return visionService.recognizeDriverLicense(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return VO.success();
    }

    @ApiOperation(value = "VIN码识别调用测试", notes = "VIN码识别调用测试")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/recognizeVINCode")
    public Object recognizeVINCode(@ApiParam(value="文件",required=true)
                                   @RequestParam(value = "file") MultipartFile file)  {
        //判断文件是否为空
        if(!file.isEmpty()) {
            //创建输入输出流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                return visionService.recognizeVINCode(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return VO.success();
    }

    //测试 使用 swagger 进行文件上传
    @ApiOperation(value = "身份证识别", notes = "身份证识别测试")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/recognizeIdentityCardAdvance")
    public Object recognizeIdentityCardAdvance(@ApiParam(value="文件",required=true)
                             @RequestParam(value = "file") MultipartFile file)  {
        //判断文件是否为空
        if(!file.isEmpty()) {
            //创建输入输出流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                return visionService.recognizeIdentityCardAdvance(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return VO.success();
    }

    @ApiOperation(value = "车辆损伤识别调用测试", notes = "车辆损伤识别调用测试")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/recognizeVehicleDamage")
    public Object recognizeVehicleDamage(@ApiParam(value="文件",required=true)
                                               @RequestParam(value = "file") MultipartFile file)  {
        //判断文件是否为空
        if(!file.isEmpty()) {
            //创建输入输出流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                return visionService.recognizeVehicleDamage(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return VO.success();
    }


}
