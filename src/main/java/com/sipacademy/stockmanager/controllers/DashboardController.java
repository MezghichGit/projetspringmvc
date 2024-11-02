package com.sipacademy.stockmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@RequestMapping("/superadmin")
	public String dashboardSuperAdmin() {
		return "/dashboard/dashboard_superadmin";
	}
	
	@RequestMapping("/admin")
	public String dashboardAdmin() {
		return "/dashboard/dashboard_admin";
	}
	@RequestMapping("/agent")
	public String agent() {
		return "/dashboard/dashboard_agent";
	}

}
