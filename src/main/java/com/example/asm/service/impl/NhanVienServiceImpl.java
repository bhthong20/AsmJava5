package com.example.asm.service.impl;

import com.example.asm.entity.NhanVien;
import com.example.asm.repository.NhanVienRepository;
import com.example.asm.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAllNV() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getByIdNV(UUID id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public void addNV(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void updateNV(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void deleteNV(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public Page<NhanVien> pageNV(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }
}
