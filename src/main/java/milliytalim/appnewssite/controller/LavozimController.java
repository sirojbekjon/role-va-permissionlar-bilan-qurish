package milliytalim.appnewssite.controller;


import milliytalim.appnewssite.aop.HuquqniTekshirish;
import milliytalim.appnewssite.payload.ApiResponse;
import milliytalim.appnewssite.payload.LavozimDto;
import milliytalim.appnewssite.payload.UserDto;
import milliytalim.appnewssite.service.LavozimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lavozim")
public class LavozimController {
    @Autowired
    LavozimService lavozimService;


    @PreAuthorize(value = "hasAuthority('ADD_LAVOZIM')")
    @PostMapping
    public HttpEntity<?> addLavozim(@Valid @RequestBody LavozimDto lavozimDto){

        ApiResponse apiResponse = lavozimService.addLavozim(lavozimDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }



//    @PreAuthorize(value = "hasAuthority('EDIT_LAVOZIM')")
    @HuquqniTekshirish(huquq="EDIT_LAVOZIM")
    @PutMapping("/{id}")
    public HttpEntity<?>editLavozim(@PathVariable Long id,@Valid @RequestBody LavozimDto lavozimDto){

        ApiResponse apiResponse = lavozimService.editLavozim(id,lavozimDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
