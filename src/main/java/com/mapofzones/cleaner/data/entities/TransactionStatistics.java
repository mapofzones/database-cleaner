package com.mapofzones.cleaner.data.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(TransactionStatisticsKey.class)
@Table(name = "total_tx_hourly_stats", schema = "public")
public class TransactionStatistics {
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

    @Column(name = "txs_cnt")
    @NonNull
    private Integer transactoinCount;

    @Column(name = "txs_w_ibc_xfer_cnt")
    @NonNull
    private Integer transactoinCountWithTransfer;

    @Column(name = "txs_w_ibc_xfer_fail_cnt")
    @NonNull
    private Integer transactoinCountWithFailedTransfer;

    @Column(name = "total_coin_turnover_amount")
    @NonNull
    private BigInteger coinTurnoverAmount;

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

    @NonNull
    public Integer getTransactoinCount() {
        return transactoinCount;
    }

    public void setTransactoinCount(@NonNull Integer transactoinCount) {
        this.transactoinCount = transactoinCount;
    }

    @NonNull
    public Integer getTransactoinCountWithTransfer() {
        return transactoinCountWithTransfer;
    }

    public void setTransactoinCountWithTransfer(@NonNull Integer transactoinCountWithTransfer) {
        this.transactoinCountWithTransfer = transactoinCountWithTransfer;
    }

    @NonNull
    public Integer getTransactoinCountWithFailedTransfer() {
        return transactoinCountWithFailedTransfer;
    }

    public void setTransactoinCountWithFailedTransfer(@NonNull Integer transactoinCountWithFailedTransfer) {
        this.transactoinCountWithFailedTransfer = transactoinCountWithFailedTransfer;
    }

    @NonNull
    public BigInteger getCoinTurnoverAmount() {
        return coinTurnoverAmount;
    }

    public void setCoinTurnoverAmount(@NonNull BigInteger coinTurnoverAmount) {
        this.coinTurnoverAmount = coinTurnoverAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionStatistics that = (TransactionStatistics) o;
        return zone.equals(that.zone) && hour.equals(that.hour) && period.equals(that.period) && transactoinCount.equals(that.transactoinCount) && transactoinCountWithTransfer.equals(that.transactoinCountWithTransfer) && transactoinCountWithFailedTransfer.equals(that.transactoinCountWithFailedTransfer) && coinTurnoverAmount.equals(that.coinTurnoverAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zone, hour, period, transactoinCount, transactoinCountWithTransfer, transactoinCountWithFailedTransfer, coinTurnoverAmount);
    }

    @Override
    public String toString() {
        return "TransactionStatistics{" +
                "zone='" + zone + '\'' +
                ", hour=" + hour +
                ", period=" + period +
                ", transactoinCount=" + transactoinCount +
                ", transactoinCountWithTransfer=" + transactoinCountWithTransfer +
                ", transactoinCountWithFailedTransfer=" + transactoinCountWithFailedTransfer +
                ", coinTurnoverAmount=" + coinTurnoverAmount +
                '}';
    }
}
