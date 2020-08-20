package com.magic.basiccenter.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FestivalQueryDTO implements Serializable {

    private static final long serialVersionUID = 6968481962616237401L;

    private String festivalYear;
}
