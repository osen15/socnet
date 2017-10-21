package com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
    // @RequestMapping(value = "/test")
    // public ModelAndView test(){
    //     ModelAndView modelAndView = new ModelAndView("test");
    //     return   modelAndView.addObject("name", "Oleg");
    // }

    @RequestMapping(value = "/")
    public ModelAndView indexTest() {
        ModelAndView modelAndView = new ModelAndView("index.vm");
        return modelAndView;
    }

  /*  @RequestMapping(value = "/test_ajax")
    public String processAjax(@RequestParam String email, @RequestParam String name) {
        String response;
        if (validateEmail(email))
            response = "{\"response\" : \"success\"}";
        else response = "{\"response\" : \"failed\"}";

        return response;
    }
  /*  @RequestMapping(value = "/test_ajax")
    public ResponseEntity<String> processAjaxBetterOption(@RequestParam String email, @RequestParam String name) {
        String response = "{\"response\" : \"success\"}";

    return  new ResponseEntity<String>(response, new  HttpHeaders(), HttpStatus.OK);
    } **/

   @RequestMapping(value = "/test_ajax")
    public ResponseEntity<String> processAjaxBetterOption(@RequestParam String email, @RequestParam String name) {
        ResponseEntity<String> response;
        if (validateEmail(email) && name != null)
            response = new ResponseEntity<>(HttpStatus.OK);
        else response = new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        return response;
    }


    private boolean validateEmail(String email) {
        return !email.contains("g") || !email.contains("gmail");

    }


}