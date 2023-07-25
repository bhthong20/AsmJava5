package com.example.asm.service;

import com.example.asm.entity.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    List<CuaHang> getAllCH();

    CuaHang getByIdCH(UUID id);

    void addCuaHang(CuaHang cuaHang);

    void updateCuaHang(CuaHang cuaHang);

    void deleteCuaHang(UUID id);

    Page<CuaHang> pageCH(Pageable pageable);
}
