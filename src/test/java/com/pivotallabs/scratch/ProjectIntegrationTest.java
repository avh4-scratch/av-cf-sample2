package com.pivotallabs.scratch;

import com.pivotallabs.scratch.model.Project;
import com.pivotallabs.scratch.model.ProjectRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class ProjectIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {
    private MockMvc mockMvc;
    @Inject private WebApplicationContext wac;
//    @Inject private JdbcTemplate template;
    @Inject ProjectRepository projectRepository;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    @Ignore
    public void shouldHaveAListOfProjects() throws Exception {
        mockMvc.perform(get("/projects"))
                .andDo(print())
                .andExpect(status().isOk())
//            .andExpect(xpath())
                .andExpect(MockMvcResultMatchers.content().string("Aaron"));
    }

    @Test
    public void creatingAProject_shouldCreateTheProject() throws Exception {
        mockMvc.perform(post("/projects")
                .param("name", "BusinessTime Android"))
                .andExpect(status().isCreated());
//        projectRepository.save(new Project("id", "blarg"));

        assertThat(countRowsInTable("PROJECT")).isEqualTo(1);
    }
}
