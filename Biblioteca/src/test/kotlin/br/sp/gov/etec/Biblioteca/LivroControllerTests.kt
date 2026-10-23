package br.sp.gov.etec.Biblioteca

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class LivroControllerTests(@Autowired val mockMvc: MockMvc) {

    @Test
    fun `POST livros retorna 201 e os dados recebidos`() {
        mockMvc.perform(
            post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{"titulo":"Java para Iniciantes","autor":"Maria Silva","ano":2026}""")
        )
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.titulo").value("Java para Iniciantes"))
            .andExpect(jsonPath("$.autor").value("Maria Silva"))
            .andExpect(jsonPath("$.ano").value(2026))
    }
}
