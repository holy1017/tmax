package mvc;

import java.util.List;

import vo.DeptVO;

public interface DeptMapper {
	
	public List<DeptVO> getDeptList(int deptno);

	public int deptInsert(DeptVO dvo);
}
