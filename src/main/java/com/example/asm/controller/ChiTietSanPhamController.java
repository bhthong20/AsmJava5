package com.example.asm.controller;

import com.example.asm.entity.ChiTietSanPham;
import com.example.asm.entity.DongSanPham;
import com.example.asm.entity.MauSac;
import com.example.asm.entity.NhaSanXuat;
import com.example.asm.entity.SanPham;
import com.example.asm.service.ChiTietSanPhamService;
import com.example.asm.service.DongSanPhamService;
import com.example.asm.service.MauSacService;
import com.example.asm.service.NhaSanXuatService;
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

import java.util.List;
import java.util.UUID;

@Controller
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private NhaSanXuatService nhaSanXuatService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSanPhamService dongSanPhamService;
    @GetMapping("/chi-tiet-sp/hien-thi")
    public String hienThiCTSP(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChiTietSanPham> chiTietSPPage = chiTietSanPhamService.pageCTSP(pageable);
        model.addAttribute("listCTSP", chiTietSPPage);
        List<SanPham> sanPhams = sanPhamService.getAllSanPham();
        model.addAttribute("listSP", sanPhams);
        List<NhaSanXuat> nhaSanXuats = nhaSanXuatService.getAllNSX();
        model.addAttribute("listNSX", nhaSanXuats);
        List<MauSac> mauSacs = mauSacService.getAllMauSac();
        model.addAttribute("listMS", mauSacs);
        List<DongSanPham> dongSanPhams = dongSanPhamService.getAllDongSP();
        model.addAttribute("listDSP", dongSanPhams);
        return "/chitietsp/chitietsp-view";
    }

    @GetMapping("/chi-tiet-sp/detail")
    public String detailCTSP(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("idDetail") String id) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChiTietSanPham> chiTietSPPage = chiTietSanPhamService.pageCTSP(pageable);
        model.addAttribute("listCTSP", chiTietSPPage);
        List<SanPham> sanPhams = sanPhamService.getAllSanPham();
        model.addAttribute("listSP", sanPhams);
        List<NhaSanXuat> nhaSanXuats = nhaSanXuatService.getAllNSX();
        model.addAttribute("listNSX", nhaSanXuats);
        List<MauSac> mauSacs = mauSacService.getAllMauSac();
        model.addAttribute("listMS", mauSacs);
        List<DongSanPham> dongSanPhams = dongSanPhamService.getAllDongSP();
        model.addAttribute("listDSP", dongSanPhams);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getByIdCTSP(UUID.fromString(id));
        model.addAttribute("chitietSP", chiTietSanPham);
        return "/chitietsp/chitietsp-view";
    }

    @GetMapping("/chi-tiet-sp/remove")
    public String deleteCTSP(@RequestParam("idRemove") String id) {
        chiTietSanPhamService.deleteCTSP(UUID.fromString(id));
        return "redirect:/chi-tiet-sp/hien-thi";
    }

    @GetMapping("/chi-tiet-sp/view-update")
    public String viewUpdateCTSP(Model model, @RequestParam("idEdit") String id) {
        List<SanPham> sanPhams = sanPhamService.getAllSanPham();
        model.addAttribute("listSP", sanPhams);
        List<NhaSanXuat> nhaSanXuats = nhaSanXuatService.getAllNSX();
        model.addAttribute("listNSX", nhaSanXuats);
        List<MauSac> mauSacs = mauSacService.getAllMauSac();
        model.addAttribute("listMS", mauSacs);
        List<DongSanPham> dongSanPhams = dongSanPhamService.getAllDongSP();
        model.addAttribute("listDSP", dongSanPhams);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getByIdCTSP(UUID.fromString(id));
        model.addAttribute("chitietSP", chiTietSanPham);
        return "/chitietsp/chitietsp-update";
    }

    @PostMapping("/chi-tiet-sp/add")
    public String addCTSP(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo, @RequestParam("sanPham") String sp, @RequestParam("nsx") String nsx, @RequestParam("mauSac") String mauSac, @RequestParam("dongSP") String dongSP, @RequestParam("namBH") String namBH, @RequestParam("soLuongTon") String soLuongTon, @RequestParam("moTa") String moTa, @RequestParam("giaNhap") String giaNhap, @RequestParam("giaBan") String giaBan) {
        if (namBH.isEmpty() || soLuongTon.isEmpty() || moTa.isEmpty() || giaBan.isEmpty() || giaNhap.isEmpty()) {
            Pageable pageable = PageRequest.of(pageNo, 5);
            Page<ChiTietSanPham> chiTietSPPage = chiTietSanPhamService.pageCTSP(pageable);
            model.addAttribute("listCTSP", chiTietSPPage);
            List<SanPham> sanPhams = sanPhamService.getAllSanPham();
            model.addAttribute("listSP", sanPhams);
            List<NhaSanXuat> nhaSanXuats = nhaSanXuatService.getAllNSX();
            model.addAttribute("listNSX", nhaSanXuats);
            List<MauSac> mauSacs = mauSacService.getAllMauSac();
            model.addAttribute("listMS", mauSacs);
            List<DongSanPham> dongSanPhams = dongSanPhamService.getAllDongSP();
            model.addAttribute("listDSP", dongSanPhams);
            model.addAttribute("error", "Vui long dien day du thong tin!");
            return "/chitietsp/chitietsp-view";
        }
        ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
                .sanPham(sanPhamService.getByIdSanPham(UUID.fromString(sp)))
                .nhaSanXuat(nhaSanXuatService.getByIdNSX(UUID.fromString(nsx)))
                .dongSanPham(dongSanPhamService.getByIdDongSP(UUID.fromString(dongSP)))
                .mauSac(mauSacService.getByIdMauSac(UUID.fromString(mauSac)))
                .namBH(Integer.valueOf(namBH))
                .soLuongTon(Integer.valueOf(soLuongTon))
                .moTa(moTa)
                .giaBan(Double.valueOf(giaBan))
                .giaNhap(Double.valueOf(giaNhap))
                .build();
        chiTietSanPhamService.addCTSP(chiTietSanPham);
        return "redirect:/chi-tiet-sp/hien-thi";
    }

    @PostMapping("/chi-tiet-sp/update")
    public String addCTSP(@RequestParam("id") String id, @RequestParam("sanPham") String sp, @RequestParam("nsx") String nsx, @RequestParam("mauSac") String mauSac, @RequestParam("dongSP") String dongSP, @RequestParam("namBH") String namBH, @RequestParam("soLuongTon") String soLuongTon, @RequestParam("moTa") String moTa, @RequestParam("giaNhap") String giaNhap, @RequestParam("giaBan") String giaBan) {
        ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
                .id(UUID.fromString(id))
                .sanPham(sanPhamService.getByIdSanPham(UUID.fromString(sp)))
                .nhaSanXuat(nhaSanXuatService.getByIdNSX(UUID.fromString(nsx)))
                .dongSanPham(dongSanPhamService.getByIdDongSP(UUID.fromString(dongSP)))
                .mauSac(mauSacService.getByIdMauSac(UUID.fromString(mauSac)))
                .namBH(Integer.valueOf(namBH))
                .soLuongTon(Integer.valueOf(soLuongTon))
                .moTa(moTa)
                .giaBan(Double.valueOf(giaBan))
                .giaNhap(Double.valueOf(giaNhap))
                .build();
        chiTietSanPhamService.updateCTSP(chiTietSanPham);
        return "redirect:/chi-tiet-sp/hien-thi";
    }
}
