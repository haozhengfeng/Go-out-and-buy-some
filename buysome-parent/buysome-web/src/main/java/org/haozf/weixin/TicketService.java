package org.haozf.weixin;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    
    public Ticket ticket(){
        String url = WeiXinContext.WX_TICKET_URL;
        url = url.replaceAll("ACCESS_TOKEN", WeiXinContext.getAccessToken().getAccess_token());
        return HttpClientUtils.sendHttpGet(url,Ticket.class);
    }

}
