import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class forgot_password extends JDialog implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField tf1,tf2,tf3,tf4,tf5,tf6;
JButton b1,b2,b3,b4;
Container con1=getContentPane();
ImageIcon mg1=new ImageIcon("forgot.jpg");
JLabel j2=new JLabel(mg1);
String user="";
Connection con;
Statement stm;
int index=0;
forgot_password(String us,int op)
{
user=us;
index=op;
setLayout(null);
setSize(1000,500);
setTitle("Forgot Password");

l1=new JLabel("You Have To Answer Three Questions To Reset Password");
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


tf1.setFont(new Font("Times New Roman",Font.BOLD,15));
tf2.setFont(new Font("Times New Roman",Font.BOLD,15));
tf3.setFont(new Font("Times New Roman",Font.BOLD,15));
tf4.setFont(new Font("Times New Roman",Font.BOLD,15));
tf5.setFont(new Font("Times New Roman",Font.BOLD,15));
tf6.setFont(new Font("Times New Roman",Font.BOLD,15));


tf1.setEditable(false);
tf2.setEditable(false);
tf3.setEditable(false);




b1=new JButton("Check");
b2=new JButton("Back");

l1.setFont(new Font("Segoe Script",Font.BOLD,20));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));
l6.setFont(new Font("Segoe Script",Font.BOLD,20));
l7.setFont(new Font("Segoe Script",Font.BOLD,20));




b1.setFont(new Font("Segoe Script",Font.BOLD,20));
b2.setFont(new Font("Segoe Script",Font.BOLD,20));


add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);

tf1.setOpaque(false);
tf2.setOpaque(false);
tf3.setOpaque(false);
tf4.setOpaque(false);
tf5.setOpaque(false);
tf6.setOpaque(false);

add(tf1);
add(tf2);
add(tf3);
add(tf4);
add(tf5);
add(tf6);

add(b1);
add(b2);

j2.setBounds(0,0,1000,500);
l1.setBounds(40,10,800,20);
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
b1.setBounds(300,400,150,25);
b2.setBounds(460,400,100,25);


tf1.setText("What Is Your Birth Place");
tf2.setText("What is Your Adhaar Number");
tf3.setText("Which Was Your Education School");



b1.addActionListener(this);
b2.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e);
}




add(j2);

setVisible(true);
}
int g=0;
String ans1="",ans2="",ans3="";
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b1)
{
ResultSet rs=stm.executeQuery("select * from set_security where user_id='"+user+"'");
while(rs.next())
{
ans1=rs.getString(2);
ans2=rs.getString(3);
ans3=rs.getString(4);
}


if((ans1.equals(tf4.getText()))&&(ans2.equals(tf5.getText()))&&(ans3.equals(tf6.getText())))
{
new change_forgot_password(user,index);
this.dispose();
}
else 
JOptionPane.showMessageDialog(this,"Sorry, But You Answers Do Not Match With You Put In Security");

}
}
catch(Exception e)
{
//JOptionPane.showMessageDialog(this,e);
e.printStackTrace();
}
}

public static void main(String lk[])
{
new forgot_password("",0);
}
}

