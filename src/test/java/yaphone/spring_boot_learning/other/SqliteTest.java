package yaphone.spring_boot_learning.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SqliteTest {

	public static void main(String[] args) throws Exception {
		Resource resource = new ClassPathResource("wechat_helper.db");
		if (resource.exists()) { // 存在
			String DB_SRC = resource.getURL().getPath();
			Connection con = DriverManager.getConnection("jdbc:sqlite://" + DB_SRC);
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT count(*) FROM user WHERE 1 = 1");
			int count = rs.getInt(1);
			System.out.println(count);

		}
	}

}
