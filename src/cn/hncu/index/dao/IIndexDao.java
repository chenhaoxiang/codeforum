package cn.hncu.index.dao;

import java.util.List;
import java.util.Map;

import cn.hncu.domain.InfoMod;

public interface IIndexDao {
	public List<InfoMod> hot();
	public Map<String, Object> all(Integer iPageNo);
}
