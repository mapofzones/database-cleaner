package com.mapofzones.cleaner.data.repositories;

import com.mapofzones.cleaner.data.entities.TransferStatistics;
import com.mapofzones.cleaner.data.entities.TransferStatisticsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface TransferStatisticsRepository extends JpaRepository<TransferStatistics, TransferStatisticsKey> {
    @Transactional
    @Modifying
    List<TransferStatistics> deleteByHourBefore(Timestamp expiryDate);
}
