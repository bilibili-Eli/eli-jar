package self.eli.demo.service;

import self.eli.demo.model.EliModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EliService<Model extends EliModel, Vo extends Model> {
    /**
     * 插入
     *
     * @param vo      vo对象
     * @param request request
     */
    void insert(Vo vo, HttpServletRequest request);

    /**
     * 更新
     *
     * @param vo      vo对象
     * @param request request
     */
    void update(Vo vo, HttpServletRequest request);

    /**
     * 删除
     *
     * @param model   model对象
     * @param request request
     */
    void delete(Model model, HttpServletRequest request);

    /**
     * 查询详情
     *
     * @param model   model对象
     * @param request request
     */
    Model selectById(Model model, HttpServletRequest request);

    /**
     * 查询全部
     *
     * @param model   model对象
     * @param request request
     */
    List<Model> selectAll(Model model, HttpServletRequest request);

    /**
     * 条件查询
     *
     * @param model   model对象
     * @param request request
     */
    List<Model> select(Model model, HttpServletRequest request);
}
