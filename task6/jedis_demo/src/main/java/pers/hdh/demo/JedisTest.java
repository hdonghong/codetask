package pers.hdh.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pers.hdh.utils.FastJsonUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

public class JedisTest {

    private static String host = "192.168.238.128";
    private static int port = 6379;

    @Test
    public void testJedis1() {
        // 创建和redis的连接
        // 参数1：服务端ip
        // 参数2：服务端端口
        Jedis jedis = new Jedis(host, port);

        // 存
        jedis.set("key1", "hello world");
        // 取
        System.out.println(jedis.get("key1"));

        // 关闭
        jedis.close();
    }

    @Test
    public void testJedisPool() {
        // 创建连接池
        JedisPool pool = new JedisPool(host, port);
        // 获取连接
        Jedis jedis = pool.getResource();
        // 存
        jedis.set("key2", "haha");
        // 取
        System.out.println(jedis.get("key2"));
        // 释放连接
        jedis.close();
        // 关闭连接池
        pool.close();
    }

    @Test
    public void testAddList() {
        JedisPool pool = new JedisPool(host, port);
        Jedis jedis = pool.getResource();
        // 存列表
        // 转换成json格式后存入redis中
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        jedis.hset("list", "1", FastJsonUtils.toJSONString(list));
        // 取
        String jsonData = jedis.hget("list", "1");
        System.out.println(jsonData);

        list = FastJsonUtils.jsonToList(jsonData, String.class);
        for (String str : list) {
            System.out.println(str);
        }

    }

}
