package org.liefersoft.backend.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.liefersoft.backend.domain.Gender;
import org.liefersoft.backend.domain.User;
import org.liefersoft.backend.service.user.UserService;
import org.liefersoft.backend.transfer.dto.UserRegistrationReqDto;
import org.liefersoft.backend.transfer.dto.UserRegistrationRespDto;
import org.liefersoft.backend.transfer.mapper.UserRegistrationReqMapper;
import org.liefersoft.backend.transfer.mapper.UserRegistrationRespMapper;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @MockBean
  private UserRegistrationReqMapper userRegistrationReqMapper;

  @MockBean
  private UserRegistrationRespMapper userRegistrationRespMapper;

  @Test
  public void userRegistrationTest() throws Exception {
    UserRegistrationReqDto userRegistrationReqDto = new UserRegistrationReqDto();
    userRegistrationReqDto.setFirstName("FirstName");
    userRegistrationReqDto.setLastName("LastName");
    userRegistrationReqDto.setGender(Gender.MALE);
    userRegistrationReqDto.setPhone(380999999999L);

    User mappedUser = new User();
    mappedUser.setFirstName("FirstName");
    mappedUser.setLastName("LastName");
    mappedUser.setGender(Gender.MALE);
    mappedUser.setPhone(380999999999L);


    UserRegistrationRespDto mappedResponseUserDto = new UserRegistrationRespDto();
    mappedResponseUserDto.setId(1L);
    mappedResponseUserDto.setFirstName("FirstName");
    mappedResponseUserDto.setLastName("LastName");
    mappedResponseUserDto.setGender(Gender.MALE);
    mappedResponseUserDto.setPhone(380999999999L);


    when(userRegistrationReqMapper.convertToEntity(userRegistrationReqDto)).thenReturn(mappedUser);
    when(userRegistrationRespMapper.convertToDto(mappedUser)).thenReturn(mappedResponseUserDto);
    when(userService.register(any())).thenReturn(mappedResponseUserDto);

    // when I pass userRegistrationReqDto instead of any(), MockHttpServletResponse body is empty string ((
//    when(userService.register(any())).thenReturn(mappedResponseUserDto);


    mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                    .contentType(APPLICATION_JSON)
                    .accept(APPLICATION_JSON)
                    .content(asJsonString(userRegistrationReqDto)))
            .andExpect(status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("FirstName")));
  }

  private String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
