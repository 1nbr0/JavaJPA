package banque.entite;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="BANQUE")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", length = 10)
    private Integer id;

    @Column(name="NOM", length = 50, nullable = false)
    private String nom;

    @OneToMany(mappedBy="banque", cascade = CascadeType.ALL)
    private Set<Client> clients = new HashSet<>();

    public Banque() {
    }

    public Banque(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        client.setBanque(this);
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
