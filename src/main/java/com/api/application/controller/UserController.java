package com.api.application.controller;

import com.api.application.domain.dto.UserDto;
import com.api.application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/users")
public record UserController(UserService userService) {

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        var users = userService.findAll();
        var usersDto = users.stream().map(UserDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        var user = userService.create(userDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(new UserDto(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        var user = userService.update(id, userDto.toModel());
        return ResponseEntity.ok(new UserDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
