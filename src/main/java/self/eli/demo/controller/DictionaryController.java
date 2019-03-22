package self.eli.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.eli.demo.model.Dictionary;
import self.eli.demo.service.DictionaryService;
import self.eli.demo.vo.DictionaryVo;

@RestController
@RequestMapping("dictionary")
public class DictionaryController extends EliController<DictionaryService, Dictionary, DictionaryVo> {

}
