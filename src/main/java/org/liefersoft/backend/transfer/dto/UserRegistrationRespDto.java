package org.liefersoft.backend.transfer.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.liefersoft.backend.domain.Gender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRespDto {
  private Long id;

  private String firstName;

  private String lastName;

  private Long phone;

  private Gender gender;
}
