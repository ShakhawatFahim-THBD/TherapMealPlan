package net.therap.domain;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 5/21/14
 * Time: 9:20 AM
 */
public class MealPlan {

    private String day;
    private String breakfastMenu;
    private String lunchMenu;

    public MealPlan() {
    }

    public MealPlan(String day, String breakfastMenu, String lunchMenu) {
        this.day = day;
        this.breakfastMenu = breakfastMenu;
        this.lunchMenu = lunchMenu;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBreakfastMenu() {
        return breakfastMenu;
    }

    public void setBreakfastMenu(String breakfastMenu) {
        this.breakfastMenu = breakfastMenu;
    }

    public String getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(String lunchMenu) {
        this.lunchMenu = lunchMenu;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "day='" + day + '\'' +
                ", breakfastMenu='" + breakfastMenu + '\'' +
                ", lunchMenu='" + lunchMenu + '\'' +
                '}';
    }
}
