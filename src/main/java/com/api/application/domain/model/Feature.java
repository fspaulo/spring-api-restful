package com.api.application.domain.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tb_feat")
public class Feature extends BaseModel {

    private String icon;
    private String description;

}
