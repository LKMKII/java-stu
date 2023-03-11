package NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class queryFrame extends JFrame implements ActionListener{
	public JPanel contentPane;
	public JTextField flightNum, takeOffCity, arriveCity;
	private JTable table;
	private DefaultTableModel tablemodel;
	private JButton query;
	int data;
	public queryFrame()
	{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 570, 300);
		this.contentPane = new JPanel();
		this.getContentPane().add(this.contentPane);
		this.contentPane.setBorder(new EmptyBorder(5,5,5,5));
		this.contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("航班号");
		lblNewLabel.setBounds(56, 10, 58, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("起飞城市");
		lblNewLabel_1.setBounds(225, 10, 58, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("到达城市");
		lblNewLabel_2.setBounds(380, 10, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		this.flightNum = new JTextField();
		this.flightNum.setBounds(56, 35, 66, 21);
		this.contentPane.add(this.flightNum);
		
		this.takeOffCity = new JTextField();
		this.takeOffCity.setBounds(225, 35, 66, 21);
		this.contentPane.add(this.takeOffCity);
		
		this.arriveCity = new JTextField();
		this.arriveCity.setBounds(380, 35, 66, 21);
		this.contentPane.add(this.arriveCity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 66, 500, 129);
		contentPane.add(scrollPane);
		
		String titles[] = {"航班号", "出发城市", "到达城市", "出发时间", "到达时间","票价", "折扣", "余票数"};
		this.tablemodel = new DefaultTableModel(titles,0);
		table = new JTable(this.tablemodel);
		scrollPane.setViewportView(table);
		
		
		this.query = new JButton("查询");
		this.query.setBounds(220, 230, 60, 23);
		this.query.addActionListener(this);
		this.contentPane.add(this.query);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals("查询")) {
				//清空原来的查询结果
				int n = this.tablemodel.getRowCount();
				while(n>0) {
					this.tablemodel.removeRow(0);
					n--;
				}
				ArrayList<Airline> airlines = new ArrayList<Airline>();
				Reader reader;
				LinkList list = new LinkList();
				try {
					reader = new FileReader("航班信息.txt");
					BufferedReader bufrd = new BufferedReader(reader);
					ListNode head = null;
					ListNode listNode = new ListNode(data);
			        ListNode indexNode = listNode;
			        while (indexNode != null){
			            indexNode=indexNode.next;
			        }
			        list.head = head;
			        list.printLink();
					String line;
					while((line = bufrd.readLine()) != null) {
						String[] datas = line.trim().split(" ");
						Airline airline = new Airline(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[6], datas[7]);
						airlines.add(airline);
					}
					bufrd.close();
					reader.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				

				String airlineNum = this.flightNum.getText().trim();
				if(airlineNum.equals("")) {
					String takeoffcity = this.takeOffCity.getText().trim();
					String arrivecity = this.arriveCity.getText().trim();
					for(int i = 0; i < airlines.size(); i++) {
						Airline airln = airlines.get(i);
						if(airln.takeOffCity.equals(takeoffcity) && airln.landCity.equals(arrivecity)) {
							Object data[] = {airln.flightNum,airln.takeOffCity,airln.landCity,airln.startTime,
									airln.arriveTime,airln.ticketPrice,airln.discount,airln.leftTicket};
							this.tablemodel.addRow(data);
						}
					}
					JOptionPane.showMessageDialog(null, "根据起止城市查询完毕！");
				}else {
					for(Airline airln: airlines) {
						if(airln.flightNum.equals(airlineNum)) {
							Object data[] = {airln.flightNum,airln.takeOffCity,airln.landCity,airln.startTime,
									airln.arriveTime,airln.ticketPrice,airln.discount,airln.leftTicket};
							this.tablemodel.addRow(data);
						}
					}
					JOptionPane.showMessageDialog(null, "根据航班号查询完毕！");
				}
			}
		}
	}
}
