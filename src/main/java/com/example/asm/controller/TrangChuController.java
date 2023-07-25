package com.example.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {

    @GetMapping("/asm/trang-chu")
    public String trangChu(){
        return "trangchu";
    }
}
