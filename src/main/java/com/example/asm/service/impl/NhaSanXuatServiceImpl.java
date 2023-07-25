package com.example.asm.service.impl;

import com.example.asm.entity.NhaSanXuat;
import com.example.asm.repository.NhaSanXuatRepository;
import com.example.asm.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public List<NhaSanXuat> getAllNSX() {
        return nhaSanXuatRepository.findAll();
    }

    @Override
    public NhaSanXuat getByIdNSX(UUID id) {
        return nhaSanXuatRepository.findById(id).orElse(null);
    }

    @Override
    public void addNSX(NhaSanXuat nhaSanXuat) {
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public void updateNSX(NhaSanXuat nhaSanXuat) {
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public void deleteNSX(UUID id) {
        nhaSanXuatRepository.deleteById(id);
    }

    @Override
    public Page<NhaSanXuat> pageNSX(Pageable pageable) {
        return nhaSanXuatRepository.findAll(pageable);
    }
}
