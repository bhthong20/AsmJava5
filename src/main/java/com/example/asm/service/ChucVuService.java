package com.example.asm.service;

import com.example.asm.entity.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    List<ChucVu> getAllCV();

    ChucVu getById(UUID id);

    void addChucVu(ChucVu chucVu);

    void updateChucVu(ChucVu chucVu);

    void deleteChucVu(UUID id);

    Page<ChucVu> pageCV(Pageable pageable);
}
