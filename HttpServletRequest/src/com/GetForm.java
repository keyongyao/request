package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class GetForm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            ServletInputStream inputStream = request.getInputStream();
            int len=0;
            byte flush[]=new byte[2048];
            while(-1!=(len=inputStream.read(flush))){
            	System.out.println(
            			URLDecoder.decode(new String(flush,0,len,"UTF-8")));
            }
            	inputStream.close();	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
