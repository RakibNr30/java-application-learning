package com.hibernate;

import com.hibernate.entity.relation.Answer;
import com.hibernate.entity.relation.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Relation {
    public static void main(String[] args) {
        SessionFactory factory = (new Configuration()).configure("hibernate.cfg.xml").buildSessionFactory();

       /* *//* 1 *//*
        Question question1 = new Question();
        question1.setValue("What is java?");

        Answer answer1 = new Answer();
        answer1.setValue("Java is a programming language.");
        answer1.setQuestion(question1);
        question1.setAnswer(answer1);

        *//* 2 *//*
        Question question2 = new Question();
        question2.setValue("What is collection framework?");

        Answer answer2= new Answer();
        answer2.setValue("API to work with objects in java.");
        answer2.setQuestion(question2);
        question2.setAnswer(answer2);*/

        Question question1 = new Question();
        question1.setValue("What is java?");

        Answer answer1 = new Answer();
        answer1.setValue("Java is a programming language.");
        answer1.setQuestion(question1);

        Answer answer2= new Answer();
        answer2.setValue("With the help of java we can create software.");
        answer2.setQuestion(question1);

        Answer answer3= new Answer();
        answer3.setValue("Java has different types of frameworks.");
        answer3.setQuestion(question1);

        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);

        question1.setAnswers(answers);

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        try {

            /*session.save(question1);
            session.save(question2);

            session.save(answer1);
            session.save(answer2);*/

            /*session.save(question1);
            session.save(answer1);
            session.save(answer2);
            session.save(answer3);*/

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            System.err.println(e.getMessage());
        }

        System.out.println("=====================================");

       /* Question question = session.get(Question.class, 1);
        System.out.println(question.getValue());
        System.out.println(question.getAnswer().getValue());*/

        Question question = session.get(Question.class, 1);
        System.out.println(question.getId());
        System.out.println(question.getValue());

        System.out.println(question.getAnswers().size());

        /* lazy */
        /*System.out.println(question.getAnswers());*/

        /*for (Answer answer: question.getAnswers()) {
            System.out.println(answer.getValue());
        }*/

        System.out.println("==================================");
        /*Answer answer = session.get(Answer.class, 2);
        System.out.println(answer.getValue());
        System.out.println(answer.getQuestion().getValue());*/

        session.close();
        factory.close();
    }
}
