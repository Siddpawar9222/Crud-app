package com.crudapp.crudapplication.service;


import com.crudapp.crudapplication.model.User;
import com.crudapp.crudapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<User> getAllUser(){
        Iterable<User>  allUser = userRepository.findAll();
        Iterator<User> iterator = allUser.iterator();
        List<User> userList = new ArrayList<>();
        while(iterator.hasNext()){
             userList.add(iterator.next());
        }
        return  userList ;
    }

    @Transactional
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void  updateUser(User user){
        User oldUser = getUser(user.getId());
        oldUser.setName(user.getName());
        oldUser.setEducation(user.getEducation());
        oldUser.setSkills(user.getSkills());
        saveUser(oldUser);
    }

    @Transactional
    public User getUser(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
    }


}
