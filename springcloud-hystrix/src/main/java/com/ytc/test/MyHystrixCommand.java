/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MyHystrixCommand
 * Author:   15065
 * Date:     2021/2/23 16:59
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.test;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

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
public class MyHystrixCommand extends HystrixCommand<String> {

    private final String name;
    public MyHystrixCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name+":"+Thread.currentThread().getName();
    }

    /**
     * 重新执行调用代码，可以发现返回的内容是“失败了”，证明已经触发了回退
     * @return
     */
    @Override
    protected String getFallback() {
        return "失败了 ";
    }

    /**
     * 同步调用
     * @param args
     */
    /*public static void main(String[] args) {
        String result = new MyHystrixCommand("qty").execute();
        System.out.println(result);//qty:hystrix-MyGroup-1
    }*/

    /**
     * 异步调用
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<String> future = new MyHystrixCommand("qty").queue();
        System.out.println(future.get());//qty:hystrix-MyGroup-1
    }
}
