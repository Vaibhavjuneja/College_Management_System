import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
class attendence_report extends JInternalFrame implements ActionListener,FocusListener,ItemListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;JComboBox bx1,bx2;
JButton b1;
JTable jt;
JScrollPane sp;
Connection con;
Statement stm;
ImageIcon i1;
attendence_report()
{
super("Attendence Report",true,true,true,true);

setSize(1000,1000);
setLayout(null);


jt=new JTable();
sp=new JScrollPane(jt);
i1=new ImageIcon("at_report.jpg");
l6=new JLabel(i1);
l1=new JLabel("Attendence Record");
l2=new JLabel("Roll No");
l3=new JLabel("Total Lectures");
l4=new JLabel("Present");
l5=new JLabel("Percentage");

l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));

tf1=new JTextField(50);
tf2=new JTextField(50);
tf3=new JTextField(50);
tf4=new JTextField(50);

tf2.setEditable(false);
tf3.setEditable(false);
tf4.setEditable(false);

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

add(tf1);
add(tf2);
add(tf3);
add(tf4);

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
{}
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
ResultSet rs=stm.executeQuery("select count(*) from attendance where roll_no='"+tf1.getText()+"' and subject='"+bx2.getSelectedItem()+"'");
if(rs.next())
size=rs.getInt(1);

if(size>0)
{
String so[]={"Date","Presence"};
Object obj[][]=new Object[size][2];

if(sp!=null)
remove(sp);

ResultSet rs01=stm.executeQuery("select adate , Presence from attendance where roll_no='"+tf1.getText()+"' and subject='"+bx2.getSelectedItem()+"'");
while(rs01.next())
{
obj[o][0]=rs01.getString(1);
obj[o][1]=rs01.getString(2);
o++;
}

DefaultTableModel model1=new DefaultTableModel(obj,so);
jt=new JTable(model1)
{
public boolean isCellEditable(int r,int c)
{
if((c==1)&&(c==2))
return true;
else 
return false;
}
};

sp=new JScrollPane(jt);
sp.setBounds(400,20,700,300);
add(sp);
ResultSet rs000=stm.executeQuery("select count(*) from attendance where roll_no='"+tf1.getText()+"' and presence='P' ");
if(rs000.next())
prsent=rs000.getInt(1);

tf2.setText(String.valueOf(size));
tf3.setText(String.valueOf(prsent));
tf4.setText(String.valueOf(((Integer.parseInt(tf2.getText()))/(Integer.parseInt(tf3.getText())))*100));

l3.setBounds(450,330,150,20);
tf2.setBounds(450,355,200,30);
l4.setBounds(450,385,150,20);
tf3.setBounds(450,410,200,30);
l5.setBounds(450,450,150,20);
tf4.setBounds(450,475,200,30);


}
else 
JOptionPane.showMessageDialog(this,"Attendence Doesn't Exist of Roll No "+tf1.getText()+"");
}

}
catch(Exception e)
{
System.out.println(e);
//e.printStackTrace();
}
}
public static void main(String kj[])
{
new attendence_report();
}
}


