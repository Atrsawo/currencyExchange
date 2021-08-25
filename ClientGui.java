import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;



/*
 * this class operate the GUI for the client 
 */
public class ClientGui extends JFrame implements ActionListener {

	private JTextArea get, show;
	private JComboBox coin1, coin2;
	private JLabel l1, l2;
	private JButton b;
	private Request r ;
	
	public  ClientGui()
	{
		r = new Request(0,"","");
		handleGui();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == coin1) {
			JComboBox c =  (JComboBox)e.getSource();
			Comp comp = (Comp) c.getSelectedItem();
			r.setFrom(comp.toString());
			}
		else if(e.getSource() == coin2) {
			JComboBox c =  (JComboBox)e.getSource();
			Comp comp = (Comp) c.getSelectedItem();
			r.setTo(comp.toString());
			}
		else if(e.getSource() == b) {
			double d = parseDouble(get.getText());
			r.setNum(d);
			new client(this, "127.0.0.1",r).start();
		}
	}
	
	//this method convert form string to double
	private double parseDouble(String text) {
		int i = 0;
		double temp = 0;
	
		while(i < text.length() && text.charAt(i) != '.')
		{
			i++;
		}
		
		temp = Integer.parseInt(text.substring(0, i));
		
		if(i<text.length() && text.charAt(i) == '.')
		{
			i++;
			String s  = text.substring(i, text.length());
			temp += (double)Integer.parseInt(s)/Math.pow(10,s.length()); 
		}
		
		return temp;
	}


	public static void main(String[] args) {
		new ClientGui();
	}
//method to handle the cleint GUI
	private void handleGui() {
			setLayout(new GridLayout(7,1));
			get = new JTextArea();
			show = new JTextArea();
			l1 = new JLabel("   convert ");
			l2 = new JLabel("to");
			b = new JButton("Convert");
			
			coin1 = new JComboBox();
			coin1.addItem(new Comp("Choose coin"));
			coin1.addItem(new Comp("NIS"));
			coin1.addItem(new Comp("$"));
			coin1.addItem(new Comp("Euro"));
			coin1.addItem(new Comp("pound sterling"));
			coin1.addItem(new Comp("Bir"));
			coin1.addActionListener(this);
		     
			coin2 = new JComboBox();
			coin2.addItem(new Comp("Choose coin"));
			coin2.addItem(new Comp("NIS"));
			coin2.addItem(new Comp("$"));
			coin2.addItem(new Comp("Euro"));
			coin2.addItem(new Comp("pound sterling"));
			coin2.addItem(new Comp("Bir"));
			coin2.addActionListener(this);
			
			
			coin1.addActionListener(this);
			coin2.addActionListener(this);
			b.addActionListener(this);
			
			add(l1);
			add(get);
			add(coin1);
			add(l2);
			add(coin2);
			add(show);
			add(b);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400,400);
			setVisible(true);
	}
	
	// class compound for Jcombox items
	private class Comp {
		
        private String compData;

        public Comp(String s) {
            this.compData= s;
        }
        @Override
        public String toString() {
            return compData;
        }
        
	}
	
	// method to set the converted number
	public void setConvertedNum(double val)
	{
		show.setText(val+"");
	}

}
