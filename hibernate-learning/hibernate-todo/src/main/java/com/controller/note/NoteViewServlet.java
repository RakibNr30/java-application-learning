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

@WebServlet("/note/*")
public class NoteViewServlet extends HttpServlet {

    private NoteRepository noteRepository;

    @Override
    public void init() throws ServletException {
        this.noteRepository = new NoteRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] parts = request.getPathInfo().trim().split("/");
        int id = Integer.parseInt(parts[1]);

        Note note = noteRepository.get(id);

        if (note == null) {
            request.getSession().setAttribute("status", "Note not found");
            response.sendRedirect("/note");
            return;
        }

        request.setAttribute("note", note);

        request.getRequestDispatcher("/views/front/note/noteView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] parts = request.getPathInfo().trim().split("/");

        Note note = noteRepository.get(Integer.parseInt(parts[1]));

        HttpSession session = request.getSession();

        String redirectTo = "/note";

        if (note == null) {
            request.getSession().setAttribute("status", "Note not found");
            response.sendRedirect(redirectTo);
            return;
        }

        try {
            this.noteRepository.delete(note);
            session.setAttribute("status", "Note deleted successfully...");
        } catch (Exception e) {
            session.setAttribute("status", "Note can not be deleted...");
        }

        response.sendRedirect(redirectTo);
    }
}
