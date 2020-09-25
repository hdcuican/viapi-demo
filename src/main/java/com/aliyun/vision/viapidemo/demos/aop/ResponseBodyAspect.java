package com.aliyun.vision.viapidemo.demos.aop;

import com.aliyun.vision.viapidemo.demos.constants.ResponseEnum;
import com.aliyun.vision.viapidemo.demos.exception.BizException;
import com.aliyun.vision.viapidemo.demos.vo.VO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <pre>
 *     @author : loktar
 *     @e-mail : aakosp@gmail.com
 *     @time   : 2020-04-20
 *     @desc   :
 *     @version: 1.0
 * </pre>
 */
@Aspect
@Component
@Order(1)
public class ResponseBodyAspect {
    private static final int TOKEN_LENGTH = 8;
    private static final int RES_LENGTH = 300;

    @Pointcut("(@within(org.springframework.web.bind.annotation.RestController) ) || @annotation(org.springframework.web.bind.annotation.ResponseBody)")
    public void responseBody() {
    }

    @Around("responseBody()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Object result = null;
        Integer code = 0;
        String simplename = signature.getDeclaringType().getSimpleName();
        String methodName =  signature.getMethod().getName();
        String requestMethod = StringUtils.join(simplename, ".", methodName);
        long start = System.currentTimeMillis();
        String token = RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH);

        try {
            printRequestParam(token, signature, args);

            result = joinPoint.proceed(args);
            if (!(result instanceof ResponseEntity)  && !(result instanceof VO)) {
                //空对象或空集合返回code 404
                if (null == result
                        || (result instanceof Collection && CollectionUtils.isEmpty((Collection) result))) {
                    result = VO.response(ResponseEnum.NO_DATA);
                }else {
                    result = VO.response(ResponseEnum.SUCCESS, result);
                }
            }
        } catch (BizException e) {
            code = e.getCode();
            result = new VO(Integer.valueOf(e.getCode()), e.getMsg());
        } catch (Throwable e) {
            code = ResponseEnum.EXCEPTION.getCode();
            result = VO.response(ResponseEnum.EXCEPTION);
        } finally {
        }
        return result;
    }

    private void printRequestParam(String token, MethodSignature signature, Object[] args) {
        List<Object> argList = new ArrayList<>();
        for (Object arg : args) {
            argList.add(arg);
        }
    }

    private String substring(String str, int length) {
        if (StringUtils.length(str) > length) {
            return str.substring(0, length);
        }
        return str;
    }

}
