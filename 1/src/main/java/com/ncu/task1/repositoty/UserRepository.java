package com.ncu.task1.repositoty;

import com.ncu.task1.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 周佳玲
 * @date 2019-07-13 12:29
 */
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    int countByUsername(String username);
    int countByTelephone(String telephone);
    int countByEmail(String email);
    @Query(value = "select * from user where username=?1 or telephone=?1",nativeQuery = true)
    UserEntity findByUsernameOrTelephone(String account);
    Page<UserEntity> findAll (Pageable pageable);


}
