package br.com.wm.wmgestorapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wm.wmgestorapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
