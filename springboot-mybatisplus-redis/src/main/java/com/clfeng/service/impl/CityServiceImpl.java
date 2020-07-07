package com.clfeng.service.impl;

import com.clfeng.entity.City;
import com.clfeng.mapper.CityMapper;
import com.clfeng.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clfeng
 * @since 2020-07-07
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public City findCityById(Long id) {
        return cityMapper.selectById(id);
    }

    @Override
    public int saveCity(City city) {
        return cityMapper.insert(city);
    }

    @Override
    public int updateCity(City city) {
        return cityMapper.updateById(city);
    }

    @Override
    public int deleteCity(Long id) {
        return cityMapper.deleteById(id);
    }
}
