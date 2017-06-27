package hello.form

import org.springframework.data.jpa.repository.JpaRepository

interface FormNodeRepository : JpaRepository<FormNode, Int>