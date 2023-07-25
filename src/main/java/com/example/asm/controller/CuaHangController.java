package com.example.asm.controller;

import com.example.asm.entity.CuaHang;
import com.example.asm.service.CuaHangService;
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
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/cua-hang/hien-thi")
    public String hienThiCH(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<CuaHang> cuaHangPage = cuaHangService.pageCH(pageable);
        model.addAttribute("listCH", cuaHangPage);
        return "/cuahang/cua-hang-view";
    }

    @GetMapping("/cua-hang/detail")
    public String detailCH(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<CuaHang> cuaHangPage = cuaHangService.pageCH(pageable);
        model.addAttribute("listCH", cuaHangPage);
        CuaHang cuaHang = cuaHangService.getByIdCH(UUID.fromString(id));
        model.addAttribute("cuaHang", cuaHang);
        return "/cuahang/cua-hang-view";
    }

    @GetMapping("/cua-hang/remove")
    public String deleteCH(@RequestParam("idRemove") String id) {
        cuaHangService.deleteCuaHang(UUID.fromString(id));
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/cua-hang/view-update")
    public String viewUpdateCH(Model model, @RequestParam("idEdit") String id) {
        CuaHang cuaHang = cuaHangService.getByIdCH(UUID.fromString(id));
        model.addAttribute("cuaHang", cuaHang);
        return "/cuahang/cua-hang-update";
    }

    @PostMapping("/cua-hang/add")
    public String addCH(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("diaChi") String diaChi, @RequestParam("thanhPho") String thanhPho, @RequestParam("quocGia") String quocGia) {
        if (ma.isEmpty() || ten.isEmpty() || diaChi.isEmpty() || thanhPho.isEmpty() || quocGia.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<CuaHang> cuaHangPage = cuaHangService.pageCH(pageable);
            model.addAttribute("listCH", cuaHangPage);
            model.addAttribute("error", "Vui Long dien day du thong tin");
            return "/cuahang/cua-hang-view";
        }
        CuaHang cuaHang = CuaHang.builder()
                .ma(ma)
                .ten(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        cuaHangService.addCuaHang(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @PostMapping("/cua-hang/upadte")
    public String updateCH(@RequestParam("id") String id,@RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("diaChi") String diaChi, @RequestParam("thanhPho") String thanhPho, @RequestParam("quocGia") String quocGia) {
        CuaHang cuaHang = CuaHang.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        cuaHangService.addCuaHang(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
}
