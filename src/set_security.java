import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class set_security extends JDialog implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
JButton b1;
Connection con;
Statement stm;
Container con1=getContentPane();
String user1="";
ImageIcon mg1=new ImageIcon("security.jpg");
String user="";
int ty=0;
JLabel j2=new JLabel(mg1);
set_security(String df,int jkl)
{
user=df;
ty=jkl;

setLayout(null);
setSize(1000,500);
setTitle("Set Security");
JOptionPane.showMessageDialog(this,"You Have To Answer Three Given Questions And This Will Help You In Resetting Password If Ever You Forgot Your Password");
l1=new JLabel("You Have To Answer Three Given Questions And This Will Help You In Resetting Password If Ever You Forgot Your Password");
l2=new JLabel("Question 1");
l3=new JLabel("Question 2");
l4=new JLabel("Question 3");
l5=new JLabel("Answer 1");
l6=new JLabel("Answer 2");
l7=new JLabel("Answer 3");



tf1=new JTextField(30);
tf2=new JTextField(30);
tf3=new JTextField(30);
tf4=new JTextField(30);
tf5=new JTextField(30);
tf6=new JTextField(30);

tf1.setOpaque(false);
tf2.setOpaque(false);
tf3.setOpaque(false);
tf4.setOpaque(false);
tf5.setOpaque(false);
tf6.setOpaque(false);

tf1.setForeground(Color.white);
tf2.setForeground(Color.white);
tf3.setForeground(Color.white);
tf4.setForeground(Color.white);
tf5.setForeground(Color.white);
tf6.setForeground(Color.white);


tf1.setFont(new Font("Times New Roman",Font.BOLD,15));
tf2.setFont(new Font("Times New Roman",Font.BOLD,15));
tf3.setFont(new Font("Times New Roman",Font.BOLD,15));
tf4.setFont(new Font("Times New Roman",Font.BOLD,15));
tf5.setFont(new Font("Times New Roman",Font.BOLD,15));
tf6.setFont(new Font("Times New Roman",Font.BOLD,15));





tf1.setEditable(false);
tf2.setEditable(false);
tf3.setEditable(false);




b1=new JButton("Save");

l1.setFont(new Font("Segoe Script",Font.BOLD,20));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));
l6.setFont(new Font("Segoe Script",Font.BOLD,20));
l7.setFont(new Font("Segoe Script",Font.BOLD,20));


l1.setForeground(Color.white);
l2.setForeground(Color.white);
l3.setForeground(Color.white);
l4.setForeground(Color.white);
l5.setForeground(Color.white);
l6.setForeground(Color.white);
l7.setForeground(Color.white);



b1.setFont(new Font("Segoe Script",Font.BOLD,20));


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


add(b1);

j2.setBounds(0,0,1000,550);
l2.setBounds(40,60,150,20);
tf1.setBounds(190,60,500,30);
l5.setBounds(40,100,150,20);
tf4.setBounds(190,100,500,30);
l3.setBounds(40,160,150,20);
tf2.setBounds(190,160,500,30);
l6.setBounds(40,200,150,20);
tf5.setBounds(190,200,500,30);
l4.setBounds(40,260,150,20);
tf3.setBounds(190,260,500,30);
l7.setBounds(40,300,150,20);
tf6.setBounds(190,300,500,30);
b1.setBounds(300,400,100,25);


tf1.setText("What Is Your Birth Place");
tf2.setText("What is Your Adhaar Number");
tf3.setText("Which Was Your Education School");

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
add(j2); 

setVisible(true);
}
int g=0;

public void actionPerformed(ActionEvent ae)
{
int count=0;
try
{
if(ae.getSource()==b1)
{
if((tf4.getText().equals(""))||(tf5.getText().equals(""))||(tf6.getText().equals("")))
{
count=2;
JOptionPane.showMessageDialog(this,"Please Answer The Questions ");
}
else if(!(validation.checkAdhaarNumber(tf5.getText())))
{
count=1;
JOptionPane.showMessageDialog(this,"Please Enter A Valid Adhaar Number");
}
if(count==0)
{
String s1="insert into set_security values('"+user+"', '"+tf4.getText()+"' , '"+tf5.getText()+"' , '"+tf6.getText()+"' )";
stm.executeUpdate(s1);
if(ty==1)
new admin_window(user);
else if(ty==2)
{
new accountant_window(user);
this.dispose();
}
else if(ty==3)
{
new faculty_window(user);
this.dispose();
}
}
}
}
catch(Exception e)
{
System.out.println(e);
}
}
public static void main(String lk[])
{
new set_security("",0);
}
}

