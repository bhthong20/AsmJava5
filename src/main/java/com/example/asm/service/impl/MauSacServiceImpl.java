package com.example.asm.service.impl;

import com.example.asm.entity.MauSac;
import com.example.asm.repository.MauSacRepository;
import com.example.asm.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAllMauSac() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac getByIdMauSac(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public void addMauSac(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void updateMauSac(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void deleteMauSac(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public Page<MauSac> pageMauSac(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }
}
