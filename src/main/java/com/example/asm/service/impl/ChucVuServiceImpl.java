package com.example.asm.service.impl;

import com.example.asm.entity.ChucVu;
import com.example.asm.repository.ChucVuRepository;
import com.example.asm.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;
    @Override
    public List<ChucVu> getAllCV() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu getById(UUID id) {
        return chucVuRepository.findById(id).orElse(null);
    }

    @Override
    public void addChucVu(ChucVu chucVu) {
        chucVuRepository.save(chucVu);

    }

    @Override
    public void updateChucVu(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void deleteChucVu(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public Page<ChucVu> pageCV(Pageable pageable) {
        return chucVuRepository.findAll(pageable);
    }
}
