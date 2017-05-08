package controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import service.WatchingService;

@Controller
@Transactional
@EnableTransactionManagement
public class WatchingController {	
	private static long sendMailDelay = 10;				//set time for Send Mail delay
	private static final long initialSendMailDelay= TimeUnit.MINUTES.toMillis(sendMailDelay);
	private ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
	
	@Autowired
	WatchingService watchService;

	public WatchingService getWatchService() {
		return watchService;
	}

	
	public void setWatchService(WatchingService watchService) {
		this.watchService = watchService;
	}
	
	@PostConstruct
	public void theodoi(){
		watchService.watching();

//		schedule.scheduleWithFixedDelay(new Runnable() {
//			
//			@Override
//			public void run() {
//				watchService.watching();
//				
//			}
//		}, 0, initialSendMailDelay, TimeUnit.MILLISECONDS);
	};

}
