package com.innotree.study.httptest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class PageMoveController {
    Logger logger = LoggerFactory.getLogger(PageMoveController.class);

    @GetMapping("/")
    public String goIndex(HttpServletRequest req) {
        logger.info("🔸🔸🔸🔸🔸 goIndex");

        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            logger.info("🔸🔸🔸🔸🔸 header = " + header + " : " + req.getHeader(header));
        }

        return "index";
    }

    @GetMapping("/httpguide1")
    public String goHttpguide1(HttpServletRequest req) {
        logger.info("🔸🔸🔸🔸🔸 goHttpguide1");

        return "/httpguide/httpresources";
    }

    @GetMapping("/httpmethod")
    public String goHttpMethod(HttpServletRequest req) {
        logger.info("🔸🔸🔸🔸🔸 goHttpMethod");

        return "/httpguide/httpmethod";
    }

    @GetMapping("/httpurl")
    public String goHttpUrl(HttpServletRequest req) {
        logger.info("🔸🔸🔸🔸🔸 goHttpUrl");

        return "/httpguide/httpurl";
    }
}
