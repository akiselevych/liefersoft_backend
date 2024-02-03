package org.liefersoft.backend.transfer.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.liefersoft.backend.domain.Gender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationReqDto {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotNull
  private Long phone;

  @NotNull
  private Gender gender;

}
