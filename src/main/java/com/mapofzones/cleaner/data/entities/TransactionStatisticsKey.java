package com.mapofzones.cleaner.data.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class TransactionStatisticsKey implements Serializable {
    private String zone;
    private Timestamp hour;
    private Integer period;
}
