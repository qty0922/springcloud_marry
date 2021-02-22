/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: CustomHealthIndicator
 * Author:   15065
 * Date:     2021/2/22 10:39
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.utils;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 〈扩展健康检查的端点来模拟异常情况〉<br>
 * 〈定义一个扩展端点，将状态设置为 DOWN〉
 *
 * @author 15065
 * @create 2021/2/22
 * @since 1.0.0
 */
@Component //代表了一个组件
public class CustomHealthIndicator extends AbstractHealthIndicator{

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //扩展好后我们访问 /actuator/health 可以看到当前的状态是 DOWN
        //修改服务的上下线状态
        //设置为：down状态
//        builder.down().withDetail("status", false);
        //默认或以下设置：up状态
//        builder.up().withDetail("status",false);
    }
}
