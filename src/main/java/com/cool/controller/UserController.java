package com.cool.controller;

import com.cool.entity.HouseUser;
import com.cool.service.UserService;
import com.cool.util.JsonModel;
import com.cool.util.MD5;
import com.cool.util.MsgCode;
import com.cool.util.Val;
import com.google.code.kaptcha.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: cjc 2018/8/24 0024
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public JsonModel login(HouseUser user, String veryCode, HttpServletRequest request){
		JsonModel jm = new JsonModel();
		jm.setResult(MsgCode.LOGIN_ERROR);

		//验证码验证
		String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if ( !code.equalsIgnoreCase(veryCode) ){
			jm.setResult(MsgCode.VERYCODE_ERROR);
			return jm;
		}

		user.setPassword(MD5.md5(user.getPassword().getBytes()));
		user = userService.login(user);
		//登录验证
		if( user != null ){
			request.getSession().setAttribute(Val.SESSION_KEY_USER,user);
			jm.setResult(MsgCode.LOGIN_SUCCESS);
			return jm;
		}
		return jm;
	}


	@RequestMapping("/reg")
	@ResponseBody
	public JsonModel register( HouseUser user ){
		JsonModel jm = new JsonModel();
		jm.setResult(MsgCode.REGS_SUCCESS);
		user.setPassword(MD5.md5(user.getPassword().getBytes()));
		userService.addUser(user);
		return jm;
	}


}
