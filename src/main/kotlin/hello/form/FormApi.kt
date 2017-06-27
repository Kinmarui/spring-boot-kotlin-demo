package com.rsqtechnologies.health.doctor.form

import hello.form.Form
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

interface FormApi {

    companion object {
        // @formatter:off
        const val FORM_TEMPLATE_ID = "formTemplateId"

        const val FORM_TEMPLATE_PATH             = "/d/formTemplate"
        const val FORM_TEMPLATE_ID_PATH          = "$FORM_TEMPLATE_PATH/{$FORM_TEMPLATE_ID}"
        // @formatter:on
    }

    @ResponseBody
    @RequestMapping(value = FORM_TEMPLATE_ID_PATH, method = arrayOf(RequestMethod.GET))
    fun getFormTemplate(@PathVariable(value = FORM_TEMPLATE_ID) form: Form): Form
}

