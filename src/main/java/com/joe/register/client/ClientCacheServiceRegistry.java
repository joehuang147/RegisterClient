package com.joe.register.client;

import java.util.Map;

/**
 * 缓存（定时拉取）远程拉取的注册中心的注册表
 *
 */
public class ClientCacheServiceRegistry {

    //注册表<服务,<实例编号,实例对象>>
    private Map<String,Map<String,ServiceInstance>> registry;

    //拉取间隔
    private final Long FETCH_REGISTRY_INTEVAL = 30 * 1000L;

    private Daemon daemon ;

    /**
     * 一个客户端实例的，心跳、注册、刷注册表，用一个sender
     */
    private HttpSender sender;

    public ClientCacheServiceRegistry(HttpSender sender){
        daemon = new Daemon();
        daemon.setDaemon(true);
        this.sender = sender;
    };

    public void initialize(){
        daemon.start();
    }

    public void destroy(){
        daemon.interrupt();
    }

    class Daemon extends Thread{
        @Override
        public void run() {
            while (RegisterClient.isIsRunning() ){
                try {
                    //调用sender的fetchRegistry方法
                    registry = sender.fetchRegistry();
                    sleep(FETCH_REGISTRY_INTEVAL);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }


}
