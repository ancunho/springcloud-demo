package com.example.demo.user.service.impl;

import com.example.demo.user.dto.UserDto;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public Page<User> getPage(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User load(Long id) {
        return this.userRepository.findById(id).orElse(new User());
    }

    @Override
    @Transactional
    public User save(UserDto userDto) {
        User user = this.userRepository.findById(userDto.getId()).orElse(new User());
        if (user ==  null) {
            user = new User();
        }

        user.setNickname(userDto.getNickname());
        user.setAvatar(userDto.getAvatar());
        return this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
