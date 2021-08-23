package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    
}
