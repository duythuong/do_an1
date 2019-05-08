

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class them {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public Connection conn = null;
	private JTextField textField_2;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them window = new them();
					window.frame.setVisible(true);
					window.frame.setTitle("thêm thông tin");
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public them() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void loi(){
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField.setBounds(254, 33, 345, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_1.setBounds(254, 100, 345, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_3.setBounds(254, 242, 345, 33);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_4.setBounds(254, 311, 345, 33);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_5.setBounds(254, 382, 345, 33);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnLu = new JButton("L\u01B0u");
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "insert into thongtin(masach,tenbd,ngaysinh,lop,tensach,ngaymuon) values(?,?,?,?,?,?)";
				try {
					String regex = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
					ketnoi kb = new ketnoi();
					conn = kb.connec();
					PreparedStatement p = conn.prepareStatement(sql);
					p.setString(1, textField.getText());
					p.setString(2, textField_1.getText());
					boolean match1 = textField_2.getText().matches(regex);
					if(match1==true) {
					p.setString(3, textField_2.getText());	
					}else {
						JOptionPane.showConfirmDialog(null, "nhap sai ngày sinh", "thông báo", JOptionPane.CANCEL_OPTION);
					}
					p.setString(4, textField_3.getText());
					p.setString(5, textField_4.getText());
					p.setString(6, textField_5.getText());
					
					int t = p.executeUpdate();
					if(t!=-1) {
						JOptionPane.showConfirmDialog(null, "thêm thành công", "thông báo", JOptionPane.CANCEL_OPTION);
					}
					
					conn.close();
				}catch (Exception e) {
//					System.out.println(e);
				}
			}
		});
		btnLu.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnLu.setBounds(318, 458, 108, 33);
		frame.getContentPane().add(btnLu);
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrame().dispose();
				
			}
		});
		btnThot.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnThot.setBounds(479, 458, 103, 33);
		frame.getContentPane().add(btnThot);
		
		JLabel lblMSinhVin = new JLabel("Mã Bạn Đọc");
		lblMSinhVin.setForeground(Color.RED);
		lblMSinhVin.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblMSinhVin.setBounds(21, 33, 131, 33);
		frame.getContentPane().add(lblMSinhVin);
		
		JLabel lblTnSinhVin = new JLabel("Tên Bạn Đọc");
		lblTnSinhVin.setForeground(Color.RED);
		lblTnSinhVin.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTnSinhVin.setBounds(21, 100, 131, 33);
		frame.getContentPane().add(lblTnSinhVin);
		
		JLabel lblNgySinh = new JLabel("Ngày Sinh");
		lblNgySinh.setForeground(Color.RED);
		lblNgySinh.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNgySinh.setBounds(21, 175, 131, 33);
		frame.getContentPane().add(lblNgySinh);
		
		JLabel lblLp = new JLabel("Lớp");
		lblLp.setForeground(Color.RED);
		lblLp.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblLp.setBounds(21, 242, 131, 33);
		frame.getContentPane().add(lblLp);
		
		JLabel lblaCh = new JLabel("Tên Sách");
		lblaCh.setForeground(Color.RED);
		lblaCh.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblaCh.setBounds(21, 311, 131, 33);
		frame.getContentPane().add(lblaCh);
		
		JLabel lblChuynNgnh = new JLabel("Ngày Mượn");
		lblChuynNgnh.setForeground(Color.RED);
		lblChuynNgnh.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblChuynNgnh.setBounds(21, 382, 168, 33);
		frame.getContentPane().add(lblChuynNgnh);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(254, 175, 345, 33);
		frame.getContentPane().add(textField_2);
		
	}
}
