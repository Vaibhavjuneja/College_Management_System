import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class create_user extends JFrame //implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7;
JButton b1,b2,b3;
JTextField tf1,tf2,tf3,tf4;
JPasswordField pf1,pf2;
create_user()
{
setSize(1000,1000);
setLayout(null);
l1=new JLabel("Create New User");
l1.setFont(new Font("The Times New Roman",Font.BOLD,30));
l2=new JLabel("Full Name");
l2.setFont(new Font("The Times New Roman",Font.BOLD,22));
l3=new JLabel("Address");
l3.setFont(new Font("The Times New Roman",Font.BOLD,22));
l4=new JLabel("Phone Number");
l4.setFont(new Font("The Times New Roman",Font.BOLD,22));
l5=new JLabel("User Id");
l5.setFont(new Font("The Times New Roman",Font.BOLD,22));
l6=new JLabel("Password");
l6.setFont(new Font("The Times New Roman",Font.BOLD,22));
l7=new JLabel("Re Enter");
l7.setFont(new Font("The Times New Roman",Font.BOLD,22));

tf1=new JTextField(30);
tf2=new JTextField(30);
tf3=new JTextField(30);
tf4=new JTextField(30);

pf1=new JPasswordField(20);
pf2=new JPasswordField(20);

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
add(pf1);
add(pf2);

l1.setBounds(20,10,300,40);
l2.setBounds(10,60,150,30);
tf1.setBounds(170,60,200,30);
l3.setBounds(10,100,150,30);
tf2.setBounds(170,100,200,30);
l4.setBounds(10,140,150,30);
tf3.setBounds(170,140,200,30);
l5.setBounds(10,180,150,30);
tf4.setBounds(170,180,200,30);
l6.setBounds(10,220,150,30);
pf1.setBounds(170,220,200,30);
l7.setBounds(10,260,150,30);
pf2.setBounds(170,260,200,30);



setVisible(true);
}
public static void main(String io[])
{
new create_user();
}
}
