package com.joe.register.client;

/**
 * 心跳反应的返回对象
 */
public class HeartbeatResponse {

    //心跳反馈的状态
    private boolean status;

    public HeartbeatResponse(boolean status){
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
