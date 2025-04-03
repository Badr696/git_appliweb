package n7.facade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Admin {
    String nom;
    String prenom;
    String mdp;
    String email;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    
    //@ManyToOne
    //Personne personne;


    public Admin() {
    }

    public Admin(String nom, String prenom, String mdp, String email){
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.email = email;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
