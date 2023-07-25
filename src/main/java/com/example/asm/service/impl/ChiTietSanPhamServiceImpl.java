package com.example.asm.service.impl;

import com.example.asm.entity.ChiTietSanPham;
import com.example.asm.repository.ChiTietSanPhamRepository;
import com.example.asm.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<ChiTietSanPham> getAllCTSP() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public ChiTietSanPham getByIdCTSP(UUID id) {
        return chiTietSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void addCTSP(ChiTietSanPham chiTietSanPham) {
    chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void updateCTSP(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void deleteCTSP(UUID id) {
        chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public Page<ChiTietSanPham> pageCTSP(Pageable pageable) {
        return chiTietSanPhamRepository.findAll(pageable);
    }
}
