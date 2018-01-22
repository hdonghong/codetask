package pers.hdh.utils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class CCPRestSmsUtils {

    private CCPRestSmsSDK restAPI;
    private String SERVER_IP;
    private String SERVER_PORT;
    private String ACCOUNT_SID;
    private String ACCOUNT_TOKEN;
    private String App_ID;

    public CCPRestSmsUtils() { }
    public CCPRestSmsUtils(CCPRestSmsSDK restAPI, String SERVER_IP, String SERVER_PORT,
                           String ACCOUNT_SID, String ACCOUNT_TOKEN, String App_ID) {
        this.restAPI = restAPI;
        restAPI.init(SERVER_IP, SERVER_PORT);
        restAPI.setAccount(ACCOUNT_SID, ACCOUNT_TOKEN);
        restAPI.setAppId(App_ID);
    }

    public CCPRestSmsSDK getRestAPI() {
        return restAPI;
    }
    public void setRestAPI(CCPRestSmsSDK restAPI) {
        this.restAPI = restAPI;
    }

}
