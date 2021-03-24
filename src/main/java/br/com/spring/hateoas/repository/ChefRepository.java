package br.com.spring.hateoas.repository;

import br.com.spring.hateoas.domain.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Long> {
}
