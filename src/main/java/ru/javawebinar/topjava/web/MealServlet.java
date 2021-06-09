package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.Service;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final int CALORIES_PER_DAY = 2000;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final Service service = new MealService();
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = String.valueOf(request.getParameter("action"));

        if (action.equals("null")) {
            request.setAttribute("meals",
                    MealsUtil.filteredByStreams(service.getListAllMeal(), LocalTime.MIN, LocalTime.MAX, CALORIES_PER_DAY));
            request.setAttribute("formatter", FORMATTER);
            log.debug("Show all meals");
            request.getRequestDispatcher("meals.jsp").forward(request, response);
            return;
        }
        String id = request.getParameter("id");
        switch (action) {
            case "delete":
                service.deleteMeal(Integer.parseInt(id));
                log.debug("delete meal:{}", id);
                response.sendRedirect("meals");
                break;
            case "add":
            case "update":
                Meal meal = ((id == null) ? new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 0) : service.getMeal(Integer.parseInt(id)));
                log.debug("Update meal:{}", id);
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/mealEdit.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Meal meal = new Meal(
                LocalDateTime.parse(req.getParameter("datetime")),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("calories")));
        String id = req.getParameter("id");
        if (Boolean.parseBoolean(req.getParameter("isNewMeal"))) {
            service.addMeal(meal);
            log.debug("add meal:{}", meal.getId());
        } else {
            meal.setId(Integer.parseInt(id));
            service.updateMeal(meal);
            log.debug("update meal:{}", meal.getId());
        }
        resp.sendRedirect("meals");
    }
}