package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Sha256;

public class MyFilter implements Filter {
	private Long setTime = (long) (60000*15);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse res = (HttpServletResponse) resp;

		Enumeration<String> headerNames = httpRequest.getHeaderNames();
		List<String> header = new ArrayList<>();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				header.add(httpRequest.getHeader(headerNames.nextElement()));
			}
		}
		try {
			if (checkToken(header.get(5))) {
				chain.doFilter(req, resp);
			}
			else{
				res.sendRedirect("/DoAnCuoiKy/checkAutherFail");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("day la filter");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	private Boolean checkToken(String token) throws SQLException, ClassNotFoundException, ParseException{
		Connection connection = ConnecUtil.getMyConnection();
		try {
			String hash = Sha256.convertSha256(token);
			String sql = "Select token, expire,auther_id from tokens where token = ?";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, hash);
		    ResultSet rs = pstm.executeQuery();		     
		    if(rs.next())
		     {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    	long kq= System.currentTimeMillis() - rs.getTimestamp("expire").getTime();
		    	if(kq< setTime){
		    		return true;
		    	}
		    	else{
					String deletesql = "delete from tokens where token = ?";
					PreparedStatement deletepstm = connection.prepareStatement(deletesql);
					deletepstm.setString(1, token);
					ResultSet rs2 = deletepstm.executeQuery();
		    	}
	    	 
		     }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			connection.close();
        }
		return false;
	}

}
