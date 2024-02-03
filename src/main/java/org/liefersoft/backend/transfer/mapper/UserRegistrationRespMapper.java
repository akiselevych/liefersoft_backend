package org.liefersoft.backend.transfer.mapper;

import org.liefersoft.backend.domain.User;
import org.liefersoft.backend.transfer.dto.UserRegistrationReqDto;
import org.liefersoft.backend.transfer.dto.UserRegistrationRespDto;
import org.springframework.stereotype.Service;


@Service
public class UserRegistrationRespMapper extends DtoMapperFacade<User, UserRegistrationRespDto> {
  public UserRegistrationRespMapper() {
    super(User.class, UserRegistrationRespDto.class);;
  }

}
