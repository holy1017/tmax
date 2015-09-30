package mvc.bak;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

public class DeptController {
	Logger log = Logger.getLogger(DeptController.class);

	@RequestMapping(value = "/dept/getDeptList")
	public String getDeptList() {
		log.info("getDeptList 호출 성공");
		return "forward:getDeptList.jsp";
//		return "redirect:getDeptList.jsp";
	}
}
