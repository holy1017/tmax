package mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.DeptVO;

/*
 * 스프링에서는 빈을 관리해주는 클래스(beanfactory)가 따로 제공됨.
 * 아래 코드의 logic에는 스프링에서 자동으로 입력함
*/
@Controller
public class DeptController {
	
	Logger logger = Logger.getLogger(DeptController.class);
	
	@Autowired
	public DeptLogic logic = null;

//	@Autowired 미사용시 아래 메소드 필요
//	<property name="logic" ref="deptLogic"></property> 필요 없음
//	public void setLogic(DeptLogic logic) {
//		this.logic = logic;
//	}

	@RequestMapping(value = "/dept/getDeptList.do")
	public String getDeptList(HttpServletRequest rq) {
		logger.info("getDeptList 호출성공");
		List<DeptVO> list=null;
		//List<DeptVO> list = new ArrayList<DeptVO>();
		list = logic.getDeptList();
		DeptVO vo=new DeptVO();
		vo.setDeptno(10);
		vo.setDname("SALES");
		vo.setLoc("BOSTON");
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		// DeptLogic logic=new DeptLogic();
		rq.setAttribute("list",	 list);
		logger.info("list:"+list);
//		return "redirect:getDeptList.jsp";
		return "forward:getDeptList.jsp";
	}
}
