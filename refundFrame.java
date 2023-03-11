package NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class refundFrame extends JFrame implements ActionListener{

	JTextField bookId, refundNum;
	JPanel panel;
	JButton refund;
	public refundFrame()
	{
		super("��Ʊ");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(200, 300, 300, 300);
		this.setVisible(true);
		
		this.panel = new JPanel();
		this.add(this.panel);
		this.panel.setLayout(null);
		
		JLabel bookid = new JLabel("������");
		bookid.setBounds(60,60,80,15);
		this.panel.add(bookid);
		
		this.bookId = new JTextField();
		this.bookId.setBounds(120, 60, 80, 20);
		this.panel.add(this.bookId);
		
		JLabel refundnum = new JLabel("��Ʊ����");
		refundnum.setBounds(60,120,80,15);
		this.panel.add(refundnum);
		
		this.refundNum = new JTextField();
		this.refundNum.setBounds(120, 120, 80, 20);
		this.panel.add(this.refundNum);
		
		this.refund = new JButton("��Ʊ");
		this.refund.setBounds(100, 200, 80, 20);
		this.panel.add(this.refund);
		this.refund.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals("��Ʊ")) {
				String bookid = this.bookId.getText();
				int num = Integer.parseInt(this.refundNum.getText());//��Ʊ��
				String flightnum = ""; 
				//��¼�������ʹ����Ʊ��Ժ�����Ϣ��Ʊ�����и���
				ArrayList<Client> bookInfo = new ArrayList<Client>();
				Reader reader;
				try {
					reader = new FileReader("��Ʊ��Ϣ.txt");
					BufferedReader bufrd = new BufferedReader(reader);
					String line;
					while((line = bufrd.readLine()) != null) {
						String[] datas = line.trim().split(" ");//trim�����Ƴ��հ��ַ���split��������һ������
						Client client = new Client(datas[0], datas[1], datas[2], datas[3], datas[4]);
						bookInfo.add(client);
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
				
				for(Client info: bookInfo) {
					if(info.bookId.equals(bookid)) {
						flightnum = info.flightNum; //��¼�����
						int n0 = Integer.parseInt(info.ticketNum); //ԭ��Ʊ��
						int n1 = n0-num; //�ֶ�Ʊ��
						if(n1 <= 0) {  //Ʊȫ������ɾ��Ʊ��0�Ŀͻ���Ϣ
							bookInfo.remove(info);
						}
						else {
							info.ticketNum = String.valueOf(n1); //���¶���Ʊ��
						}
						break;
					}
				}
				
				
				//������Ʊ��Ķ�Ʊ��Ϣ��������Ʊ�Ķ���
				File file=new File("��Ʊ��Ϣ.txt");
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter(file,false); //���¶�Ʊ��Ϣ
					for(Client client: bookInfo)
						fileWriter.write(client.toString());
					fileWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// ���º�����Ϣ��Ʊ��
				ArrayList<Airline> airlines = new ArrayList<Airline>();
				Reader readr;
				try {
					readr = new FileReader("������Ϣ.txt");
					BufferedReader bufrd = new BufferedReader(readr);
					String line;
					while((line = bufrd.readLine()) != null) {
						String[] datas = line.trim().split(" ");
						Airline airline = new Airline(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[6], datas[7]);
						airlines.add(airline);
					}
					bufrd.close();
					readr.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(Airline airln: airlines) {
					if(airln.flightNum.equals(flightnum)) {
						airln.leftTicket = String.valueOf(Integer.parseInt(airln.leftTicket) + num);
					}
				}
				
				//��������ĺ�����Ϣд���ļ�
				File file1=new File("������Ϣ.txt");
				FileWriter fileWriter1;
				try {
					fileWriter1 = new FileWriter(file1,false);  //��׷�ӣ�false
					for(Airline airline: airlines)
						fileWriter1.write(airline.toString());
					fileWriter1.close();
				} catch (IOException e1) {
					//TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showInternalMessageDialog(null, "��Ʊ�ɹ���");
			}
		}
	}
	
}
