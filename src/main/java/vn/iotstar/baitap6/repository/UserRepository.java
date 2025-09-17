package vn.iotstar.baitap6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.baitap6.entity.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    List<User> findByUsernameContaining(String username);
    List<User> findByEmailContaining(String email);
    List<User> findByPhoneContaining(String phone);
}
