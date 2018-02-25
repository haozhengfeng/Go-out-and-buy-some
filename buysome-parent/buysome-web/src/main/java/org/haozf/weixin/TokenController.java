package org.haozf.weixin;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;
    
    @RequestMapping("/")
    public void token(HttpServletResponse resp) throws IOException {
        resp.getWriter().println(WeiXinContext.getAccessToken().getAccess_token());
    }
    
    @RequestMapping("/refresh")
    public void retoken(HttpServletResponse resp) throws IOException {
        tokenService.retoken();
    }

}
