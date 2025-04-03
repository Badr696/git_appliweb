package n7.facade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient {
    String nom;
    String unite;
    Float prix;
    Float stock;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    
    //@ManyToOne
    //Personne personne;


    public Ingredient() {
    }

    public Ingredient(String nom, String unite, Float prix){
        this.nom = nom;
        this.unite = unite;
        this.prix = prix;
        this.stock = (float) 0.0;
    }

    public String getNom() {
        return nom;
    }
    public String getUnite() {
        return unite;
    }
    public Float getPrix() {
        return prix;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    } 

    public Float achat(Float quantite) {
        return stock += quantite;
    }
    public Float utilisation(Float quantite) {
        return stock -= quantite;
    } 
    
}
