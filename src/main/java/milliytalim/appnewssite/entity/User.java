package milliytalim.appnewssite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import milliytalim.appnewssite.entity.enums.Huquq;
import milliytalim.appnewssite.entity.template.AbstractEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends AbstractEntity implements UserDetails  {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lavozim lavozim;

    private boolean enabled;
    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;

    public User(String fullName, String userName, String encode, Lavozim orElseThrow, boolean b) {
        this.fullName = fullName;
        this.username = userName;
        this.password = encode;
        this.lavozim = orElseThrow;
        this.enabled = b;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Huquq> huquqList = this.lavozim.getHuquqList();
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Huquq huquq : huquqList) {
         grantedAuthorities.add(new SimpleGrantedAuthority(huquq.name())); }


//        }     for (Huquq huquq : huquqList) {
//         grantedAuthorities.add(new GrantedAuthority() {
//             @Override
//             public String getAuthority() {
//                 return huquq.name();
//             }
//         });
//        }


        return grantedAuthorities;
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return this.accountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.accountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.credentialNonExpired
//                ;
//    }

}
