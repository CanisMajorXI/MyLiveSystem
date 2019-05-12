package edu.sdust.mylive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration

public class RedisConfig {

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        System.out.println("begin!!!!!!!!!!!!!!!!!!!!!!!!!");
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        //使用fastjson序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(template.getStringSerializer());
        template.setHashValueSerializer(template.getStringSerializer());
        // template.setValueSerializer(fastJsonRedisSerializer);
        // template.setHashValueSerializer(fastJsonRedisSerializer);
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

//    @Bean("springSessionDefaultRedisSerializer")
//    public RedisSerializer<Object> defaultRedisSerializer(){
//        // log.debug("自定义Redis Session序列化加载成功");
//        System.out.println("加载成功");
//        return valueSerializer();
//    }
//
//    private RedisSerializer<Object> valueSerializer() {
//        //return new StringRedisSerializer();
//        return new GenericJackson2JsonRedisSerializer();
//    }

}


