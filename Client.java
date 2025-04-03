package n7.facade;

import jakarta.persistence.Entity;

@Entity
public class Client extends Utilisateur {
    
    private String mdp;
    private Float solde;

    public Client() {}

    public Client(String nom, String prenom, String email, String mdp) {
        super(nom, prenom, email);
        this.mdp = mdp;
        this.solde = 0.0f;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Float getSolde() {
        return solde;
    }

    public void credit(Float valeur) {
        this.solde += valeur;
    }

    public void debit(Float valeur) {
        this.solde -= valeur;
    }
}
