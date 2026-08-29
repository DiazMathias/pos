package com.mathias.pos.service;

import com.mathias.pos.dto.ProductRequestDTO;
import com.mathias.pos.dto.ProductResponseDTO;

public interface IProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

}