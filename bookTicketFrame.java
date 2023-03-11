package NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class bookTicketFrame extends JFrame implements ActionListener{
	JTextField name, id, flightNum, ticketNum, bookId;
	JPanel contentPane;
	JButton bookBtn;
	public bookTicketFrame()
	{
		super("��Ʊ");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100,100,220,340);
		this.contentPane = new JPanel();
		this.add(this.contentPane);
		this.contentPane.setLayout(null);
		
		JLabel name_ = new JLabel("����");
		name_.setBounds(25, 28, 58, 15);
		this.contentPane.add(name_);
		this.name = new JTextField("",15);
		this.name.setBounds(70, 25, 80, 20);
		this.contentPane.add(this.name);
		
		
		JLabel id_ = new JLabel("���֤��");
		id_.setBounds(20, 68, 58, 15);
		this.contentPane.add(id_);
		this.id = new JTextField("",15);
		this.id.setBounds(70, 65, 80, 20);
		this.contentPane.add(this.id);
		
		
		JLabel flightNum_ = new JLabel("�����");
		flightNum_.setBounds(25, 108, 58, 15);
		this.contentPane.add(flightNum_);
		this.flightNum = new JTextField("",15);
		this.flightNum.setBounds(70, 105, 80, 20);
		this.contentPane.add(this.flightNum);
		
		JLabel ticktNum_ = new JLabel("Ʊ��");
		ticktNum_.setBounds(25, 148, 58, 15);
		this.contentPane.add(ticktNum_);
		this.ticketNum = new JTextField("",15);
		this.ticketNum.setBounds(70, 145, 80, 20);
		this.contentPane.add(this.ticketNum);
		
		JLabel bookId_ = new JLabel("������");
		bookId_.setBounds(25, 188, 58, 15);
		this.contentPane.add(bookId_);
		this.bookId = new JTextField("",15);
		this.bookId.setBounds(70, 185, 80, 20);
		this.contentPane.add(this.bookId);
		
		this.bookBtn = new JButton("Ԥ��");
		this.bookBtn.setBounds(65, 240, 80, 20);
		this.contentPane.add(this.bookBtn);
		this.bookBtn.addActionListener(this);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals("Ԥ��")) {
				ArrayList<Airline> airlines = new ArrayList<Airline>();
				Reader reader;
				try {
					reader = new FileReader("������Ϣ.txt");
					BufferedReader bufrd = new BufferedReader(reader);
					String line;
					while((line = bufrd.readLine()) != null) {
						String[] datas = line.trim().split(" ");
						Airline airline = new Airline(datas[0], datas[1], 
								datas[2], datas[3], datas[4], datas[5], datas[6], datas[7]);
						airlines.add(airline);
					}
					bufrd.close();
					reader.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Client client = this.getClient();
				for(Airline airln: airlines) {
					if(airln.flightNum.equals(client.flightNum)) {
						if(Integer.parseInt(airln.leftTicket) >= Integer.parseInt(client.ticketNum)) {
							File file=new File("��Ʊ��Ϣ.txt");
							FileWriter fileWriter;
							try {
								fileWriter = new FileWriter(file,true);
								fileWriter.write(client.toString());
								System.out.println(client.toString());
								fileWriter.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							// ��Ʊ������
							airln.leftTicket = String.valueOf(Integer.parseInt(airln.leftTicket) - Integer.parseInt(client.ticketNum));  
							
							File f=new File("������Ϣ.txt");
							FileWriter fileW;
							try {
								fileW = new FileWriter(f, false);
								for(Airline airline: airlines) {
									fileW.write(airline.toString());
								}
								fileW.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Ԥ���ɹ���");
						}else {
							JOptionPane.showMessageDialog(null, "�ú���Ʊ�Ѿ����꣡��Ԥ����������");
						}
					}
				}
				
			}
		}
		
	}
	
	public Client getClient() {
		return new Client(this.name.getText(), this.id.getText(),
				this.flightNum.getText(),this.ticketNum.getText(),this.bookId.getText());
	}

}
