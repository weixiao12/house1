package com.cool.controller;

import com.cool.entity.District;
import com.cool.entity.Street;
import com.cool.service.DistrictService;
import com.cool.service.StreetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *     @Auther: cjc 2018/8/28 0028
 */
@Controller
@RequestMapping("/district")
public class DistrictController {

	@Resource
	private DistrictService districtService;


	@RequestMapping("/getAll")
	@ResponseBody
	public List<District> getAll(){
		List<District> districts = districtService.getAll();
		return districts;
	}

}
