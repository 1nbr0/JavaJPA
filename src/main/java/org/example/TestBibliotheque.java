package org.example;

import org.example.entities.Client;
import org.example.entities.Emprunt;
import org.example.entities.Livre;

import javax.persistence.*;
import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-pu");
        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();

        Emprunt emprunt = em.find(Emprunt.class, 1);
        System.out.println(emprunt.toString());

        Client client = em.find(Client.class, 2);
        System.out.println(client.toString());
    }
}
