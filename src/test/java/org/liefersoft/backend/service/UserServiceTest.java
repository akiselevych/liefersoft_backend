package org.liefersoft.backend.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.liefersoft.backend.dao.UserJpaRepository;
import org.liefersoft.backend.domain.Gender;
import org.liefersoft.backend.domain.User;
import org.liefersoft.backend.service.user.DefaultUserService;
import org.liefersoft.backend.service.user.UserService;
import org.liefersoft.backend.transfer.dto.UserRegistrationReqDto;
import org.liefersoft.backend.transfer.dto.UserRegistrationRespDto;
import org.liefersoft.backend.transfer.mapper.UserRegistrationReqMapper;
import org.liefersoft.backend.transfer.mapper.UserRegistrationRespMapper;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
  @Mock
  private UserJpaRepository userJpaRepository;

  @Mock
  private UserRegistrationReqMapper userRegistrationReqMapper;

  @Mock
  private UserRegistrationRespMapper userRegistrationRespMapper;

  @Captor
  private ArgumentCaptor<User> argumentCaptor;

  @InjectMocks
  private DefaultUserService userService;

  @Test
  public void userRegistrationTest() {
    UserRegistrationReqDto userRegistrationReqDto = new UserRegistrationReqDto();
    userRegistrationReqDto.setFirstName("FirstName");
    userRegistrationReqDto.setLastName("LastName");
    userRegistrationReqDto.setGender(Gender.MALE);
    userRegistrationReqDto.setPhone(380999999999L);

    User user = userRegistrationReqMapper.convertToEntity(userRegistrationReqDto);

    UserRegistrationRespDto userRegistrationRespDto = userRegistrationRespMapper.convertToDto(user);

    when(userJpaRepository.save(user)).thenReturn(user);

    UserRegistrationRespDto serviceResponse = userService.register(userRegistrationReqDto);

    assertEquals(userRegistrationRespDto, serviceResponse);
  }

  @Test
  public void userRegistrationCaptorTest() {
    UserRegistrationReqDto userRegistrationReqDto = new UserRegistrationReqDto();
    userRegistrationReqDto.setFirstName("FirstName");
    userRegistrationReqDto.setLastName("LastName");
    userRegistrationReqDto.setGender(Gender.MALE);
    userRegistrationReqDto.setPhone(380999999999L);

    User mappedUser = userRegistrationReqMapper.convertToEntity(userRegistrationReqDto);
    UserRegistrationRespDto mappedResponseUserDto = userRegistrationRespMapper.convertToDto(mappedUser);

    userService.register(userRegistrationReqDto);

    verify(userJpaRepository).save(argumentCaptor.capture());

    User user = argumentCaptor.getValue();

    UserRegistrationRespDto userRegistrationRespDto = userRegistrationRespMapper.convertToDto(user);

    assertEquals(mappedResponseUserDto,userRegistrationRespDto);
  }
}
