package cn.hncu.publish.service;

import cn.hncu.domain.Info;
import cn.hncu.utils.tx.Transaction;

public interface IPublishService {
	@Transaction
	public String publish(Info info);
}
