package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Brand;
import br.gov.sp.fatec.springbootapp.entity.Car;
import br.gov.sp.fatec.springbootapp.repository.BrandRepository;
import br.gov.sp.fatec.springbootapp.repository.CarRepository;

@Service
public class BrandService {

    @Autowired
	private CarRepository carRepo;

	@Autowired
	private BrandRepository brandRepo;

    @Transactional
    public Brand registerBrand(String name, String car) {
        Car carr = new Car();
		carr.setModel(car);
		carRepo.save(carr);
		Brand bra = new Brand();
		bra.setName(name);
		bra.setCars(new HashSet<Car>());
		bra.getCars().add(carr);
		brandRepo.save(bra);

        return bra;
    }

}
