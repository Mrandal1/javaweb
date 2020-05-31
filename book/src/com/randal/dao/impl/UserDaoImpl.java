package com.randal.dao.impl;

import com.randal.dao.UserDao;
import com.randal.pojo.User;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.dao.impl
 * @data 2020/5/30 16:43
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email`from t_user where username= ? ";
        return queryForOne(sql, User.class, username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values( ? , ? , ? )";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email`from t_user where username= ? and password= ? ";
        return queryForOne(sql, User.class, username, password);
    }
}
