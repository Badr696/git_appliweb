package n7.facade;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@?
    private Utilisateur posteur; 
    //@?
    private Utilisateur destinataire;  

    private String texte;
    private Date dateEnvoi;

    public Message() {}

    public Message(Utilisateur posteur, Utilisateur destinataire, String texte) {
        this.posteur = posteur;
        this.destinataire = destinataire;
        this.texte = texte;
        this.dateEnvoi = new Date(); 
    }

    public Integer getId() {
        return id;
    }

    public Utilisateur getPosteur() {
        return posteur;
    }

    public void setPosteur(Utilisateur posteur) {
        this.posteur = posteur;
    }

    public Utilisateur getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Utilisateur destinataire) {
        this.destinataire = destinataire;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
}
