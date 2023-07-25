package com.example.asm.service;

import com.example.asm.entity.KhachHang;
import com.example.asm.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAllMauSac();

    MauSac getByIdMauSac(UUID id);

    void addMauSac(MauSac mauSac);

    void updateMauSac(MauSac mauSac);

    void deleteMauSac(UUID id);

    Page<MauSac> pageMauSac(Pageable pageable);
}
