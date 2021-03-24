package br.com.spring.hateoas.mapper;

import br.com.spring.hateoas.domain.Chef;
import br.com.spring.hateoas.dto.ChefResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ChefMapper {

    public ChefResponseDto mapper(Chef chef) {
        return ChefResponseDto.builder()
                .id(chef.getId())
                .name(chef.getName())
                .age(chef.getAge())
                .build();
    }
}
