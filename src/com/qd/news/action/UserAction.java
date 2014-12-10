package com.qd.news.action;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ModelDriven;
import com.qd.news.dto.UserDto;
import com.qd.news.model.User;
import com.qd.news.service.impl.UserServiceImpl;
import com.qd.news.template.ActionTemplate;
import com.qd.news.util.Container;
import com.qd.news.util.MD5Code;

@SuppressWarnings("serial")
@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionTemplate implements ModelDriven<User> {
    private UserDto userDto;
    private User user = new User();
    private UserServiceImpl userServiceImpl;
    private MD5Code md5Code;

    public MD5Code getMd5Code() {
        return md5Code;
    }

    @Resource
    public void setMd5Code(MD5Code md5Code) {
        this.md5Code = md5Code;
    }

    public UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }

    @Resource(name = "userServiceImpl")
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public String save() {
        this.userServiceImpl.save(user);
        this.getResult().put("message", "用户保存成功!!!!");
        return SUCCESS;
    }

    public String register() {
        System.out.println(userDto.getUser());
        if (!userDto.getUser().getPassword().trim()
                .equals(userDto.getRepassword().trim())) {
            this.getResult().put("message", "密码不一致!!!!");
            return SUCCESS;
        }
        if (this.userServiceImpl.isExists(userDto.getUser())) {
            this.getResult().put("message", "该用户已经存在!!!!");
            return SUCCESS;
        } else {
            this.userServiceImpl.save(userDto.getUser());
            this.getResult().put("message", "用户注册成功!!!!");
            return SUCCESS;
        }
    }

    public String delete() {
        this.userServiceImpl.delete(keyId, User.class);
        this.getResult().put("message", "用户删除成功!!!!");
        return SUCCESS;
    }

    public String update() {
        this.userServiceImpl.update(keyId, user, User.class);
        this.getResult().put("message", "用户更新成功!!!!");
        return SUCCESS;
    }

    public String findListByPage() {
        Container<User> container = this.getPageSpliter().getListByPage(
                User.class, page, rows, null, null);
        this.getResult().put(ROWS, container.getDataContainer());
        this.getResult().put(TOTAL, container.getTotal());
        return SUCCESS;
    }

    public User getModel() {
        return user;
    }
}
