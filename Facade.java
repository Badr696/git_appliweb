package n7.facade;
import java.util.Optional;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Facade {
    @Autowired
    ProfRepository pr;
    @Autowired
    ClientRepository cr;
    @Autowired
    AdminRepository ar;
    @Autowired
    IngredientRepository ir;

    
    @GetMapping("/ajoutClient")
    public void ajoutClient(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("email") String email,@RequestParam("mot de passe") String mdp ){
        Client c = new Client(nom, prenom, mdp, email);
        cr.save(c);
    }

    @PostMapping("/connexion")
    public ResponseEntity<?> connexion(@RequestBody Client client) {
        Optional<Client> foundClient = cr.findByEmail(client.getEmail());
        
        if (foundClient.isPresent() && foundClient.get().getMdp().equals(client.getMdp())) {
            return ResponseEntity.ok("Connexion réussie");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Adresse ou mot de passe invalide");
    }

    @GetMapping("/ajoutProf")
    public void ajoutProf(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("email") String email,@RequestParam("mot de passe") String mdp, @RequestParam("rib") String rib,@RequestParam("telephone") String tel){
        Prof p = new Prof(nom, prenom, mdp, email, rib , Integer.valueOf(tel));
        pr.save(p);
    }

    @GetMapping("/ajoutAdmin")
    public void ajoutAdmin(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("email") String email,@RequestParam("mot de passe") String mdp ){
        Admin a = new Admin(nom, prenom, mdp, email);
        ar.save(a);
    }

    @GetMapping("/ajoutIngredient")
    public void ajoutIngredient(@RequestParam("nom") String nom,@RequestParam("unite") String unite,@RequestParam("prix") String prix){
        Ingredient i = new Ingredient(nom, unite, Float.valueOf(prix));
        ir.save(i);
    }

    @GetMapping("/listeClient")
    public Collection<Client> listeClient(){
        return cr.findAll();
    }

    @GetMapping("/listeProf")
    public Collection<Prof> listeProf(){
        return pr.findAll();
    }

    @GetMapping("/listeAdmin")
    public Collection<Admin> listeAdmin(){
        return ar.findAll();
    }

    @GetMapping("/listeIngredient")
    public Collection<Ingredient> listeIngredient(){
        return ir.findAll();
    }





    /*
    @GetMapping("/associer")
    public void associer(@RequestParam("IdPersonne") Integer idP,@RequestParam("IdAdresse") Integer idA){
        Personne p = pr.findById(idP).get();
        Adresse a = ar.findById(idA).get();
        a.personne = p;
        ar.save(a);
        p.getAdresse().add(a);
        pr.save(p);
        
    }
    */
}
