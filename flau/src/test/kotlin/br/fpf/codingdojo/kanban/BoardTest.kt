package br.fpf.codingdojo.kanban

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view


@RunWith(SpringRunner::class)
@SpringBootTest
class BoardTest {
    val BASE_PATH = "http://localhost:8680/boards"


    var mockMvc = MockMvcBuilders.standaloneSetup(BoardController()).build()

    @Before
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(BoardController()).build()
    }

    @Test
    fun testGet3Boards() {

        //given
        //eu tenho 3 quadros no banco
        val listBoard = listOf(
                Board(id = 1, name = "TPC"),
                Board(id = 2, name = "Nexus"),
                Board(id = 3, name = "BEWS"))
        //when
        //eu fizer um request de get na api
        mockMvc.perform(get("/boards"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andDo(print())

        //then
        //receberei um json com uma lista de 3 quadros
    }

}
