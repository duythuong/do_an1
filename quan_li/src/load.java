

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class load {

	Vector<String> va = new Vector<String>();
	Vector<Vector<String>> vb = new Vector<Vector<String>>();
	Statement st;
	ResultSet rs;
	ResultSetMetaData rsm;
	int n;
	Connection conn=null;
	public void load1() {
		ketnoi kn = new ketnoi();
		conn = kn.connec();
		va.clear();
		vb.clear();
		String s[] = {"Mã Bạn Đọc","Tên Bạn Đọc","Ngày Sinh","Lớp","Tên Sách","Ngày Mượn"};
		try {
			for(int i=0;i<s.length;i++) {
				va.add(s[i]);
			}
			st = conn.createStatement();
			rs = st.executeQuery("select * from thongtin");
			rsm = rs.getMetaData();
			n = rsm.getColumnCount();
			while(rs.next()) {
				Vector<String> row = new Vector<String>(n);
				for(int i=1;i<=n;i++) {
					row.add(rs.getString(i));			    
				}
				vb.add(row);
			}
			rs.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
