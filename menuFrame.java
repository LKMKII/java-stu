package NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class menuFrame extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnmanager, btnuser;
	public menuFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		JLabel Title = new JLabel("飞机订票系统");
		Title.setBounds(172, 10, 154, 34);
		this.contentPane.add(Title);
		
		this.btnmanager = new JButton("管理员登陆");
		this.btnmanager.setBounds(50, 77, 97, 23);
		this.contentPane.add(this.btnmanager);
		this.btnmanager.addActionListener(this);
		
		this.btnuser = new JButton("用户登陆");
		this.btnuser.setBounds(200, 77, 97, 23);
		this.contentPane.add(this.btnuser);
		this.btnuser.addActionListener(this);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new menuFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			switch(e.getActionCommand()) {
			case "管理员登陆":
				new Manager();
				break;
			case "用户登陆":
				new Users();
				break;				
			}
		}
		
	}

}
