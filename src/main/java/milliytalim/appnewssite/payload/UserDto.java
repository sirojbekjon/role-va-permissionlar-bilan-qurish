package milliytalim.appnewssite.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "fullName  bo'sh bo'lmasin")
    private String fullName;

    @NotNull(message = "username  bo'sh bo'lmasin")
    private String username;

    @NotNull(message = "password  bo'sh bo'lmasin")
    private String password;

    @NotNull(message = "lavozim bosh bo'lmasligi kerak")
    private Integer lavozimId;
}
