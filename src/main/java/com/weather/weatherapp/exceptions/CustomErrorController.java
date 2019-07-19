package com.weather.weatherapp.exceptions;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * A simple custom catch-all error handler.
 * This could be enhanced to handle specific error such as 404, 500 etc.
 */

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}