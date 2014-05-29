package net.therap.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/20/14
 * Time: 9:26 AM
 */
@WebServlet ("/logout")
public class LogoutController extends HttpServlet {

    private static final String LOGIN_REQUEST = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.invalidate();
        resp.sendRedirect(getServletContext().getContextPath()+LOGIN_REQUEST);
    }
}
