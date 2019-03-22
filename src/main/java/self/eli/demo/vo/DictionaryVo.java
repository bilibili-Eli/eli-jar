package self.eli.demo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import self.eli.demo.model.Dictionary;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class DictionaryVo extends Dictionary {
    /**
     * 子类集合
     */
    private List<Dictionary> children;
}
