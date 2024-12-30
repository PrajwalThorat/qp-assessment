package com.groceryapp.qp_assessment.service;


import com.groceryapp.qp_assessment.model.User;
import com.groceryapp.qp_assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(long userId) {
        userRepository.deleteById(userId);
        return "User Deleted";
    }

}
