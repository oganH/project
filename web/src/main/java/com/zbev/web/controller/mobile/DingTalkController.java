package com.zbev.web.controller.mobile;

import com.zbev.core.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xlm on  2019/5/24
 */
@Controller
@RequestMapping("/mobile/dingtalk")
public class DingTalkController {

    @Autowired
    private StationService stationServices;


    @GetMapping("/index")
    public ModelAndView indexPage(){
        System.out.println("【钉钉】 index");
        return new ModelAndView("index");
    }

}
