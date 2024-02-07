package com.controller.note;

import com.entity.Note;
import com.repository.NoteRepository;
import com.repository.NoteRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/note")
public class NoteListServlet extends HttpServlet {

    private NoteRepository noteRepository;

    @Override
    public void init() throws ServletException {
        this.noteRepository = new NoteRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Note> notes = this.noteRepository.getAll();

        request.setAttribute("notes", notes);

        request.getRequestDispatcher("/views/front/note/noteList.jsp").forward(request, response);
    }
}
