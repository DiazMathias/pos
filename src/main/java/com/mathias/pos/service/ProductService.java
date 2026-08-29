package com.mathias.pos.service;

import com.mathias.pos.dto.ProductRequestDTO;
import com.mathias.pos.dto.ProductResponseDTO;
import com.mathias.pos.entity.Barcode;
import com.mathias.pos.entity.Product;
import com.mathias.pos.repository.IProductRepository;
import com.mathias.pos.utils.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setStock(productRequestDTO.getStock());
        product.setBarcodes(linkToProduct(product, Mapper.toEntity(productRequestDTO.getBarcodes())));

        return Mapper.toDTO(productRepository.save(product));
    }

    private List<Barcode> linkToProduct(Product product, List<Barcode> barcodes) {
        barcodes.forEach(barcode -> barcode.setProduct(product));
        return barcodes;
    }

}