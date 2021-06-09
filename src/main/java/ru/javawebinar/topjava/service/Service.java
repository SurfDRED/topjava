package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface Service {
    List<Meal> getListAllMeal();

    void updateMeal(Meal meal);

    void addMeal(Meal meal);

    Meal getMeal(int id);

    void deleteMeal(int id);
}