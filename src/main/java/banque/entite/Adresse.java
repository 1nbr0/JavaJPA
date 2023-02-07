package banque.entite;

import javax.persistence.*;

@Embeddable
public class Adresse {
    @Column(name="NUM", length = 10)
    private Integer numero;

    @Column(name="RUE")
    private String rue;

    @Column(name="VILLE")
    private String ville;

    @Column(name="CODEPOST")
    private Integer codePostal;

    public Adresse() {
    }

    public Adresse(Integer numero, String rue, String ville, Integer codePostal) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "numero=" + numero +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                '}';
    }
}