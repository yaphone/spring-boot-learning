package cn.zhouyafeng.common.model;

/**
 * 用户模型
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月21日 下午10:24:39
 * @version 1.0
 *
 */
public class UserEntity {

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
