package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.model.Fabricante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Integer> {
}