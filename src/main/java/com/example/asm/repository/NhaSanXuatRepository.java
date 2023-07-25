package com.example.asm.repository;

import com.example.asm.entity.NhaSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhaSanXuatRepository extends JpaRepository<NhaSanXuat, UUID> {
}
