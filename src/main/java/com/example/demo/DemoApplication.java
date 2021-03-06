package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @RequestMapping("/{name}")
	String index(@PathVariable("name") String name, Model model){
        model.addAttribute("name", name);
	    return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public Map json(){
        Map m=new HashMap();
        m.put("index1","str1");
        m.put("index2","str2");
        m.put("index3","str3");
        return m;
    }
}
