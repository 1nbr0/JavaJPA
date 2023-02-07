package org.example.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="LIVRE")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", length = 10)
    private Integer id;

    @Column(name="TITRE", length = 250, nullable = false)
    private String titre;

    @Column(name="AUTEUR", length = 50, nullable = false)
    private String auteur;

    @ManyToMany(mappedBy="livres")
    private Set<Emprunt> emprunts;

    public Livre() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        auteur = auteur;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Livre :" +
                "id : " + id +
                ", Titre : '" + titre + '\'' +
                ", Auteur : '" + auteur + '\'' + '\n';
    }
}
