

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class tim {

	public Connection conn= null;
	Vector<String> vc = new Vector<String>();
	Vector<Vector<String>> vd = new Vector<Vector<String>>();
	String s;
	Statement st;
	ResultSet rs;
	String t2 = null;
	
	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public void timkiem() {
		ketnoi kn = new ketnoi();
		conn = kn.connec();
		vc.clear();
		vd.clear();
		String a[] = {"Mã Bạn Đọc","Tên Bạn Đọc","Ngày Sinh","Lớp","Tên Sách","Ngày Mượn"};
		try {
			for(int i=0;i<a.length;i++) {
				vc.add(a[i]);
			}
			st = conn.createStatement();
			rs = st.executeQuery("select * from thongtin where masach like '%"+t2+"%'");
			ResultSetMetaData rsm = rs.getMetaData();
			int n = rsm.getColumnCount();
			while(rs.next()) {
				Vector<String> row = new Vector<String>(n);
				for(int i=1;i<=n;i++)
					row.add(rs.getString(i));
				vd.add(row);
			}
			rs.close();
                 
		} catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
		}
		
	}
}
