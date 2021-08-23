package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.gov.sp.fatec.springbootapp.entity.Brand;
import br.gov.sp.fatec.springbootapp.repository.BrandRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

	@Autowired
	private BrandRepository braRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void brandRepositorySaveTestOk() {
		Brand bra = new Brand();
		bra.setName("teste");
		braRepo.save(bra);
		assertNotNull(bra.getId());
	}

}
