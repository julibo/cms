package com.julibo.pig.cms;

import lombok.extern.log4j.Log4j2;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class WebApiTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeClass
    public static void beforeClassTest() {
        System.out.println("before class test");
    }

    @Before
    public void setupMockMvc(){
        System.out.println("before test");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testPing() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/cms/test/ping"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("pong"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testHello() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/cms/test/hello").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("hello pig cms"))
                .andDo(MockMvcResultHandlers.print());
    }

    @After
    public void afterTest() {
        System.out.println("after test");
    }

    @AfterClass
    public static void afterClassTest() {
        System.out.println("after class test");
    }
}
