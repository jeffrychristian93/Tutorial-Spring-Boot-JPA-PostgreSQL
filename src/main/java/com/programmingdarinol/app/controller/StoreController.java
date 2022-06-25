package com.programmingdarinol.app.controller;

import com.programmingdarinol.app.dto.StoreDTO;
import com.programmingdarinol.app.model.Store;
import com.programmingdarinol.app.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

  @Autowired
  StoreService storeService;

  @PostMapping("/add/{merchantId}")
  public StoreDTO addStoreToMerchant(@PathVariable Long merchantId, @RequestBody StoreDTO request){
    final Store store = storeService.mapToEntity(request);
    final Store result = storeService.addStore(merchantId, store);
    return storeService.mapToDto(result);
  }
}
