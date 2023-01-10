package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProduitServiceTest {

	@Autowired
	private IProduitService ps;

	@Test
	public void shouldReturnAllProduit() {
		List<Produit> expected = ps.retrieveAllProduits();
		Assertions.assertEquals(expected.size(), 0);
	}

}
