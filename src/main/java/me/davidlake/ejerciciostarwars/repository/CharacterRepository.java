package me.davidlake.ejerciciostarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.davidlake.ejerciciostarwars.entity.Character;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {
    private static final String filename = "static/starwars.json";
    private List<Character> characterList = new ArrayList<>();
    private final ObjectMapper objectMapper;

    public CharacterRepository(
            ObjectMapper objectMapper
    ) {
        this.objectMapper = objectMapper;
        loadCharacterList();
    }

    public List<Character> searchByName(String name) {
        return characterList
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    private void loadCharacterList() {
        try {
            characterList = objectMapper.readValue(
                    new ClassPathResource(filename).getFile(),
                    new TypeReference<>() {}
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
