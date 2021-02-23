/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MyHystrixCommand1
 * Author:   15065
 * Date:     2021/2/23 17:35
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/23
 * @since 1.0.0
 */
public class MyHystrixCommand1 extends HystrixCommand<String> {

    private final String name;
    public MyHystrixCommand1(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        this.name = name;
    }

    /**
     * 把创建对象时传进来的 name 参数作为缓存的 key
     * @return
     */
    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }

    @Override
    protected String run() throws Exception {
        System.err.println("get data");
        return this.name + ":" + Thread.currentThread().getName();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String result = new MyHystrixCommand1("qty").execute();
        System.out.println(result);
        Future<String> future = new MyHystrixCommand1("qty").queue();
        System.out.println(future.get());
        context.shutdown();

        //结果：可以看到只输出了一次 get data，缓存生效。
        /*get data
        qty:hystrix-MyGroup-1
        qty:hystrix-MyGroup-1*/
    }
}
