package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Car;
import br.gov.sp.fatec.springbootapp.repository.CarRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

	@Autowired
	private CarRepository carRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void carRepositorySaveTestOk() {
		Car car = new Car();
		car.setModel("test");
		carRepo.save(car);
		assertNotNull(car.getModel());
	}

	@Test
	void carRepositoryFindByModelTestOk() {
		Car car = new Car();
		car.setModel("test2");
		carRepo.save(car);
		assertNotNull(carRepo.findByModel("test2"));
	}

}
