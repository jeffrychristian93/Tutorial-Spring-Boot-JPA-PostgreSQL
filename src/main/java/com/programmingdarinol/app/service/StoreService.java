package com.programmingdarinol.app.service;

import com.programmingdarinol.app.dto.StoreDTO;
import com.programmingdarinol.app.model.Store;

public interface StoreService {

  Store addStore(Long merchantId, Store store);

  Store mapToEntity(StoreDTO storeDTO);
  StoreDTO mapToDto(Store store);
}
