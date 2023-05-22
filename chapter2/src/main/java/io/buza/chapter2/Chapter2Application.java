package io.buza.chapter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication(scanBasePackages = "io.buza.*")
@Controller
@RequestMapping("/chapter2")
public class Chapter2Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter2Application.class, args);
    }

    @GetMapping("/index/{value}")
    public ModelAndView index(ModelAndView modelAndView, @PathVariable("value") String value) {
        modelAndView.getModelMap().addAttribute("key", value);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
