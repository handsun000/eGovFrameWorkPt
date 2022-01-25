package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.CodeService;
import egovframework.example.sample.service.CodeVO;
import egovframework.example.sample.service.impl.CodeDAO;

@Controller
public class CodeController {
	
	@Resource(name = "codeService")
	private CodeService codeService;
	
	
	@RequestMapping(value = "codeWrite.do")
	public String codeWrite() {
		return "code/codeWrite";
	}
	
	@RequestMapping(value = "codeWriteSave.do")
	public String insertCode(CodeVO vo) throws Exception {
		codeService.insertCodes(vo);
		return "redirect:codeList.do";
	}
	
	@RequestMapping(value = "codeList.do")
	public String codeList(CodeVO vo, ModelMap model) throws Exception {
		
		int count = codeService.selectCodesCount(vo);
		List list = codeService.selectCodesList(vo);
		
		model.addAttribute("count", count);
		model.addAttribute("result", list);
		
		return "code/codeList";
	}
	
	@RequestMapping(value = "codeDelete.do")
	public String codeDelete(int code) throws Exception {
		
		codeService.codeDelete(code);
		
		return "redirect:codeList.do";
	}
	
	@RequestMapping(value = "codeModifyWrite.do")
	public String codeModifyWrite(int code, ModelMap model) throws Exception {
		
		CodeVO vo = codeService.selectCodesDetail(code);
		model.addAttribute("result", vo);
		
		return "code/codeModifyWrite";
	}
	
	@RequestMapping(value = "codeModifyWriteSave.do")
	public String codeModifyWriteSave(CodeVO vo) throws Exception {
		
		System.out.println("저장완료");
		codeService.updateCodes(vo);
		
		return "redirect:codeList.do";
	}
}
