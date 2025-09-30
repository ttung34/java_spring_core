package vn.hoidanit.laptopshop.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.Role;


public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);

}
