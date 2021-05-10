package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.model.FoodVO;
import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet {

	protected FoodService fService;
	public FoodController() {
		fService =  new FoodServiceImplV1();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if (subPath.equals("/seq")) {
			
			String strSeq = req.getParameter("id");
			
			if (strSeq == null || strSeq.equals("")) { // null값이거나 또는 아무것도 입력하지 않고 전송하면
				out.println("번호가 없음");
				out.close();
			} else {
				Long nSeq = Long.valueOf(strSeq);
				FoodDTO foodDTO = fService.f
				
			}
			
			
		}
		
		
	}

	
	
	

}
