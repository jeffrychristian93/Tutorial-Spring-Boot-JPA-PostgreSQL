package com.programmingdarinol.app.service;

import com.programmingdarinol.app.dto.MerchantDTO;
import com.programmingdarinol.app.model.Merchant;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MerchantService {

  Merchant create(Merchant merchant);
  Merchant update(Long id, Merchant merchant);
  Boolean delete(Long id);
  List<Merchant> findAll();

  Page<Merchant> findAll(Pageable pageable);

  Merchant findById(Long id);

  MerchantDTO mapToDto(Merchant merchant);
  Merchant mapToEntity(MerchantDTO merchantDTO);
}
