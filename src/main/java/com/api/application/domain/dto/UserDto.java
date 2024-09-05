package com.api.application.domain.dto;

import com.api.application.domain.model.User;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record UserDto(
        Long id,
        String name,
        AccountDto account,
        CardDto card,
        List<FeatureDto> features) {

    public UserDto(User model) {
        this(
                model.getId(),
                model.getName(),
                ofNullable(model.getAccount()).map(AccountDto::new).orElse(null),
                ofNullable(model.getCard()).map(CardDto::new).orElse(null),
                ofNullable(model.getFeatures()).orElse(emptyList()).stream().map(FeatureDto::new).collect(toList())
        );
    }

    public User toModel() {
        User model = new User();
        model.setId(this.id);
        model.setName(this.name);
        model.setAccount(ofNullable(this.account).map(AccountDto::toModel).orElse(null));
        model.setCard(ofNullable(this.card).map(CardDto::toModel).orElse(null));
        model.setFeatures(ofNullable(this.features).orElse(emptyList()).stream().map(FeatureDto::toModel).collect(toList()));
        return model;
    }

}
