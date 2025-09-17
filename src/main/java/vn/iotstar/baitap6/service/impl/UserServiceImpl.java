package vn.iotstar.baitap6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import vn.iotstar.baitap6.entity.User;
import vn.iotstar.baitap6.repository.UserRepository;
import vn.iotstar.baitap6.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository  userRepository;

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return userRepository.findAll(example);
    }

    @Override
    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        userRepository.deleteById(integer);
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
