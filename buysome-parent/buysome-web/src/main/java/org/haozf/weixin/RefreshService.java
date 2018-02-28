package org.haozf.weixin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/**
 * 更新access_token ticket等
 * @author haozhengfeng
 *
 */
@Service
public class RefreshService {

	@Autowired
	TokenService tokenService;
	
	@Autowired
	TicketService ticketService;
	
	@Scheduled(fixedRate = 1000 * 7000)
    public void refreshAll(){
	    System.out.println("获取微信accesstoken");
		try {
			AccessToken token = tokenService.token();
			WeiXinContext.setAccessToken(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("获取微信accesstoken失败");
		}
		
		Ticket ticket = ticketService.ticket();
    	WeiXinContext.setJsapi_ticket(ticket);
    }
	
}
