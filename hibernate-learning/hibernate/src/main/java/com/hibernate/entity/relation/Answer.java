package com.hibernate.entity.relation;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    private String value;

    /*@OneToOne(mappedBy = "answer") //mappedBy = "ans" to prevent generate column
    private Question question;*/

    @ManyToOne
    private Question question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", question=" + question +
                '}';
    }
}
