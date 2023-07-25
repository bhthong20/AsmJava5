package com.example.asm.service.impl;

import com.example.asm.entity.CuaHang;
import com.example.asm.repository.CuaHangRepository;
import com.example.asm.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getAllCH() {
        return cuaHangRepository.findAll();
    }

    @Override
    public CuaHang getByIdCH(UUID id) {
        return cuaHangRepository.findById(id).orElse(null);
    }

    @Override
    public void addCuaHang(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void updateCuaHang(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void deleteCuaHang(UUID id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public Page<CuaHang> pageCH(Pageable pageable) {
        return cuaHangRepository.findAll(pageable);
    }
}
