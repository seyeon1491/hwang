package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//라이브러리 등록
		//gui폴더에 마우스 오른쪽 빌드 패스
		//라이브러리
		//add Jars
		//lib에 담은 ojdbc6.jar을 불러와 저장
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = 
			DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", //Url
					"hr", //id
					"hr");//pw
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from test2");
			
			while (rs.next()) {
				String id = rs.getString("id");
				Date reg_data = rs.getDate("REG_DATA");
				int grade = rs.getInt("grade");
				System.out.println(id+","+reg_data+","+grade+">>>>>>>>");
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
