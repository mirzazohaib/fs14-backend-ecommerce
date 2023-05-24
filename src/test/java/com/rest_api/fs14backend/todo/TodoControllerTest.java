package com.rest_api.fs14backend.todo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

  @Autowired
  MockMvc mvc;

  @Test
  @WithMockUser(username = "yazan", roles = {"ADMIN"})
  void hello() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.get("api/v1/todos/hello?name=Hai"); // Arrange

    MvcResult results = mvc.perform(request).andReturn();

    assertEquals("Hello, Hai", results.getResponse().getContentAsString());

  }


}