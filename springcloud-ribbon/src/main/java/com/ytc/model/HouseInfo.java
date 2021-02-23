/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: HouseInfo
 * Author:   15065
 * Date:     2021/2/23 9:15
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/23
 * @since 1.0.0
 */
@Data
public class HouseInfo implements Serializable {

    private Integer houseId;

    private String houseName;

    public HouseInfo() {
    }

    public HouseInfo(Integer houseId, String houseName) {
        this.houseId = houseId;
        this.houseName = houseName;
    }
}
