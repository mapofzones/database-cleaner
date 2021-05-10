package com.mapofzones.cleaner.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(TransferStatisticsKey.class)
@Table(name = "ibc_transfer_hourly_stats", schema = "public")
public class TransferStatistics {
    @Id
    @Column(name = "zone")
    @NonNull
    private String zone;

    @Id
    @Column(name = "zone_src")
    @NonNull
    private String zoneSource;

    @Id
    @Column(name = "zone_dest")
    @NonNull
    private String zoneDestination;

    @Id
    @Column(name = "hour")
    @NonNull
    private Timestamp hour;

    @Id
    @Column(name = "period")
    @NonNull
    private Integer period;

    @Column(name = "txs_cnt")
    @NonNull
    private Integer transferCount;

    @NonNull
    public String getZone() {
        return zone;
    }

    public void setZone(@NonNull String zone) {
        this.zone = zone;
    }

    @NonNull
    public String getZoneSource() {
        return zoneSource;
    }

    public void setZoneSource(@NonNull String zoneSource) {
        this.zoneSource = zoneSource;
    }

    @NonNull
    public String getZoneDestination() {
        return zoneDestination;
    }

    public void setZoneDestination(@NonNull String zoneDestination) {
        this.zoneDestination = zoneDestination;
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

    @NonNull
    public Integer getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(@NonNull Integer transferCount) {
        this.transferCount = transferCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferStatistics that = (TransferStatistics) o;
        return zone.equals(that.zone) && zoneSource.equals(that.zoneSource) && zoneDestination.equals(that.zoneDestination) && hour.equals(that.hour) && period.equals(that.period) && transferCount.equals(that.transferCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zone, zoneSource, zoneDestination, hour, period, transferCount);
    }

    @Override
    public String toString() {
        return "TransferStatistics{" +
                "zone='" + zone + '\'' +
                ", zoneSource='" + zoneSource + '\'' +
                ", zoneDestination='" + zoneDestination + '\'' +
                ", hour=" + hour +
                ", period=" + period +
                ", transferCount=" + transferCount +
                '}';
    }
}
