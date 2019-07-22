package com.joe.register.client;

import java.util.UUID;

/**
 * 注册、心跳、拉取注册表的启动程序
 */
public class RegisterClient {

    private static String serviceName = "storeService";
    private static String ip = "192.168.31.78";
    private static int port = 9099;
    private static String hostName = "storeService1";
    private static String instanceId = UUID.randomUUID().toString().replace("-","");
    private static HeartbeatWorker heartbeatWorker;
    private static ClientCacheServiceRegistry clientCacheServiceRegistry;
    /**
     * 保持可见性
     */
    private static volatile boolean isRunning = true;
    /**
     * 使用同一个sender
     */
    private static HttpSender sender;

    public static boolean isIsRunning() {
        return isRunning;
    }

    public static void main(String[] args){
        try{
            sender = new HttpSender();

            ServiceInstance seriveInstanceMsg = new ServiceInstance(serviceName,instanceId,ip,hostName,port);
            RegisterClientWorker registerClientWorker = new RegisterClientWorker(seriveInstanceMsg,sender);
            registerClientWorker.start();
            //main阻塞，等registerClientWorker执行完成，main继续
            registerClientWorker.join();
            System.out.println("main线程执行！");

            heartbeatWorker = new HeartbeatWorker(serviceName, instanceId,sender);
            heartbeatWorker.start();

            clientCacheServiceRegistry = new ClientCacheServiceRegistry(sender);
            clientCacheServiceRegistry.initialize();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void shutdown(){
        isRunning = false;
        heartbeatWorker.interrupt();
        clientCacheServiceRegistry.destroy();
        sender.cancel(serviceName,instanceId);
    }


}
