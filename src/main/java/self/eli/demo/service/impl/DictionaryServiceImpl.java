package self.eli.demo.service.impl;

import org.springframework.stereotype.Service;
import self.eli.demo.mapper.DictionaryMapper;
import self.eli.demo.model.Dictionary;
import self.eli.demo.service.DictionaryService;
import self.eli.demo.vo.DictionaryVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public void insert(DictionaryVo dictionaryVo, HttpServletRequest request) {
        dictionaryVo.setDictionaryId(UUID.randomUUID().toString());
        dictionaryVo.iniInsert(request);
        dictionaryMapper.insertSelective(dictionaryVo);
    }

    @Override
    public void update(DictionaryVo dictionaryVo, HttpServletRequest request) {
        dictionaryVo.iniModify(request);
        dictionaryMapper.updateByPrimaryKeySelective(dictionaryVo);
    }

    @Override
    public void delete(Dictionary dictionary, HttpServletRequest request) {
        dictionaryMapper.delete(dictionary);
    }

    @Override
    public Dictionary selectById(Dictionary dictionary, HttpServletRequest request) {
        return dictionaryMapper.selectOne(dictionary);
    }

    @Override
    public List<Dictionary> selectAll(Dictionary model, HttpServletRequest request) {
        return dictionaryMapper.selectAll();
    }

    @Override
    public List<Dictionary> select(Dictionary model, HttpServletRequest request) {
        return dictionaryMapper.select(model);
    }
}
