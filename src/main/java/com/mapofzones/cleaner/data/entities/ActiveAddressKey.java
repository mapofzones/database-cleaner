package com.mapofzones.cleaner.data.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class ActiveAddressKey implements Serializable {
    private String address;
    private String zone;
    private Timestamp hour;
    private Integer period;
}
