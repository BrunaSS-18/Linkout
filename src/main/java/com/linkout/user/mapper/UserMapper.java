package com.linkout.user.mapper;

import com.linkout.user.dtos.UserResponse;
import com.linkout.user.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<UserResponse> toResponseList(List<User> users);

    UserResponse toResponse(User user);
}
