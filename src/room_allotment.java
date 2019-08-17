import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Graphics.*;
import javax.swing.table.*;
class room_allotment extends JFrame implements ActionListener,FocusListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JComboBox cb1,cb2,cb3;
JButton b1,b2;
JTextField tf1,tf2,tf3,tf4;
JTable jt;
JScrollPane sp;
Connection con;
Statement stm;
room_allotment()
{
setLayout(null);
setSize(1000,1000);
setExtendedState(JFrame.MAXIMIZED_BOTH);

l1=new JLabel("Hostel");
l2=new JLabel("Block");
l3=new JLabel("Structure");
l4=new JLabel("Roll No");
l5=new JLabel("From");
l6=new JLabel("To");
l7=new JLabel("Vacancy");
l8=new JLabel("Room Co-Occopants");

l1.setFont(new Font("Times New Roman",Font.BOLD,25));
l2.setFont(new Font("Times New Roman",Font.BOLD,25));
l3.setFont(new Font("Times New Roman",Font.BOLD,25));
l4.setFont(new Font("Times New Roman",Font.BOLD,25));
l5.setFont(new Font("Times New Roman",Font.BOLD,25));
l6.setFont(new Font("Times New Roman",Font.BOLD,25));
l7.setFont(new Font("Times New Roman",Font.BOLD,25));
l8.setFont(new Font("Times New Roman",Font.BOLD,25));

b1=new JButton("Search");
b2=new JButton("Save");

b1.setFont(new Font("Times New Roman",Font.BOLD,25));
b2.setFont(new Font("Times New Roman",Font.BOLD,25));

cb1=new JComboBox();
cb2=new JComboBox();
cb3=new JComboBox();

cb1.setFont(new Font("Times New Roman",Font.BOLD,20));
cb2.setFont(new Font("Times New Roman",Font.BOLD,20));
cb3.setFont(new Font("Times New Roman",Font.BOLD,20));

tf1=new JTextField(50);
tf2=new JTextField(50);
tf3=new JTextField(50);
tf4=new JTextField(50);

cb1.addItem("Select");
cb2.addItem("Select");
cb3.addItem("Select");


add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);

add(cb1);
add(cb2);
add(cb3);

add(b1);

add(tf1);
add(tf2);
add(tf3);
add(tf4);


l1.setBounds(50,100,150,20);
cb1.setBounds(50,125,200,30);
l2.setBounds(500,100,150,20);
cb2.setBounds(500,125,200,30);
l3.setBounds(950,100,150,20);
cb3.setBounds(950,125,200,30);
b1.setBounds(450,230,150,30);

cb1.addFocusListener(this);
b1.addActionListener(this);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();

ResultSet rs=stm.executeQuery("select hostel_name from hostel_mass");
while(rs.next())
{
cb1.addItem(rs.getString(1));
}
}
catch(Exception e)
{
e.printStackTrace();
}


setVisible(true);


}

int size=0;
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b1)
{
ResultSet rs2=stm.executeQuery("select count(*) from room_data where room_no like '"+block_code+String.valueOf(cb2.getSelectedIndex())+String.valueOf(cb3.getSelectedIndex())+"%'");
if(rs2.next())
{
size=rs2.getInt(1);
System.out.println(size);
}
if(size>0)
{
String so[]={"Select","Room No","Status"};
Object obj[][]=new Object[size][3];

if(sp!=null)
remove(sp);

int c=0;
JRadioButton jb=new JRadioButton("");
ResultSet rs0=stm.executeQuery("select room_no,room_status from room_data where hostel_block='"+cb2.getSelectedItem()+"' and room_structure='"+cb3.getSelectedItem()+"'");
while(rs0.next())
{
obj[c][0]=(jb);
obj[c][1]=rs0.getString(1);
obj[c][2]=rs0.getString(2);
c++;
}

DefaultTableModel mb=new DefaultTableModel(obj,so);
jt=new JTable(mb)
{
public boolean isCellEditable(int r,int c)
{
if((c==1)||(c==2))
return true;
else 
return false;
}
};

sp=new JScrollPane(jt);
sp.setBounds(100,400,700,(30*(size+2)));
add(sp);
}
}
}
catch(Exception ea)
{
ea.printStackTrace();
}
}
String block_code="";
public void focusLost(FocusEvent fe)
{
try
{

int blocks=0,floors=0;
if(fe.getSource()==cb1)
{
ResultSet rs=stm.executeQuery("select hostel_code,total_blocks,total_floors from hostel_mass where hostel_name='"+cb1.getSelectedItem()+"'");
if(rs.next())
{
block_code=rs.getString(1);
blocks=rs.getInt(2);
floors=rs.getInt(3);
}

for(int i=1;i<=blocks;i++)
{
cb2.addItem(block_code+"-"+String.valueOf(i));
}
for(int j=1;j<=floors;j++)
{
cb3.addItem("Floor No-"+j);
}


}
}
catch(Exception e)
{
e.printStackTrace();
}
}
public void focusGained(FocusEvent fe)
{}
public void pain(Graphics g)
{
g.drawLine(0,210,1370,210);
}

public static void main(String kl[])
{
new room_allotment();
}
}