package com.ngockhuong.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MainController {
    @Value("${text.copyright: Default Copyright}")
    private String copyright;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.user}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @RequestMapping("/showConfig")
    @ResponseBody
    public String showConfig() {
        String configInfo = "Copyright: " + copyright
                + "<br>spring.datasource.driver-class-name=" + driverClassName
                + "<br>spring.datasource.url=" + url
                + "<br>spring.datasource.user=" + user
                + "<br>spring.datasource.password=" + password;

        return configInfo;
    }
}
