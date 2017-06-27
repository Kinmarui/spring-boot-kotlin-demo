package hello.form

import org.springframework.data.jpa.repository.JpaRepository

interface FormRepository : JpaRepository<Form, Int>