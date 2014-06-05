package net.therap.dao;

import net.therap.domain.MealPlan;
import net.therap.util.QueryExecutor;
import net.therap.util.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/21/14
 * Time: 9:20 AM
 */
public class MealPlanDao {

    public MealPlan getMealPlanByDay(String day) {
        day = day.toLowerCase();

        String query = "SELECT day, breakfast, lunch FROM meal_plan WHERE day = ?";

        List<MealPlan> mealPlanList = QueryExecutor.executeSelectQuery(query, new ResultSetProcessor<MealPlan>() {
            @Override
            public MealPlan getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                MealPlan mealPlan = new MealPlan();
                mealPlan.setDay(resultSet.getString("day"));
                mealPlan.setBreakfastMenu(resultSet.getString("breakfast"));
                mealPlan.setLunchMenu(resultSet.getString("lunch"));
                return mealPlan;
            }
        }, day);

        if (mealPlanList.size() > 0)
            return mealPlanList.get(0);

        return null;
    }

    public List<MealPlan> getFullMealPlan() {
        String query = "SELECT day, breakfast, lunch FROM meal_plan";

        List<MealPlan> mealPlanList = QueryExecutor.executeSelectQuery(query, new ResultSetProcessor<MealPlan>() {
            @Override
            public MealPlan getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                MealPlan mealPlan = new MealPlan();
                mealPlan.setDay(resultSet.getString("day"));
                mealPlan.setBreakfastMenu(resultSet.getString("breakfast"));
                mealPlan.setLunchMenu(resultSet.getString("lunch"));
                return mealPlan;
            }
        });

        return mealPlanList;
    }

    public void updateMealPlan(MealPlan updatedMealPlan) {
        String query = "UPDATE meal_plan SET breakfast= ?, lunch = ? WHERE day = ?";

        QueryExecutor.executeUpdateQuery(query, updatedMealPlan.getBreakfastMenu(), updatedMealPlan.getLunchMenu(),
                updatedMealPlan.getDay());
    }
}
