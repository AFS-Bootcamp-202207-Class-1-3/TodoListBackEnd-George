package com.example.todolist;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.JpaTodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TodoControllerTest {
    @Autowired
    private MockMvc client;
    @Autowired
    private JpaTodoRepository jpaTodoRepository;

    @BeforeEach
    void cleanDB() {
        jpaTodoRepository.deleteAll();
    }
    @Test
    void should_return_all_todos_when_call_get_all_todos_api() throws Exception {
        //given
        jpaTodoRepository.save(new Todo(1, "first todo", false));
        jpaTodoRepository.save(new Todo(1, "second todo", false));
        jpaTodoRepository.save(new Todo(1, "third todo", false));

        //when & then
        client.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("first todo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].content").value("second todo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].content").value("third todo"));

        //should
        assertThat(jpaTodoRepository.findAll().size(), equalTo(3));
        assertThat(jpaTodoRepository.findAll().get(0).getContent(), equalTo("first todo"));
        assertThat(jpaTodoRepository.findAll().get(1).getContent(), equalTo("second todo"));
        assertThat(jpaTodoRepository.findAll().get(2).getContent(), equalTo("third todo"));
    }
}
