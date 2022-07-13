package Assignment_Canhnhph17851.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class Authenticate implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handle
	) throws IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") == null) {
			response.sendRedirect("/SOF3021_Assignment_Canhnhph17851" + "/login");
			return false;
		}
		return true;
	}
}
