package tn.esprit.rh.achat.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockServiceTest {
    
    @Autowired
    IStockService stockService;

    @Test
	public void testRetrieveAllStocks() {
        List<Stock> StockList = stockService.retrieveAllStocks();
        Assertions.assertEquals(0, StockList.size());
	}
}
