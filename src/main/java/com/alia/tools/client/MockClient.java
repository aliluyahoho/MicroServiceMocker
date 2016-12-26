package com.alia.tools.client;import com.alia.tools.entity.MockServiceInfoDTO;import com.alibaba.dubbo.config.ServiceConfig;import com.alibaba.dubbo.rpc.service.GenericService;import org.apache.commons.lang.NullArgumentException;import org.apache.commons.lang.StringUtils;/** * Created by Alia on 2016/12/17. */public class MockClient {    private String interfaceName;    private String version;    private Integer timeout;    private volatile ServiceConfig<GenericService> service = null;    public MockClient(MockServiceInfoDTO serviceInfo) {        this.interfaceName = serviceInfo.getInterfaceName();        this.version = serviceInfo.getVersion();        this.timeout = serviceInfo.getTimeout();    }    public void start(GenericService T) {        if (!StringUtils.isEmpty(this.interfaceName) && this.interfaceName.length() > 0) {            this.service = new ServiceConfig();            this.service.setInterface(this.interfaceName);            if (this.version != "" && this.version.length() > 0) {                this.service.setVersion(this.version);            }            if (this.timeout.toString() != "" && this.timeout.toString().length() > 0) {                this.service.setTimeout(this.timeout);            }            this.service.setRef(T);            this.service.export();        } else {            throw new NullArgumentException("The \'interfaceName\' should not be " + this.interfaceName +                    ", please make sure you have the correct \'interfaceName\' passed in");        }    }    public void stop(GenericService T) {        this.service = new ServiceConfig();        this.service.setInterface(this.interfaceName);        if (this.version != "" && this.version.length() > 0) {            this.service.setVersion(this.version);        }        if (this.timeout.toString() != "" && this.timeout.toString().length() > 0) {            this.service.setTimeout(this.timeout);        }        this.service.setRef(T);        this.service.unexport();    }}