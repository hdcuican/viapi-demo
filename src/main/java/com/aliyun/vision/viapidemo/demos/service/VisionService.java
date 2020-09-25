package com.aliyun.vision.viapidemo.demos.service;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.aliyun.facebody20191230.models.RecognizeExpressionAdvanceRequest;
import com.aliyun.facebody20191230.models.RecognizeExpressionResponse;
import com.aliyun.facebody20191230.models.RecognizeFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.RecognizeFaceResponse;
import com.aliyun.objectdet20191230.models.RecognizeVehicleDamageAdvanceRequest;
import com.aliyun.objectdet20191230.models.RecognizeVehicleDamageResponse;
import com.aliyun.ocr20191230.Client;
import com.aliyun.ocr20191230.models.*;
import com.aliyun.tearpc.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Service
public class VisionService {

    private Client ocrClient;
    com.aliyun.facebody20191230.Client faceClient;
    com.aliyun.objectdet20191230.Client objectdetClient;
    private RuntimeOptions runtime;

    @Value("${viapi.accessKeyId}")
    private String accessKeyId;
    @Value("${viapi.accessKeySecret}")
    private String accessKeySecret;

    @PostConstruct
    private void init() throws Exception {
        Config config = new Config();
        config.type = "access_key";
        config.regionId = "cn-shanghai";
        config.accessKeyId = accessKeyId;
        config.accessKeySecret = accessKeySecret;
        config.endpoint = "ocr.cn-shanghai.aliyuncs.com";
        ocrClient = new Client(config);
        config.endpoint = "facebody.cn-shanghai.aliyuncs.com";
        faceClient = new com.aliyun.facebody20191230.Client(config);
        config.endpoint = "objectdet.cn-shanghai.aliyuncs.com";
        objectdetClient = new com.aliyun.objectdet20191230.Client(config);
        runtime = new RuntimeOptions();
    }

    /**
     * 视觉AI平台 车牌识别调用测试
     * @param inputStream
     * @return
     * @throws Exception
     */
    public Object recognizeLicensePlateAdvance(InputStream inputStream) throws Exception {
        RecognizeLicensePlateAdvanceRequest request = new RecognizeLicensePlateAdvanceRequest();
        request.imageURLObject = inputStream;
        RecognizeLicensePlateResponse response = ocrClient.recognizeLicensePlateAdvance(request, runtime);
        return response;
    }


    /**
     * 视觉AI平台 驾驶证识别调用测试
     * @param inputStream
     * @return
     * @throws Exception
     */
    public Object recognizeDriverLicense(InputStream inputStream) throws Exception {
        RecognizeDriverLicenseAdvanceRequest request = new RecognizeDriverLicenseAdvanceRequest();
        request.imageURLObject = inputStream;
        request.setSide("face");
        RecognizeDriverLicenseResponse response = ocrClient.recognizeDriverLicenseAdvance(request, runtime);
        return response;
    }

    /**
     * 视觉AI平台 行驶证识别调用测试
     * @param inputStream
     * @return
     * @throws Exception
     */
    public Object recognizeDrivingLicense(InputStream inputStream) throws Exception {
        RecognizeDrivingLicenseAdvanceRequest request = new RecognizeDrivingLicenseAdvanceRequest();
        request.imageURLObject = inputStream;
        request.setSide("face");
        RecognizeDrivingLicenseResponse response = ocrClient.recognizeDrivingLicenseAdvance(request, runtime);
        return response;
    }

    /**
     * 视觉AI平台 VIN码识别调用测试
     * @param inputStream
     * @return
     * @throws Exception
     */
    public Object recognizeVINCode(InputStream inputStream) throws Exception {
        RecognizeVINCodeAdvanceRequest request = new RecognizeVINCodeAdvanceRequest();
        request.imageURLObject = inputStream;
        RecognizeVINCodeResponse response = ocrClient.recognizeVINCodeAdvance(request, runtime);
        return response;
    }

    /**
     * 视觉AI平台 人脸表情识别调用测试
     * @param inputStream
     * @return
     * @throws Exception
     */
    public Object recognizeExpression(InputStream inputStream) throws Exception {
        RecognizeExpressionAdvanceRequest request = new RecognizeExpressionAdvanceRequest();
        request.imageURLObject = inputStream;
        RecognizeExpressionResponse response = faceClient.recognizeExpressionAdvance(request, runtime);
        return response.data.elements;
    }

    /**
     * 视觉AI平台 人脸属性识别调用测试
     * @param inputStream
     * @return
     * @throws Exception
     */
    public Object recognizeFace(InputStream inputStream) throws Exception {
        RecognizeFaceAdvanceRequest request = new RecognizeFaceAdvanceRequest();
        request.imageURLObject = inputStream;
        RecognizeFaceResponse response = faceClient.recognizeFaceAdvance(request, runtime);
        return response.data.expressions;
    }



    /**
     * 视觉AI平台 身份证识别调用测试
     * @param inputStream
     * @return
     * @throws Exception
     */
    public Object recognizeIdentityCardAdvance(InputStream inputStream) throws Exception {
        RecognizeIdentityCardAdvanceRequest request = new RecognizeIdentityCardAdvanceRequest();
        request.imageURLObject = inputStream;
        request.setSide("face");
        RecognizeIdentityCardResponse response = ocrClient.recognizeIdentityCardAdvance(request, runtime);
        return response;
    }


    /**
     * 视觉AI平台 车辆损伤调用测试
     * @param inputStream
     * @return
     * @throws Exception
     */
    public Object recognizeVehicleDamage(InputStream inputStream) throws Exception {
        RecognizeVehicleDamageAdvanceRequest request = new RecognizeVehicleDamageAdvanceRequest();
        request.imageURLObject = inputStream;
        RecognizeVehicleDamageResponse response = objectdetClient.recognizeVehicleDamageAdvance(request, runtime);
        return response;
    }


}
