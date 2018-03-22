package com.purebook.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.result.JsonResultwithData;
import com.example.result.ResultCode;
import com.purebook.backend.entity.User;
import com.purebook.backend.service.UserService;

@RestController
@RequestMapping(value="v1/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	//登陆。
	@RequestMapping(method=RequestMethod.GET)
	public JsonResultwithData login(@RequestParam int id,@RequestParam String password){
		User user=userService.findUserById(id);
		if(user!=null){
			if(user.getPassword().equals(password)){
				JsonResultwithData jsonResultwithData=new JsonResultwithData();
				jsonResultwithData.setData(user);
				return jsonResultwithData;
			}
			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.NOT_LOGIN);
			jsonResultwithData.setData(null);
			return jsonResultwithData;
		}
		JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.NOT_FOUND);
		jsonResultwithData.setData(null);
		return jsonResultwithData;
	}
}
