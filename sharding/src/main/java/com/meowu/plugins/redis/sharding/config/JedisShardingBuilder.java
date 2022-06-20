package com.meowu.plugins.redis.sharding.config;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.JedisSharding;

import java.util.List;

public class JedisShardingBuilder{

    private List<String> shardsString;

    private List<HostAndPort> shards;
    private JedisClientConfig config;

    public JedisShardingBuilder(){

    }

    public JedisSharding builder(){
        if(CollectionUtils.isEmpty(shards)){
            defaultShards();
        }

        return new JedisSharding(this.shards, this.config);
    }

    private void defaultShards(){
        shards = Lists.newArrayList(new HostAndPort("localhost", 6379));
    }

    private void defaultConfig(){
        config = DefaultJedisClientConfig.builder()
                                         .build();
    }
}
