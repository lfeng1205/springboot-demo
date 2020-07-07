package com.clfeng.service;

import com.clfeng.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author clfeng
 * @since 2020-07-07
 */
public interface CityService extends IService<City> {

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    City findCityById(Long id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    int saveCity(City city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    int updateCity(City city);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    int deleteCity(Long id);
}
