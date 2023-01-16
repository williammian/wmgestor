package br.com.wm.wmgestorapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wm.wmgestorapi.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
