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
		
		JLabel Title = new JLabel("�ɻ���Ʊϵͳ");
		Title.setBounds(172, 10, 154, 34);
		this.contentPane.add(Title);
		
		this.btnmanager = new JButton("����Ա��½");
		this.btnmanager.setBounds(50, 77, 97, 23);
		this.contentPane.add(this.btnmanager);
		this.btnmanager.addActionListener(this);
		
		this.btnuser = new JButton("�û���½");
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
			case "����Ա��½":
				new Manager();
				break;
			case "�û���½":
				new Users();
				break;				
			}
		}
		
	}

}
