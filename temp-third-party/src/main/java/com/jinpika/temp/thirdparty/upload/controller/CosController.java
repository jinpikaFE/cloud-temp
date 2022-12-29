package com.jinpika.temp.thirdparty.upload.controller;

import com.jinpika.temp.thirdparty.upload.dto.CosCallbackResult;
import com.jinpika.temp.thirdparty.upload.service.impl.CosServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Api(tags = "CosController")
@Tag(name = "CosController", description = "Cos管理")
@RequestMapping("/cos")
public class CosController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CosController.class);
    @Autowired
    private CosServiceImpl cosService;

    @ApiOperation(value = "cos上传对象")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CosCallbackResult upload(@RequestPart("file") MultipartFile file) {

        CosCallbackResult result = cosService.upload(file);
        return result;
    }
}
