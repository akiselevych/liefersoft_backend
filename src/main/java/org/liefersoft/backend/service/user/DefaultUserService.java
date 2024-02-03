package org.liefersoft.backend.service.user;

import lombok.RequiredArgsConstructor;
import org.liefersoft.backend.dao.UserJpaRepository;
import org.liefersoft.backend.domain.User;
import org.liefersoft.backend.transfer.dto.UserRegistrationReqDto;
import org.liefersoft.backend.transfer.dto.UserRegistrationRespDto;
import org.liefersoft.backend.transfer.mapper.UserRegistrationReqMapper;
import org.liefersoft.backend.transfer.mapper.UserRegistrationRespMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService{
  private final UserRegistrationReqMapper userRegistrationReqMapper;
  private final UserRegistrationRespMapper userRegistrationRespMapper;
  private final UserJpaRepository userJpaRepository;

  @Override
  public UserRegistrationRespDto register(UserRegistrationReqDto userRegistrationReqDto) {
   User user =  userJpaRepository.save(userRegistrationReqMapper.convertToEntity(userRegistrationReqDto));

   return userRegistrationRespMapper.convertToDto(user);
  }
}
