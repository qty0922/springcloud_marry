/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: HouseClientController
 * Author:   15065
 * Date:     2021/2/23 9:24
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.controller;

import com.ytc.model.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/23
 * @since 1.0.0
 */
@RestController
public class HouseClientController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取数据结果可通过 RestTemplate 的 getForObject 方法（如下代码所示）来实现，此方法有三个重载的实现：
     * url：请求的 API 地址，有两种方式，其中一种是字符串，另一种是 URI 形式。
     * responseType：返回值的类型。
     * uriVariables：PathVariable 参数，有两种方式，其中一种是可变参数，另一种是 Map 形式。
     *
     * public <T> T getForObject(String url, Class<T> responseType,
     *                           Object... uriVariables);
     * public <T> T getForObject(String url, Class<T> responseType,
     *                           Map<String, ?> uriVariables);
     * public <T> T getForObject(URI url, Class<T> responseType);
     *
     * @param name
     * @return
     */
    @GetMapping("/call/data")
    public HouseInfo getData(@RequestParam("name") String name){
        return restTemplate.getForObject("http://springcloud-ribbon:8083/house/data?name="+ name, HouseInfo.class);
    }

    @GetMapping("/call/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return restTemplate.getForObject( "http://springcloud-ribbon:8083/house/data/{name}", String.class, name);
    }


    /**
     * 使用 getForEntity 来获取数据
     * getForEntity 中可以获取返回的状态码、请求头等信息，
     * 通过 getBody 获取响应的内容。其余的和 getForObject 一样，也是有 3 个重载的实现。
     * @param name
     * @return
     */
    @GetMapping("/call/dataEntity")
    public HouseInfo getData3(@RequestParam("name") String name) {
        ResponseEntity<HouseInfo> responseEntity = restTemplate.getForEntity("http://springcloud-ribbon:8083/house/data?name=" + name, HouseInfo.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            return responseEntity.getBody();
        }
        return null;
    }

    /**
     * postForObject 同样有 3 个重载的实现。除了 postForObject 还可以使用 postForEntity 方法
     *
     *
     * public <T> T postForObject(String url, Object request,
     *                            Class<T> responseType, Object... uriVariables);
     *
     * public <T> T postForObject(String url, Object request,
     *                            Class<T> responseType, Map<String, ?> uriVariables);
     *
     * public <T> T postForObject(URI url, Object request, Class<T> responseType);
     * @return
     */
    @GetMapping("/call/save")
    public Long add() {
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setHouseId(123);
        houseInfo.setHouseName("北京—海淀—XX小区");
        Long id = restTemplate.postForObject("http://springcloud-ribbon:8083/house/save", houseInfo, Long.class);
        return id;
    }
}
