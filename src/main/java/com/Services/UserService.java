package com.Services;

import com.Entities.User;
import com.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    public Long insert(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setRegKey(uuid);
        if (userRepository.insert(user) > 0) {
            mailService.registerMail(user.getEmail(), user.getRegKey());
        }
        return 1l;
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public User findByUsernameAndPass(User user) {

        return userRepository.findByUsernameAndPass(user.getUsername(), user.getPass());
    }

    public User findByUsername(String username) {

        return userRepository.findByUsername(username);

    }

    public Boolean findByKey(String key) {
        User user = userRepository.findByKey(key);
        user.setActive(true);
        if(user!=null){
            user.setActive(true);
            return true;
        }else
            return false;

    }

}
