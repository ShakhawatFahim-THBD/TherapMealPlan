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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/22/14
 * Time: 9:05 AM
 */
@WebServlet ("/update-meal-plan")
public class AdminMealPlanController extends HttpServlet {

    private static final String UPDATE_MEAL_PLAN_PAGE = "/WEB-INF/jsp/updateMealPlan.jsp";
    private MealPlanService mealPlanService;

    public AdminMealPlanController() {
        mealPlanService = new MealPlanService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loggedInUserCount = (String) req.getServletContext().getAttribute("loggedInUserCount");

        List<MealPlan> mealPlans = mealPlanService.getFullMealPlan();
        req.setAttribute("mealPlans", mealPlans);
        req.setAttribute("loggedInUserCount", loggedInUserCount);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(UPDATE_MEAL_PLAN_PAGE);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String day = req.getParameter("day");
        String breakfast = req.getParameter("breakfast");
        String lunch = req.getParameter("lunch");

        MealPlan updatedMealPlan = new MealPlan(day, breakfast, lunch);
        mealPlanService.updateMealPlan(updatedMealPlan);
        doGet(req, resp);
    }
}