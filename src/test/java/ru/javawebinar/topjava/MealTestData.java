package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int NOT_FOUND = 10;
    public static final LocalDate DATE_START = LocalDate.of(2020, 1, 30);
    public static final LocalDate DATE_END = LocalDate.of(2020, 1, 31);
    public static final List<Meal> userMeals;
    public static final List<Meal> userMealsOneDate;
    public static final List<Meal> userMealsBetween;

    public static final Meal userMeal2 = new Meal(START_SEQ + 2, LocalDateTime.of(2020, 1, 30, 9, 50), "Завтрак пользователя", 259);
    public static final Meal userMeal3 = new Meal(START_SEQ + 3, LocalDateTime.of(2020, 1, 30, 12, 25), "Обед пользователя", 678);
    public static final Meal userMeal4 = new Meal(START_SEQ + 4, LocalDateTime.of(2020, 1, 30, 20, 35), "Ужин пользователя", 300);
    public static final Meal userMeal5 = new Meal(START_SEQ + 5, LocalDateTime.of(2020, 1, 31, 0, 0), "Еда на граничное значение пользователя", 150);
    public static final Meal userMeal6 = new Meal(START_SEQ + 6, LocalDateTime.of(2020, 1, 31, 9, 55), "Завтрак пользователя", 345);
    public static final Meal userMeal7 = new Meal(START_SEQ + 7, LocalDateTime.of(2020, 1, 31, 13, 25), "Обед пользователя", 1500);
    public static final Meal userMeal8 = new Meal(START_SEQ + 8, LocalDateTime.of(2020, 1, 31, 20, 35), "Ужин пользователя", 550);

    public static final Meal adminMeal9 = new Meal(START_SEQ + 9, LocalDateTime.of(2020, 1, 30, 10, 0), "Завтрак админа", 150);

    static {
        userMeals = Arrays.asList(userMeal8, userMeal7, userMeal6, userMeal5, userMeal4, userMeal3, userMeal2);
        userMealsOneDate = Arrays.asList(userMeal4, userMeal3, userMeal2);
        userMealsBetween = Arrays.asList(userMeal8, userMeal7, userMeal6, userMeal5, userMeal4, userMeal3, userMeal2);
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertIsEmpty(Iterable<Meal> actual) {
        assertThat(actual).isEmpty();
    }

    public static Meal getUpdated(Meal m) {
        Meal updated = new Meal(m);
        updated.setDateTime(LocalDateTime.of(2021, 7, 31, 20, 45));
        updated.setDescription("Updated meal");
        updated.setCalories(9999);
        return updated;
    }

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.of(2021, 5, 30, 12, 35, 0), "New meal", 7777);
    }
}