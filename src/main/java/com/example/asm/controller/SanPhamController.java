package com.example.asm.controller;

import com.example.asm.entity.SanPham;
import com.example.asm.service.SanPhamService;
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
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/san-pham/hien-thi")
    public String hienThiSanPham(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<SanPham> sanPhamPage = sanPhamService.pageSanPham(pageable);
        model.addAttribute("listSP", sanPhamPage);
        return "/sanpham/san-pham-view";
    }

    @GetMapping("/san-pham/detail")
    public String detailSanPham(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<SanPham> sanPhamPage = sanPhamService.pageSanPham(pageable);
        model.addAttribute("listSP", sanPhamPage);
        SanPham sanPham = sanPhamService.getByIdSanPham(UUID.fromString(id));
        model.addAttribute("sanPham", sanPham);
        return "/sanpham/san-pham-view";
    }

    @GetMapping("/san-pham/remove")
    public String removeSanPham(@RequestParam("idRemove") String id) {
        sanPhamService.deleteSanPham(UUID.fromString(id));
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/view-update")
    public String viewUpdateSanPham(Model model, @RequestParam("idEdit") String id) {
        SanPham sanPham = sanPhamService.getByIdSanPham(UUID.fromString(id));
        model.addAttribute("sanPham", sanPham);
        return "/sanpham/san-pham-update";
    }

    @PostMapping("/san-pham/add")
    public String addSanPham(Model model, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        if (ma.isEmpty() || ten.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<SanPham> sanPhamPage = sanPhamService.pageSanPham(pageable);
            model.addAttribute("listSP", sanPhamPage);
            model.addAttribute("error", "Vui Long Dien Day Du Thong Tin");
            return "/sanpham/san-pham-view";
        }
        SanPham sanPham = SanPham.builder()
                .ma(ma)
                .ten(ten)
                .build();
        sanPhamService.addSanPham(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/san-pham/update")
    public String updateSanPham(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten) {
        SanPham sanPham = SanPham.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .build();
        sanPhamService.updateSanPham(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}
