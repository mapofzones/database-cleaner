package com.mapofzones.cleaner.processor;

import com.mapofzones.cleaner.data.constants.DateConstants;
import com.mapofzones.cleaner.data.repositories.ActiveAddressRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class Processor {
    private final ActiveAddressRepository activeAddressRepository;

    public Processor(ActiveAddressRepository activeAddressRepository) {
        this.activeAddressRepository = activeAddressRepository;
    }

    public void doScript() {
        System.out.println("Starting...");

        System.out.println("ready to cleanup database");
        Timestamp twoMonthAgo = new Timestamp(System.currentTimeMillis() - DateConstants.TWO_MONTH);
        activeAddressRepository.deleteByHourBefore(twoMonthAgo);
        System.out.println("Finished!");
        System.out.println("---------------");
    }
}
