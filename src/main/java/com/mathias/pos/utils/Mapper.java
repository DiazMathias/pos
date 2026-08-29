package com.mathias.pos.utils;

import com.mathias.pos.dto.BarcodeRequestDTO;
import com.mathias.pos.dto.BarcodeResponseDTO;
import com.mathias.pos.dto.ProductResponseDTO;
import com.mathias.pos.entity.Barcode;
import com.mathias.pos.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    // Product -> ProductResponseDTO (includes its barcodes)
    public static ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setBarcodes(toDTO(product.getBarcodes()));

        return dto;
    }

    // List<Barcode> -> List<BarcodeResponseDTO>
    public static List<BarcodeResponseDTO> toDTO(List<Barcode> barcodes) {
        List<BarcodeResponseDTO> result = new ArrayList<>();
        for (Barcode barcode : barcodes) {
            BarcodeResponseDTO barcodeDTO = new BarcodeResponseDTO();
            barcodeDTO.setId(barcode.getId());
            barcodeDTO.setCode(barcode.getBarcode());
            result.add(barcodeDTO);
        }

        return result;
    }

    // List<BarcodeRequestDTO> -> List<Barcode>
    public static List<Barcode> toEntity(List<BarcodeRequestDTO> barcodes) {
        List<Barcode> result = new ArrayList<>();
        for (BarcodeRequestDTO barcodeDTO : barcodes) {
            Barcode barcode = new Barcode();
            barcode.setBarcode(barcodeDTO.getCode());
            result.add(barcode);
        }

        return result;
    }

}