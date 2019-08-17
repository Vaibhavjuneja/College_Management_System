import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class hostel_mass extends JFrame implements ActionListener
{
JLabel l0,l1,l2,l3,l4,l5,l6,l7;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,tf20,tf21,tf22;
JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9;
JButton b1;
Connection con;
Statement stm;
hostel_mass()
{
setSize(1000,1000);
setExtendedState(JFrame.MAXIMIZED_BOTH);
setLayout(null);

l0=new JLabel("Hostel Master");
l1=new JLabel("Hostel Name");
l2=new JLabel("Hostel Code");
l3=new JLabel("Total No Of Rooms");
l4=new JLabel("Select Types Of Rooms In Your Hostel");
l5=new JLabel("Total No Of Blocks");
l6=new JLabel("Fees");
l7=new JLabel("Total No Of Floors");

b1=new JButton("Save");
b1.setFont(new Font("Segoe Script",Font.BOLD,25));

l0.setFont(new Font("Segoe Script",Font.BOLD,40));
l1.setFont(new Font("Segoe Script",Font.BOLD,25));
l2.setFont(new Font("Segoe Script",Font.BOLD,25));
l3.setFont(new Font("Segoe Script",Font.BOLD,25));
l4.setFont(new Font("Segoe Script",Font.BOLD,25));
l5.setFont(new Font("Segoe Script",Font.BOLD,25));
l6.setFont(new Font("Segoe Script",Font.BOLD,25));
l7.setFont(new Font("Segoe Script",Font.BOLD,25));


tf1=new JTextField(50);
tf2=new JTextField(50);
tf3=new JTextField(50);
tf4=new JTextField(50);
tf5=new JTextField(50);
tf6=new JTextField(50);
tf7=new JTextField(50);
tf8=new JTextField(50);
tf9=new JTextField(50);
tf10=new JTextField(50);
tf11=new JTextField(50);
tf12=new JTextField(50);
tf13=new JTextField(50);
tf14=new JTextField(50);
tf15=new JTextField(50);
tf16=new JTextField(50);
tf17=new JTextField(50);
tf18=new JTextField(50);
tf19=new JTextField(50);
tf20=new JTextField(50);
tf21=new JTextField(50);
tf22=new JTextField(50);



cb1=new JCheckBox("Single Seater Non Ac");
cb2=new JCheckBox("Double Seater Non Ac");
cb3=new JCheckBox("Triple Seater Non Ac");
cb4=new JCheckBox("Four Seater Non Ac");
cb5=new JCheckBox("Single Seater  Ac");
cb6=new JCheckBox("Double Seater Ac");
cb7=new JCheckBox("Triple Seater Ac");
cb8=new JCheckBox("Four Seater Ac");


cb1.setFont(new Font("Segoe Script",Font.BOLD,20));
cb2.setFont(new Font("Segoe Script",Font.BOLD,20));
cb3.setFont(new Font("Segoe Script",Font.BOLD,20));
cb4.setFont(new Font("Segoe Script",Font.BOLD,20));
cb5.setFont(new Font("Segoe Script",Font.BOLD,20));
cb6.setFont(new Font("Segoe Script",Font.BOLD,20));
cb7.setFont(new Font("Segoe Script",Font.BOLD,20));
cb8.setFont(new Font("Segoe Script",Font.BOLD,20));

add(l0);
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);

add(tf1);
add(tf2);
add(tf3);
add(tf4);
add(tf5);
add(tf6);
add(tf7);
add(tf8);
add(tf9);
add(tf10);
add(tf11);
add(tf12);
add(tf13);
add(tf14);
add(tf15);
add(tf16);
add(tf17);
add(tf18);
add(tf19);
add(tf20);
add(tf21);
add(tf22);

add(cb1);
add(cb2);
add(cb3);
add(cb4);
add(cb5);
add(cb6);
add(cb7);
add(cb8);

add(b1);

l0.setBounds(10,20,400,50);
l1.setBounds(10,80,200,30);
tf1.setBounds(10,115,300,30);
l2.setBounds(10,145,200,30);
tf2.setBounds(10,175,300,30);
l3.setBounds(10,215,300,30);
tf3.setBounds(10,250,300,30);
l5.setBounds(10,290,300,30);
tf13.setBounds(10,325,300,30);
l7.setBounds(10,375,300,30);
tf22.setBounds(10,410,300,30);
l4.setBounds(600,80,500,30);
l6.setBounds(950,130,100,30);
cb1.setBounds(500,170,400,30);
tf14.setBounds(900,170,200,30);
cb2.setBounds(500,210,400,30);
tf15.setBounds(900,210,200,30);
cb3.setBounds(500,250,400,30);
tf16.setBounds(900,250,200,30);
cb4.setBounds(500,290,400,30);
tf17.setBounds(900,290,200,30);
cb5.setBounds(500,330,400,30);
tf18.setBounds(900,330,200,30);
cb6.setBounds(500,370,400,30);
tf19.setBounds(900,370,200,30);
cb7.setBounds(500,410,400,30);
tf20.setBounds(900,410,200,30);
cb8.setBounds(500,450,400,30);
tf21.setBounds(900,450,200,30);
b1.setBounds(750,550,100,30);

tf14.setText(String.valueOf(0));
tf15.setText(String.valueOf(0));
tf16.setText(String.valueOf(0));
tf17.setText(String.valueOf(0));
tf18.setText(String.valueOf(0));
tf19.setText(String.valueOf(0));
tf20.setText(String.valueOf(0));
tf21.setText(String.valueOf(0));


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
}
catch(Exception e)
{
e.printStackTrace();
}


b1.addActionListener(this);
setVisible(true);
}


public void actionPerformed(ActionEvent ae)
{
int count=0;
try
{
if(ae.getSource()==b1)
{
if((tf1.getText().equals(""))||(tf2.getText().equals(""))||(tf3.getText().equals(""))||(tf13.getText().equals("")))
{
count=1;
JOptionPane.showMessageDialog(this,"Kindly Enter All The Fields");
}
if(!((cb1.isSelected())||(cb2.isSelected())||(cb3.isSelected())||(cb4.isSelected())||(cb5.isSelected())||(cb6.isSelected())||(cb7.isSelected())||(cb8.isSelected())))
{
count=2;
JOptionPane.showMessageDialog(this,"Kindly Select A Room Type");
}

if(count==0)
{
String si="insert into hostel_mass values('"+tf1.getText()+"' , '"+tf2.getText()+"' , "+Integer.parseInt(tf3.getText())+" ,  "+Integer.parseInt(tf13.getText())+" ,"+Integer.parseInt(tf14.getText())+" , "+Integer.parseInt(tf15.getText())+" , "+Integer.parseInt(tf16.getText())+" , "+Integer.parseInt(tf17.getText())+" , "+Integer.parseInt(tf18.getText())+" , "+Integer.parseInt(tf19.getText())+" , "+Integer.parseInt(tf20.getText())+" , "+Integer.parseInt(tf21.getText())+","+Integer.parseInt(tf22.getText())+")";
stm.executeUpdate(si);
JOptionPane.showMessageDialog(this,"Successfully Saved");
}

}
}
catch(NumberFormatException ne)
{
ne.printStackTrace();
JOptionPane.showMessageDialog(this,"Kindly Enter Data According To Formats");
}
catch(Exception e)
{
e.printStackTrace();
}
}


public static void main(String op[])
{
new hostel_mass();

}


}