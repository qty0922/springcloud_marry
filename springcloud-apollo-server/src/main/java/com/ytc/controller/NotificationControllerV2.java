/**
 * @Copyright (C), 2015-2021, XXX有限公司
 * @FileName: NotificationControllerV2
 * @Author: qintianyu
 * @Date: 2021/3/2 10:12
 * @Description:
 * @Version: 1.0
 */
package com.ytc.controller;

import com.ctrip.framework.apollo.core.dto.ApolloConfigNotification;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.ytc.mapper.DeferredResultWrapper;
import com.ytc.mapper.ReleaseMessageListener;
import com.ytc.model.ReleaseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 〈队列存储模拟配置更新〉<br>
 *
 * @author qintianyu
 * @create 2021/3/2
 * @since 1.0.0
 */
@RestController
public class NotificationControllerV2 implements ReleaseMessageListener {

    //模拟配置更新，向其中插入数据表示有更新
    public static Queue<String> queue = new LinkedBlockingDeque<>();

    @GetMapping("/addMsg")
    public String addMsg(){
        queue.add("xxx");
        System.out.println("发："+queue.toString());
        return "success";
    }

    private final Multimap<String, DeferredResultWrapper> deferredResults = Multimaps
            .synchronizedSetMultimap(HashMultimap.create());

    @Override
    public void handleMessage(ReleaseMessage message) {
        System.err.println("handleMessage："+message);
        List<DeferredResultWrapper> results = Lists.newArrayList(deferredResults.get("xxx"));
        for (DeferredResultWrapper deferredResultWrapper:results){
            List<ApolloConfigNotification> list = new ArrayList<>();
            list.add(new ApolloConfigNotification("application",1));
            deferredResultWrapper.setResult(list);
        }
    }

    @GetMapping("/getConfig")
    public DeferredResult<ResponseEntity<List<ApolloConfigNotification>>> getConfig(){
        DeferredResultWrapper deferredResultWrapper = new DeferredResultWrapper();
        List<ApolloConfigNotification> newNotifications = getApolloConfigNotifications();
        if (!newNotifications.isEmpty()){
            deferredResultWrapper.setResult(newNotifications);
        }else{
            deferredResultWrapper.onTimeout(()->{
                System.err.println("onTimeout");
            });

            deferredResultWrapper.onCompletion(() -> {
                System.err.println("onCompletion");
            });
            deferredResults.put("xxxx", deferredResultWrapper);
        }
        System.out.println("结果："+newNotifications.toString());
        return deferredResultWrapper.getResult();
    }

    private List<ApolloConfigNotification> getApolloConfigNotifications() {
        System.out.println("收："+queue.toString());
        List<ApolloConfigNotification> list = new ArrayList<>();
        String result = queue.poll();
        System.out.println("result："+result);
        if (result != null) {
            list.add(new ApolloConfigNotification("application", 1));
        }
        return list;
    }
}
