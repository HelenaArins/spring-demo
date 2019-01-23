package com.rookie.training.springdemo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/teste")
public class ControllerTest {
	
	@RequestMapping("/get")
	public View get() {
		return new View() {
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				// TODO Auto-generated method stub
				response.getWriter().println("Hi!");				
			}			
		};
	}
	@ResponseBody
	@RequestMapping("/getString")
	public String getResponseBody() {
		return "Hi again!";
	}
	
}
