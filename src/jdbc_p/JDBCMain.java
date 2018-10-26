package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//���̺귯�� ���
		//gui������ ���콺 ������ ���� �н�
		//���̺귯��
		//add Jars
		//lib�� ���� ojdbc6.jar�� �ҷ��� ����
		
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
