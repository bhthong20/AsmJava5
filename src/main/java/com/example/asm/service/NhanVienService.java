package com.example.asm.service;

import com.example.asm.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    List<NhanVien> getAllNV();

    NhanVien getByIdNV(UUID id);

    void addNV(NhanVien nhanVien);

    void updateNV(NhanVien nhanVien);

    void deleteNV(UUID id);

    Page<NhanVien> pageNV(Pageable pageable);
}
