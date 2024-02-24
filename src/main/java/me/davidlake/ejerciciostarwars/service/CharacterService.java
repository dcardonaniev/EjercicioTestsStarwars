package me.davidlake.ejerciciostarwars.service;

import me.davidlake.ejerciciostarwars.dto.CharacterDTO;
import me.davidlake.ejerciciostarwars.entity.Character;
import me.davidlake.ejerciciostarwars.exception.NotFoundException;
import me.davidlake.ejerciciostarwars.repository.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final ModelMapper modelMapper;

    public CharacterService(
            CharacterRepository characterRepository,
            ModelMapper modelMapper
    ) {
        this.characterRepository = characterRepository;
        this.modelMapper = modelMapper;
    }

    public List<CharacterDTO> searchByName(String name) {
        List<Character> matched = characterRepository.searchByName(name);
        if (matched.isEmpty())
            throw new NotFoundException("No hay ningún personaje con ese nombre");

        return matched
                .stream()
                .map(character -> modelMapper.map(character, CharacterDTO.class))
                .toList();
    }
}
