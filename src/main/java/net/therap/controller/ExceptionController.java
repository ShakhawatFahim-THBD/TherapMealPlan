package net.therap.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/22/14
 * Time: 10:49 AM
 */
@WebServlet ("/internal-error")
public class ExceptionController extends HttpServlet {

    private static final String INTERNAL_ERROR_PAGE = "/WEB-INF/jsp/internalError.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(INTERNAL_ERROR_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
