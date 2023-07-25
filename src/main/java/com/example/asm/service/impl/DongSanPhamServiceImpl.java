package com.example.asm.service.impl;

import com.example.asm.entity.DongSanPham;
import com.example.asm.repository.DongSanPhamRepository;
import com.example.asm.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {
    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSanPham> getAllDongSP() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public DongSanPham getByIdDongSP(UUID id) {
        return dongSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void addDongSP(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void updateDongSP(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void deleteDongSP(UUID id) {
        dongSanPhamRepository.deleteById(id);
    }

    @Override
    public Page<DongSanPham> pageDongSP(Pageable pageable) {
        return dongSanPhamRepository.findAll(pageable);
    }
}
