package com.mapofzones.cleaner.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(ActiveAddressKey.class)
@Table(name = "test_active_addresses", schema = "public")
public class ActiveAddress {
    @Id
    @Column(name = "address")
    @NonNull
    private String address;

    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "hour")
    @NonNull
    private Timestamp hour;

    @Id
    @Column(name = "period")
    @NonNull
    private Integer period;

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getZone() {
        return zone;
    }

    public void setZone(@NonNull String zone) {
        this.zone = zone;
    }

    @NonNull
    public Timestamp getHour() {
        return hour;
    }

    public void setHour(@NonNull Timestamp hour) {
        this.hour = hour;
    }

    @NonNull
    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(@NonNull Integer period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveAddress that = (ActiveAddress) o;
        return address.equals(that.address) && zone.equals(that.zone) && hour.equals(that.hour) && period.equals(that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, zone, hour, period);
    }

    @Override
    public String toString() {
        return "ActiveAddresses{" +
                "address='" + address + '\'' +
                ", zone='" + zone + '\'' +
                ", hour=" + hour +
                ", period=" + period +
                '}';
    }
}
