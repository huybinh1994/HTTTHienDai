package controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class DeMo {
	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public @ResponseBody String getlist() {
		data dt = new data();
		dt.setMessage("Hello World");
		dto dto = new dto();
		dto.setStatusCode(200);
		dto.setData(dt);
		String json = new Gson().toJson(dto);
		return json;
	}
}
