package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Sha256;

public class Master implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse res = (HttpServletResponse) resp;

		String headerNames = httpRequest.getHeaders("Authorization").nextElement();
		if(checkAccount(headerNames,1)){
			chain.doFilter(req, resp);
		}else{
			res.sendRedirect("/DoAnCuoiKy/checkAutherFail");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	public static Boolean checkAccount(String token, int i){
		Connection connection;
		try {
			connection = ConnecUtil.getMyConnection();
			String hash = Sha256.convertSha256(token);
			String sql = "Select flag "
					+ "from tokens, users "
					+ "where tokens.auther_id = users.id and tokens.token = ?";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, hash);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()){
				if(rs.getInt("flag")==i){
					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
