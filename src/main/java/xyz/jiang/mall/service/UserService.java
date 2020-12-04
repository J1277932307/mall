package xyz.jiang.mall.service;

import xyz.jiang.mall.exception.MallException;
import xyz.jiang.mall.model.pojo.User;

public interface UserService {
    public User getUser();

    void register(String userName, String password) throws MallException;

    User login(String userName, String password) throws MallException;

    void updateInformation(User user) throws MallException;

    boolean checkAdminRole(User user);
}
