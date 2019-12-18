package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionaryController {

    Map<String,String> dicitonary = new HashMap<>();
    {
        dicitonary.put("hello", "xin chào");
        dicitonary.put("computer", "máy tính");
        dicitonary.put("goodbye", "tạm biệt");
        dicitonary.put("laptop", "máy tính xách tay");
    }

    @GetMapping("home")
    public ModelAndView viewHome() {
        ModelAndView modelAndView = new ModelAndView("/dictionary/index");
        return modelAndView;
    }

    @PostMapping("home")
    public ModelAndView viewResult(@RequestParam String eng) {
        ModelAndView modelAndView = new ModelAndView("/dictionary/index");
        String vi = dicitonary.get(eng);
        if(vi != null) {
            modelAndView.addObject("vi",vi);
        } else {
            modelAndView.addObject("vi","Không tìm thấy");
        }
        return modelAndView;
    }
}
