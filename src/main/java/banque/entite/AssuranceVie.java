package banque.entite;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="ASSURANCE_VIE")
public class AssuranceVie extends Compte {

    private LocalDate dateFin;

    private Double taux;

    public AssuranceVie() {
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                ", dateFin=" + dateFin +
                ", taux=" + taux +
                '}';
    }
}
