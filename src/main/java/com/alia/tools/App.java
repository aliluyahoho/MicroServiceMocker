package com.alia.tools;import com.alia.tools.container.MockServer;import com.alia.tools.entity.MockServiceInfoDTO;/** * Created by Alia on 2016/12/17. */public class App {    public static String serviceName = "com.alia.service.AliaTestService";    public static String version = "alia-1.0.0";    public static int timeout = 500;    public App() {    }    public static void main(String[] args) throws InstantiationException, IllegalAccessException {        // 1.服务名称：自定义，跟需要调用的服务名一致就行        // 2.版本号：        // 3.响应时间：ms        MockServer.run(MyProviderMockImpl.class, new MockServiceInfoDTO( serviceName , version , timeout));    }}