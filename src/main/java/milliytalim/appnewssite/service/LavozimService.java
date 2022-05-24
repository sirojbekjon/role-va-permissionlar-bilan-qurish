package milliytalim.appnewssite.service;

import milliytalim.appnewssite.entity.Lavozim;
import milliytalim.appnewssite.payload.ApiResponse;
import milliytalim.appnewssite.payload.LavozimDto;
import milliytalim.appnewssite.repository.LavozimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LavozimService {

    @Autowired
    LavozimRepository lavozimRepository;

    public ApiResponse addLavozim(LavozimDto lavozimDto){

         if (lavozimRepository.existsByName(lavozimDto.getName())){
             return new ApiResponse("Bunday lavozim mavjud",false);
         }
         Lavozim lavozim = new Lavozim(
                 lavozimDto.getName(),
                 lavozimDto.getHuquqList(),
                 lavozimDto.getDescription());
         lavozimRepository.save(lavozim);
         return new ApiResponse("Lavozim yaratildi",true);

    }

}
