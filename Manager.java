package NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Manager extends JFrame implements ActionListener{
	private JPanel contentPane2;
	private JButton btnInput, btnQuery, btnChange;
	public Manager() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane2 = new JPanel();
		this.contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane2);
		this.contentPane2.setLayout(null);
		
		JLabel Title = new JLabel("管理员界面");
		Title.setBounds(172, 10, 154, 34);
		this.contentPane2.add(Title);
		
		this.btnInput = new JButton("录入航班");
		this.btnInput.setBounds(50, 77, 97, 23);
		this.contentPane2.add(this.btnInput);
		this.btnInput.addActionListener(this);
		
		this.btnQuery = new JButton("查询航班");
		this.btnQuery.setBounds(50, 122, 97, 23);
		this.contentPane2.add(this.btnQuery);
		this.btnQuery.addActionListener(this);
		
		this.btnChange = new JButton("修改航班信息");
		this.btnChange.setBounds(243, 122, 136, 23);
		this.contentPane2.add(this.btnChange);
		this.btnChange.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			switch(e.getActionCommand()) {
			case "录入航班":
				new airlineInfoInputFrame();
				break;
			case "查询航班":
				new queryFrame();
				break;				
			case "修改航班信息":
				new changeAirline();
				break;
			}
		}
		
	}

}

