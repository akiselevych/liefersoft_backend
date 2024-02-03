package org.liefersoft.backend.service.user;

import org.liefersoft.backend.domain.User;
import org.liefersoft.backend.transfer.dto.UserRegistrationReqDto;
import org.liefersoft.backend.transfer.dto.UserRegistrationRespDto;

public interface UserService {
  UserRegistrationRespDto register(UserRegistrationReqDto userRegistrationReqDto);
}
