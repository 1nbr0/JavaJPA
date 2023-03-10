package org.example.entities;

import javax.persistence.*;
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

    @OneToMany(mappedBy="idClient")
    private Set<Emprunt> emprunts;

    public Client() {
        emprunts = new HashSet<Emprunt>();
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

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Client : " +
                "id : " + id + '\n' +
                ", nom : " + nom + '\n' +
                ", prenom : " + prenom + '\n' +
                ", emprunts : " + emprunts + '\n';
    }
}
