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
public class Crenaux {
    Recette recette;
    Time heure;
    Integer prix;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @ManyToMany() //mappedBy = "personne", fetch = FetchType.EAGER
    List<Client> clients;
    
    Boolean estProf;
    Prof prof;


    public Crenaux() {
    }

    public Crenaux(Recette recette, Time heure, Integer prix){
        this.recette = recette;
        this.heure = heure;
        this.clients = new ArrayList<>();
        this.prix = prix;
        this.estProf = false;
    }

    public Crenaux(Recette recette, Time heure, Integer prix, Prof prof){
        this.recette = recette;
        this.heure = heure;
        this.clients = new ArrayList<>();
        this.prix = prix;
        this.prof = prof;
        this.estProf = true;
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Boolean getEstProf() {
        return estProf;
    }

    public void setEstProf(Boolean estProf) {
        this.estProf = estProf;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public void ajoutClient(Client c){
        this.clients.add(c);
    }

    public void retirerClient(Client c){
        this.clients.remove(c);
    }
    
}
