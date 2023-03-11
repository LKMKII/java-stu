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
		
		JLabel Title = new JLabel("����Ա����");
		Title.setBounds(172, 10, 154, 34);
		this.contentPane2.add(Title);
		
		this.btnInput = new JButton("¼�뺽��");
		this.btnInput.setBounds(50, 77, 97, 23);
		this.contentPane2.add(this.btnInput);
		this.btnInput.addActionListener(this);
		
		this.btnQuery = new JButton("��ѯ����");
		this.btnQuery.setBounds(50, 122, 97, 23);
		this.contentPane2.add(this.btnQuery);
		this.btnQuery.addActionListener(this);
		
		this.btnChange = new JButton("�޸ĺ�����Ϣ");
		this.btnChange.setBounds(243, 122, 136, 23);
		this.contentPane2.add(this.btnChange);
		this.btnChange.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			switch(e.getActionCommand()) {
			case "¼�뺽��":
				new airlineInfoInputFrame();
				break;
			case "��ѯ����":
				new queryFrame();
				break;				
			case "�޸ĺ�����Ϣ":
				new changeAirline();
				break;
			}
		}
		
	}

}

