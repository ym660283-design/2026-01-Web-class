package kr.hnu.ice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductService service;

    @Override
    public void init() throws ServletException {
        service = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String view;

        if ("info".equals(action)) {
            view = info(request, response);
        } else {
            view = list(request, response);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String list(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", service.findAll());
        return "productList.jsp";
    }

    private String info(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        request.setAttribute("product", service.find(id));
        return "productInfo.jsp";
    }
}
