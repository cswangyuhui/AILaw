package com.law.criminal;

import com.law.criminal.web.CriminalSearchController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
public class HelloTest {
    private MockMvc mockMvc;

    @Test
    public void hello(){
        System.out.println("hello world");
    }

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(new CriminalSearchController()).build();
    }

    @Test
    public void getHello() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/param_hello?name=小明")
//                //.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
//                .accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("小明")));
    }

}
