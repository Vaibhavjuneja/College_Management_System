import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
class marks_report extends JInternalFrame implements ActionListener,FocusListener,ItemListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;JComboBox bx1,bx2;
JButton b1;
JTable jt;
JScrollPane sp;
Connection con;
Statement stm;
ImageIcon i1;
marks_report()
{
super("Marks Report",true,true,true,true);
setSize(1000,1000);
setLayout(null);


jt=new JTable();
sp=new JScrollPane(jt);
i1=new ImageIcon("at_report.jpg");
l6=new JLabel(i1);
l1=new JLabel("Marks Record");
l2=new JLabel("Roll No");
l3=new JLabel("Sessionel 1(40)");
l4=new JLabel("Sessionel 2(40)");
l5=new JLabel("Internal (20)");
l7=new JLabel("Percentage");

l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));
l7.setFont(new Font("Segoe Script",Font.BOLD,20));

tf1=new JTextField(50);
tf2=new JTextField(50);
tf3=new JTextField(50);
tf4=new JTextField(50);
tf5=new JTextField(50);

tf2.setEditable(false);
tf3.setEditable(false);
tf4.setEditable(false);
tf5.setEditable(false);

bx1=new JComboBox();
bx2=new JComboBox();

bx1.setFont(new Font("Segoe Script",Font.BOLD,20));
bx2.setFont(new Font("Segoe Script",Font.BOLD,20));

b1=new JButton("Show");
b1.setFont(new Font("Segoe Script",Font.BOLD,25));

bx1.addItem("select semester");
bx1.addItem("1st");
bx1.addItem("2nd");
bx1.addItem("3rd");
bx1.addItem("4th");
bx1.addItem("5th");
bx1.addItem("6th");
bx1.addItem("7th");
bx1.addItem("8th");



bx2.addItem("select subject");

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l7);

add(tf1);
add(tf2);
add(tf3);
add(tf4);
add(tf5);

add(bx1);
add(bx2);

add(b1);

l6.setBounds(0,0,1370,750);
l1.setBounds(20,20,300,30);
l2.setBounds(20,70,150,20);
tf1.setBounds(20,100,300,30);
bx1.setBounds(20,140,300,30);
bx2.setBounds(20,180,300,30);
b1.setBounds(50,220,150,30);

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

tf1.addFocusListener(this);
b1.addActionListener(this);


bx1.addItemListener(this);
add(sp);
add(l6);

setVisible(true);

}

public void focusGained(FocusEvent fe)
{
if(fe.getSource()==tf1)
{
l3.setVisible(false);
l4.setVisible(false);
l5.setVisible(false);
l7.setVisible(false);
tf2.setVisible(false);
tf3.setVisible(false);
tf4.setVisible(false);
tf5.setVisible(false);
}
}
String dep="",dep_cod="";
public void focusLost(FocusEvent fe)
{
try
{
if(fe.getSource()==tf1)
{
ResultSet rs=stm.executeQuery("select stream from student_data where roll_no='"+tf1.getText()+"'");
if(rs.next())
{
dep=rs.getString(1);
ResultSet rs00=stm.executeQuery("select department_code from department_master where department_name='"+dep+"'");
if(rs00.next())
dep_cod=rs00.getString(1);
}
}
}
catch(Exception e)
{
System.out.println(e);
}
}


public void itemStateChanged(ItemEvent ie)
{
try
{
if((ie.getSource()==bx1)&& (ie.getStateChange()==ItemEvent.SELECTED))
{
ResultSet rs0=stm.executeQuery("select subject_name from subject_master where department_code='"+dep_cod+"' and semester='"+bx1.getSelectedItem()+"'");
while(rs0.next())
{
bx2.addItem(rs0.getString(1));
}
}
}
catch(Exception e)
{
System.out.println(e);
}
}



int size=0;
int prsent=0;
public void actionPerformed(ActionEvent ae)
{
int o=0;
try
{
if(ae.getSource()==b1)
{
ResultSet rs011=stm.executeQuery("select * from student_record where roll_no='"+tf1.getText()+"' and subject_name='"+bx2.getSelectedItem()+"'");
if(rs011.next())
{
ResultSet rs001=stm.executeQuery("select * from student_record where roll_no='"+tf1.getText()+"' and subject_name='"+bx2.getSelectedItem()+"'");
while(rs001.next())
{
tf2.setText(rs001.getString(5));
tf3.setText(rs001.getString(6));
tf4.setText(rs001.getString(7));
}
tf5.setText(String.valueOf(Integer.parseInt(tf2.getText())+Integer.parseInt(tf3.getText())+Integer.parseInt(tf4.getText())));
}
else 
JOptionPane.showMessageDialog(this,"Record Not Found");



l3.setBounds(800,20,200,20);
tf2.setBounds(800,45,200,30);
l4.setBounds(800,85,200,20);
tf3.setBounds(800,110,200,30);
l5.setBounds(800,150,200,20);
tf4.setBounds(800,175,200,30);
l7.setBounds(800,215,200,20);
tf5.setBounds(800,240,200,30);
l3.setVisible(true);
l4.setVisible(true);
l5.setVisible(true);
l7.setVisible(true);
tf2.setVisible(true);
tf3.setVisible(true);
tf4.setVisible(true);
tf5.setVisible(true);
}
}
catch(Exception e)
{
//System.out.println(e);
e.printStackTrace();
}
}
public static void main(String kj[])
{
new marks_report();
}
}

