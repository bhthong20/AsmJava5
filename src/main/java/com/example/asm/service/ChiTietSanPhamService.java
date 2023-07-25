package com.example.asm.service;

import com.example.asm.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAllCTSP();

    ChiTietSanPham getByIdCTSP(UUID id);

    void addCTSP(ChiTietSanPham chiTietSanPham);

    void updateCTSP(ChiTietSanPham chiTietSanPham);

    void deleteCTSP(UUID id);

    Page<ChiTietSanPham> pageCTSP(Pageable pageable);
}
