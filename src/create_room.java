import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.TimeUnit;
class create_room extends JDialog implements ActionListener,ItemListener,FocusListener,KeyListener
{
JLabel l0,l1,l2,l3,l4,l5;
JTextField tf1,tf2;
JComboBox cb1,cb2,cb3,cb4;
JButton b1,b2,b3,b4;
JPanel p1;
JList jl1;
Connection con;
Statement stm;
create_room()
{
setSize(800,400);
setLayout(null);

p1=new JPanel();
jl1=new JList();

l0=new JLabel("Create A New Room");
l1=new JLabel("Hostel");
l2=new JLabel("Block");
l3=new JLabel("Structure");
l4=new JLabel("Room Number");
l5=new JLabel("Room Status");


l0.setFont(new Font("Segoe Script",Font.BOLD,32));
l1.setFont(new Font("Segoe Script",Font.BOLD,25));
l2.setFont(new Font("Segoe Script",Font.BOLD,25));
l3.setFont(new Font("Segoe Script",Font.BOLD,25));
l4.setFont(new Font("Segoe Script",Font.BOLD,25));
l5.setFont(new Font("Segoe Script",Font.BOLD,25));

tf1=new JTextField(50);
tf2=new JTextField(50);

cb1=new JComboBox();
cb2=new JComboBox();
cb3=new JComboBox();
cb4=new JComboBox();

cb1.setFont(new Font("Segoe Script",Font.BOLD,25));
cb2.setFont(new Font("Segoe Script",Font.BOLD,25));
cb3.setFont(new Font("Segoe Script",Font.BOLD,25));
cb4.setFont(new Font("Segoe Script",Font.BOLD,25));

cb1.addItem("Select");
cb2.addItem("Select");
cb3.addItem("Select");
cb4.addItem("Select");

b1=new JButton("Add New");
b2=new JButton("Save Details");
b3=new JButton("Search");
b4=new JButton("Modify");

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));
b3.setFont(new Font("Segoe Script",Font.BOLD,25));
b4.setFont(new Font("Segoe Script",Font.BOLD,25));


add(l0);
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);

add(tf1);
add(tf2);


add(cb1);
add(cb2);
add(cb3);
add(cb4);

add(b1);
add(b2);
add(b3);
add(b4);


l0.setBounds(250,20,400,30);
l1.setBounds(10,70,200,25);
cb1.setBounds(10,95,300,30);
l2.setBounds(400,70,200,25);
cb2.setBounds(400,95,300,30);
l3.setBounds(10,135,200,25);
cb3.setBounds(10,165,300,30);
l4.setBounds(400,135,200,25);
tf1.setBounds(400,165,300,30);
l5.setBounds(10,205,200,25);
cb4.setBounds(10,235,300,30);
b1.setBounds(380,235,170,30);
b2.setBounds(570,235,200,30);
tf2.setBounds(10,290,300,30);
b3.setBounds(320,290,150,30);
b4.setBounds(490,290,150,30);

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
catch(Exception ee)
{
ee.printStackTrace();
}

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

b3.setEnabled(false);
b4.setEnabled(false);

cb1.addFocusListener(this);
cb3.addItemListener(this);
tf2.addFocusListener(this);
b3.addActionListener(this);

tf2.addKeyListener(this);

tf1.setEditable(false);
tf1.setFont(new Font("Times New Roman",Font.BOLD,20));
tf1.setForeground(Color.BLUE);



setVisible(true);
}
public void keyPressed(KeyEvent e)
{}
public void keyReleased(KeyEvent e)
{
ResultSet rs0=stm.executeQuery("select room_no from room_data where room_no like "+tf2.getText()+"%");
while(rs0.next())
{
jl1.addComponent(rs0.getString(1));
}

}
public void keyTyped(KeyEvent e)
{}

String block_code="";
public void focusLost(FocusEvent ie)
{
try
{

int blocks=0,floors=0;
if(ie.getSource()==cb1)
{
ResultSet rs=stm.executeQuery("select hostel_code, total_blocks,total_floors from hostel_mass where hostel_name='"+cb1.getSelectedItem()+"'");
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


int type[]=new int[9];
ResultSet rs0=stm.executeQuery("select * from hostel_mass where hostel_name='"+cb1.getSelectedItem()+"'");
if(rs0.next())
{
type[1]=rs0.getInt(5);
type[2]=rs0.getInt(6);
type[3]=rs0.getInt(7);
type[4]=rs0.getInt(8);
type[5]=rs0.getInt(9);
type[6]=rs0.getInt(10);
type[7]=rs0.getInt(11);
type[8]=rs0.getInt(12);
}

if(type[1]>0)
{
cb4.addItem("Single Non Ac");
}
if(type[2]>0)
{
cb4.addItem("Double Non Ac");
}
if(type[3]>0)
{
cb4.addItem("Tripple Non Ac");
}
if(type[4]>0)
{
cb4.addItem("Four Non Ac");
}
if(type[5]>0)
{
cb4.addItem("Single Ac");
}
if(type[6]>0)
{
cb4.addItem("Double Ac");
}
if(type[7]>0)
{
cb4.addItem("Tripple Ac");
}
if(type[8]>0)
{
cb4.addItem("Four Sharing Ac");
}









}
}
catch(Exception e)
{
e.printStackTrace();
}
}

public void focusGained(FocusEvent fe)
{
if(fe.getSource()==tf2)
{
b3.setEnabled(true);
}
}

public void actionPerformed(ActionEvent ae)
{
int check=0;
try
{
if(ae.getSource()==b1)
{
cb1.setSelectedIndex(0);
cb2.setSelectedIndex(0);
cb3.setSelectedIndex(0);
cb4.setSelectedIndex(0);
tf1.setText("");
tf2.setText("");

}
if(ae.getSource()==b2)
{
if((tf1.getText().equals(""))||(cb4.getSelectedIndex()==0))
{
check=1;
JOptionPane.showMessageDialog(this,"Kindly Fill Each And Every Detail of  Room Properly ");
}

if(check==0)
{
ResultSet r=stm.executeQuery("select * from room_data where room_no='"+tf1.getText()+"'");
if(r.next())
JOptionPane.showMessageDialog(this,"Details Already Exists For Room No "+tf1.getText()+" If You Want To Modify Detail Go  For Search Option");
else
{
String si="insert into room_data values('"+cb1.getSelectedItem()+"','"+cb2.getSelectedItem()+"','"+cb3.getSelectedItem()+"','"+tf1.getText()+"','"+cb4.getSelectedItem()+"')";
stm.executeUpdate(si);
JOptionPane.showMessageDialog(this,"Successfully Saved");
}
}
}

String cbi1="",cbi2="",cbi3="",cbi4="",cbi5="";
if(ae.getSource()==b3)
{
ResultSet rs01=stm.executeQuery("select * from room_data where room_no='"+tf2.getText()+"'");
if(rs01.next())
{
cbi1=rs01.getString(1);
cbi2=rs01.getString(2);
cbi3=rs01.getString(3);
cbi4=rs01.getString(4);
cbi5=rs01.getString(5);
b4.setEnabled(true);
}
else 
JOptionPane.showMessageDialog(this,"Data Doesn't Exists For "+tf2.getText());



cb1.setSelectedItem(cbi1);
TimeUnit.MILLISECONDS.sleep(100);
cb2.setSelectedItem(cbi2);
cb3.setSelectedItem(cbi3);
tf1.setText(cbi4);
cb4.setSelectedItem(cbi5);

}

if(ae.getSource()==b4)
{

if(check==0)
{
String su="update room_data set hostel_name='"+cb1.getSelectedItem()+"' , hostel_block='"+cb2.getSelectedItem()+"', room_structure='"+cb3.getSelectedItem()+"',room_no='"+tf1.getText()+"', room_status='"+cb4.getSelectedItem()+"' where room_no='"+tf1.getText()+"'";
stm.executeUpdate(su);
JOptionPane.showMessageDialog(this,"Successfully Updated");
b1.doClick();
b4.setEnabled(false);
}
else
JOptionPane.showMessageDialog(this,"All Data Is Necessary");
}


}
catch(Exception aee)
{
aee.printStackTrace();
}
}

int count=0;
public void itemStateChanged(ItemEvent ie)
{
try
{
if(ie.getSource()==cb3&&ie.getStateChange()==ItemEvent.SELECTED)
{
ResultSet rs=stm.executeQuery("select count(*) from room_data where hostel_block='"+cb2.getSelectedItem()+"' and room_structure='"+cb3.getSelectedItem()+"'");
if(rs.next())
count=rs.getInt(1);

tf1.setText(block_code+String.valueOf((cb2.getSelectedIndex()*1000)+(cb3.getSelectedIndex()*100)+(count+1)));
}
}
catch(Exception ee)
{
ee.printStackTrace();
}
}


public static void main(String io[])
{
new create_room();
}




}