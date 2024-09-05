package com.api.application.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name="tb_card")
public class Card extends BaseModel {

    @Column(unique = true)
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
