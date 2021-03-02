/**
 * @Copyright (C), 2015-2021, XXX有限公司
 * @FileName: ReleaseMessageScanner
 * @Author: qintianyu
 * @Date: 2021/3/2 10:19
 * @Description:
 * @Version: 1.0
 */
package com.ytc.thread;

import com.ytc.controller.NotificationControllerV2;
import com.ytc.model.ReleaseMessage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * InitializingBean接口为bean提供了初始化方法的方式，
 * 它只包括afterPropertiesSet方法，
 * 凡是继承该接口的类，在初始化bean的时候都会执行该方法。
 *
 *
 * @author qintianyu
 * @create 2021/3/2
 * @since 1.0.0
 */
//@Component
public class ReleaseMessageScanner implements InitializingBean {

    @Autowired
    private NotificationControllerV2 configController;

    @Override
    public void afterPropertiesSet() throws Exception {
        //定时任务从数据库扫描没有新的配置发布
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    String result = NotificationControllerV2.queue.poll();
                    if (result!=null){
                        ReleaseMessage message = new ReleaseMessage();
                        message.setMessage(result);
                        configController.handleMessage(message);
                    }
                }
            }
        }).start();
    }
}
