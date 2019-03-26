package self.eli.demo.service.impl;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/1 14:57.
 */
public abstract class BaseRedisServiceImpl<T> {
    @Resource
    protected RedisTemplate<String, Object> redisTemplate;
    @Resource
    protected HashOperations<String, String, T> hashOperations;

    /**
     * 存入redis中的key
     *
     * @return String
     */
    protected abstract String getRedisKey();

    /**
     * 添加
     *
     * @param key    key
     * @param model 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T model, long expire) {
        hashOperations.put(getRedisKey(), key, model);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key) {
        hashOperations.delete(getRedisKey(), key);
    }

    /**
     * 查询
     *
     * @param key 查询的key
     * @return T
     */
    public T get(String key) {
        return hashOperations.get(getRedisKey(), key);
    }

    /**
     * 获取当前redis库下所有对象
     *
     * @return List<T>
     */
    public List<T> getAll() {
        return hashOperations.values(getRedisKey());
    }

    /**
     * 查询查询当前redis库下所有key
     *
     * @return Set<String>
     */
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisKey());
    }

    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return isKeyExists
     */
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisKey(), key);
    }

    /**
     * 查询当前key下缓存数量
     *
     * @return long总数
     */
    public long count() {
        return hashOperations.size(getRedisKey());
    }

    /**
     * 清空redis
     */
    public void empty() {
        Set<String> set = hashOperations.keys(getRedisKey());
        set.forEach(key -> hashOperations.delete(getRedisKey(), key));
    }
}
