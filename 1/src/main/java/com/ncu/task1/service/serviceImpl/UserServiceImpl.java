package com.ncu.task1.service.serviceImpl;

import com.google.common.collect.Lists;
import com.ncu.task1.bean.MD5;
import com.ncu.task1.dto.UserListDto;
import com.ncu.task1.dto.UserSimDto;
import com.ncu.task1.entity.UserEntity;
import com.ncu.task1.exception.DataCheckException;
import com.ncu.task1.exception.ExistException;
import com.ncu.task1.exception.UnauthorizedException;
import com.ncu.task1.param.LoginParam;
import com.ncu.task1.param.PageParam;
import com.ncu.task1.param.RegisterParam;
import com.ncu.task1.param.UpdateParam;
import com.ncu.task1.repositoty.UserRepository;
import com.ncu.task1.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 周佳玲
 * @date 2019-07-13 12:33
 */
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * 用户注册
     * @param registerParam
     * @throws Exception
     */
    public void addUser(RegisterParam registerParam) throws Exception{
        if (userRepository.countByUsername(registerParam.getUsername())>0){
            throw new ExistException("用户名已使用！");
        }
        if (userRepository.countByTelephone(registerParam.getTelephone())>0){
            throw new ExistException("电话号码已被注册");
        }
        if (userRepository.countByEmail(registerParam.getEmail())>0){
            throw new ExistException("电子邮箱已被注册");
        }
        UserEntity userEntity = UserEntity.builder().username(registerParam.getUsername())
                .password(MD5.md5(registerParam.getUsername(),registerParam.getPassword())).gender(registerParam.getGender())
                .telephone(registerParam.getTelephone()).email(registerParam.getEmail())
                .role("普通用户").introduce(registerParam.getIntroduce())
                .registTime(LocalDateTime.now()).build();
        userRepository.save(userEntity);
    }

    /**
     * 用户登陆
     * @param loginParam
     * @return
     * @throws Exception
     */
    public UserEntity login(LoginParam loginParam) throws Exception{
        UserEntity userEntity = userRepository.findByUsernameOrTelephone(loginParam.getAccount());
        if (userEntity == null){
            throw new ExistException("用户不存在");
        }

        //验证
        boolean checked = MD5.vertify(loginParam.getPassword(),userEntity.getUsername(),userEntity.getPassword());

        if (checked){
            return userEntity;
        }
        else {
            throw new UnauthorizedException("账号或密码错误");
        }
    }

    /**
     * 分页显示用户
     * @param pageParam
     * @return
     */
    public UserListDto listUser(PageParam pageParam){
        PageRequest pageRequest = PageRequest.of(pageParam.getPageNum()-1,pageParam.getPageLimit());
        Page<UserEntity> userEntityPage = userRepository.findAll(pageRequest);
        List<UserSimDto> userSimDto = Lists.newArrayListWithCapacity(userEntityPage.getSize());

        userEntityPage.stream().forEach(x->{
            userSimDto.add(UserSimDto.builder()
            .id(x.getId()).username(x.getUsername())
                    .build()
            );
        });

        UserListDto userListDto = UserListDto.builder()
                .list(userSimDto)
                .build();
        return userListDto;

    }

    /**
     * 根据id删除用户
     * @param id
     * @throws Exception
     */
    public void delUser(int id) throws Exception{
        userRepository.deleteById(id);
    }

    public void updateUser(UpdateParam updateParam) throws Exception{
        UserEntity userEntity = userRepository.findByUsername(updateParam.getUsername());

        //md5验证
        String oldmd5 = MD5.md5(userEntity.getUsername(),updateParam.getOldPassword());
        String newmd5 = MD5.md5(userEntity.getUsername(),updateParam.getNewPassword());

        if (oldmd5 != newmd5){
            throw new DataCheckException("旧密码错误");
        }

        userRepository.modifiedPassword(updateParam.getUsername(),updateParam.getOldPassword(),
                updateParam.getNewPassword(),updateParam.getGender(),updateParam.getTelephone());

    }

}
