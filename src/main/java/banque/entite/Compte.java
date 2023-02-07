package banque.entite;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", length = 10)
    private Integer id;

    @Column(name="NUM")
    private String numero;

    @Column(name="SOLDE")
    private Double solde;

    @ManyToMany(mappedBy="comptes")
    private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy="compte", cascade = CascadeType.ALL)
    private Set<Operation> operations = new HashSet<>();

    public Compte() {
    }

    public Compte(String numero, Double solde, Set<Operation> operations) {
        this.numero = numero;
        this.solde = solde;
        this.operations = operations;
    }

    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public void addClient(Client client) {
        this.clients.add(client);
        client.getComptes().add(this);
    }

    public void addOperation(Operation operation) {
        operation.setCompte(this);
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", operations=" + operations +
                '}';
    }
}
