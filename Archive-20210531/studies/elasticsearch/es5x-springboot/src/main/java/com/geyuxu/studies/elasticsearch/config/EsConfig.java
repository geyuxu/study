package com.geyuxu.studies.elasticsearch.config;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class EsConfig implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {
    @Value("${elasticsearch.clusternodes}")
    private String clusterNodes ;

    @Value("${elasticsearch.clustername}")
    private String clusterName;

    private TransportClient client;

    @Override
    public void destroy() throws Exception {
        try {
            if (client != null) {
                client.close();
            }
        } catch (final Exception e) {
        }
    }

    @Override
    public TransportClient getObject() throws Exception {
        return client;
    }

    @Override
    public Class<TransportClient> getObjectType() {
        return TransportClient.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        buildClient();
    }

    protected void buildClient()  {
        try {
            PreBuiltTransportClient  preBuiltTransportClient = new PreBuiltTransportClient(settings());
            if (!"".equals(clusterNodes)){
                for (String nodes:clusterNodes.split(",")) {
                    String InetSocket [] = nodes.split(":");
                    String  Address = InetSocket[0];
                    Integer  port = Integer.valueOf(InetSocket[1]);
                    preBuiltTransportClient.addTransportAddress(new
                            InetSocketTransportAddress(InetAddress.getByName(Address),port ));
                }
                client = preBuiltTransportClient;
            }
        } catch (UnknownHostException e) {
        }
    }
    /**
     * 初始化默认的client
     */
    private Settings settings(){
        Settings settings = Settings.builder()
                .put("cluster.name",clusterName)
                .put("client.transport.sniff",true).build();
        client = new PreBuiltTransportClient(settings);
        return settings;
    }

}