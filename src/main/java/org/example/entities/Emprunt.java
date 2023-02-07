package org.example.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", length = 10)
    private Integer id;

    @Column(name="DATE_DEBUT", nullable = false)
    private LocalDateTime dateDebut;

    @Column(name="DATE_FIN", nullable = true)
    private LocalDateTime dateFin;

    @Column(name="DELAI", nullable = true)
    private Integer delai;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client idClient;

    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID")
    )
    private Set<Livre> livres;

    public Emprunt() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt : " +
                "Identifiant de l'emprunt : " + id +
                ", date de début : " + dateDebut +
                ", date de fin : " + dateFin +
                ", délai : " + delai +
                ", livres associés : " + livres +
                ", Client associé : " + idClient.getNom() +
                '\n';
    }
}
