package milliytalim.appnewssite.service;

import milliytalim.appnewssite.entity.Lavozim;
import milliytalim.appnewssite.entity.User;
import milliytalim.appnewssite.exception.ResourceNotFoundException;
import milliytalim.appnewssite.payload.ApiResponse;
import milliytalim.appnewssite.payload.RegisterDto;
import milliytalim.appnewssite.repository.LavozimRepository;
import milliytalim.appnewssite.repository.UserRepository;
import milliytalim.appnewssite.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LavozimRepository lavozimRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public ApiResponse registerUser(RegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getPassword())){
            return new ApiResponse("parollar mos emas",false);
        }
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ApiResponse("Bunday userName avval ro'yxatdan o'tgan", false);
        }


        User user = new User(
                registerDto.getFullName(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                lavozimRepository.findByName(AppConstants.USER).orElseThrow(()->new ResourceNotFoundException("lavozim","name",AppConstants.USER)),
                true
        );
        userRepository.save(user);
        return new ApiResponse("Muvaffaqqiyatli ro'yxatdan o'tdingiz",true);
    }

    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));


    }
}
