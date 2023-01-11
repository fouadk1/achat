package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.TemporalType;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
@SpringBootTest

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class ReglementServiceTest {


 @Autowired
 IReglementService rs;
 
 
 @MockBean
 ReglementRepository reglementRepository;
 
 @InjectMocks
 ReglementServiceImpl reglementService;
 
@Order(1)
@Test

public void testRetrieveAllReglements() {
	Reglement rg = new Reglement(1L,1.7f,2.5f,true,null,null);	 
	List<Reglement> listreglement = new ArrayList<Reglement>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
	 add(new Reglement(2L,1.7f,2.5f,true,null,null));
	 add(new Reglement(3L,1.7f,2.5f,true,null,null));
	 }
	 };			
Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(rg));
Reglement rg1 = reglementService.retrieveReglement(null);
Assertions.assertNotNull(rg1);

 }


}