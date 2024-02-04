package com.debugs.userPage.common;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.member.model.vo.Member;
import com.debugs.userPage.mainPage.model.vo.User;

/**
 * Servlet Filter implementation class TicketCheckFilter
 */
@WebFilter(servletNames= {
"addCurrentPlayListAllController",
"addCurrentPlayListController",
"addPlayRecommendController",
"changeMusicLikeController",
"musicPlayerController",
"selectCurrentPlayList",
"selectPlayListController",
"selectUserPlaylistController"
})
public class TicketCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TicketCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 사용자의 회원번호를 가지고 사용중인 이용권 조회
		// 유효한 이용권이면 true / 유효하지 않은 이용권이면 false
		Member loginUser = (Member)((HttpServletRequest) request).getSession().getAttribute("loginUser");
		
		if(loginUser == null) {
			((HttpServletResponse)response).getWriter().print("loginFalse");
			return;
		}else {
			String ticketDate = loginUser.getTicketDate();
			if(ticketDate == null) {
				((HttpServletResponse)response).getWriter().print("playFalse");
				return;
			}else {
				// 이용권 기한 체크.
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        Date TicketDate;
		        Date currentDate = new Date();
		        int comparison  = 0;
				try {
					TicketDate = formatter.parse(ticketDate);
					comparison = currentDate.compareTo(TicketDate);					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (comparison > 0) { // 현재시간이 이용권 사용가능기한보다 이전일 경우..
					((HttpServletResponse)response).getWriter().print("playFalse");
					return;
		        }
				
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
