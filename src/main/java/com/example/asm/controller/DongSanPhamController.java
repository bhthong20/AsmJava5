package com.example.asm.controller;

import com.example.asm.entity.DongSanPham;
import com.example.asm.service.DongSanPhamService;
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
public class DongSanPhamController {
    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("/dong-sp/hien-thi")
    public String hienThiDSP(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<DongSanPham> pageDongSP = dongSanPhamService.pageDongSP(pageable);
        model.addAttribute("listDSP", pageDongSP);
        return "/dongsp/dong-sp-view";
    }

    @GetMapping("/dong-sp/detail")
    public String detailDSP(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<DongSanPham> pageDongSP = dongSanPhamService.pageDongSP(pageable);
        model.addAttribute("listDSP", pageDongSP);
        DongSanPham dongSanPham = dongSanPhamService.getByIdDongSP(UUID.fromString(id));
        model.addAttribute("dongSP", dongSanPham);
        return "/dongsp/dong-sp-view";
    }

    @GetMapping("/dong-sp/remove")
    public String removeDSP(@RequestParam("idRemove") String id) {
        dongSanPhamService.deleteDongSP(UUID.fromString(id));
        return "redirect:/dong-sp/hien-thi";
    }

    @GetMapping("/dong-sp/view-update")
    public String viewUpdateDSP(Model model, @RequestParam("idEdit") String id) {
        DongSanPham dongSanPham = dongSanPhamService.getByIdDongSP(UUID.fromString(id));
        model.addAttribute("dongSP", dongSanPham);
        return "/dongsp/dong-sp-update";
    }

    @PostMapping("/dong-sp/add")
    public String addDSP(Model model, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        if (ma.isEmpty() || ten.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<DongSanPham> pageDongSP = dongSanPhamService.pageDongSP(pageable);
            model.addAttribute("listDSP", pageDongSP);
            model.addAttribute("error", "Vui Long Dien Day Du Thong Tin");
            return "/dongsp/dong-sp-view";
        }
        DongSanPham dongSanPham = DongSanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        dongSanPhamService.addDongSP(dongSanPham);
        return "redirect:/dong-sp/hien-thi";
    }

    @PostMapping("/dong-sp/update")
    public String updateDSP(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        DongSanPham dongSanPham = DongSanPham.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        dongSanPhamService.updateDongSP(dongSanPham);
        return "redirect:/dong-sp/hien-thi";
    }
}
