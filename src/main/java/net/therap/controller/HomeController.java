package net.therap.controller;

import net.therap.domain.MealPlan;
import net.therap.service.MealPlanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/19/14
 * Time: 3:02 PM
 */
@WebServlet ("/home")
public class HomeController extends HttpServlet {

    private static final String HOME_PAGE = "/WEB-INF/jsp/home.jsp";
    private MealPlanService mealPlanService;

    public HomeController() {
        mealPlanService = new MealPlanService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todayName = getTodayName(req);
        MealPlan mealPlanToday = mealPlanService.getMealPlanByDay(todayName);
        req.setAttribute("mealPlan", mealPlanToday);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(HOME_PAGE);
        requestDispatcher.forward(req, resp);
    }

    private String getTodayName(HttpServletRequest request) {
        Locale clientLocale = request.getLocale();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE", clientLocale);

        Date todayDate = new Date(System.currentTimeMillis());
        return dateFormatter.format(todayDate);
    }
}
