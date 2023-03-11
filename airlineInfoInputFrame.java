package NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class airlineInfoInputFrame extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField txtFlightNum,txtTakeOffCity,txtLandCity,txtStartTime,
	txtArriveTime,txtTicketPrice,txtDiscount,txtLeftTicket;
	private JButton InputAirlineInfo;
	
	public airlineInfoInputFrame() 
	{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);	
			
		JLabel title = new JLabel("航班信息录入");
		title.setBounds(160, 20, 100, 20);
		this.contentPane.add(title);	
		
		JLabel lblNewLabel_1 = new JLabel("航班号");
		lblNewLabel_1.setBounds(22, 64, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("起飞城市");
		lblNewLabel_2.setBounds(22, 97, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("到达城市");
		lblNewLabel_3.setBounds(22, 138, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("起飞时间");
		lblNewLabel_4.setBounds(219, 64, 58, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("到达时间");
		lblNewLabel_5.setBounds(219, 97, 58, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("票价");
		lblNewLabel_6.setBounds(219, 138, 58, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("余票数");
		lblNewLabel_7.setBounds(219, 178, 58, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("折扣");
		lblNewLabel_8.setBounds(219, 206, 58, 15);
		contentPane.add(lblNewLabel_8);
		
		this.txtFlightNum = new JTextField("");
		this.txtFlightNum.setBounds(79, 61, 66, 21);
		contentPane.add(this.txtFlightNum);
		this.txtFlightNum.setColumns(10);
		
		this.txtTakeOffCity = new JTextField("");
		this.txtTakeOffCity.setBounds(79, 94, 66, 21);
		contentPane.add(this.txtTakeOffCity);
		this.txtTakeOffCity.setColumns(10);
		
		this.txtLandCity = new JTextField("");
		this.txtLandCity.setBounds(79, 135, 66, 21);
		contentPane.add(this.txtLandCity);
		this.txtLandCity.setColumns(10);
		
		this.txtStartTime = new JTextField("");
		this.txtStartTime.setBounds(277, 61, 66, 21);
		contentPane.add(this.txtStartTime);
		this.txtStartTime.setColumns(10);
		
		this.txtArriveTime = new JTextField("");
		this.txtArriveTime.setBounds(277, 94, 66, 21);
		contentPane.add(this.txtArriveTime);
		this.txtArriveTime.setColumns(10);
		
		this.txtTicketPrice = new JTextField("");
		this.txtTicketPrice.setBounds(277, 135, 66, 21);
		contentPane.add(this.txtTicketPrice);
		this.txtTicketPrice.setColumns(10);
		
		this.txtLeftTicket = new JTextField("");
		this.txtLeftTicket.setBounds(277, 175, 66, 21);
		contentPane.add(this.txtLeftTicket);
		this.txtLeftTicket.setColumns(10);
		
		this.txtDiscount = new JTextField("");
		this.txtDiscount.setBounds(277, 203, 66, 21);
		contentPane.add(this.txtDiscount);
		this.txtDiscount.setColumns(10);
		
		this.InputAirlineInfo = new JButton("录入航班信息");
		this.InputAirlineInfo.setBounds(40, 200, 143, 23);
		this.contentPane.add(this.InputAirlineInfo);
		this.InputAirlineInfo.addActionListener(this);

			
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals("录入航班信息")) {
				Airline airline = this.getAirline();
				File file=new File("航班信息.txt");
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter(file,true);
					fileWriter.write(airline.toString());
					fileWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "信息录入成功！");

			}
		}
	}
	
	public Airline getAirline() {
		return new Airline(this.txtFlightNum.getText(), this.txtTakeOffCity.getText(), 
				this.txtLandCity.getText(), this.txtStartTime.getText(),
				this.txtArriveTime.getText(), this.txtTicketPrice.getText(),
				this.txtDiscount.getText(), this.txtLeftTicket.getText());
	}
	

}
