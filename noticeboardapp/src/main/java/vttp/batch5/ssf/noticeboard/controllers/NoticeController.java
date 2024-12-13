package vttp.batch5.ssf.noticeboard.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.redis.core.RedisTemplate;

import jakarta.validation.Valid;
import vttp.batch5.ssf.noticeboard.models.Notice;
import vttp.batch5.ssf.noticeboard.services.NoticeService;

// Use this class to write your request handlers

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping("")
    public String getNotice(Model model){
        Notice n = new Notice();
        model.addAttribute("notice", n);
        return "notice";
    }
    
    @PostMapping("")
    public String submit(@Valid @ModelAttribute("notice") Notice entity, BindingResult result) {
        if (result.hasErrors()) {
            return "notice"; 

        noticeService.postToNoticeServer();
        return "messagePosted";
        }

    }
     @GetMapping("/health")  
    public ModelAndView getHealth() {
        ModelAndView mav = new ModelAndView(); 

        try {
            checkHealth();  
            
                        mav.setViewName("healthy");  
                        mav.setStatus(HttpStatusCode.valueOf(200)); 
                    } catch (Exception ex) {
                        mav.setViewName("unhealthy");  
                        mav.setStatus(HttpStatusCode.valueOf(500));  
                    }
            
                    return mav;
                }
            
        private void checkHealth() throws Exception {
        Random random = new Random();
        Integer value = random.nextInt(0, 10);

        if (value <= 5) {  // If value is <= 5, simulate an error
            throw new Exception("Simulating error..." + value.toString());
        }
    }

  }



    