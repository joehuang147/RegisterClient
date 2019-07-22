package com.joe.register.client;

/**
 * 定时发送心跳的线程
 */
public class HeartbeatWorker extends Thread{

    //服务名称
    private String serviceName;
    //实例编号
    private String instanceId;
    //发送心跳间隔
    private Long heartbeatInterval = 10 * 1000L;
    private HttpSender sender;

    public HeartbeatWorker(String serviceName,String instanceId,HttpSender sender){
        this.serviceName = serviceName;
        this.instanceId = instanceId;
        this.sender = sender;
    }


    @Override
    public void run() {
        HeartbeatRequest heartbeatRequest = new HeartbeatRequest(this.serviceName, this.instanceId);
        HeartbeatResponse heartbeatResponse = new HeartbeatResponse(true);
        try {
            while(RegisterClient.isIsRunning() && heartbeatResponse.getStatus()) {
                System.out.println("发送心跳！");
                heartbeatResponse = sender.heartbeat(heartbeatRequest);
                sleep(heartbeatInterval);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
