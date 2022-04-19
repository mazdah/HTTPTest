package com.innotree.study.httptest.webresources.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DynamicWebResource {
    Logger logger = LoggerFactory.getLogger(DynamicWebResource.class);

    @PostMapping(value = "/calcadd")
    @ResponseBody
    public Map<String, String> calcAdd(@RequestBody Map<String, Object> param) {
        logger.info("🔹🔹🔹🔹🔹 calcAdd : param = {}", param);

        Map<String, String> responseMap = new HashMap<String, String>();

        if (null != param && param.size() > 0) {
            String fNum = (String)param.get("firstNum");
            String sNum = (String)param.get("secondNum");

            logger.info("🔹🔹🔹🔹🔹 calcAdd : fNum = " + fNum + ", sNum = " + sNum);

            responseMap.put("responseCode", "SUCCESS");
            responseMap.put("responseValue", "" + (Integer.valueOf(fNum) + Integer.valueOf(sNum)));
        } else {
            responseMap.put("responseCode", "FAIL");
            responseMap.put("responseValue", "NaN");
        }

        logger.info("🔹🔹🔹🔹🔹 calcAdd : responseMap = {}", responseMap);
        return responseMap;
    }

}
