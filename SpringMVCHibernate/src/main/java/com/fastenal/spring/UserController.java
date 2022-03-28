package com.fastenal.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fastenal.spring.model.Product;
import com.fastenal.spring.model.User;
import com.fastenal.spring.service.UserService;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

@Controller
public class UserController {

	@Autowired(required = true)
	@Qualifier(value = "userService")
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {

		user.setPassword(Integer.toString(user.getPassword().hashCode()));
		this.userService.addUser(user);

		return "redirect:http://localhost:3000/";

	}



	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public void Signin(HttpServletRequest req, HttpServletResponse res) throws IOException {

		try {
			String jsonBody = IOUtils.toString(req.getReader());
			String s;
			JSONObject json = new JSONObject(jsonBody);
			String email = (String) json.get("username");
			String password = (String) json.get("password");
			password = Integer.toString(password.hashCode());
			System.out.println("password from req is: "+password);

			User reqUser = new User();
			reqUser.setEmail(email);
			reqUser.setPassword(password);
			System.out.println(reqUser);

			User user = this.userService.getUserById(email);
			System.out.println("user got from db is :" + user);

			if (user != null && user.getPassword().equals(password)) {
				s = " {\"token\": \"" + email + "\"} ";
			} else {
				s = " {\"token\": \"null\"} ";
			}

			System.out.println("response is :" + s);
			PrintWriter wr = res.getWriter();
			wr.print(s);
			wr.flush();
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
