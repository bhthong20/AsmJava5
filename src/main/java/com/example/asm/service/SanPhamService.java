package com.example.asm.service;

import com.example.asm.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAllSanPham();

    SanPham getByIdSanPham(UUID id);

    void addSanPham(SanPham sanPham);

    void updateSanPham(SanPham sanPham);

    void deleteSanPham(UUID id);

    Page<SanPham> pageSanPham(Pageable pageable);
}
