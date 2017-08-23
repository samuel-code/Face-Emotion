package com.tan.authroization.vo;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
public class ResponseVO {

    private String responseCode;
    private String responseMsg;
    private Object data;

    private ResponseVO(){
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseVO success(){
        ResponseVO responseVO = new ResponseVO();
        responseVO.responseCode = "000000";
        responseVO.responseMsg = "success";
        return responseVO;
    }

    public static ResponseVO success(Object data){
        ResponseVO responseVO = new ResponseVO();
        responseVO.responseCode = "000000";
        responseVO.responseMsg = "success";
        responseVO.data = data;
        return responseVO;
    }

    public static ResponseVO error(String responseCode,String responseMsg){
        ResponseVO responseVO = new ResponseVO();
        responseVO.responseCode = responseCode;
        responseVO.responseMsg = responseMsg;
        return responseVO;
    }
}
