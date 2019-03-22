package self.eli.demo.service.impl;

import org.springframework.stereotype.Service;
import self.eli.demo.mapper.DictionaryMapper;
import self.eli.demo.model.Dictionary;
import self.eli.demo.service.DictionaryService;
import self.eli.demo.vo.DictionaryVo;

@Service
public class DictionaryServiceImpl extends EliServiceImpl<DictionaryMapper, Dictionary, DictionaryVo> implements DictionaryService {
}
