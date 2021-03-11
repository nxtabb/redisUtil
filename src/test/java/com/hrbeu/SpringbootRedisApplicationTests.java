package com.hrbeu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrbeu.pojo.User;
import com.hrbeu.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    @Qualifier(value = "myRedisTemplate")
    private RedisTemplate myRedisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        redisUtil.del("user1");


//        //List
//        ListOperations forList = redisTemplate.opsForList();
    }
    @Test
    public void test01() throws JsonProcessingException {
        myRedisTemplate.getConnectionFactory().getConnection().flushDb();
        User user = new User("宁熙桐",23);
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        ValueOperations forValue = myRedisTemplate.opsForValue();
        forValue.set("user1",user);
        Object user1 = forValue.get("user1");
        User user2 = (User) user1;
        System.out.println(user2.getName());

    }

    @Test
    public void test02(){
        Map<Object,Object> map = new HashMap<>();
        map.put("name","宁熙桐");
        map.put("age",20);
        redisUtil.hmset("test2",map);
        Map<Object, Object> test2 = redisUtil.hmget("test2");
        System.out.println(test2);
        redisUtil.hincrby("test2","age",20);

    }

}
