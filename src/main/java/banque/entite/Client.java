package banque.entite;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", length = 10)
    private Integer id;

    @Column(name="NOM", length = 50, nullable = false)
    private String nom;

    @Column(name="PRENOM", length = 50, nullable = false)
    private String prenom;

    @Column(name="DATE_NAIS")
    private LocalDate dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="BAN_ID")
    private Banque banque;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="CLI_COMP",
            joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_COMP", referencedColumnName="ID")
    )
    private Set<Compte> comptes = new HashSet<>();

    public Client() {
    }

    public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = this.adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        if (this.banque != null) {
            this.banque.getClients().remove(this);
        }

        this.banque = banque;

        if (this.banque != null) {
            this.banque.getClients().add(this);
        }
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public void addCompte(Compte compte) {
        this.comptes.add(compte);
        compte.getClients().add(this);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", adresse=" + adresse +
                ", banque=" + banque +
                ", comptes=" + comptes +
                '}';
    }
}
