package com.example.asm.controller;

import com.example.asm.entity.ChucVu;
import com.example.asm.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/chuc-vu/hien-thi")
    public String hienThiCV(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChucVu> chucVuPage = chucVuService.pageCV(pageable);
        model.addAttribute("listCV", chucVuPage);
        return "/chucvu/chuc-vu-view";
    }

    @GetMapping("/chuc-vu/detail")
    public String detailCV(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChucVu> chucVuPage = chucVuService.pageCV(pageable);
        model.addAttribute("listCV", chucVuPage);
        ChucVu chucVu = chucVuService.getById(UUID.fromString(id));
        model.addAttribute("chucVu", chucVu);
        return "/chucvu/chuc-vu-view";
    }

    @GetMapping("/chuc-vu/remove")
    public String removeCV(@RequestParam("idRemove") String id) {
        chucVuService.deleteChucVu(UUID.fromString(id));
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/chuc-vu/view-update")
    public String viewUpdateCV(Model model, @RequestParam("idEdit") String id) {
        ChucVu chucVu = chucVuService.getById(UUID.fromString(id));
        model.addAttribute("chucVu", chucVu);
        return "/chucvu/chuc-vu-update";
    }

    @PostMapping("/chuc-vu/add")
    public String addChucVu(Model model, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        if (ma.isEmpty() || ten.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<ChucVu> chucVuPage = chucVuService.pageCV(pageable);
            model.addAttribute("listCV", chucVuPage);
            model.addAttribute("error", "Vui Long Dien Day Du Thong Tin");
            return "/chucvu/chuc-vu-view";
        }
        ChucVu chucVu = ChucVu.builder()
                .ma(ma)
                .ten(ten)
                .build();
        chucVuService.addChucVu(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("/chuc-vu/update")
    public String updateChucVu(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        ChucVu chucVu = ChucVu.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        chucVuService.updateChucVu(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
}
