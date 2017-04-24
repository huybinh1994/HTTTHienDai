package controller;

import java.nio.file.WatchService;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	WatchingService watchService;

	public WatchingService getWatchService() {
		return watchService;
	}

	
	public void setWatchService(WatchingService watchService) {
		this.watchService = watchService;
	}

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

	@RequestMapping(value = "/theodoi", method = RequestMethod.GET)
	public  void theodoi() {
		watchService.watching();
	}
}
