package self.eli.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import self.eli.demo.model.Dictionary;
import self.eli.demo.service.DictionaryService;
import self.eli.demo.vo.DictionaryVo;

@Controller
@RequestMapping("dictionary")
public class DictionaryController extends EliController<DictionaryService, Dictionary, DictionaryVo> {
}
