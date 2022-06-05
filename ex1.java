import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ex1 extends JFrame implements ActionListener{
	static String[] arr = {
			"7","8","9","/",
			"4","5","6","*",
			"1","2", "3","-",
			"0",".","=","+"
			};
	static JButton[] btn = new JButton[16];
	static JLabel calc_txt;
	static JLabel result_txt;
	static JLabel state_txt;
	static ex1 mainActivity;
	static String total_data = "";
	
	public static void main(String[] args) {
		System.out.println("[GUI (awt/swing) - ÀÚ¹Ù °è»ê±â ]");
		
		mainActivity = new ex1();
		
		JFrame frm = new JFrame("ÀÚ¹Ù °è»ê±â");
		frm.setSize(400, 550);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setResizable(false);
		frm.getContentPane().setLayout(null);
		
		state_txt = new JLabel("state");
		state_txt.setBounds(0, 464, 400, 46);
		state_txt.setOpaque(true);
		state_txt.setBackground(Color.WHITE);
		state_txt.setForeground(Color.BLUE);
		state_txt.setFont(new Font("±½Àº µ¸¿ò", 0, 20));
		state_txt.setHorizontalAlignment(JLabel.CENTER);
		
		calc_txt = new JLabel("0");
		calc_txt.setBounds(0, 0, 400, 75);
		calc_txt.setOpaque(true);
		calc_txt.setBackground(Color.BLACK);
		calc_txt.setForeground(Color.WHITE);
		calc_txt.setFont(new Font("±½Àº µ¸¿ò", 0, 20));
		calc_txt.setHorizontalAlignment(JLabel.CENTER);
		
		result_txt = new JLabel("result");
		result_txt.setBounds(0, 75, 400, 50);
		result_txt.setOpaque(true);
		result_txt.setBackground(Color.GRAY);
		result_txt.setForeground(Color.WHITE);
		result_txt.setFont(new Font("±½Àº µ¸¿ò", 0, 20));
		result_txt.setHorizontalAlignment(JLabel.CENTER);
		
		JButton button = new JButton("CE");
		frm.add(button);
		button.setBounds(0, 125, 400, 50);
		button.setFont(new Font("±½Àº µ¸¿ò",0 ,20 ));
		button.setBackground(Color.white);
		button.setForeground(Color.black);
		button.addActionListener(mainActivity);
		
		JPanel grid_panel = new JPanel();
		grid_panel.setLayout(new GridLayout(4, 4, 0, 0));
						
		for(int idx=0; idx<arr.length; idx++) {
			btn[idx] = new JButton(arr[idx]);
			btn[idx].setFont(new Font("±½Àº µ¸¿ò", 0, 20));
			if(arr[idx].contains("*") || arr[idx].contains("/") || 
					arr[idx].contains("+") || arr[idx].contains("-")) {
				btn[idx].setBackground(Color.white);
			}
			else {
				btn[idx].setBackground(Color.white);
			}			
			btn[idx].setForeground(Color.black);
			btn[idx].addActionListener(mainActivity);
			
			grid_panel.add(btn[idx]);	
		}
		grid_panel.setBounds(0, 175, 385, 288);
		frm.getContentPane().add(calc_txt);
		frm.getContentPane().add(result_txt);
		frm.getContentPane().add(state_txt);
		frm.getContentPane().add(grid_panel);
		frm.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		
		case "0": 
			total_data += "0";
			calc_txt.setText(total_data); 
			break;
			
		case "1": 
			total_data += "1";
			calc_txt.setText(total_data); 
			break;
			
		case "2": 
			total_data += "2";
			calc_txt.setText(total_data);		
			break;
			
		case "3": 
			total_data += "3";
			calc_txt.setText(total_data);
			break;	
			
		case "4": 
			total_data += "4";
			calc_txt.setText(total_data);
			break;	
			
		case "5": 
			total_data += "5";
			calc_txt.setText(total_data); 
			break;
			
		case "6": 
			total_data += "6";
			calc_txt.setText(total_data); 
			break;	
			
		case "7": 
			total_data += "7";
			calc_txt.setText(total_data); 
			break;	
			
		case "8": 
			total_data += "8";
			calc_txt.setText(total_data); 
			break;		
			
		case "9": 
			total_data += "9";
			calc_txt.setText(total_data); 
			break;		
		
		case "*": 
			total_data += "*";
			calc_txt.setText(total_data); 
			break;		
			
		case "/": 
			total_data += "/";
			calc_txt.setText(total_data); 
			break;
			
		case "+": 
			total_data += "+";
			calc_txt.setText(total_data); 
			break;
			
		case "-": 
			total_data += "-";
			calc_txt.setText(total_data); 
			break;
			
		case "CE":
			total_data = "";
			calc_txt.setText("0"); 
			result_txt.setText("result"); 
			break;
			
		case ".":
			if(total_data != "." &&! total_data.contains(".")) {
				total_data += ".";
				calc_txt.setText(total_data);
			}
			else {
				result_txt.setText("result");	
			}			
			break;
			
		case "=": 
			if(total_data != null && total_data.length() > 0) {
				int data = calc(total_data);
				result_txt.setText(String.valueOf(data));
			}
			else {
				result_txt.setText("result");	
			}
			break;
			
		default :
			calc_txt.setText("error"); 
			break;
		}
	}
	
	public static int calc(String input) { 
		int idx; 		
		idx = input.indexOf('+');
					
		if (idx != -1) {
			return calc(input.substring(0, idx)) + calc(input.substring(idx + 1)); 
		} 
		else {
			idx = input.indexOf('-'); 
			if (idx != -1) { 
				return calc(input.substring(0, idx)) - calc(input.substring(idx + 1));
			} 
			else {
				idx = input.indexOf('*'); 
				if (idx != -1) {
					return calc(input.substring(0, idx)) * calc(input.substring(idx + 1)); 
				} 
				else { 
					idx = input.indexOf('/'); 
					if (idx != -1) { 
						return calc(input.substring(0, idx)) / calc(input.substring(idx + 1));
					} 
					else {
						idx = input.indexOf('.'); 
						if (idx != -1) {
							return calc(input.substring(0, idx)) / calc(input.substring(idx + 1));
						}
					}
				} 
			} 
		}
		String data = input.trim();
		if (data == null || data.isEmpty()) {
			return 0;
		}   			
		return Integer.parseInt(data); 
	} 
}