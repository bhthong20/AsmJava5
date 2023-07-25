package com.example.asm.service.impl;

import com.example.asm.entity.SanPham;
import com.example.asm.repository.SanPhamRepository;
import com.example.asm.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;


    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham getByIdSanPham(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void deleteSanPham(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public Page<SanPham> pageSanPham(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }
}
