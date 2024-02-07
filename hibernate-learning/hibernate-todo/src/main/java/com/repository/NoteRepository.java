package com.repository;

import com.entity.Note;

import java.util.List;

public interface NoteRepository {
    List<Note> getAll();

    void save(Note note);

    Note get(long id);

    void update(Note note);

    void delete(Note note);
}
