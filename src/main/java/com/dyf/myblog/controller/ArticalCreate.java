package com.dyf.myblog.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticalCreate{
    @GetMapping("/web/createArtical")
    public String blogPage() {
        return "html/createArtical";
    }
}
