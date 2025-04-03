package n7.facade;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;

    //@ManyToMany?
    private List<Message> messages;

    //@OneToOne?
    private Message solution;  

    public Discussion() {
        this.messages = new ArrayList<>();
    }

    public Discussion(String question) {
        this.question = question;
        this.messages = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void ajouterMessage(Message message) {
        this.messages.add(message);
    }

    public Message getSolution() {
        return solution;
    }

    public void setSolution(Message solution) {
        this.solution = solution;
    }
}
