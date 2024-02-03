package org.liefersoft.backend.transfer.mapper;

import org.liefersoft.backend.domain.User;
import org.liefersoft.backend.transfer.dto.UserRegistrationReqDto;
import org.springframework.stereotype.Service;


@Service
public class UserRegistrationReqMapper extends DtoMapperFacade<User, UserRegistrationReqDto> {
  public UserRegistrationReqMapper() {
    super(User.class, UserRegistrationReqDto.class);;
  }

}
