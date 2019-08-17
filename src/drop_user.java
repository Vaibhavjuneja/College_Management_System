import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class drop_user extends JInternalFrame implements ActionListener,FocusListener
{
JLabel l1,l2,l3,l4;
JComboBox bx1;
JTextField tf1;
JButton b1;
Connection con;
Statement stm;
ImageIcon mg=new ImageIcon("bye.jpg");
JLabel j0=new JLabel(mg);
drop_user()
{
super("Drop User",true,true,true,true);
setSize(1000,1000);
setLayout(null);


l1=new JLabel("Drop User");
l2=new JLabel("User Type");
l3=new JLabel("User Id");
l4=new JLabel("(Press Tab)");


l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,15));

bx1=new JComboBox();
bx1.setFont(new Font("Segoe Script",Font.BOLD,25));

tf1=new JTextField(50);
tf1.setFont(new Font("Times New Roman",Font.BOLD,15));

b1=new JButton("Drop");
b1.setFont(new Font("Segoe Script",Font.BOLD,25));

bx1.addItem("Select User Type");
bx1.addItem("Employee");
bx1.addItem("Student");


add(l1);
add(l2);
add(l3);
add(l4);


add(bx1);
add(tf1);
add(b1);

j0.setBounds(0,0,1370,750);
l1.setBounds(500,20,400,30);
l2.setBounds(450,90,200,20);
bx1.setBounds(450,115,300,30);
l3.setBounds(450,160,200,20);
tf1.setBounds(450,185,300,30);
b1.setBounds(550,230,100,30);
l4.setBounds(750,185,300,15);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
}
catch(Exception e)
{
System.out.println(e);
}


b1.setEnabled(false);
b1.addActionListener(this);
tf1.addFocusListener(this);

add(j0);

setVisible(true);
}

public void focusGained(FocusEvent fe)
{}
public void focusLost(FocusEvent fe)
{
try
{
if(fe.getSource()==tf1)
{

if(bx1.getSelectedIndex()==1)
{
ResultSet rs=stm.executeQuery("select * from employee_data where user_id='"+tf1.getText()+"'");
if(rs.next())
b1.setEnabled(true);
else
JOptionPane.showMessageDialog(this,"User Doesn't Exist");
}


else if(bx1.getSelectedIndex()==2)
{
ResultSet rs0=stm.executeQuery("select * from student_data where user_id='"+tf1.getText()+"'");
if(rs0.next())
b1.setEnabled(true);
else 
JOptionPane.showMessageDialog(this,"User Not Found");
}

else 
{
JOptionPane.showMessageDialog(this,"Please Select User Type First And Then Enter User Id");
b1.setEnabled(false);
tf1.setText("");
}


}
}
catch(Exception e)
{
System.out.println(e);
}
}

public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b1)
{
if(bx1.getSelectedIndex()==1)
{
String sd="delete from employee_data where user_id='"+tf1.getText()+"'";
stm.executeUpdate(sd);
JOptionPane.showMessageDialog(this,"Successfull");
}

else if(bx1.getSelectedIndex()==2)
{
String sd="delete from student_data where user_id='"+tf1.getText()+"'";
stm.executeUpdate(sd);
JOptionPane.showMessageDialog(this,"Successfull");
}
bx1.setSelectedIndex(0);
tf1.setText("");
b1.setEnabled(false);
}
}
catch(Exception e)
{
System.out.println(e);
}

}

public static void main(String kj[])
{
new drop_user();
}
}





