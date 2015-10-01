package mvc;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import vo.DeptVO;

@Service
public class DeptLogic {
	Logger logger = Logger.getLogger(DeptController.class);
	
	public List<DeptVO> getDeptList() {
		logger.info("getDeptList 호출 성공");
		//List<DeptVO> list =null;
		List<DeptVO> list = new ArrayList<DeptVO>();
		return list;

	}
}
