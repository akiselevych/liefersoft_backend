package org.liefersoft.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.liefersoft.backend.service.user.UserService;
import org.liefersoft.backend.transfer.dto.UserRegistrationReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/users")
public class UserRestController {
  private final UserService userService;

  @PostMapping
  public ResponseEntity<?> register(@RequestBody @Valid UserRegistrationReqDto userDto){
    return ResponseEntity.status(201).body(userService.register(userDto));
  }
}
