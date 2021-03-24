package br.com.spring.hateoas.service;

import br.com.spring.hateoas.domain.Chef;
import br.com.spring.hateoas.dto.ChefResponseDto;
import br.com.spring.hateoas.mapper.ChefMapper;
import br.com.spring.hateoas.repository.ChefRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chefRepository;

    private final ChefMapper chefMapper;

    @Override
    public List<ChefResponseDto> list() {
        return chefRepository.findAll().stream()
                .map(chefMapper::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public ChefResponseDto searchById(Long id) {
        final Chef chef = chefRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum Chefe Encontrado!"));
        return chefMapper.mapper(chef);
    }
}
