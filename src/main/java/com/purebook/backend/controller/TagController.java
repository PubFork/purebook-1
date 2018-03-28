package com.purebook.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.result.JsonResult;
import com.example.result.JsonResultwithData;
import com.example.result.ResultCode;
import com.purebook.backend.entity.Tag;
import com.purebook.backend.service.TagService;

@RestController
@RequestMapping(value="v1/tags")
public class TagController {
	
	@Autowired
	TagService tagService;
	
	
	//热门标签
	@RequestMapping
	public JsonResult getTags(){
		List<Tag> tags= tagService.getTag();
		if(tags!=null){
			JsonResultwithData jsonResultwithData=new JsonResultwithData(ResultCode.SUCCESS);
			jsonResultwithData.setData(tags);
			return jsonResultwithData;
		}
		JsonResult jsonResult = new JsonResult(ResultCode.EXCEPTION);
		return jsonResult;
	}
}
