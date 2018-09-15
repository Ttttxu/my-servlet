package test1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class Myservlet1 extends HttpServlet{
	private static final long serialVersionUID = -6148890140821452083L;

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		System.out.println("get");
		System.out.println(request.getParameter("firstname"));
		System.out.println(request.getParameter("lastname"));
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("post");
		//doGet(request, response);
		Map<String, String[]> map = request.getParameterMap();
		Map<String, Object> data = new HashMap<>();
		List<String> list = null;
		for (Entry<String, String[]> e : map.entrySet()) {
			System.out.println(e.getKey());
			list = new ArrayList<>();
			for (String str : e.getValue()) {
				System.out.println(str);
				list.add(str);
			}
			data.put(e.getKey(), list);
		}
		JSONObject jsonObject = JSONObject.fromObject(data);
		PrintWriter out = response.getWriter();
		out.write(jsonObject.toString());
		out.close();
	}
}

