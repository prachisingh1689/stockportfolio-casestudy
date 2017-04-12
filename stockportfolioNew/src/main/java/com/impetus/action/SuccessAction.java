package com.impetus.action;

import com.impetus.services.MyConstant;
import com.opensymphony.xwork2.ActionSupport;

public class SuccessAction extends ActionSupport

{


private static final long serialVersionUID = 1L;

public String execute(){
		
		return MyConstant.SUCCESS;
	}
	
	
}
