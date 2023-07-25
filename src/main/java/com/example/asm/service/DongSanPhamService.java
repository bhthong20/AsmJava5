package com.example.asm.service;

import com.example.asm.entity.DongSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    List<DongSanPham> getAllDongSP();

    DongSanPham getByIdDongSP(UUID id);

    void addDongSP(DongSanPham dongSanPham);

    void updateDongSP(DongSanPham dongSanPham);

    void deleteDongSP(UUID id);

    Page<DongSanPham> pageDongSP(Pageable pageable);
}
