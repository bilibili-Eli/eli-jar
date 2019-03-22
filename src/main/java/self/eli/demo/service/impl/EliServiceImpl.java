package self.eli.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import self.eli.demo.model.EliModel;
import self.eli.demo.service.EliService;
import tk.mybatis.mapper.common.Mapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class EliServiceImpl<M extends Mapper<Model>, Model extends EliModel, Vo extends Model> implements EliService<Model, Vo> {

    @Autowired
    private M mapper;

    @Override
    public void insert(Vo vo, HttpServletRequest request) {
        vo.iniInsert(request);
        mapper.insertSelective(vo);
    }

    @Override
    public void update(Vo vo, HttpServletRequest request) {
        vo.iniModify(request);
        mapper.updateByPrimaryKeySelective(vo);
    }

    @Override
    public void delete(Model model, HttpServletRequest request) {
        mapper.delete(model);
    }

    @Override
    public Model selectById(Model model, HttpServletRequest request) {
        return mapper.selectOne(model);
    }

    @Override
    public List<Model> selectAll(Model model, HttpServletRequest request) {
        return mapper.select(model);
    }
}
