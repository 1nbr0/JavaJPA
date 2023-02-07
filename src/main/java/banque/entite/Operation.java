package banque.entite;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("O")
@Table(name="OPERATION")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", length = 10)
    private Integer id;

    @Column(name="DATE")
    private LocalDateTime date;

    @Column(name="MONTANT")
    private Double montant;

    @Column(name="MOTIF", length = 250)
    private String motif;

    @ManyToOne
    @JoinColumn(name="COMP_ID")
    private Compte compte;

    public Operation() {
    }

    public Operation(LocalDateTime date, Double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        if (this.compte != null) {
            this.compte.getOperations().remove(this);
        }

        this.compte = compte;

        if (this.compte != null) {
            this.compte.getOperations().add(this);
        }
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                '}';
    }
}
