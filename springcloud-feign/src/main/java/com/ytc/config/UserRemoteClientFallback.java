/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: UserRemoteClientFallback
 * Author:   15065
 * Date:     2021/2/24 10:48
 * Description:
 * History:
 * qty               <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ytc.config;

import com.ytc.model.User;
import com.ytc.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 15065
 * @create 2021/2/24
 * @since 1.0.0
 */
@Component  //把类注入到spring中，交给spring管理
public class UserRemoteClientFallback implements UserService {

    @Override
    public List<User> queryUserList() {
        System.out.println("出现错误！");
        return null;
    }

    @Override
    public void register(User user) {
        System.out.println("出现错误！");
    }
}
