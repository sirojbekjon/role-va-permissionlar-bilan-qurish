package milliytalim.appnewssite.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import milliytalim.appnewssite.entity.enums.Huquq;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LavozimDto {

    @NotBlank
    private String name;

    private String description;

    @NotEmpty
    private List<Huquq> huquqList;
}
