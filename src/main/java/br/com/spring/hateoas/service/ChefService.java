package br.com.spring.hateoas.service;

import br.com.spring.hateoas.dto.ChefResponseDto;

import java.util.List;

public interface ChefService {

    List<ChefResponseDto> list();

    ChefResponseDto searchById(Long id);

}
