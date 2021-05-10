package com.mapofzones.cleaner.processor;

import com.mapofzones.cleaner.data.constants.DateConstants;
import com.mapofzones.cleaner.data.entities.ActiveAddress;
import com.mapofzones.cleaner.data.entities.TransactionStatistics;
import com.mapofzones.cleaner.data.repositories.ActiveAddressRepository;
import com.mapofzones.cleaner.data.repositories.TransactionStatisticsRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class Processor {
    private final ActiveAddressRepository activeAddressRepository;
    private final TransactionStatisticsRepository transactionStatisticsRepository;

    public Processor(ActiveAddressRepository activeAddressRepository, TransactionStatisticsRepository transactionStatisticsRepository) {
        this.activeAddressRepository = activeAddressRepository;
        this.transactionStatisticsRepository = transactionStatisticsRepository;
    }

    public void doScript() {
        System.out.println("Starting...");

        System.out.println("ready to cleanup database");
        Timestamp twoMonthAgo = new Timestamp(System.currentTimeMillis() - DateConstants.TWO_MONTH);
        List<ActiveAddress> activeAddresses = activeAddressRepository.deleteByHourBefore(twoMonthAgo);
        List<TransactionStatistics> transactionStatistics = transactionStatisticsRepository.deleteByHourBefore(twoMonthAgo);
        System.out.println("Finished!");
        System.out.println("---------------");
    }
}
