package com.example.asm.controller;

import com.example.asm.entity.MauSac;
import com.example.asm.service.MauSacService;
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
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/mau-sac/hien-thi")
    public String hienThiMS(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<MauSac> mauSacPage = mauSacService.pageMauSac(pageable);
        model.addAttribute("listMS", mauSacPage);
        return "/mausac/mau-sac-view";
    }

    @GetMapping("/mau-sac/detail")
    public String detailMS(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<MauSac> mauSacPage = mauSacService.pageMauSac(pageable);
        model.addAttribute("listMS", mauSacPage);
        MauSac mauSac = mauSacService.getByIdMauSac(UUID.fromString(id));
        model.addAttribute("mauSac", mauSac);
        return "/mausac/mau-sac-view";
    }

    @GetMapping("/mau-sac/remove")
    public String removeMS(@RequestParam("idRemove") String id) {
        mauSacService.deleteMauSac(UUID.fromString(id));
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/view-update")
    public String viewUpdateMS(Model model, @RequestParam("idEdit") String id) {
        MauSac mauSac = mauSacService.getByIdMauSac(UUID.fromString(id));
        model.addAttribute("mauSac", mauSac);
        return "/mausac/mau-sac-update";
    }

    @PostMapping("/mau-sac/add")
    public String addMS(Model model, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        if (ma.isEmpty() || ten.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<MauSac> mauSacPage = mauSacService.pageMauSac(pageable);
            model.addAttribute("listMS", mauSacPage);
            model.addAttribute("error", "Vui Long Dien Day Du Thong Tin");
            return "/mausac/mau-sac-view";
        }
        MauSac mauSac = MauSac.builder()
                .ma(ma)
                .ten(ten)
                .build();
        mauSacService.addMauSac(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/mau-sac/update")
    public String updateMS(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        MauSac mauSac = MauSac.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        mauSacService.updateMauSac(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
