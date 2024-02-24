package me.davidlake.ejerciciostarwars.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class CharacterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testSearchByNameOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{name}", "Luke"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name")
                        .value("Luke Skywalker"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].height")
                        .value(172))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mass")
                        .value(77))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender")
                        .value("male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].homeworld")
                        .value("Tatooine"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].species")
                        .value("Human"));
    }

    @Test
    public void testSearchByNameThrowsNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/{name}", "Batman"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound());
    }
}