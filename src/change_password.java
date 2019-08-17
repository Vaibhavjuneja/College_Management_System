import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class change_password extends JDialog implements ActionListener
{
JLabel l1,l2,l3,l4;
JPasswordField pf1,pf2,pf3;
JButton b1,b2;
Container con1=getContentPane();
Connection con;
Statement stm;
String user="";
int check_index=0;
change_password(String id, int d)
{
user=id;
check_index=d;
con1.setBackground(Color.yellow);
setLayout(null);
setSize(500,350);
l1=new JLabel("Change Password");
l2=new JLabel("Old");
l3=new JLabel("New");
l4=new JLabel("Re-Enter");

pf1=new JPasswordField(30);
pf2=new JPasswordField(30);
pf3=new JPasswordField(30);

b1=new JButton("Change");
b2=new JButton("Cancel");

l1.setFont(new Font("Segoe Script",Font.BOLD,25));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
b1.setFont(new Font("Segoe Script",Font.BOLD,20));
b2.setFont(new Font("Segoe Script",Font.BOLD,20));

add(l1);
add(l2);
add(l3);
add(l4);
add(pf1);
add(pf2);
add(pf3);
add(b1);
add(b2);

l1.setBounds(50,20,300,30);
l2.setBounds(10,60,100,25);
pf1.setBounds(110,60,250,25);
l3.setBounds(10,95,100,25);
pf2.setBounds(110,95,250,25);
l4.setBounds(10,130,100,25);
pf3.setBounds(110,130,250,25);
b1.setBounds(10,175,150,30);
b2.setBounds(170,175,150,30);

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
String check_pass="";
try
{
if(ae.getSource()==b1)
{
if(check_index==1)
{
ResultSet rs=stm.executeQuery("select password from admin where user_id='"+user+"'");
if(rs.next())
check_pass=rs.getString(1);
}
else if(check_index==2)
{
ResultSet rs=stm.executeQuery("select password from employee_data where user_id='"+user+"'");
if(rs.next())
check_pass=rs.getString(1);
}

if((pf1.getText().equals(""))||(pf2.getText().equals(""))||(pf3.getText().equals("")))
{
count=1;
JOptionPane.showMessageDialog(this,"Please Fill All Fields");
}
else if(!((validation.checkPassword(pf2.getText()))||(validation.checkPassword(pf3.getText()))))
{
count=2;
JOptionPane.showMessageDialog(this,"Password Length Must Be Greater Than Or Equal To Eight With One Character");
}
else if(!(pf2.getText().equals(pf3.getText())))
{
count=3;
JOptionPane.showMessageDialog(this,"Re-Enter Password Again Bcz Password Donot Math With Re-Entered One");
}
else if(!(check_pass.equals(pf1.getText())))
{
count=4;
JOptionPane.showMessageDialog(this,"You Entered Wrong Old Password");
}

if((count==0)&&(check_index==1))
{
String su="update admin set password='"+pf2.getText()+"' where user_id='"+user+"'";
stm.executeUpdate(su);
JOptionPane.showMessageDialog(this,"Successfully changed");
}
else if((count==0)&&(check_index==2))
{
String su="update employee_data set password='"+pf2.getText()+"' where user_id='"+user+"'";
stm.executeUpdate(su);
JOptionPane.showMessageDialog(this,"Successfully changed");
this.dispose();
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
new change_password("",0);
}
}