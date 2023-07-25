package com.example.asm.service;

import com.example.asm.entity.NhaSanXuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {

    List<NhaSanXuat> getAllNSX();

    NhaSanXuat getByIdNSX(UUID id);

    void addNSX(NhaSanXuat nhaSanXuat);

    void updateNSX(NhaSanXuat nhaSanXuat);

    void deleteNSX(UUID id);

    Page<NhaSanXuat> pageNSX(Pageable pageable);
}
