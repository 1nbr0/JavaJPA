package banque.entite;

import javax.persistence.*;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {

    private String beneficiare;

    public Virement() {
    }

    public Virement(String beneficiare) {
        this.beneficiare = beneficiare;
    }

    public String getBeneficiare() {
        return beneficiare;
    }

    public void setBeneficiare(String beneficiare) {
        this.beneficiare = beneficiare;
    }

    @Override
    public String toString() {
        return "Virement{" +
                ", beneficiare='" + beneficiare + '\'' +
                '}';
    }
}
