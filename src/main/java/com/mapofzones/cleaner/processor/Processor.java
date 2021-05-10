package com.mapofzones.cleaner.processor;

import com.mapofzones.cleaner.data.constants.DateConstants;
import com.mapofzones.cleaner.data.entities.ActiveAddress;
import com.mapofzones.cleaner.data.entities.TransactionStatistics;
import com.mapofzones.cleaner.data.entities.TransferStatistics;
import com.mapofzones.cleaner.data.repositories.ActiveAddressRepository;
import com.mapofzones.cleaner.data.repositories.TransactionStatisticsRepository;
import com.mapofzones.cleaner.data.repositories.TransferStatisticsRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class Processor {
    private final ActiveAddressRepository activeAddressRepository;
    private final TransactionStatisticsRepository transactionStatisticsRepository;
    private final TransferStatisticsRepository transferStatisticsRepository;

    public Processor(ActiveAddressRepository activeAddressRepository,
                     TransactionStatisticsRepository transactionStatisticsRepository,
                     TransferStatisticsRepository transferStatisticsRepository) {
        this.activeAddressRepository = activeAddressRepository;
        this.transactionStatisticsRepository = transactionStatisticsRepository;
        this.transferStatisticsRepository = transferStatisticsRepository;
    }

    public void doScript() {
        System.out.println("Starting...");

        System.out.println("ready to cleanup database");
        Timestamp twoMonthAgo = new Timestamp(System.currentTimeMillis() - DateConstants.TWO_MONTH);
        List<ActiveAddress> activeAddresses = activeAddressRepository.deleteByHourBefore(twoMonthAgo);
        System.out.println("active addresses: " + activeAddresses);
        List<TransactionStatistics> transactionStatistics = transactionStatisticsRepository.deleteByHourBefore(twoMonthAgo);
        System.out.println("transaction statistics: " + transactionStatistics);
        List<TransferStatistics> transferStatistics = transferStatisticsRepository.deleteByHourBefore(twoMonthAgo);
        System.out.println("transfer statistics: " + transferStatistics);
        System.out.println("Finished!");
        System.out.println("---------------");
    }
}
