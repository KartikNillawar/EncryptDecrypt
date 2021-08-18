import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ImageOperation {
	public static void Operation(int key)
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		//file input stream reader
		try {
			FileInputStream fis = new FileInputStream(file);
			byte []data = new byte[fis.available()];
			fis.read(data);
			int i = 0;
			for(byte b:data)
			{
				System.out.println(b);
				data[i] = (byte) (b^key);
				i++;
			}
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null,"Done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//GUI
		JFrame f = new JFrame();
		f.setTitle("Encryption/Decryption");
		f.setSize(300,250);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Roboto",Font.BOLD,25);
		
		//Creating Button
		JButton button = new JButton();
		button.setText("Open Image");
		button.setFont(font);
		
		//creating text field
		JTextField textField = new JTextField(10);
		textField.setFont(font);
		f.setLayout(new FlowLayout());
		
		//Listener
		//Listener
		button.addActionListener(e->{
			System.out.println("hii");
			String text = textField.getText();
			int temp = Integer.parseInt(text);
			Operation(temp);
		});
		
		f.add(button);
		f.add(textField);
		
		f.setVisible(true);
		
		
	}

}
