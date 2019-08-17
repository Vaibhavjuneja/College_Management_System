import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class put_attendance extends JFrame 
{
JLabel l1,l2,l3,l4;
JTextField tf1,tf2;
JComboBox bx1,bx2;
Connection con;
Statement stm;
JTable jt;
put_attendance()
{
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);

l1=new JLabel("Department");
l2=new JLabel("Semester");
l3=new JLabel("Subjects");
l4=new JLabel("Date");

l1.setFont(new Font("Segoe Script",Font.BOLD,20));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));

tf1=new JTextField(50);
tf2=new JTextField(50);

tf1.setFont(new Font("Segoe Script",Font.BOLD,15));
tf2.setFont(new Font("Segoe Script",Font.BOLD,15));


bx1=new JComboBox();
bx2=new JComboBox();

bx1.setFont(new Font("Segoe Script",Font.BOLD,25));
bx2.setFont(new Font("Segoe Script",Font.BOLD,25));

add(l1);
add(l2);
add(l3);
add(l4);

add(tf1);
add(tf2);

add(bx1);
add(bx2);


