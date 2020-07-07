package com.clfeng.controller;


import com.clfeng.entity.City;
import com.clfeng.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clfeng
 * @since 2020-07-07
 */
@RestController
@RequestMapping("/")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "city/{id}",method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

    @RequestMapping(value = "city",method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "city",method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "city/{id}",method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }

}

