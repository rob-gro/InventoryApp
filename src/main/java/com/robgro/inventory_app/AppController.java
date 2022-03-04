package com.robgro.inventory_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/"})
    public String viewHomePage() {
        return "index";
    }
}
