/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: EurekaStateChangeListener
 * Author:   15065
 * Date:     2021/2/22 10:57
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 〈服务上下线监控〉<br>
 * 〈
     * 目前支持的事件：
     * EurekaInstanceCanceledEvent 服务下线事件。
     * EurekaInstanceRegisteredEvent 服务注册事件。
     * EurekaInstanceRenewedEvent 服务续约事件。
     * EurekaRegistryAvailableEvent Eureka 注册中心启动事件。
     * EurekaServerStartedEvent Eureka Server 启动事件。
 *  〉
 *
 * 基于 Eureka 提供的事件机制，可以监控服务的上下线过程，
 * 在过程发生中可以发送邮件来进行通知。
 * 下面代码只是演示了监控的过程，并未发送邮件。
 *
 * @author 15065
 * @create 2021/2/22
 * @since 1.0.0
 */
//@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务下线 ");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.err.println(instanceInfo.getAppName() + " 进行注册 ");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        System.err.println(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约 ");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        System.err.println(" 注册中心启动 ");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        System.err.println("Eureka Server启动 ");
    }
}
