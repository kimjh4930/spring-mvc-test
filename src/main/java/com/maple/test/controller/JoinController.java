/*
 * @(#)JoinController.java $version 2015. 2. 7.
 *
 * Copyright 2015 NHN Ent. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.maple.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maple.test.model.Member;
import com.maple.test.service.MemberService;

/**
 * @author Kanghoon Choi
 */
@Controller
public class JoinController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("/join/form")
	public String getForm() {
		
		System.out.println("Hello world!");
		
		return "join";
	}
	
	@RequestMapping("/join")
	
	public String join(/*@ModelAttribute 가 생략되어있느 형태*/Model model, Member member){
		
		boolean result = memberService.join(member);
		
		if(result){
			return "joinSuccess";
		} else {
			model.addAttribute("failmag","회원가입에 실패했어요");
		}
		
		return "joinFail";
	}
}
