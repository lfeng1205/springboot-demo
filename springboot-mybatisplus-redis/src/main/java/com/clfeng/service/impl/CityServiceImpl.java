package com.clfeng.service.impl;

import com.clfeng.entity.City;
import com.clfeng.mapper.CityMapper;
import com.clfeng.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author clfeng
 * @since 2020-07-07
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public City findCityById(Long id) {
        //从缓存中取数据
        String key = "city_" + id;

        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        //缓存是否存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            City city = operations.get(key);
            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }

        //从数据库中读取数据
        City city = cityMapper.selectById(id);

        //插入缓存
        operations.set(key, city, 10, TimeUnit.SECONDS);
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
        return city;
    }

    @Override
    public int saveCity(City city) {
        return cityMapper.insert(city);
    }

    @Override
    public int updateCity(City city) {

        // 缓存存在，删除缓存
        String key = "city_" + city.getId();
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }
        int res = cityMapper.updateById(city);
        if (res > 0) {
            //更新缓存
            operations.set(key, city, 10, TimeUnit.SECONDS);
            LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());
        }
        return cityMapper.updateById(city);
    }

    @Override
    public int deleteCity(Long id) {

        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }

        return cityMapper.deleteById(id);
    }
}
