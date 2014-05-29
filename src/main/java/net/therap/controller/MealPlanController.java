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
 * Date: 5/21/14
 * Time: 3:58 PM
 */
@WebServlet ("/complete-meal-plan")
public class MealPlanController extends HttpServlet {

    private static final String FULL_MEAL_PLAN_PAGE = "/WEB-INF/jsp/completeMealPlan.jsp";
    private MealPlanService mealPlanService;

    public MealPlanController() {
        mealPlanService = new MealPlanService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MealPlan> mealPlans = mealPlanService.getFullMealPlan();
        req.setAttribute("mealPlans", mealPlans);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(FULL_MEAL_PLAN_PAGE);
        requestDispatcher.forward(req, resp);
    }
}
