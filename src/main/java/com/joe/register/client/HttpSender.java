package com.joe.register.client;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 向远程注册中心，发送注册、心跳、拉取注册表的请求
 */
public class HttpSender {

    public RegisterResponse register(RegisterRequest request){
        System.out.println("发送注册请求【"+request+"】");
        return new RegisterResponse(RegisterResponse.SUCCESS);
    }

    public HeartbeatResponse heartbeat(HeartbeatRequest request){
        System.out.println("发送心跳操作【"+request+"】");
        return new HeartbeatResponse(true);
    }

    public Map<String, Map<String,ServiceInstance>> fetchRegistry(){
        ServiceInstance s1 = new ServiceInstance("Order","OrderSerivceInstance1"
        ,"192.168.31.4","OrderService1",9099);
        ServiceInstance s2 = new ServiceInstance("Order","OrderSerivceInstance2"
        ,"192.168.31.5","OrderService1",9099);
        ServiceInstance s3 = new ServiceInstance("Good","GoodSerivceInstance1"
        ,"192.168.31.6","GoodService1",9098);

        Map<String, Map<String, ServiceInstance>> registry =
                new HashMap<String, Map<String, ServiceInstance>>();
        Map<String, ServiceInstance> OrderService = new HashMap<String, ServiceInstance>();
        Map<String, ServiceInstance> GoodService = new HashMap<String, ServiceInstance>();

        OrderService.put(s1.getInstanceId(), s1);
        OrderService.put(s2.getInstanceId(), s2);
        GoodService.put(s3.getInstanceId(), s3);

        registry.put(s1.getServiceName(), OrderService);
        registry.put(s3.getServiceName(), GoodService);

        System.out.println("拉取注册表：" + registry);

        return registry;
    }

    public void cancel(String serviceName,String instanceid){
        System.out.println(String.format("服务：%s的实例：%s 下线成功！",serviceName,instanceid));
    }

}
