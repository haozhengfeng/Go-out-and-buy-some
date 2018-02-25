package org.haozf.weixin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
    
    @RequestMapping("/")
    public void ticket(HttpServletResponse resp) throws IOException {
    	ticketService.ticket();
    }
    
    @RequestMapping("/refresh")
    public void reticket(HttpServletResponse resp) throws IOException {
    }
    
    
    @RequestMapping("/config")
    @ResponseBody
    public Map<String, Object> getConfig(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        String appId = WeiXinContext.APPID;
        // 获取页面路径(前端获取时采用location.href.split('#')[0]获取url)
        String url = request.getHeader("referer");
        // 获取ticket
        String jsapi_ticket = WeiXinContext.getJsapi_ticket().getTicket();
        // 获取Unix时间戳(java时间戳为13位,所以要截取最后3位,保留前10位)
        String timeStamp = Long.toString(System.currentTimeMillis() / 1000);
        String noncestr = UUID.randomUUID().toString();
        // 注意这里参数名必须全部小写，且必须有序
        String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timeStamp + "&url=" + url;
        String signature = SecurtityUtils.SHA1(sign);
        // 组装完毕，回传
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("appId", appId);
        ret.put("timestamp", timeStamp);
        ret.put("nonceStr", noncestr);
        ret.put("signature", signature);
        return ret;
    }

}
