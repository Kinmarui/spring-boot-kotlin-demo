package hello.form

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*
import javax.persistence.*

@Entity
@Table(uniqueConstraints = arrayOf(UniqueConstraint(columnNames = arrayOf("form_id", "ref"))))
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class FormNode(
        var ref: String = UUID.randomUUID().toString(),
        val name: String = "",
        var type: FormNodeType,
        var position: Int = 0,

        @ElementCollection
        val binding: Map<FormBinding, String> = emptyMap(),

        @OneToMany(cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
        val children: List<FormNode> = emptyList(),

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        var form: Form? = null) : BaseEntity() {

    enum class FormNodeType {
        GROUP,
        TEXT,
        INT,
        SLIDER,
        RADIO,
        MULTISELECT,
        SELECTABLE
    }

    enum class FormBinding {
        SHOW_WHEN_SELECTED,
        HIDE_WHEN_SELECTED
    }
}


