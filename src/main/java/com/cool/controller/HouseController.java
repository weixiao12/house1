package com.cool.controller;

import com.cool.entity.House;
import com.cool.entity.HouseType;
import com.cool.entity.HouseUser;
import com.cool.entity.Street;
import com.cool.service.HousePicService;
import com.cool.service.HouseService;
import com.cool.service.HouseTypeService;
import com.cool.service.StreetService;
import com.cool.util.PageResult;
import com.cool.util.Val;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Auther: cjc 2018/8/26 0026
 */
@Controller
@RequestMapping("/house")
public class HouseController {
	@Resource
	private HouseService houseService;
	@Resource
	private StreetService streetService;
	@Resource
	private HouseTypeService houseTypeService;
	@Resource
	private HousePicService housePicService;

	@RequestMapping("/list")
	public String home(PageResult pageResult, @ModelAttribute("house") House house, Model model, HttpSession session){
		houseService.getHouseByPage(pageResult,house);
		List<Street> streets = streetService.getAll();
		List<HouseType> hts = houseTypeService.getAll();
		model.addAttribute("result",pageResult);
		model.addAttribute("sts",streets);
		model.addAttribute("hts",hts);
		HouseUser user = (HouseUser) session.getAttribute(Val.SESSION_KEY_USER);
		if( user != null && "y".equals(user.getIsAdmin()) ){
			return  "guanli";
		}
		return "list";
	}

	@RequestMapping("/get")
	public String getHouse( Integer houseId, Model model ){
		House house = houseService.getHouseById(houseId);
		model.addAttribute("house",house);
		return "details";
	}

	@RequestMapping("/gotoPubish")
	public String gotoPubish( Model model ){
		List<HouseType> hts = houseTypeService.getAll();
		model.addAttribute("hts",hts);
		return "fabu";
	}

	@RequestMapping("/add")
	public String pubish( PageResult pageResult,  House house, Model model, HttpSession session ){
		HouseUser user = (HouseUser) session.getAttribute(Val.SESSION_KEY_USER);
		house.setHouseUser(user);
		house.setAdddate(new Date());
		house.setIsDelete(0);
		houseService.addHouse(house);
		return home(pageResult,new House(),model,session);
	}

	@RequestMapping("/exit")
	public String exitLogin(HttpSession session){
		session.removeAttribute(Val.SESSION_KEY_USER);
		return "login";
	}

	@RequestMapping("/delete")
	public String delete( PageResult pageResult,  Integer houseId, Model model, HttpSession session ){
		House house = houseService.getHouseById(houseId);
		house.setIsDelete(1);
		houseService.update(house);
		return home(pageResult,new House(),model,session);
	}

	@RequestMapping("/gotoUpdate")
	public String gotoUpdate(  Integer houseId, Model model ){
		House house = houseService.getHouseById(houseId);
		List<HouseType> hts = houseTypeService.getAll();
		model.addAttribute("hts",hts);
		model.addAttribute("house",house);
		return "update";
	}

	@RequestMapping("/update")
	public String update( PageResult pageResult,  House house, Model model, HttpSession session ){
		House h = houseService.getHouseById(house.getHouseId());
		house.setIsDelete(0);
		house.setHouseUser(h.getHouseUser());
		house.setAdddate(h.getAdddate());
		houseService.update(house);
		return home(pageResult,new House(),model,session);
	}

	@RequestMapping("/addPic")
	public String addPic( String[] imgBase64, Integer houseId, Model model ){
		housePicService.addPic(imgBase64,houseId);
		return getHouse(houseId,model);
	}

}
