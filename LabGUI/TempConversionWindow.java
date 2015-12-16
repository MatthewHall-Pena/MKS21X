import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversionWindow extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

    public TempConversionWindow() {
	this.setTitle("Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	JButton b = new JButton("CtoF");
	b.addActionListener(this);
	b.setActionCommand("CtoF");
	JButton b2 = new JButton("FtoC");
	b2.addActionListener(this);
	b2.setActionCommand("FtoC");


	t = new JTextField(10);

	j = new JLabel("The Converted Value is ");
	pane.add(t);
	pane.add(b);
	pane.add(b2);
	pane.add(j);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	String s = t.getText();
	if(event.equals("CtoF")){
	    j.setText(""+CtoF(Double.parseDouble( s)));
	}
	if(event.equals("FtoC")){
	    j.setText(""+FtoC(Double.parseDouble( s)));
  
	}
    }
    public static double FtoC(double t){
	return (t-32)*5/9.;
    }
    public static double CtoF(double t){
	return t*9/5+32;
    }
} 