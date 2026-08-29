package com.mathias.pos.repository;

import com.mathias.pos.entity.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBarcodeRepository extends JpaRepository<Barcode, Long> {
}