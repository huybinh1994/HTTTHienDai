package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.MasterReportDTO;
import model.TransactionDTO;
import service.TransactionService;
import service.WriteCsvService;

@Controller
@Transactional
@EnableTransactionManagement
public class SendFileController {

	WriteCsvService write;

	public WriteCsvService getWrite() {
		return write;
	}
	@Autowired
	public void setWrite(WriteCsvService write) {
		this.write = write;
	}
	TransactionService tranSer;
	
	public TransactionService getTranSer() {
		return tranSer;
	}
	@Autowired
	public void setTranSer(TransactionService tranSer) {
		this.tranSer = tranSer;
	}
	@RequestMapping(value = "/downloadTranBymerchan", produces = MediaType.APPLICATION_OCTET_STREAM)
	public @ResponseBody HttpEntity<byte[]> getFile() throws IOException, ParseException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date d = df.parse("2017-01-07 07:47:45.220");
		Date t =df.parse("2017-04-07 07:47:45.220");
		List<MasterReportDTO>masterrp = tranSer.callMasterReport(d,t );
		MasterReportDTO p = new MasterReportDTO();
		write.wirteCsv(masterrp);
		java.nio.file.Path path = Paths.get("data.xls");
		byte[] file = Files.readAllBytes(path);
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.set("Content-Disposition", "attachment; filename=data.xls");
		header.setContentLength(file.length);
		//
		return new HttpEntity<byte[]>(file, header);
	}
	@RequestMapping(value = "/downloadTranBymerchan_cardtype", produces = MediaType.APPLICATION_OCTET_STREAM)
	public @ResponseBody HttpEntity<byte[]> getFile2() throws IOException, ParseException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date d = df.parse("2017-01-07 07:47:45.220");
		Date t =df.parse("2017-04-07 07:47:45.220");
		List<MasterReportDTO>masterrp = tranSer.callMasterReport(d,t );
		MasterReportDTO p = new MasterReportDTO();
		write.wirteCsv(masterrp);
		java.nio.file.Path path = Paths.get("data.xls");
		byte[] file = Files.readAllBytes(path);
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.set("Content-Disposition", "attachment; filename=data.xls");
		header.setContentLength(file.length);
		//
		return new HttpEntity<byte[]>(file, header);
	}
}
