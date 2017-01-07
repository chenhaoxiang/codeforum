package cn.hncu.publish.service;
import java.util.List;
import java.util.Map;

import cn.hncu.domain.Info;
import cn.hncu.domain.InfoMod;
import cn.hncu.index.dao.IIndexDao;
import cn.hncu.index.dao.IndexDaoJdbc;
import cn.hncu.publish.dao.IPublishDao;
import cn.hncu.publish.dao.PublishDaoJdbc;

public class PublishServiceImpl implements IPublishService{
	//声明dao
	private IPublishDao dao = new PublishDaoJdbc();
	public String publish(Info info) {
		return dao.publish(info);
	}
}
