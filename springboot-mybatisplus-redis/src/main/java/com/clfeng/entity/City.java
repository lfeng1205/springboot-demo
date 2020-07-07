package com.clfeng.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author clfeng
 * @since 2020-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class City implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 城市编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 省份编号
     */
    private Integer provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;


}
