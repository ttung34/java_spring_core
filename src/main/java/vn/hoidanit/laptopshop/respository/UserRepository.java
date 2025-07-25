package vn.hoidanit.laptopshop.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User hoidanthanhtung);

    List<User> findByEmail(String email);

    List<User> findAll();

    User findById(long id);

    void deleteById(long id);
}
