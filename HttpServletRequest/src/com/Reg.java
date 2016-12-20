package com;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class Reg extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
//		test2(request);
		test1(request);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void test1(HttpServletRequest request) {
		User user = new User();
		System.out.println("封装数据前：" + user);
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println("封装后的数据：" + user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private void test2(HttpServletRequest request) {
		User user = new User();
		System.out.println("封装数据前：" + user);
		
		/*
		 * Map<String, String[]> parameterMap = request.getParameterMap();
		 * Set<String> keySet = parameterMap.keySet(); for (String key : keySet)
		 * { System.out.println(key + ":"); for (String value :
		 * parameterMap.get(key)) { System.out.println(value + "\t"); } }
		 */

		for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
			String name = entry.getKey();
			String[] value = entry.getValue();

			try {
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				Method writeMethod = pd.getWriteMethod();

				try {
					if (value.length == 1) {
						writeMethod.invoke(user, value[0]);
					} else {
						writeMethod.invoke(user, (Object) value);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (IntrospectionException e) {
				e.printStackTrace();
			}

		}
		System.err.println("封装后的数据："+user);
	}

	private void test3(HttpServletRequest request) {

	}

	private void test4(HttpServletRequest request) {

	}
}
