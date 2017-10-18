package com.hxqh.eam.redis;

//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;

/**
 * Created by lh on 2017/4/21.
 */
public class JedisAPI {

//    private static JedisPool pool;
//    private static Properties properties = null;
//
//    static {
//        InputStream inputStream = JedisAPI.class.getClassLoader().getResourceAsStream("redis.config");
//        properties = new Properties();
//        try {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//
//        jedisPoolConfig.setMaxTotal(Integer.valueOf(properties.getProperty("MAX_TOTAL")));
//        jedisPoolConfig.setMaxIdle(Integer.valueOf(properties.getProperty("MAX_IDLE")));
//        jedisPoolConfig.setMaxWaitMillis(Integer.valueOf(properties.getProperty("MAX_WAIT_MILLIS")));
//        jedisPoolConfig.setTestOnBorrow(Boolean.valueOf(properties.getProperty("TEST_ON_BORROW")));
//        jedisPoolConfig.setTestOnReturn(Boolean.valueOf(properties.getProperty("TEST_ON_RETURN")));
//        jedisPoolConfig.setTestWhileIdle(Boolean.valueOf(properties.getProperty("TEST_WHILE_IDES")));
//
//        pool = new JedisPool(jedisPoolConfig, properties.getProperty("ADDR_ARRAY"), Integer.valueOf(properties.getProperty("PORT")), 10000);
//
//    }
//
//    public static void returnResource(JedisPool pool, Jedis redis) {
//        if (redis != null)
//            pool.returnResource(redis);
//    }
//
//    /**
//     * get
//     *
//     * @param key
//     * @return
//     */
//    public static String get(String key) {
//        Jedis jedis = null;
//        String value = null;
//
//        try {
//            jedis = pool.getResource();
//            value = jedis.get(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            returnResource(pool, jedis);
//        }
//        return value;
//    }
//
//
//    /**
//     * set
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public static String set(String key, String value) {
//        Jedis jedis = null;
//
//        try {
//            jedis = pool.getResource();
//            return jedis.set(key, value);
//        } catch (Exception e) {
//            return "0";
//        } finally {
//            returnResource(pool, jedis);
//        }
//    }
//
//    /**
//     * @param key
//     * @param strings
//     * @return
//     */
//    public static long lpush(String key, String[] strings) {
//        Jedis jedis = null;
//
//        try {
//            jedis = pool.getResource();
//            return jedis.lpush(key, strings);
//        } catch (Exception e) {
//            return 0L;
//        } finally {
//            returnResource(pool, jedis);
//        }
//    }
//
//    /**
//     * lpush
//     *
//     * @param key
//     * @return
//     */
//    public static List<String> lrange(String key) {
//        Jedis jedis = null;
//        try {
//            jedis = pool.getResource();
//            return jedis.lrange(key, 0, -1);
//        } catch (Exception e) {
//            return null;
//        } finally {
//            returnResource(pool, jedis);
//        }
//    }
//
//
//    public static String hmset(String key, Map map) {
//        Jedis jedis = null;
//        try {
//            jedis = pool.getResource();
//            return jedis.hmset(key, map);
//        } catch (Exception e) {
//            return "0";
//        } finally {
//            returnResource(pool, jedis);
//        }
//    }
//
//
//    public static List<String> hmget(String key, String... strings) {
//        Jedis jedis = null;
//        try {
//            jedis = pool.getResource();
//            return jedis.hmget(key, strings);
//        } catch (Exception e) {
//            return null;
//        } finally {
//            returnResource(pool, jedis);
//        }
//    }
//
//
//    /**
//     * 删除
//     * @param key
//     * @return
//     */
//    public static Long hdel(String key) {
//        Jedis jedis = null;
//        try {
//            jedis = pool.getResource();
//            return jedis.hdel(key);
//        } catch (Exception e) {
//            return null;
//        } finally {
//            returnResource(pool, jedis);
//        }
//    }
//
//
//    public static boolean exist(String key) {
//        Jedis jedis = null;
//        try {
//            jedis = pool.getResource();
//            return jedis.exists(key);
//        } catch (Exception e) {
//
//        } finally {
//            returnResource(pool, jedis);
//        }
//        return false;
//    }

}
