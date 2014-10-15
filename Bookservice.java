package books;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.sql.Statement;

	public class Bookservice {
		// ������̬ȫ�ֱ���
		static Connection conn;

		static Statement st;

		private String worklen;

		public static void main(String[] args) {
			query();	//��ѯ��¼����ʾ
		}
		
		/* ��ѯ���ݿ⣬�������Ҫ��ļ�¼�����*/
		public static void query() {
			
			conn = getConnection();	//ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
			try {
				String sql = "select * from book";		// ��ѯ���ݵ�sql���
				st = conn.createStatement();	//��������ִ�о�̬sql����Statement����st���ֲ�����
				ResultSet rs = st.executeQuery(sql);	//ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
				System.out.println("���Ĳ�ѯ���Ϊ��");
				while (rs.next()) {	// �ж��Ƿ�����һ������
					// �����ֶ�����ȡ��Ӧ��ֵ
					String author = rs.getString("author");
					String worklen = rs.getString("booknames");
					String wage = rs.getString("date").trim();
					
					//����鵽�ļ�¼�ĸ����ֶε�ֵ
					System.out.println(author + " " + worklen + " " + wage);
				
				}
				
				conn.close();	//�ر����ݿ�����
				
			} catch (SQLException e) {
				System.out.println("��ѯ����ʧ��");
			}
		}
		public String getBooks()
		{
			return worklen;
		}


		/* ��ȡ���ݿ����ӵĺ���*/
		public static Connection getConnection() {
			Connection con = null;	//���������������ݿ��Connection����
			try {
				Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������
				
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/test", "root", "123456");// ������������
				
			} catch (Exception e) {
				System.out.println("���ݿ�����ʧ��" + e.getMessage());
			}
			return con;	//���������������ݿ�����
		}
	}

