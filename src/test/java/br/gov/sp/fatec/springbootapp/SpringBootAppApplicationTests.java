package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Brand;
import br.gov.sp.fatec.springbootapp.entity.Car;
import br.gov.sp.fatec.springbootapp.repository.BrandRepository;
import br.gov.sp.fatec.springbootapp.repository.CarRepository;
import br.gov.sp.fatec.springbootapp.service.BrandService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private BrandService brandService;

	@Test
	void contextLoads() {
	}

	@Test
	void carRepositorySaveTestOk() {
		Car car = new Car();
		car.setModel("testCar");
		carRepo.save(car);
		assertNotNull(car.getModel());
	}

	@Test
	void brandRepositorySaveTestOk() {
		Car car = new Car();
		car.setModel("testCar1");
		carRepo.save(car);
		Brand bra = new Brand();
		bra.setName("testBrand");
		bra.setCars(new HashSet<Car>());
		bra.getCars().add(car);
		brandRepo.save(bra);

		assertNotNull(bra.getId());
	}

	@Test
	void carRepositoryFindByModelTestOk() {
		Car car = new Car();
		car.setModel("testCar2");
		carRepo.save(car);
		assertNotNull(carRepo.findByModel("testCar2"));
	}

	@Test
	void brandRepositoryFindByCarModelTestOk() {
		Car car = new Car();
		car.setModel("testCar1");
		carRepo.save(car);
		Brand bra = new Brand();
		bra.setName("testBrand");
		bra.setCars(new HashSet<Car>());
		bra.getCars().add(car);
		brandRepo.save(bra);

		List<Brand> brands = brandRepo.findByCarsModel("testCar1");

		assertFalse(brands.isEmpty());
	}

	@Test
	void brandServiceRegisterBrandTestOk() {
		brandService.registerBrand("teste", "testCar1");

		List<Brand> brands = brandRepo.findByCarsModel("testCar1");

		assertFalse(brands.isEmpty());
	}

}
