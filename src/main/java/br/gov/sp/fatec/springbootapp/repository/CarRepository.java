package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
    
    public Car findByModel (String model);

}
