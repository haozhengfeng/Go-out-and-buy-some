package org.haozf.weixin;


public class WeiXinContext {

//    public static final String APPID = "wx72d98338495bb300";
//    public static final String APPSECRT = "03417a4badc01434a08125ba94c20876";
    
    public static final String APPID = "wx14c8e3f2be9e4f20";
    public static final String APPSECRT = "54e13730cd752856a6b8f7bea6d7fe13";

    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    
    public static final String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    
    public static final String MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    
    public static final String MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    
    public static final String MENU_ADDCONDITIONAL = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
    
    public static final String MENU_DELCONDITIONAL = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
    
    public static final String MENU_TRYMATCH = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";
    
    public static final String MEDIA_URL ="https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    
    public static final String WX_SERVER_IP = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
    
    public static final String WX_AUTHO_URL="http://57d75926.ngrok.io/wx_web/wxuser/wxautho";
    
    public static AccessToken accessToken;
    
    public static AccessToken getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(AccessToken accessToken) {
        WeiXinContext.accessToken = accessToken;
    }
    
    public static final String WX_TICKET_URL="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    
    public static Ticket jsapi_ticket;
    
    
    public static Ticket getJsapi_ticket() {
		return jsapi_ticket;
	}

	public static void setJsapi_ticket(Ticket jsapi_ticket) {
		WeiXinContext.jsapi_ticket = jsapi_ticket;
	}

	public static final String TOKEN = "haozhengfeng";
    
    public static String MSG_TEXT_TYPE = "text";
    public static String MSG_IMAGE_TYPE = "image";
    public static String MSG_VOICE_TYPE = "voice";
    public static String MSG_VIDEO_TYPE = "video";
    public static String MSG_SHORTVIDEO_TYPE = "shortvideo";
    public static String MSG_LOCATION_TYPE = "location";
    public static String MSG_EVENT_TYPE = "event";
    
    public static String mSG_LINK_TYPE = "link";

}
