package me.davidlake.ejerciciostarwars.controller;

import me.davidlake.ejerciciostarwars.dto.CharacterDTO;
import me.davidlake.ejerciciostarwars.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> searchByName(@PathVariable String name) {
        return ResponseEntity.ok(characterService.searchByName(name));
    }
}
