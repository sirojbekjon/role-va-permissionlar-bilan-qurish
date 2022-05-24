package milliytalim.appnewssite.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import milliytalim.appnewssite.entity.enums.Huquq;
import milliytalim.appnewssite.entity.template.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lavozim extends AbstractEntity{

    @Column(unique = true,nullable = false)
    private String name; //ADMIN USER YOKI BOSHQALAR BOLISHI MUMKIN

    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Huquq> huquqList;

    @Column(length = 500)
    private String description;


}
