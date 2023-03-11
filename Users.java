package NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Users extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JButton btnQuery, btnBook, btnRefund;
	public Users() {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		JLabel Title = new JLabel("�û�����");
		Title.setBounds(172, 10, 154, 34);
		this.contentPane.add(Title);
		
		this.btnQuery = new JButton("��ѯ����");
		this.btnQuery.setBounds(50, 122, 97, 23);
		this.contentPane.add(this.btnQuery);
		this.btnQuery.addActionListener(this);
		
		this.btnBook = new JButton("��Ʊ");
		this.btnBook.setBounds(50, 77, 97, 23);
		this.contentPane.add(this.btnBook);
		this.btnBook.addActionListener(this);
		
		this.btnRefund = new JButton("��Ʊ");
		this.btnRefund.setBounds(243, 122, 136, 23);
		this.contentPane.add(this.btnRefund);
		this.btnRefund.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			switch(e.getActionCommand()) {
			case "��ѯ����":
				new queryFrame();
				break;
			case "��Ʊ":
				new bookTicketFrame();
				break;
			case "��Ʊ":
				new refundFrame();
				break;
			}
		}
		
	}

}