package com.example.asm.controller;

import com.example.asm.entity.KhachHang;
import com.example.asm.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");

    @GetMapping("/khach-hang/hien-thi")
    public String hienThiKH(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<KhachHang> khachHangPage = khachHangService.pageKH(pageable);
        model.addAttribute("listKH", khachHangPage);
        return "/khachhang/khach-hang-view";
    }

    @GetMapping("khach-hang/detail")
    public String detailKH(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<KhachHang> khachHangPage = khachHangService.pageKH(pageable);
        model.addAttribute("listKH", khachHangPage);
        KhachHang khachHang = khachHangService.getByIdKH(UUID.fromString(id));
        model.addAttribute("khachHang", khachHang);
        return "/khachhang/khach-hang-view";
    }

    @GetMapping("/khach-hang/remove")
    public String removeKH(@RequestParam("idRemove") String id) {
        khachHangService.deleteKH(UUID.fromString(id));
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/view-update")
    public String viewUpdateKH(Model model, @RequestParam("idEdit") String id) {
        KhachHang khachHang = khachHangService.getByIdKH(UUID.fromString(id));
        model.addAttribute("khachHang", khachHang);
        return "/khachhang/khach-hang-update";
    }

    @PostMapping("/khach-hang/add")
    public String addKH(Model model, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("tenDem") String tenDem, @RequestParam("ho") String ho, @RequestParam("ngaySinh") String ngaySinh, @RequestParam("sdt") String sdt, @RequestParam("diaChi") String diaChi, @RequestParam("thanhPho") String thanhPho, @RequestParam("quocGia") String quocGia, @RequestParam("matKhau") String matKhau, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) throws ParseException {
        if (ma.isEmpty() || ten.isEmpty() || tenDem.isEmpty() || ho.isEmpty() || ngaySinh.isEmpty() || sdt.isEmpty() || diaChi.isEmpty() || thanhPho.isEmpty() || quocGia.isEmpty() || matKhau.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<KhachHang> khachHangPage = khachHangService.pageKH(pageable);
            model.addAttribute("listKH", khachHangPage);
            model.addAttribute("error", "Vui Long Dien Day Du Thong Tin");
            return "/khachhang/khach-hang-view";
        }
        KhachHang khachHang = KhachHang.builder()
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(dateFormat.parse(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .matKhau(matKhau)
                .build();
        khachHangService.addKH(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/khach-hang/update")
    public String updateKH(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("tenDem") String tenDem, @RequestParam("ho") String ho, @RequestParam("ngaySinh") String ngaySinh, @RequestParam("sdt") String sdt, @RequestParam("diaChi") String diaChi, @RequestParam("thanhPho") String thanhPho, @RequestParam("quocGia") String quocGia, @RequestParam("matKhau") String matKhau) throws ParseException {
        KhachHang khachHang = KhachHang.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(dateFormat.parse(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .matKhau(matKhau)
                .build();
        khachHangService.updateKH(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
}
