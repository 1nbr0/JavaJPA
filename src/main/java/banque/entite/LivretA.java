package banque.entite;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="LIVRET_A")
public class LivretA extends Compte {
    private Double taux;

    public LivretA() {
    }

    public LivretA(Double taux) {
        this.taux = taux;
    }

    public LivretA(String numero, Double solde, Double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public LivretA(String numero, Double solde, Set<Operation> operations, Double taux) {
        super(numero, solde, operations);
        this.taux = taux;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                ", taux=" + taux +
                '}';
    }
}
