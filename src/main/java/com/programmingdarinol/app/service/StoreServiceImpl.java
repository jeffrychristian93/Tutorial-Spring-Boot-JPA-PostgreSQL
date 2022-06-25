package com.programmingdarinol.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programmingdarinol.app.dto.StoreDTO;
import com.programmingdarinol.app.model.Merchant;
import com.programmingdarinol.app.model.Store;
import com.programmingdarinol.app.repository.StoreRepository;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{

  ObjectMapper mapper = new ObjectMapper();

  @Autowired
  MerchantService merchantService;

  @Autowired
  StoreRepository storeRepository;

  @Override
  public Store addStore(Long merchantId, Store store) {
    final Merchant merchant = merchantService.findById(merchantId);
    if (merchant != null) {
      //add store to db
      store = storeRepository.save(store);
      if (merchant.getStores() != null) {
        List<Store> stores = merchant.getStores();
        stores.add(store);
        merchant.setStores(stores);
      } else {
        merchant.setStores(Collections.singletonList(store));
      }
      merchantService.create(merchant);
      return store;
    }
    return null;
  }

  @Override
  public Store mapToEntity(StoreDTO storeDTO) {
    return mapper.convertValue(storeDTO, Store.class);
  }

  @Override
  public StoreDTO mapToDto(Store store) {
    return mapper.convertValue(store, StoreDTO.class);
  }
}
