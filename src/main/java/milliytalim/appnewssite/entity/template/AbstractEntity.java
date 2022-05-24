package milliytalim.appnewssite.entity.template;

import lombok.Data;
import milliytalim.appnewssite.entity.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false,nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;


    @JoinColumn(updatable = false) //update qilolmasligi uchun qoyilgan
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;



    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User updatedBy;
}
