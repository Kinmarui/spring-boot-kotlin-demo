package com.rsqtechnologies.health.doctor.form

import hello.form.Form
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FormController : FormApi {

    companion object {
        val API = FormApi.Companion
    }

    override fun getFormTemplate(@PathVariable(value = API.FORM_TEMPLATE_ID) form: Form): Form {
        return form
    }
}
