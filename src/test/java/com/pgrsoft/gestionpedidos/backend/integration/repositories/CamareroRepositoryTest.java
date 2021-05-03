package com.pgrsoft.gestionpedidos.backend.integration.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;


@RunWith(SpringRunner.class)  	//Puente entre JUnit y Spring Boot
@DataJpaTest					// Necesario par probar la capa de integración
public class CamareroRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private CamareroRepository camareroRepository; // Esta es la clase que vamos a testear
	
	// Los métodos de Test deben ser totalmente independientes entre ellos...
	@Test
	public void whenFindByNombre() {
		
		//given
		CamareroDTO camarero = new CamareroDTO();
		camarero.setId(10000L);
		camarero.setNombre("Camarero de Test");
		testEntityManager.persist(camarero);			// Lo persisto "manualmente"
		testEntityManager.flush();  					// Hace efectiva la persistencia
		
		//when
		CamareroDTO camareroEncontrado = camareroRepository.findByNombre("Camarero de Test");
		
		//then
		assertThat(camareroEncontrado.getNombre()).isEqualTo(camarero.getNombre());
		
	}
	
	@Test
	public void whenFindAll() {
		
		//when
		List<CamareroDTO> camareros = camareroRepository.findAll();
		
		//then
		assertThat(camareros.size()).isEqualTo(3);	
	}
	
	
	public void whenCreate() {
		
		//TODO
		
		//when
		CamareroDTO nuevoCamarero = new CamareroDTO(1000L, "NUEVO");
		
		// Cómo comprobar que la siguiente linea funciona?
		camareroRepository.save(nuevoCamarero);
		
		// INNECESARIO?
		
		// Obtengo el entityManager "normal" para poder consultar cualquier tipo
		// de cosa que el de Test no incorpora...
		
//		EntityManager entityManager = testEntityManager.getEntityManager();
		
//		String strJPQL = "select c from CamareroDTO c";
//		Query query = entityManager.createQuery(strJPQL);
		
//		List<CamareroDTO> camareros = query.getResultList();
		
				
		
	}
	
	
	
	
	
	
	
}
