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

    public ApiResponse editLavozim(Long id, LavozimDto lavozimDto) {

        Optional<Lavozim> optionalLavozim = lavozimRepository.findById(id);
        Lavozim lavozim = optionalLavozim.get();
        lavozim.setName(lavozimDto.getName());
        lavozim.setDescription(lavozimDto.getDescription());
        lavozim.setHuquqList(lavozimDto.getHuquqList());
        lavozimRepository.save(lavozim);
        return new ApiResponse("edited",true);
    }
}
