package cloudcode.helloworld;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
// import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HelloWorldControllerTests {

	@Autowired
	private MockMvc mvc;

  @Test
  public void getIndex() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/"))
        .andExpect(status().isOk())
				.andExpect(view().name("index"))
        .andExpect(model().attributeExists("service"))
				.andExpect(model().attributeExists("revision"));
  }
}
