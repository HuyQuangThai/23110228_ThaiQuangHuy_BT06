package vn.iotstar.baitap6.service;

import org.springframework.data.domain.Example;
import vn.iotstar.baitap6.entity.User;

import java.util.List;
import java.util.Optional;

public  interface UserService  {

    <S extends User> List<S> findAll(Example<S> example);

    <S extends User> S save(S entity);

    void deleteById(Integer integer);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
