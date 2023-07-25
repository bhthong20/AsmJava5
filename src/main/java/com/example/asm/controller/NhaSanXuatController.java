package com.example.asm.controller;

import com.example.asm.entity.NhaSanXuat;
import com.example.asm.service.NhaSanXuatService;
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
public class NhaSanXuatController {

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @GetMapping("/nha-san-xuat/hien-thi")
    public String hienThiNSX(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<NhaSanXuat> nsxPage = nhaSanXuatService.pageNSX(pageable);
        model.addAttribute("listNSX", nsxPage);
        return "/nhasanxuat/nha-san-xuat-view";
    }

    @GetMapping("/nha-san-xuat/detail")
    public String detailNSX(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<NhaSanXuat> nsxPage = nhaSanXuatService.pageNSX(pageable);
        model.addAttribute("listNSX", nsxPage);
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getByIdNSX(UUID.fromString(id));
        model.addAttribute("Nsx", nhaSanXuat);
        return "/nhasanxuat/nha-san-xuat-view";
    }

    @GetMapping("/nha-san-xuat/remove")
    public String removeNSX(@RequestParam("idRemove") String id) {
        nhaSanXuatService.deleteNSX(UUID.fromString(id));
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("/nha-san-xuat/view-update")
    public String viewUpdateNSX(Model model, @RequestParam("idEdit") String id) {
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getByIdNSX(UUID.fromString(id));
        model.addAttribute("Nsx", nhaSanXuat);
        return "/nhasanxuat/nha-san-xuat-update";
    }

    @PostMapping("/nha-san-xuat/add")
    public String addNSX(Model model, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        if (ma.isEmpty() || ten.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<NhaSanXuat> nsxPage = nhaSanXuatService.pageNSX(pageable);
            model.addAttribute("listNSX", nsxPage);
            model.addAttribute("error", "Vui Long Dien Day Du Thong Tin");
            return "/nha-san-xuat/nha-san-xuat-view";
        }
        NhaSanXuat nhaSanXuat = NhaSanXuat.builder()
                .ma(ma)
                .ten(ten)
                .build();
        nhaSanXuatService.addNSX(nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @PostMapping("/nha-san-xuat/update")
    public String updateNSX(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        NhaSanXuat nhaSanXuat = NhaSanXuat.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        nhaSanXuatService.updateNSX(nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }
}
