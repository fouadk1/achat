package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class categorieproduit {

    @Autowired
    IProduitService ps;

    @Test
    @Order(1)
    public void categorieproduit() {
        public class Categorie{

       
        private String name;
        private int stock;
    }
    public Categorie(String name)
    {
    this.name=name;
    this.stock=0;
    }
public String getName() {
    return name;
}
public void setName (string name)
{
    this.name=name;
}
public int getStock() {
    return stock;
}
public void setStock (int stock)
{
    this.stock=stock;
}
        
    }


}
