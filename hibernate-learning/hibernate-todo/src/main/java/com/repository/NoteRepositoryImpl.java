package com.repository;

import com.entity.Note;
import com.utils.FactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Closeable;
import java.util.List;

public class NoteRepositoryImpl implements NoteRepository, Closeable {

    private Session session;

    public NoteRepositoryImpl() {
        this.session = FactoryUtil.getFactory().openSession();
    }

    @Override
    public List<Note> getAll() {
        Query query = this.session.createQuery("from Note");
        return query.list();
    }

    @Override
    public void save(Note note) {
        Transaction tx = session.beginTransaction();
        this.session.save(note);
        tx.commit();
    }

    @Override
    public Note get(long id) {
        return this.session.get(Note.class, id);
    }

    @Override
    public void update(Note note) {
        Transaction tx = session.beginTransaction();

        Note updatableNote = session.get(Note.class, note.getId());
        updatableNote.setTitle(note.getTitle());
        updatableNote.setContent(note.getContent());

        tx.commit();
    }

    @Override
    public void delete(Note note) {
        Transaction tx = session.beginTransaction();
        this.session.delete(note);
        tx.commit();
    }


    @Override
    public void close() {
        this.session.close();
        FactoryUtil.closeFactory();
    }
}
