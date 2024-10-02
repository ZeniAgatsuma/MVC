package com.zeni.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ZeniMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZeniMvcApplication.class, args);
    }

    @GetMapping("/")
    public String indexPost(Model model) {
        return "indexpost";
    }
}
