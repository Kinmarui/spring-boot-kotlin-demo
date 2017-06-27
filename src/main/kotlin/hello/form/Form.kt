package hello.form

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
class Form(
        val name: String = "",

        @OneToOne(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        val rootNode: FormNode? = null) : BaseEntity(){

        override fun toString(): String {
                return "Form(id=$id, name='$name', rootNode=${rootNode.toString()})"
        }
}

