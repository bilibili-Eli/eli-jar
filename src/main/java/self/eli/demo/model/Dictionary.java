package self.eli.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Dictionary extends EliModel {
    /**
     * 字典id
     */
    @Id
    @Column(name = "dictionary_id")
    private String dictionaryId;
    /**
     * 父类id
     */
    @Column(name = "parent_id")
    private String parentId;
    /**
     * 是否父类
     */
    @Column(name = "is_parent")
    private Integer isParent;
    /**
     * 字典序列
     */
    @Column(name = "dictionary_seq")
    private Integer dictionarySeq;
    /**
     * 字典名称
     */
    @Column(name = "dictionary_name")
    private String dictionaryName;
}
