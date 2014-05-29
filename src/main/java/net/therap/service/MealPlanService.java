package net.therap.service;

import net.therap.dao.MealPlanDao;
import net.therap.domain.MealPlan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/21/14
 * Time: 10:33 AM
 */
public class MealPlanService {

    public MealPlan getMealPlanByDay(String day) {
        MealPlanDao mealPlanDao = new MealPlanDao();
        return mealPlanDao.getMealPlanByDay(day);
    }

    public List<MealPlan> getFullMealPlan() {
        MealPlanDao mealPlanDao = new MealPlanDao();
        return mealPlanDao.getFullMealPlan();
    }

    public void updateMealPlan(MealPlan updatedMealPlan) {
        MealPlanDao mealPlanDao = new MealPlanDao();
        mealPlanDao.updateMealPlan(updatedMealPlan);
    }
}
