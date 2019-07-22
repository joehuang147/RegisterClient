package com.joe.register.client;

public class ServiceInstance {

    private String serviceName;
    private String instanceId;
    private String ip;
    private String hostName;
    private int port;

    public ServiceInstance(String serviceName, String instanceId, String ip, String hostName, int port) {
        this.serviceName = serviceName;
        this.instanceId = instanceId;
        this.ip = ip;
        this.hostName = hostName;
        this.port = port;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getIp() {
        return ip;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
