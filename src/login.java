import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class login extends JFrame implements ActionListener,ItemListener
{
JLabel l1,l2,l3;
JTextField tf1;
JPasswordField pf1;
JButton b1,b2,b3;
JComboBox bx1;
Connection con;
Statement stm;
Container con1=getContentPane();
ImageIcon mg=new ImageIcon("beti.jpg");

JLabel j0=new JLabel(mg);
ImageIcon mg1=new ImageIcon("dummy1.png");
JLabel j1=new JLabel(mg1);
login()
{
setSize(400,300);
con1.setBackground(Color.gray);
setLayout(null);
setTitle("Log In");
setExtendedState(JFrame.MAXIMIZED_BOTH);

l1=new JLabel("User Type");
l2=new JLabel("User Id");
l3=new JLabel("Password");

tf1=new JTextField(30);
pf1=new JPasswordField(30);

bx1=new JComboBox();

b1=new JButton("Log In");
b2=new JButton("Forgot Password..?");
b3=new JButton("Reset");

l1.setFont(new Font("Segoe Script",Font.BOLD,25));
l2.setFont(new Font("Segoe Script",Font.BOLD,25));
l3.setFont(new Font("Segoe Script",Font.BOLD,25));

l1.setForeground(Color.white);
l2.setForeground(Color.white);
l3.setForeground(Color.white);

b1.setFont(new Font("Segoe Script",Font.BOLD,20));
b2.setFont(new Font("Segoe Script",Font.BOLD,20));
b3.setFont(new Font("Segoe Script",Font.BOLD,20));


bx1.setFont(new Font("Segoe Script",Font.BOLD,20));
bx1.addItem("Select Type");
bx1.addItem("Admin");
bx1.addItem("Accountant");
bx1.addItem("Faculty");

add(l1);
add(l2);
add(l3);
add(tf1);
add(pf1);
add(bx1);
add(b1);
add(b2);
add(b3);

j0.setBounds(0,0,1370,750);
l1.setBounds(500,400,150,30);
bx1.setBounds(500,435,300,30);
l2.setBounds(500,475,150,30);
tf1.setBounds(500,510,300,30);
l3.setBounds(500,550,150,30);
pf1.setBounds(500,585,300,30);
b1.setBounds(500,625,145,30);
b3.setBounds(655,625,145,30);
b2.setBounds(500,670,300,30);
j1.setBounds(525,130,250,250);
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


b1.addActionListener(this);
b3.addActionListener(this);
b2.addActionListener(this);
bx1.addItemListener(this);

add(j1);
add(j0);
setVisible(true);
}
String check="";
public void itemStateChanged(ItemEvent ie)
{
if(ie.getSource()==bx1)
{
check=bx1.getSelectedItem().toString();
}
}

public void actionPerformed(ActionEvent ae)
{
int asd=0;
try
{

if(ae.getSource()==b3)
{
tf1.setText("");
pf1.setText("");
bx1.setSelectedIndex(0);
}

if(ae.getSource()==b1)
{

if(check.equals("Admin"))
{
ResultSet rs0=stm.executeQuery("select * from admin where user_id='"+tf1.getText()+"'");
if(rs0.next())
{
if(rs0.getString(2).equals(pf1.getText()))
{
ResultSet rs=stm.executeQuery("select * from set_security where user_id='"+tf1.getText()+"'");
if(!(rs.next()))
new set_security(tf1.getText(),1);
else
new admin_window(tf1.getText());
this.dispose();
}
else 
JOptionPane.showMessageDialog(this,"Incoreect Possword");
}
else 
JOptionPane.showMessageDialog(this,"Incorrect Admin Id");
}

else if(check.equals("Accountant"))
{
ResultSet rs=stm.executeQuery("select user_id from employee_data where email='"+tf1.getText()+"' and etitle='Accountant'");
if(rs.next())
{
ResultSet rs1=stm.executeQuery("select password from employee_data where user_id='"+tf1.getText()+"'");
if(rs1.next())
{
if(rs1.getString(1).equals(pf1.getText()))
{
ResultSet rs00=stm.executeQuery("select * from set_security where user_id='"+tf1.getText()+"'");
if(!(rs00.next()))
new set_security(tf1.getText(),bx1.getSelectedIndex());
else 
new accountant_window(tf1.getText());
this.dispose();
}
else
JOptionPane.showMessageDialog(this,"You Entered A Wrong Password");
}
}
else
JOptionPane.showMessageDialog(this,"User Not Found");
}

else if(check.equals("Faculty"))
{
ResultSet rs=stm.executeQuery("select user_id from employee_data where email='"+tf1.getText()+"' and etitle='Faculty'");
if(rs.next())
{
ResultSet rs1=stm.executeQuery("select password from employee_data where user_id='"+tf1.getText()+"'");
if(rs1.next())
{
if(rs1.getString(1).equals(pf1.getText()))
{
ResultSet rs00=stm.executeQuery("select * from set_security where user_id='"+tf1.getText()+"'");
if(!(rs00.next()))
new set_security(tf1.getText(),bx1.getSelectedIndex());
else 
new faculty_window(tf1.getText());
this.dispose();
}
else
JOptionPane.showMessageDialog(this,"You Entered A Wrong Password");
}
}
else
JOptionPane.showMessageDialog(this,"User Not Found");
}

}

if(ae.getSource()==b2)
{
ResultSet rs=stm.executeQuery("select * from set_security where user_id='"+tf1.getText()+"'");
if(rs.next())
{
new forgot_password(tf1.getText(),bx1.getSelectedIndex());
this.dispose();
}
else 
JOptionPane.showMessageDialog(this,"Record Not Found");
}

}
catch(Exception e)
{
//System.out.println(e);
e.printStackTrace();
}
}
public static void main(String op[])
{
new login();
}
}