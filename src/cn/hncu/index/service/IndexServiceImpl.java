package cn.hncu.index.service;
import java.util.List;
import java.util.Map;

import cn.hncu.domain.InfoMod;
import cn.hncu.index.dao.IIndexDao;
import cn.hncu.index.dao.IndexDaoJdbc;

public class IndexServiceImpl implements IIndexService{
	//声明dao
	private IIndexDao dao = new IndexDaoJdbc();
	
	public List<InfoMod> hot() {
		return dao.hot();
	}
	public Map<String, Object> all(Integer iPageNo) {
		return dao.all(iPageNo);
	}
}
