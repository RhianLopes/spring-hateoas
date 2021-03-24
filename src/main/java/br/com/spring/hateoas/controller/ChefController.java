package br.com.spring.hateoas.controller;

import br.com.spring.hateoas.dto.ChefMenuResponseDto;
import br.com.spring.hateoas.dto.ChefResponseDto;
import br.com.spring.hateoas.service.ChefService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/chef")
@RequiredArgsConstructor
public class ChefController {

    private final ChefService chefService;

    @GetMapping
    public ChefMenuResponseDto welcome() {
        final Link listSimple = linkTo(methodOn(ChefController.class).listSimple()).withSelfRel();
        final Link listHateoas = linkTo(methodOn(ChefController.class).listHateoas()).withSelfRel();
        final Link searchByIdSimple = linkTo(methodOn(ChefController.class).searchByIdSimple(1L)).withSelfRel();
        final Link searchByIdHateoas = linkTo(methodOn(ChefController.class).searchByIdHateoas(1L)).withSelfRel();
        return new ChefMenuResponseDto("Bem-Vindo ao menu de chefes!").add(Arrays.asList(listSimple, listHateoas, searchByIdSimple, searchByIdHateoas));
    }

    @GetMapping("/simple")
    public List<ChefResponseDto> listSimple() {
        return chefService.list();
    }

    @GetMapping("/hateoas")
    public CollectionModel<ChefResponseDto> listHateoas() {
        final List<ChefResponseDto> chefs = chefService.list();
        for (ChefResponseDto chef : chefs) {
            final Link link = linkTo(methodOn(ChefController.class).searchByIdHateoas(chef.getId())).withSelfRel();
            chef.add(link);
        }
        final Link link = linkTo(ChefController.class).withSelfRel();
        final CollectionModel<ChefResponseDto> response = CollectionModel.of(chefs, link);
        return response;
    }

    @GetMapping("/simple/{id}")
    public ChefResponseDto searchByIdSimple(@PathVariable("id") Long id) {
        return chefService.searchById(id);
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<ChefResponseDto> searchByIdHateoas(@PathVariable("id") Long id) {
        final ChefResponseDto chef = chefService.searchById(id);
        final Link link = linkTo(methodOn(ChefController.class).listHateoas()).withSelfRel();
        return EntityModel.of(chef, link);
    }
}
