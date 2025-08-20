package com.excursao.marcinho.repository;

import com.excursao.marcinho.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    boolean existsByHotel(String hotel);
}
