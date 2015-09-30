package mvc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.DeptVO;

@Controller
public class DeptController {
	Logger logger = Logger.getLogger(DeptController.class);

	@RequestMapping(value = "/dept/getDeptList.do")
	public String getDeptList() {
		logger.info("getDeptList ȣ호출성공");
		DeptVO vo=new DeptVO();
//		return "redirect:getDeptList.jsp";
		return "forward:getDeptList.jsp";
	}
}
