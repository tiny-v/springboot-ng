package com.my.sa.core.util.IdUtil;

/**
 * id生成器接口
 * @author chewj
 * 2014-04-03
 */
interface IdGenerator {

	/**
	 * 获取ID
	 * @return id值
	 */
	public long nextId();
}
