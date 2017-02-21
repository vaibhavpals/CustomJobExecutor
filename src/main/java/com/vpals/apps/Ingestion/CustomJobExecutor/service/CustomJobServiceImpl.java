package com.vpals.apps.Ingestion.CustomJobExecutor.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.vpals.apps.Ingestion.CustomJobExecutor.entity.CustomJobDetails;
import com.vpals.apps.Ingestion.CustomJobExecutor.entity.HostDetails;
import com.vpals.apps.Ingestion.CustomJobExecutor.utility.SSHManager;

@Component
public class CustomJobServiceImpl implements CustomJobService {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomJobServiceImpl.class);
	
	public String executeCustomJob(String jsonObject){
		JSONObject inputJson = new JSONObject(jsonObject);
		LOGGER.info("Setting host details");
		HostDetails hostDetails = new HostDetails();
		hostDetails.setHostName(inputJson.get("hostName").toString());
		hostDetails.setHostUser(inputJson.get("hostUser").toString());
		hostDetails.setHostPassword(inputJson.get("hostPassword").toString());
		hostDetails.setHostPort(Integer.parseInt(inputJson.get("hostPort").toString()));
		LOGGER.info("Setting custom job details");
		CustomJobDetails cjDetails = new CustomJobDetails();
		cjDetails.setCustomJobLocation(inputJson.get("customJobLocation").toString());
		cjDetails.setCustomJobFileName(inputJson.get("fileName").toString());
		cjDetails.setCustomJobType(inputJson.get("jobType").toString());
		cjDetails.setCustomJobArgText(inputJson.get("jobDetails").toString());
		cjDetails.setCustomJobClassName(inputJson.get("customJobClassName").toString());
		cjDetails.setHostDetails(hostDetails);
		String result = sshExecuteJob(cjDetails);
		LOGGER.info("SSH JOB RESULT : " +result);
		
		
		return result;
	}

	private String sshExecuteJob(CustomJobDetails cjDetails) {
		SSHManager instance = new SSHManager(
				cjDetails.getHostDetails().getHostUser(),
				cjDetails.getHostDetails().getHostPassword(),
				cjDetails.getHostDetails().getHostName(),
				"",
				cjDetails.getHostDetails().getHostPort());
		LOGGER.info("created SSHManager instance");
		String errorMessage = instance.connect();

		String command = prepareCommand(cjDetails);
	     if(errorMessage != null)
	     {
	        LOGGER.info(errorMessage);
	     }
	     String result = instance.sendCommand(command);
	     instance.close();
	     return result;
	}

	private String prepareCommand(CustomJobDetails cjDetails) {
		String command1 = "echo -e \"" + cjDetails.getCustomJobArgText() + "\" | cat > "
				+ cjDetails.getCustomJobLocation()  + "config.properties";
		LOGGER.info(command1);
		String command2 = "";
		if("java".equalsIgnoreCase(cjDetails.getCustomJobType())) {
			command2 = "java -cp ";
		
		command2 = command2 + cjDetails.getCustomJobLocation()
		+ cjDetails.getCustomJobFileName() + " "
		+ cjDetails.getCustomJobClassName() + " "
		+ cjDetails.getCustomJobLocation() 
		+ "config.properties";
		}
		LOGGER.info(command2);
		return command1 + ";" +command2;
	}
}
