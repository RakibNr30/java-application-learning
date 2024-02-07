package com.controller.note;

import com.entity.Note;
import com.repository.NoteRepository;
import com.repository.NoteRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/note/add")
public class NoteAddServlet extends HttpServlet {

    private NoteRepository noteRepository;

    @Override
    public void init() throws ServletException {
        this.noteRepository = new NoteRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/front/note/noteAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectTo = "/note";

        Note note = new Note();
        note.setTitle(request.getParameter("title"));
        note.setContent(request.getParameter("content"));

        HttpSession session = request.getSession();

        try {
            this.noteRepository.save(note);
            session.setAttribute("status", "Note added successfully...");
        } catch (Exception e) {
            session.setAttribute("status", "Note can not be added...");
            System.err.println(e.getMessage());
            redirectTo = "/note/add";
        }

        response.sendRedirect(redirectTo);
    }
}
