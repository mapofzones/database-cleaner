package com.mapofzones.cleaner.data.repositories;

import com.mapofzones.cleaner.data.entities.TransactionStatistics;
import com.mapofzones.cleaner.data.entities.TransactionStatisticsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface TransactionStatisticsRepository extends JpaRepository<TransactionStatistics, TransactionStatisticsKey> {
    @Transactional
    @Modifying
    List<TransactionStatistics> deleteByHourBefore(Timestamp expiryDate);
}
