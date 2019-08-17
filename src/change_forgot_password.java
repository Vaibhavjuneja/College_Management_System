import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class change_forgot_password extends JDialog implements ActionListener
{
JLabel l1,l2,l3,l4;
JPasswordField pf1,pf2,pf3;
JButton b1,b2;
Container con1=getContentPane();
Connection con;
Statement stm;
String user="";
int index=0;
change_forgot_password(String ui,int iu)
{
user=ui;
index=iu;
con1.setBackground(Color.yellow);
setLayout(null);
setSize(500,350);
l1=new JLabel("Change Password");
l3=new JLabel("New");
l4=new JLabel("Re-Enter");


pf2=new JPasswordField(30);
pf3=new JPasswordField(30);

b1=new JButton("Change");
b2=new JButton("Cancel");

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));


l1.setFont(new Font("Segoe Script",Font.BOLD,25));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
b1.setFont(new Font("Segoe Script",Font.BOLD,20));
b2.setFont(new Font("Segoe Script",Font.BOLD,20));

add(l1);
add(l3);
add(l4);

add(pf2);
add(pf3);
add(b1);
add(b2);

l1.setBounds(50,30,300,30);
l3.setBounds(10,75,100,25);
pf2.setBounds(120,75,250,25);
l4.setBounds(10,110,100,25);
pf3.setBounds(120,110,250,25);
b1.setBounds(10,165,150,30);
b2.setBounds(170,165,150,30);

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

setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
int count=0;
try
{
if(ae.getSource()==b1)
{
if((pf2.getText().equals(""))||(pf3.getText().equals("")))
{
count=1;
JOptionPane.showMessageDialog(this,"Kindly Fill Both Fields");
}
else if(!(pf2.getText()).equals(pf3.getText()))
{
count=2;
JOptionPane.showMessageDialog(this,"Re-Enter Again Bcz Your Re-Entered Password Not Match With New One");
System.out.println(pf2.getText());
}
else if(!(validation.checkPassword(pf2.getText())))
{
count=3;
JOptionPane.showMessageDialog(this,"Password Length Must Be Greater Than Or Equal To Eight With One Character");
}
if(count==0)
{
if(index==1)
{
String su="update admin set password='"+pf2.getText()+"' where user_id='"+user+"'";
stm.executeUpdate(su);
JOptionPane.showMessageDialog(this,"Successfully Chaged");
new admin_window(user);
}
else if(index==2)
{
String su="update employee_data set password='"+pf2.getText()+"' where user_id='"+user+"'";
stm.executeUpdate(su);
JOptionPane.showMessageDialog(this,"Successfully Chaged");
new accountant_window(user) ;
}
else if(index==3)
{
String su="update employee_data set password='"+pf2.getText()+"' where user_id='"+user+"'";
stm.executeUpdate(su);
JOptionPane.showMessageDialog(this,"Successfully Chaged");
new faculty_window(user);
}
}
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
public static void main(String kl[])
{
new change_forgot_password("",0);
}
}