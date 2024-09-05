package com.api.application.domain.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tb_feat")
public class Feature extends BaseModel {

    private String icon;
    private String description;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
