package NEW;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class changeAirline extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;
	public changeAirline()
	{
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入要修改信息的航班号：");
		lblNewLabel.setBounds(24, 39, 162, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("修改内容：");
		lblNewLabel_1.setBounds(24, 75, 100, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("出发城市");
		lblNewLabel_2.setBounds(21, 118, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("到达城市");
		lblNewLabel_3.setBounds(24, 151, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("出发时间");
		lblNewLabel_4.setBounds(24, 189, 58, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("到达时间");
		lblNewLabel_5.setBounds(21, 222, 58, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("票价");
		lblNewLabel_6.setBounds(233, 118, 58, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("余票数");
		lblNewLabel_7.setBounds(233, 153, 58, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("折扣");
		lblNewLabel_8.setBounds(234, 195, 58, 15);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField("");
		textField.setBounds(93, 114, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("");
		textField_1.setBounds(94, 148, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("");
		textField_2.setBounds(94, 188, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField("");
		textField_3.setBounds(95, 222, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField("");
		textField_4.setBounds(286, 115, 66, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField("");
		textField_5.setBounds(283, 154, 66, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField("");
		textField_6.setBounds(285, 195, 66, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField("");
		textField_7.setBounds(190, 36, 66, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		this.btnNewButton = new JButton("修改");//修改
		btnNewButton.setBounds(191, 232, 97, 23);
		contentPane.add(btnNewButton);
		this.btnNewButton .addActionListener(this);
		
		
		JLabel lblNewLabel_9 = new JLabel("修改界面");
		lblNewLabel_9.setBounds(190, 0, 58, 15);
		contentPane.add(lblNewLabel_9);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals("修改")) {
				ArrayList<Airline> airlines = new ArrayList<Airline>();
				Reader reader;
				try {
					reader = new FileReader("航班信息.txt");
					BufferedReader bufrd = new BufferedReader(reader);	    
					String line;
					while((line = bufrd.readLine()) != null) {
						String[] datas = line.trim().split(" ");
						Airline airline = new Airline(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[6], datas[7]);
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
				
				//找到对应的航班更新信息
				Airline newAirline = this.getAirline();
				for(int i = 0; i < airlines.size(); i++) {
					Airline airline = airlines.get(i);
					if(airline.flightNum.equals(newAirline.flightNum)){
						airlines.set(i, newAirline);
						break;
					}
				}
				
				//重新写入
				File file=new File("航班信息.txt");
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter(file,false);
					for(Airline airline: airlines)
						fileWriter.write(airline.toString());
					fileWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "成功修改航班信息！");
				
			}
		}
	}
	
	public Airline getAirline() {
		return new Airline(this.textField_7.getText(), this.textField.getText(), 
				this.textField_1.getText(), this.textField_2.getText(),
				this.textField_3.getText(), this.textField_4.getText(),
				this.textField_6.getText(), this.textField_5.getText());
	}

}
