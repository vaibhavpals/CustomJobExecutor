package com.vpals.apps.Ingestion.CustomJobExecutor.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vpals.apps.Ingestion.CustomJobExecutor.service.CustomJobService;

@Controller
@ComponentScan("com.vpals.apps.Ingestion.CustomJobExecutor.service") 
public class CustomJobExecutorCtrlImpl implements CustomJobExecutorCtrl{

	@Autowired
	private CustomJobService customJobService;
	
	@RequestMapping(value="/executeCustomJob", method=RequestMethod.POST)
	@ResponseBody
	public String executeCustomJob(@RequestBody String jsonObject){
		String retStr = customJobService.executeCustomJob(jsonObject);
		return new JSONObject().put("fetchedRecords",retStr).toString();
	}
}
