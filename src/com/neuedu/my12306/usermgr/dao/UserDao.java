package com.neuedu.my12306.usermgr.dao;

import java.util.*;

import com.neuedu.my12306.usermgr.domain.*;

public interface UserDao {
	public abstract List<User> getList() throws Exception;

	public abstract boolean add(User c) throws Exception;

	public abstract boolean del(User c) throws Exception;

	public abstract boolean alter(User c) throws Exception;

	public abstract User exactSearch(String s, Object o) throws Exception;

	public abstract List<User> fuzzySearch(String s, Object o) throws Exception;

	public abstract List<IpAddress> getIpList() throws Exception;

	public abstract int getListPageCount(int pageSize, User one)
			throws Exception;

	public abstract int getListRowCount(User one) throws Exception;

	public abstract User login(String u, String p) throws Exception;

	boolean del(int[] i) throws Exception;

	public abstract User findUser(User u) throws Exception;

	/**
	 * 删除用户(采用调用存储过程完成)
	 * 
	 * @param userIdList
	 * @return 操作是否成功
	 * @throws SQLException
	 */
	boolean deleteUsersProcedure(int[] userIdList) throws Exception;

	public abstract List<User> getUserList(int pageSize, int rowNum, User one)
			throws Exception;

	/**
	 * 获取指定页用户信息列表，通过分页SQL语句实现
	 * 
	 * @param pageSize
	 *            ，每页显示信息条数
	 * @param rowNum
	 *            ，需要获取的页数
	 * @param one
	 *            ，查询条件
	 * @return 用户信息列表，List[User]，若无满足条件则列表为空
	 * @throws SQLException
	 */
	List<User> getUserListRS(int pageSize, int pageNum, User one)
			throws Exception;

	/**
	 * 更新用户信息
	 * 
	 * @param one
	 *            ，需要更新的用户信息对象
	 * @return 执行是否成功
	 * @throws SQLException
	 */
}
