package com.programmingdarinol.app.repository;

import com.programmingdarinol.app.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
