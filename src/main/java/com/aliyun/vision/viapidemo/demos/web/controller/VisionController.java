package com.aliyun.vision.viapidemo.demos.web.controller;


import com.aliyun.vision.viapidemo.demos.constants.ResponseEnum;
import com.aliyun.vision.viapidemo.demos.exception.BizException;
import com.aliyun.vision.viapidemo.demos.service.VisionService;
import com.aliyun.vision.viapidemo.demos.vo.VO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@Api(tags = "视觉AI应用作业1demo相关接口")
@RequestMapping("/demo1")
public class VisionController {

    @Autowired
    private VisionService visionService;

    //测试 使用 swagger 进行文件上传
    @ApiOperation(value = "车牌识别调用测试", notes = "车牌识别调用测试")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/recognizeLicensePlateAdvance")
    public Object recognizeLicensePlateAdvance(@ApiParam(value="文件",required=true)
                             @RequestParam(value = "file") MultipartFile file)  {
        //判断文件是否为空
        if(!file.isEmpty()) {
            //创建输入输出流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                return visionService.recognizeLicensePlateAdvance(inputStream);
            } catch (Exception e) {
                throw new BizException(ResponseEnum.PARSE_FAIL);
            }
        }
        return VO.success();
    }

    @ApiOperation(value = "行驶证识别调用测试", notes = "行驶证识别调用测试")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/recognizeDrivingLicense")
    public Object recognizeDrivingLicense(@ApiParam(value="文件",required=true)
                                         @RequestParam(value = "file") MultipartFile file)  {
        //判断文件是否为空
        if(!file.isEmpty()) {
            //创建输入输出流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                return visionService.recognizeDrivingLicense(inputStream);
            } catch (Exception e) {
                throw new BizException(ResponseEnum.PARSE_FAIL);
            }
        }
        return VO.success();
    }


    @ApiOperation(value = "人脸表情识别调用测试", notes = "人脸表情识别调用测试")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/recognizeExpression")
    public Object recognizeExpression(@ApiParam(value="文件",required=true)
                                   @RequestParam(value = "file") MultipartFile file)  {
        //判断文件是否为空
        if(!file.isEmpty()) {
            //创建输入输出流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                return visionService.recognizeExpression(inputStream);
            } catch (Exception e) {
                throw new BizException(ResponseEnum.PARSE_FAIL);
            }
        }
        return VO.success();
    }

    @ApiOperation(value = "人脸属性识别调用测试", notes = "人脸属性识别调用测试")
    @ApiImplicitParam(paramType = "form", name = "file", value = "文件对象", required = true, dataType = "__file")
    @PostMapping(value = "/recognizeFace")
    public Object recognizeFace(@ApiParam(value="文件",required=true)
                                      @RequestParam(value = "file") MultipartFile file)  {
        //判断文件是否为空
        if(!file.isEmpty()) {
            //创建输入输出流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                return visionService.recognizeFace(inputStream);
            } catch (Exception e) {
                throw new BizException(ResponseEnum.PARSE_FAIL);
            }
        }
        return VO.success();
    }
}
