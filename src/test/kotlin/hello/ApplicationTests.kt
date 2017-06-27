package hello

import com.rsqtechnologies.health.doctor.form.FormController
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun findAll() {
        val content = """[{"firstName":"Jack","lastName":"Bauer","id":1},{"firstName":"Chloe","lastName":"O'Brian","id":2},{"firstName":"Kim","lastName":"Bauer","id":3},{"firstName":"David","lastName":"Palmer","id":4},{"firstName":"Michelle","lastName":"Dessler","id":5}]"""
        assertEquals(content, restTemplate.getForEntity("/", String::class.java).body)
    }
    @Test
    fun form_get_correct() {
        assertEquals(HttpStatus.OK, restTemplate.getForEntity(FormController.API.FORM_TEMPLATE_ID_PATH, String::class.java, "1"))
    }
}
