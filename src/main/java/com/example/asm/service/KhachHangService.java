package com.example.asm.service;

import com.example.asm.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    List<KhachHang> getAllKH();

    KhachHang getByIdKH(UUID id);

    void addKH(KhachHang khachHang);

    void updateKH(KhachHang khachHang);

    void deleteKH(UUID id);

    Page<KhachHang> pageKH(Pageable pageable);
}
