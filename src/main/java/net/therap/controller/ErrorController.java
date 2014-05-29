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
 * Date: 5/20/14
 * Time: 12:28 PM
 */
@WebServlet ("/resource-not-found")
public class ErrorController extends HttpServlet {
    private static final String ERROR_PAGE = "/WEB-INF/jsp/pageNotFound.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(ERROR_PAGE);
        dispatcher.forward(req, resp);
    }
}
