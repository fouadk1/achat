package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class OperateurServiceTest {
    
    @Autowired
    private IOperateurService operateurService;

    @MockBean
    private OperateurRepository repository;

    @Test
	public void testRetrieveAllOperators() {
        List<Operateur> OperateurFixtures= Stream.of(new Operateur(1L, "Hammadi", "lakhdher", "124578A", null),
        new Operateur(2L, "Marwen", "ammar", "hahahaha121", null),
        new Operateur(3L, "bouslimi", "hassna", "784521zareyt", null))
        .collect(Collectors.toList());
        when(repository.findAll()).thenReturn(OperateurFixtures);
        List<Operateur> RetrievedOperateurList = operateurService.retrieveAllOperateurs();
        Assertions.assertEquals(3, RetrievedOperateurList.size());
	}

    @Test
    public void testAddOperator() {
        Operateur operateur = new Operateur(2L, "Marwen", "ammar", "hahahaha121", null);
        when(repository.save(operateur)).thenReturn(operateur);
        Assertions.assertEquals(operateur, operateurService.addOperateur(operateur));
	}

    
}
