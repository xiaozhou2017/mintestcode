package com.example.demo.controller;
import com.example.demo.ExtraUtils.ResponseObject;
import com.example.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    private static Logger log = LoggerFactory.getLogger(DemoController.class);



    /**
     *input string like "2"  "2,3"   "8,9,6"  "10,99,12"
     * @param digitstr
     * @return ResponseObject
     */

    @RequestMapping(value = "/letterbynum",method = RequestMethod.GET)
    public ResponseObject getletterbynum(String digitstr){ //没有封装Bean,对数组传值不友好，暂时采用string 规则传值
        List<String> ls;
        try {
            log.info("===input========={}",digitstr);
            ls=demoService.doexcute(digitstr);
            log.info("===output========={}",ls);
            return ResponseObject.success(ls);
        }catch (Exception e){
            log.info("system error ~~~~~~~~~~~~~");
            return ResponseObject.error(ResponseObject.ResponseCode_COMMON_ERROE,e.getMessage());
        }
    }

}
