package n7.facade;

import jakarta.persistence.Entity;

@Entity
public class Prof extends Utilisateur {

    private String mdp;
    private String rib;
    private Integer tel;

    public Prof() {}

    public Prof(String nom, String prenom, String email, String mdp, String rib, Integer tel) {
        super(nom, prenom, email);
        this.mdp = mdp;
        this.rib = rib;
        this.tel = tel;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}
