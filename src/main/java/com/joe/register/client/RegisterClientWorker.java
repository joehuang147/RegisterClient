package com.joe.register.client;

/**
 * 服务注册线程，注册完就关闭
 */
public class RegisterClientWorker extends Thread{

    private ServiceInstance instanceMsg;

    private HttpSender sender;

    private boolean finishRegister;

//    private Long heartbeatInterval = 10 * 1000L;

    public RegisterClientWorker(ServiceInstance instanceMsg,HttpSender sender){
        this.instanceMsg = instanceMsg;
        this.finishRegister = false;
        this.sender = sender;
    }

    @Override
    public void run() {
        if(!finishRegister){
            RegisterRequest registerRequest = new RegisterRequest(instanceMsg.getIp(), instanceMsg.getHostName(), instanceMsg.getPort(), instanceMsg
                    .getServiceName(), instanceMsg.getInstanceId());
            RegisterResponse response = sender.register(registerRequest);
            if(response.getStatus().equals(RegisterResponse.SUCCESS)){
                finishRegister = true;
                System.out.println(registerRequest.getServiceName()+"的服务"+registerRequest.getInstanceId()+"注册成功");
            }
        }

    }
}
