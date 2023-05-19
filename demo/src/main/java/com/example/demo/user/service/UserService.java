package com.example.demo.user.service;

import com.example.demo.user.dto.UserDto;
import com.example.demo.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    /**
     * 获取用户分页数据
     * @param pageable
     * @return
     */
    Page<User> getPage(Pageable pageable);

    /**
     * 加载指定的用户信息
     *
     * @param id
     * @return
     */
    User load(Long id);

    /**
     * 保存/更新用户
     * @param userDto
     * @return
     */
    User save(UserDto userDto);

    /**
     * 删除指定用户
     * @param id
     */
    void delete(Long id);

}
