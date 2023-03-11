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
		super("退票");
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(200, 300, 300, 300);
		this.setVisible(true);
		
		this.panel = new JPanel();
		this.add(this.panel);
		this.panel.setLayout(null);
		
		JLabel bookid = new JLabel("订单号");
		bookid.setBounds(60,60,80,15);
		this.panel.add(bookid);
		
		this.bookId = new JTextField();
		this.bookId.setBounds(120, 60, 80, 20);
		this.panel.add(this.bookId);
		
		JLabel refundnum = new JLabel("退票数量");
		refundnum.setBounds(60,120,80,15);
		this.panel.add(refundnum);
		
		this.refundNum = new JTextField();
		this.refundNum.setBounds(120, 120, 80, 20);
		this.panel.add(this.refundNum);
		
		this.refund = new JButton("退票");
		this.refund.setBounds(100, 200, 80, 20);
		this.panel.add(this.refund);
		this.refund.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals("退票")) {
				String bookid = this.bookId.getText();
				int num = Integer.parseInt(this.refundNum.getText());//退票数
				String flightnum = ""; 
				//记录航班号以使得退票后对航班信息的票数进行更新
				ArrayList<Client> bookInfo = new ArrayList<Client>();
				Reader reader;
				try {
					reader = new FileReader("订票信息.txt");
					BufferedReader bufrd = new BufferedReader(reader);
					String line;
					while((line = bufrd.readLine()) != null) {
						String[] datas = line.trim().split(" ");//trim（）移除空白字符，split（）返回一个数组
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
						flightnum = info.flightNum; //记录航班号
						int n0 = Integer.parseInt(info.ticketNum); //原订票数
						int n1 = n0-num; //现订票数
						if(n1 <= 0) {  //票全部退完删除票数0的客户信息
							bookInfo.remove(info);
						}
						else {
							info.ticketNum = String.valueOf(n1); //更新订单票数
						}
						break;
					}
				}
				
				
				//更新退票后的订票信息，更新退票的订单
				File file=new File("订票信息.txt");
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter(file,false); //更新订票信息
					for(Client client: bookInfo)
						fileWriter.write(client.toString());
					fileWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// 更新航班信息的票数
				ArrayList<Airline> airlines = new ArrayList<Airline>();
				Reader readr;
				try {
					readr = new FileReader("航班信息.txt");
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
				
				//将更新完的航班信息写入文件
				File file1=new File("航班信息.txt");
				FileWriter fileWriter1;
				try {
					fileWriter1 = new FileWriter(file1,false);  //不追加，false
					for(Airline airline: airlines)
						fileWriter1.write(airline.toString());
					fileWriter1.close();
				} catch (IOException e1) {
					//TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showInternalMessageDialog(null, "退票成功！");
			}
		}
	}
	
}
