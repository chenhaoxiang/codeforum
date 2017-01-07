package cn.hncu.index.service;

import java.util.List;
import java.util.Map;

import cn.hncu.domain.InfoMod;

public interface IIndexService {
	public List<InfoMod> hot();
	public Map<String, Object> all(Integer iPageNo);
}
