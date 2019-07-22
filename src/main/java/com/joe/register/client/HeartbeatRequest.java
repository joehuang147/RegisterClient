package com.joe.register.client;

/**
 * 注册信息对象
 */
public class HeartbeatRequest {
    //serviceName,instanId
    //服务名称，实例编号
    private String serviceName;
    private String instanceId;

    public HeartbeatRequest(String serviceName,String instanceId){
        this.serviceName = serviceName;
        this.instanceId = instanceId;
    }

    @Override
    public String toString() {
        return "HeartbeatRequest{" +
                "serviceName='" + serviceName + '\'' +
                ", instanceId='" + instanceId + '\'' +
                '}';
    }
}
