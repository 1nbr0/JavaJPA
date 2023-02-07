package banque.entite;

import org.example.entities.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class MainBanque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Banque banque = new Banque("HSBC");
        banque.addClient(new Client("Valjan", "Jean"));

        Adresse adresse = new Adresse(6, "Avenue De La Richesse", "Paris", 75000);
        Client client = new Client("Bond", "James", LocalDate.ofEpochDay(1992/12/2), adresse);
        banque.addClient(client);

        Compte compte = new Compte("038BJ924SFO2", 128302322.23);
        compte.addOperation(new Operation(LocalDateTime.now(), 100000.23, "J'ai une dette à payer :/"));
        client.addCompte(compte);

        client.addCompte(new LivretA("48038FZ21ZF23", 1283.34, 3.3));

        em.persist(banque);

        System.out.println(client);

        et.commit();
        em.close();
        emf.close();
    }
}
