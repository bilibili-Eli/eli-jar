package self.eli.demo.mapper;

import org.springframework.stereotype.Repository;
import self.eli.demo.model.Dictionary;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DictionaryMapper extends Mapper<Dictionary> {
    @Override
    List<Dictionary> selectAll();
}
