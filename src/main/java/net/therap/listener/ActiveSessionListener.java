package net.therap.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/25/14
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static int loggedInUserCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        loggedInUserCount++;
        updateLoggedInUserCountInServletContext(loggedInUserCount, sessionEvent);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        loggedInUserCount--;
        updateLoggedInUserCountInServletContext(loggedInUserCount, sessionEvent);
    }

    private void updateLoggedInUserCountInServletContext(int loggedInUserCount, HttpSessionEvent sessionEvent) {
        HttpSession httpSession = sessionEvent.getSession();
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute("loggedInUserCount", String.valueOf(loggedInUserCount));
    }

}
