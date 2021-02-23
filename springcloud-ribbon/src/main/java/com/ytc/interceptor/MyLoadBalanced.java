/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MyLoadBalanced
 * Author:   15065
 * Date:     2021/2/23 14:27
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.interceptor;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * 〈自定义一个负载均衡的注解〉<br>
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/23
 * @since 1.0.0
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier
public @interface MyLoadBalanced {
}

