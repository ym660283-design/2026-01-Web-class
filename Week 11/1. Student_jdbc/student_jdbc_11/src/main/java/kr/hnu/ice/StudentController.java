package kr.hnu.ice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {
    private StudentDAO dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new StudentDAO();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String view;

        if ("insert".equals(action)) {
            view = insert(request);
        } else if ("edit".equals(action)) {
            view = edit(request);
        } else if ("update".equals(action)) {
            view = update(request);
        } else if ("delete".equals(action)) {
            view = delete(request);
        } else {
            view = list(request);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    private String list(HttpServletRequest request) {
        try {
            request.setAttribute("students", dao.getAll());
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
        }
        return "studentInfo.jsp";
    }

    private String insert(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String univ = request.getParameter("univ");
            String birthdate = request.getParameter("birthdate");
            String email = request.getParameter("email");

            dao.insert(id, name, univ, birthdate, email);
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
        }

        try {
            request.setAttribute("students", dao.getAll());
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
        }
        return "studentInfo.jsp";
    }

    private String edit(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("editStudent", dao.getById(id));
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
        }

        return list(request);
    }

    private String update(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String univ = request.getParameter("univ");
            String birthdate = request.getParameter("birthdate");
            String email = request.getParameter("email");

            dao.update(id, name, univ, birthdate, email);
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
        }

        return list(request);
    }

    private String delete(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
        } catch (RuntimeException e) {
            request.setAttribute("error", e.getMessage());
        }

        return list(request);
    }
}
