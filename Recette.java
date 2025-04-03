package n7.facade;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Recette {
    String nom;
    Duration temps;
    String instruction;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @ManyToMany() //mappedBy = "personne", fetch = FetchType.EAGER
    List<Ingredient> ingredients; 


    public Recette() {
    }

    public Recette(String nom, Duration temps, String instruction){
        this.nom = nom;
        this.temps = temps;
        this.ingredients = new ArrayList<>();
        this.instruction = instruction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTemps(Duration temps) {
        this.temps = temps;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Duration getTemps() {
        return temps;
    }

    public String getInstruction() {
        return instruction;
    }

    public Integer getId() {
        return id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    
    public void ajoutIngredient(Ingredient i){
        this.ingredients.add(i);
    }

    public void retirerIngredient(Ingredient i){
        this.ingredients.remove(i);
    }
    
}
