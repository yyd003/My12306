package com.neuedu.my12306.usermgr.dao;

import java.net.InetAddress;
import java.sql.*;
import java.util.*;

import com.neuedu.my12306.common.*;
import com.neuedu.my12306.usermgr.domain.*;

public class UserDaoImpl implements UserDao{
			private Connection conn = null;

			public UserDaoImpl(Connection conn) {
				// TODO Auto-generated constructor stub
				this.conn = conn;
			}

			public UserDaoImpl() {
				// TODO Auto-generated constructor stub
			}

			@Override
			public boolean add(User c) throws Exception {
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				int idx=0;
				String add_sql = "insert into tab_user(username,password,birthday,rule,realname,sex,city,cert_type,cert,user_type,status,content,login_ip,image_path) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					System.out.println(add_sql);
					pstmt = (PreparedStatement) conn.prepareStatement(add_sql);
					pstmt.setString(++idx, c.getUsername());
					pstmt.setString(++idx, Md5Utils.md5(c.getPassword()));
					pstmt.setDate(++idx, c.getBirthday());
					pstmt.setString(++idx,  c.getRule());
					pstmt.setString(++idx,  c.getRealname());
					pstmt.setString(++idx,  c.getSex());
					pstmt.setInt(++idx,  c.getCity());
					pstmt.setInt(++idx,  c.getCert_type());
					pstmt.setString(++idx,  c.getCert());
					pstmt.setInt(++idx,  c.getUser_type());
					pstmt.setString(++idx,  c.getStatus());
					pstmt.setString(++idx,  c.getContent());
					pstmt.setString(++idx,  InetAddress.getLocalHost().getHostAddress());
					pstmt.setString(++idx,  c.getImage_path());
//					content,login_ip,image_path
					pstmt.executeUpdate();
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return true;
			}

			@Override
			public boolean del(int[] i) throws Exception {
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String it ="(";
				for (int j : i) {
					it+=String.valueOf(j);
					it+=",";
				}
				it=it.substring(0,it.length()-1);
				it+=")";
				//{1}
				String del_sql = "DELETE FROM tab_user WHERE id in "+it+";";
				// DELETE FROM tab_user WHERE id in(1,2);
//				DELETE FROM 表名称 WHERE 列名称 = 值
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(del_sql);
//					pstmt.setString(1, it);
					System.out.println(pstmt.toString());
					pstmt.executeUpdate();
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return true;
			}
			
			@Override
			public boolean del(User c) throws Exception {
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				//{1}
				String del_sql = "delete from tab_user where Username = ?";
				// String sql = "delete from students where Name='" + name + "'";
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(del_sql);
					pstmt.setString(1, c.getUsername());
					pstmt.executeUpdate();
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return true;
			}

			@Override
			public boolean alter(User c) throws Exception {
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				String ALT_sql = "update tab_user set Username=? where id=?";
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(ALT_sql);
					pstmt.setString(1, c.getUsername());
					pstmt.setInt(2, c.getId());
					pstmt.executeUpdate();
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return true;
			}

			@Override
			public List<User> getList() throws Exception {
				// TODO Auto-generated method stub
				String find_sql = "select * from tab_user";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<User> result = new ArrayList<User>();
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(find_sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						User one = new User();
						one.setId(rs.getInt("id"));
						one.setUsername(rs.getString("User"));
						result.add(one);
					}
				} finally {
					DBUtils.closeStatement(rs, pstmt);
					// if(rs!=null)rs.close();
				}
				return result;
			}

			public Connection getConn() {
				return conn;
			}

			public void setConn(Connection conn) {
				this.conn = conn;
			}

			@Override
			public User exactSearch(String s, Object o) throws Exception {
				// TODO Auto-generated method stub
				// "select * from  readermessage WHERE 读者姓名='张勇'"
				ResultSet rs = null;
				User c = null;
				PreparedStatement pstmt = null;
				String ES_sql = "select * from tab_user Where " + s + "=?";
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(ES_sql);
					pstmt.setObject(1, o);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						c = new User();
						c.setUsername(rs.getString("user"));
						c.setId(rs.getInt("id"));
					}
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return c;
			}

			@Override
			public List<User> fuzzySearch(String s, Object o) throws Exception {
				// TODO Auto-generated method stub
				// String sql = "SELECT MerchandiseID, MName, Number, InPrice, Explain"+
				// " FROM repertory where MName like '%?%'";
				String FS_sql = "select * from tab_user where " + s + " like '%"+ o + "%'";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<User> result = new ArrayList<User>();
				try {
					// System.out.println(FS_sql);
					pstmt = (PreparedStatement) conn.prepareStatement(FS_sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						User one = new User();
						one.setId(rs.getInt("id"));
						one.setUsername(rs.getString("user"));
						result.add(one);
					}
				} finally {
					DBUtils.closeStatement(rs, pstmt);
					// if(rs!=null)rs.close();
				}
				return result;
			}
			
			@Override
			public User findUser(User one) throws SQLException {
				// SQL语句
				StringBuffer find_sql = new StringBuffer();
				find_sql.append("SELECT u.*, ");
				find_sql.append("c.id cid, c.cityid ccityid, c.city ccity, c.father cfather, ");
				find_sql.append("p.id pid, p.provinceid pprovinceid, p.province pprovince, ");
				find_sql.append("t.id tid, t.content tcontent, ");
				find_sql.append("e.id eid, e.content econtent ");
				find_sql.append("FROM tab_user  u, tab_city c, tab_province p, tab_usertype t, tab_certtype e ");
				find_sql.append("WHERE u.city = c.id AND c.father = p.provinceid AND u.user_type = t.id AND u.cert_type = e.id");

				// 查询条件标记
				boolean tag = false;
				// 查询条件id字段
				Integer id = one.getId();
				if (id != null && id != 0) {
					find_sql.append(" AND u.id=" + id);
					tag = true;
				}
				// 查询条件username字段
				String username = one.getUsername();
				if (username != null && !username.isEmpty()) {
					find_sql.append(" AND u.username='" + username + "'");
					tag = true;
				}
				// 查询条件password字段
				String password = one.getPassword();
				if (password != null && !password.isEmpty()) {
					find_sql.append(" AND u.password='" + password + "'");
					tag = true;
				}
				// 查询条件rule字段
				String rule = one.getRule();
				if (rule != null && !rule.isEmpty()) {
					find_sql.append(" AND u.rule='" + rule + "'");
					tag = true;
				}
				// 查询条件realname字段，模糊查询
				String realname = one.getRealname();
				if (realname != null && !realname.isEmpty()) {
					find_sql.append(" AND u.realname LIKE '%" + realname + "%'");
					tag = true;
				}
				// 查询条件sex字段
				String sex = one.getSex();
				if (sex != null && !sex.isEmpty()) {
					find_sql.append(" AND u.sex='" + sex + "'");
					tag = true;
				}
				// 查询条件city字段
				if (one.getCity() != null) {
					Integer city = one.getCity();
					if (city != null && city != 0) {
						find_sql.append(" AND u.city=" + city);
						tag = true;
					}
				}
				// 查询条件cert_type字段
				if (one.getCert_type() != null) {
					Integer certtype = one.getCert_type();
					if (certtype != null && certtype != 0) {
						find_sql.append(" AND u.cert_type=" + certtype);
						tag = true;
					}
				}
				// 查询条件cert字段
				String cert = one.getCert();
				if (cert != null && !cert.isEmpty()) {
					find_sql.append(" AND u.cert LIKE '%" + cert + "%'");
					tag = true;
				}
				// 查询条件user_type字段
				if (one.getUser_type() != null) {
					Integer usertype = one.getUser_type();
					if (usertype != null && usertype != 0) {
						find_sql.append(" AND u.user_type=" + usertype);
						tag = true;
					}
				}
				// 查询条件content字段
				String content = one.getContent();
				if (content != null && !content.isEmpty()) {
					find_sql.append(" AND u.content LIKE '%" + content + "%'");
					tag = true;
				}
				// 查询条件status字段
				String status = one.getStatus();
				if (status != null && !status.isEmpty()) {
					find_sql.append(" AND u.status='" + status + "'");
					tag = true;
				}
				// 查询条件login_ip字段
				String ip = one.getLogin_ip();
				if (ip != null && !ip.isEmpty()) {
					find_sql.append(" AND u.login_ip='" + ip + "'");
					tag = true;
				}
				// 查询条件image_path字段
				String image = one.getImage_path();
				if (image != null && !image.isEmpty()) {
					find_sql.append(" AND u.image_path='" + image + "'");
					tag = true;
				}

				// 若没有查询条件则返回对象为null
				if (!tag) {
					return null;
				}

				User user = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					pstmt = conn.prepareStatement(find_sql.toString());
					rs = pstmt.executeQuery();
					if (rs.next()) {
						// 解析结果集对象，封装查询结果
						user = new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setRule(rs.getString("rule"));
						user.setRealname(rs.getString("realname"));
						user.setSex(rs.getString("sex"));

						// city
						Province province = new Province();
						province.setId(rs.getInt("pid"));
						province.setProvince(rs.getString("pprovince"));
						province.setProvinceid(rs.getString("pprovinceid"));

						City city = new City();
						city.setId(rs.getInt("cid"));
						city.setCityId(rs.getString("ccityid"));
						city.setCity(rs.getString("ccity"));
						city.setProvience(province);

						user.setCity(city);

						// CertType
						CertType certType = new CertType();
						certType.setId(rs.getInt("eid"));
						certType.setContent(rs.getString("econtent"));
						user.setCertType(certType);;

						user.setCert(rs.getString("cert"));
						user.setBirthday(rs.getDate("birthday"));

						// UserType
						UserType userType = new UserType();
						userType.setId(rs.getInt("tid"));
						userType.setContent(rs.getString("tcontent"));
						user.setUserType(userType);

						user.setContent(rs.getString("content"));
						user.setStatus(rs.getString("status"));
						user.setLogin_ip(rs.getString("login_ip"));
						user.setImage_path(rs.getString("image_path"));
					}
				} finally {
					DBUtils.closeStatement(rs, pstmt);
				}
				return user;
			}
			

			@Override
			public boolean deleteUsersProcedure(int[] t) throws Exception {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<IpAddress> getIpList() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public User login(String username, String password) throws Exception {
				// SQL语句
				StringBuffer buff = new StringBuffer();
				buff.append("SELECT u.*, ");
				buff.append("c.id cid, c.cityid ccityid, c.city ccity, c.father cfather, ");
				buff.append("p.id pid, p.provinceid pprovinceid, p.province pprovince, ");
				buff.append("t.id tid, t.content tcontent, ");
				buff.append("e.id eid, e.content econtent ");
				buff.append("FROM tab_user  u, tab_city c, tab_province p, tab_usertype t, tab_certtype e ");
				buff.append("WHERE u.city = c.id AND c.father = p.provinceid AND u.user_type = t.id AND u.cert_type = e.id ");
				buff.append("AND username=? AND password = ? ");
				String find_sql = buff.toString();
//				System.out.println(find_sql);
				User user = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					// 设置语句对象，SQL语句条件
					pstmt = conn.prepareStatement(find_sql);
					pstmt.setString(1, username);
					pstmt.setString(2, Md5Utils.md5(password));

					rs = pstmt.executeQuery();
					if (rs.next()) {
						// 解析结果集对象，封装查询结果
						user = new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setRule(rs.getString("rule"));
						user.setRealname(rs.getString("realname"));
						user.setSex(rs.getString("sex"));

						// city
						Province province = new Province();
						province.setId(rs.getInt("pid"));
						province.setProvince(rs.getString("pprovince"));
						province.setProvinceid(rs.getString("pprovinceid"));

						City city = new City();
						city.setId(rs.getInt("cid"));
						city.setCityId(rs.getString("ccityid"));
						city.setCity(rs.getString("ccity"));
						city.setProvince(province);

						user.setCity(city);

						// CertType
						CertType certType = new CertType();
						certType.setId(rs.getInt("eid"));
						certType.setContent(rs.getString("econtent"));
						user.setCertType(certType);

						user.setCert(rs.getString("cert"));
						user.setBirthday(rs.getDate("birthday"));

						// UserType
						UserType userType = new UserType();
						userType.setId(rs.getInt("tid"));
						userType.setContent(rs.getString("tcontent"));
						user.setUserType(userType);

						user.setContent(rs.getString("content"));
						user.setStatus(rs.getString("status"));
						user.setLogin_ip(rs.getString("login_ip"));
						user.setImage_path(rs.getString("image_path"));
					}
				} finally {
					 System.out.println("udim:" + pstmt);
					DBUtils.closeStatement(rs, pstmt);
				}

				return user;
			}

			@Override
			public int getListPageCount(int t, User c) throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getListRowCount(User c) throws Exception {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<User> getUserListRS(int t, int i, User c)
					throws Exception {
				// TODO Auto-generated method stub
				return null;
			}

}
