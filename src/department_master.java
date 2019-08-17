import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class department_master extends JInternalFrame implements ActionListener,ItemListener,FocusListener
{
JLabel l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2,tf3,tf4,tf5;
JButton b1,b2,b3;
JComboBox bx1;
Connection con;
Statement stm;
ImageIcon mg1=new ImageIcon("dep.jpg");
JLabel j2=new JLabel(mg1);
department_master()
{
super("Department Master",true,true,true,true);

setLayout(null);
setSize(1000,1000);


l1=new JLabel("Department Master");
l2=new JLabel("Department Name");
l3=new JLabel("Department Code");
l4=new JLabel("Fees Per Semester");
l5=new JLabel("Number Of Seats");
l6=new JLabel("Vacant Seats");

l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));
l6.setFont(new Font("Segoe Script",Font.BOLD,20));

tf1=new JTextField(50);
tf2=new JTextField(50);
tf3=new JTextField(50);
tf4=new JTextField(50);
tf5=new JTextField(50);


tf1.setFont(new Font("Times New Roman",Font.BOLD,15));
tf2.setFont(new Font("Times New Roman",Font.BOLD,15));
tf3.setFont(new Font("Times New Roman",Font.BOLD,15));
tf4.setFont(new Font("Times New Roman",Font.BOLD,15));
tf5.setFont(new Font("Times New Roman",Font.BOLD,15));


b1=new JButton("Add New");
b2=new JButton("Submit");
b3=new JButton("Modify");

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));
b3.setFont(new Font("Segoe Script",Font.BOLD,25));

bx1=new JComboBox();
bx1.addItem("Find");
bx1.setFont(new Font("Segoe Script",Font.BOLD,20));


add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);


add(tf1);
add(tf2);
add(tf3);
add(tf4);
add(tf5);


add(b1);
add(b2);
add(b3);
add(bx1);

j2.setBounds(0,0,1370,750);
l1.setBounds(500,20,400,30);
l2.setBounds(500,90,200,20);
tf1.setBounds(500,115,300,30);
l3.setBounds(500,155,200,20);
tf2.setBounds(500,180,300,30);
l4.setBounds(500,220,200,20);
tf3.setBounds(500,245,300,30);
l5.setBounds(500,285,200,20);
tf4.setBounds(500,310,300,30);
l6.setBounds(500,350,200,20);
tf5.setBounds(500,375,300,30);
b1.setBounds(400,420,170,30);
b2.setBounds(580,420,150,30);
b3.setBounds(740,420,150,30);
bx1.setBounds(550,470,150,30);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
bx1.addItemListener(this);
tf4.addFocusListener(this);

tf1.setEditable(false);
tf2.setEditable(false);
tf3.setEditable(false);
tf4.setEditable(false);
tf5.setEditable(false);

b2.setEnabled(false);
b3.setEnabled(false);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();

ResultSet rs=stm.executeQuery("select department_code from department_master");
while(rs.next())
{
bx1.addItem(rs.getString(1));
}
}
catch(Exception e)
{
System.out.println(e);
}


add(j2);


setVisible(true);
}


public static void main(String pl[])
{
new department_master();
}
public void focusGained(FocusEvent fe)
{}
public void focusLost(FocusEvent fe)
{
if(fe.getSource()==tf4)
{
tf5.setText(tf4.getText());
}
}

public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b2)
{
ResultSet rs=stm.executeQuery("select * from department_master where department_name= '"+tf1.getText()+"' or department_code='"+tf2.getText()+"'");
if(rs.next())
{
JOptionPane.showMessageDialog(this,"Department Already Exist");
}
else
{
if(!(validation.checkString(tf1.getText())))
JOptionPane.showMessageDialog(this,"Please Enter A Valid Department Name");

else
{
String s1="insert into department_master values( '"+tf1.getText()+"' , '"+tf2.getText()+"' ,"+Integer.parseInt(tf3.getText())+", "+Integer.parseInt(tf4.getText())+", "+tf5.getText()+")";
stm.executeUpdate(s1);
bx1.addItem(tf2.getText());
JOptionPane.showMessageDialog(this,"Successfully Submitted");
}
}
}
if(ae.getSource()==b1)
{
tf1.setEditable(true);
tf2.setEditable(true);
tf3.setEditable(true);
tf4.setEditable(true);
tf1.setText("");
tf2.setText("");
tf3.setText("");
tf4.setText("");
tf5.setText("");
b2.setEnabled(true);
b3.setEnabled(false);
}
if(ae.getSource()==b3)
{
String s1="update department_master set sem_fee="+Integer.parseInt(tf3.getText())+", no_of_seats="+Integer.parseInt(tf4.getText())+", vacant_seats="+tf5.getText()+" where department_name='"+tf1.getText()+"'";
stm.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"successfully modified");
}

}
catch(NumberFormatException ne)
{
JOptionPane.showMessageDialog(this,"Please Input Data Correctly");
}
catch(Exception e)
{
System.out.println(e);
}
}
public void itemStateChanged(ItemEvent ie)
{
tf3.setEditable(true);
tf4.setEditable(true);
try
{
if(ie.getSource()==bx1 && ie.getStateChange()==ItemEvent.SELECTED)
{
ResultSet rs=stm.executeQuery("select * from department_master where department_code='"+bx1.getSelectedItem()+"'");
while(rs.next())
{
tf1.setText(rs.getString(1));
tf2.setText(rs.getString(2));
tf3.setText(rs.getString(3));
tf4.setText(rs.getString(4));
tf5.setText(rs.getString(5));
b3.setEnabled(true);
tf1.setEditable(false);
tf2.setEditable(false);
}
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}