package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.MasterReportCardtype;
import model.MasterReportDTO;
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
	@RequestMapping(value = "/downloadTranBymerchan", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM)
	public @ResponseBody HttpEntity<byte[]> getFile(@RequestParam(value = "search", required = false) String search
			,@RequestParam(value = "merchan_type", required = false) String merchan_type
			,@RequestParam(value = "region", required = false) String region
			,@RequestParam(value = "level", required = false) String level
			,@RequestParam(value = "code", required = false) String code
			,@RequestParam(value = "fromdate", required = false) String fromdate
			,@RequestParam(value = "todate", required = false) String todate) throws IOException, ParseException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		List<MasterReportDTO>masterrp = tranSer.callMasterReport(search,merchan_type , region, level, code, fromdate, todate);
		MasterReportDTO p = new MasterReportDTO();
		write.wirteCsv(masterrp);
		java.nio.file.Path path = Paths.get("data.xls");
		byte[] file = Files.readAllBytes(path);
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.set("Content-Disposition", "attachment; filename=TranBymerchan.xls");
		header.setContentLength(file.length);
		//
		return new HttpEntity<byte[]>(file, header);
	}
	@RequestMapping(value = "/downloadTranBymerchan_cardtype", produces = MediaType.APPLICATION_OCTET_STREAM)
	public @ResponseBody HttpEntity<byte[]> getFile2(@RequestParam(value = "search", required = false) String search
			,@RequestParam(value = "merchan_type", required = false) String merchan_type
			,@RequestParam(value = "region", required = false) String region
			,@RequestParam(value = "level", required = false) String level
			,@RequestParam(value = "code", required = false) String code
			,@RequestParam(value = "fromdate", required = false) String fromdate
			,@RequestParam(value = "todate", required = false) String todate) throws IOException, ParseException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date d = df.parse(fromdate);
//		Date t =df.parse(todate);
		List<MasterReportCardtype>masterrp = tranSer.callMasterReportCardtype(search,merchan_type , region, level, code, fromdate, todate);
		MasterReportDTO p = new MasterReportDTO();
		write.wirteCsvCardtype(masterrp);
		java.nio.file.Path path = Paths.get("data2.xls");
		byte[] file = Files.readAllBytes(path);
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		header.set("Content-Disposition", "attachment; filename=TranBymerchan_cardtype.xls");
		header.setContentLength(file.length);
		//
		return new HttpEntity<byte[]>(file, header);
	}
}
