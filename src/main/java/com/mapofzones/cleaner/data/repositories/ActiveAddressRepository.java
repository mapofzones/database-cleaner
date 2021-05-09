package com.mapofzones.cleaner.data.repositories;

import com.mapofzones.cleaner.data.entities.ActiveAddress;
import com.mapofzones.cleaner.data.entities.ActiveAddressKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ActiveAddressRepository extends JpaRepository<ActiveAddress, ActiveAddressKey> {
    @Transactional
    @Modifying
    List<ActiveAddress> deleteByHourBefore(Timestamp expiryDate);
}
