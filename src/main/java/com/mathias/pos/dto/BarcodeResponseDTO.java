package com.mathias.pos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BarcodeResponseDTO {

    private Long id;
    private String code;

}
