package com.example.asm.controller;

import com.example.asm.entity.ChucVu;
import com.example.asm.entity.CuaHang;
import com.example.asm.entity.NhanVien;
import com.example.asm.service.ChucVuService;
import com.example.asm.service.CuaHangService;
import com.example.asm.service.NhanVienService;
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
import java.util.List;
import java.util.UUID;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/nhan-vien/hien-thi")
    public String hienThiNhanVien(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<NhanVien> nhanVienPage = nhanVienService.pageNV(pageable);
        model.addAttribute("listNV", nhanVienPage);
//        List<NhanVien> nhanViens = nhanVienService.getAllNV();
//        model.addAttribute("listNV", nhanViens);
        List<CuaHang> cuaHangs = cuaHangService.getAllCH();
        model.addAttribute("listCH", cuaHangs);
        List<ChucVu> chucVus = chucVuService.getAllCV();
        model.addAttribute("listCV", chucVus);
        return "/nhanvien/nhan-vien-view";
    }

    @GetMapping("/nhan-vien/detail")
    public String detailNhanVien(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<NhanVien> nhanVienPage = nhanVienService.pageNV(pageable);
        model.addAttribute("listNV", nhanVienPage);
        List<CuaHang> cuaHangs = cuaHangService.getAllCH();
        model.addAttribute("listCH", cuaHangs);
        List<ChucVu> chucVus = chucVuService.getAllCV();
        model.addAttribute("listCV", chucVus);
        NhanVien nhanVien = nhanVienService.getByIdNV(UUID.fromString(id));
        model.addAttribute("nhanVien", nhanVien);
        return "/nhanvien/nhan-vien-view";
    }

    @GetMapping("/nhan-vien/remove")
    public String removeNhanVien(@RequestParam("idRemove") String id) {
        nhanVienService.deleteNV(UUID.fromString(id));
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/nhan-vien/view-update")
    public String viewUpdateNhanVien(Model model, @RequestParam("idEdit") String id) {
        NhanVien nhanVien = nhanVienService.getByIdNV(UUID.fromString(id));
        model.addAttribute("nhanVien", nhanVien);
        List<CuaHang> cuaHangs = cuaHangService.getAllCH();
        model.addAttribute("listCH", cuaHangs);
        List<ChucVu> chucVus = chucVuService.getAllCV();
        model.addAttribute("listCV", chucVus);
        return "/nhanvien/nhan-vien-update";
    }

    @PostMapping("/nhan-vien/add")
    public String addNhanVien(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("tenDem") String tenDem, @RequestParam("ho") String ho, @RequestParam("ngaySinh") String ngaySinh, @RequestParam("sdt") String sdt, @RequestParam("diaChi") String diaChi, @RequestParam("gioiTinh") String gioiTinh, @RequestParam("matKhau") String matKhau, @RequestParam("cuaHang") String cuaHang, @RequestParam("chucVu") String chucVu, @RequestParam("trangThai") String trangThai) throws ParseException {
        if (ma.isEmpty() || ten.isEmpty() || tenDem.isEmpty() || ho.isEmpty() || ngaySinh.isEmpty() || sdt.isEmpty() || diaChi.isEmpty() || matKhau.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<NhanVien> nhanVienPage = nhanVienService.pageNV(pageable);
            model.addAttribute("listNV", nhanVienPage);
            List<CuaHang> cuaHangs = cuaHangService.getAllCH();
            model.addAttribute("listCH", cuaHangs);
            List<ChucVu> chucVus = chucVuService.getAllCV();
            model.addAttribute("listCV", chucVus);
            model.addAttribute("error", "Vui Long Dien Day Du Thong Tin");
            return "/nhanvien/nhan-vien-view";
        }
        NhanVien nhanVien = NhanVien.builder()
                .ma(ma)
                .ten(ten)
                .ho(ho)
                .tenDem(tenDem)
                .gioiTinh(gioiTinh)
                .ngaySinh(format.parse(ngaySinh))
                .diaChi(diaChi)
                .sdt(sdt)
                .trangThai(Integer.valueOf(trangThai))
                .matKhau(matKhau)
                .cuaHang(cuaHangService.getByIdCH(UUID.fromString(cuaHang)))
                .chucVu(chucVuService.getById(UUID.fromString(chucVu)))
                .build();
        nhanVienService.addNV(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/nhan-vien/update")
    public String updateNhanVien(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten, @RequestParam("tenDem") String tenDem, @RequestParam("ho") String ho, @RequestParam("ngaySinh") String ngaySinh, @RequestParam("sdt") String sdt, @RequestParam("diaChi") String diaChi, @RequestParam("gioiTinh") String gioiTinh, @RequestParam("matKhau") String matKhau, @RequestParam("cuaHang") String cuaHang, @RequestParam("chucVu") String chucVu, @RequestParam("trangThai") String trangThai) throws ParseException {
        NhanVien nhanVien = NhanVien.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .ho(ho)
                .tenDem(tenDem)
                .gioiTinh(gioiTinh)
                .ngaySinh(format.parse(ngaySinh))
                .diaChi(diaChi)
                .sdt(sdt)
                .trangThai(Integer.valueOf(trangThai))
                .matKhau(matKhau)
                .cuaHang(cuaHangService.getByIdCH(UUID.fromString(cuaHang)))
                .chucVu(chucVuService.getById(UUID.fromString(chucVu)))
                .build();
        nhanVienService.addNV(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

}
