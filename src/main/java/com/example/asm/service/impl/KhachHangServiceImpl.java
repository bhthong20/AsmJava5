package com.example.asm.service.impl;

import com.example.asm.entity.KhachHang;
import com.example.asm.repository.ChucVuRepository;
import com.example.asm.repository.KhachHangRepository;
import com.example.asm.service.ChucVuService;
import com.example.asm.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAllKH() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang getByIdKH(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public void addKH(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void updateKH(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void deleteKH(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public Page<KhachHang> pageKH(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }
}
