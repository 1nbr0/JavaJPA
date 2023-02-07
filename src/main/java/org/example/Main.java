package org.example;

import org.example.entities.Livre;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

/*        Livre livre = em.find(Livre.class, 2);

        System.out.println(livre.toString());

        et.begin();
        Livre livre1 = new Livre();

        livre1.setTitre("FormuliX");
        livre1.setAuteur("Lucas Durand");

        em.persist(livre1);

        Livre updateLivre = em.find(Livre.class, 5);

        if (updateLivre != null) {
            updateLivre.setTitre(" Du plaisir dans la cuisine");
        }*/


 /*       TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre='Guerre et paix'", Livre.class);

        Livre livreTitre = query.getResultList().get(0);

        TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.auteur='Lucas Durand'", Livre.class);

        Livre livreAuteur = query2.getResultList().get(0);

        System.out.println(livreTitre.toString());
        System.out.println(livreAuteur.toString());

        Livre deleteLivre = em.find(Livre.class, 6);

        if (deleteLivre != null) {
            em.remove(deleteLivre);
        }*/

        TypedQuery<Livre> queryAll = em.createQuery("from Livre", Livre.class);

        List<Livre> allLivre = queryAll.getResultList();

        System.out.println("Liste des livres");
        for (Livre livre:
             allLivre) {
            System.out.printf(livre.toString());
        }

        et.commit();
        em.close();
        emf.close();
    }
}