package milliytalim.appnewssite.component;

import milliytalim.appnewssite.entity.Lavozim;
import milliytalim.appnewssite.entity.User;
import milliytalim.appnewssite.entity.enums.Huquq;
import milliytalim.appnewssite.repository.LavozimRepository;
import milliytalim.appnewssite.repository.UserRepository;
import milliytalim.appnewssite.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import static milliytalim.appnewssite.entity.enums.Huquq.*;

@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    UserRepository userRepository;

    @Autowired
    LavozimRepository lavozimRepository;



    @Value("${spring.sql.init.mode}")
    private String initialMode;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            Huquq[] huquqs = Huquq.values();


            Lavozim admin = lavozimRepository.save(new Lavozim(
                    AppConstants.ADMIN,
                    Arrays.asList(huquqs),
                    "Sistema egasi"
            ));


            Lavozim user = lavozimRepository.save(new Lavozim(
                    AppConstants.USER,
                    Arrays.asList(ADD_COMMENT, EDIT_COMMENT, DELETE_MY_COMMENT),
                    "oddiy foydalanuvchi"
            ));


            userRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    admin,
                    true,
                    true,
                    true,
                    true
            ));


            userRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode( "user123"),
                    user,
                    true,
                    true,
                    true,
                    true
            ));
        }
    }
}
