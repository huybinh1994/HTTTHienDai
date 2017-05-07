package controller;

import java.nio.file.WatchService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import service.MasterService;
import service.WatchingService;

@Controller
@Transactional
@EnableTransactionManagement
public class MasterController {
	MasterService masterService;

	public MasterService getMasterService() {
		return masterService;
	}

	@Autowired
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}

	@RequestMapping(value = "/listmaster", method = RequestMethod.GET)
	public @ResponseBody String getlistMaster() {
		String json = new Gson().toJson(masterService.getAll());
		return json;
	}

	

}
