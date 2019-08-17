import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class hostel_master extends JFrame implements FocusListener,ActionListener,ItemListener
{
JLabel l1,l01,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField tf1,tf2,tf3,tf4,tf5,tf6;
JComboBox bx1,bx2,bx3,bx4,bx5;
JButton b1,b2,b3;
JRadioButton rb1,rb2;
Connection con;
Statement stm;
hostel_master()
{
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);


l1=new JLabel("Hostel Master");
l01=new JLabel("Hostel Name");
l2=new JLabel("No.Of Blocks");
l3=new JLabel("Choose Block");
l4=new JLabel("Total No. Of Rooms");
l5=new JLabel("Vacant Rooms");
l6=new JLabel("Seater");
l7=new JLabel("Room No From");
l8=new JLabel("To");
l9=new JLabel("Hostel Charges");

l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l01.setFont(new Font("Segoe Script",Font.BOLD,20));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));
l6.setFont(new Font("Segoe Script",Font.BOLD,20));
l7.setFont(new Font("Segoe Script",Font.BOLD,20));
l8.setFont(new Font("Segoe Script",Font.BOLD,20));
l9.setFont(new Font("Segoe Script",Font.BOLD,20));


tf1=new JTextField(100);
tf2=new JTextField(50);
tf3=new JTextField(50);
tf4=new JTextField(50);
tf5=new JTextField(50);
tf6=new JTextField(50);


bx1=new JComboBox();
bx2=new JComboBox();
bx3=new JComboBox();
bx4=new JComboBox();
bx5=new JComboBox();


bx1.setFont(new Font("Segoe Script",Font.BOLD,25));
bx2.setFont(new Font("Segoe Script",Font.BOLD,25));
bx3.setFont(new Font("Segoe Script",Font.BOLD,25));
bx4.setFont(new Font("Segoe Script",Font.BOLD,25));
bx5.setFont(new Font("Segoe Script",Font.BOLD,25));

bx1.addItem("Select Block");
bx2.addItem("Select Seater");
bx2.addItem("Single Seater");
bx2.addItem("Double Seater");
bx2.addItem("Tripple Seater");
bx2.addItem("Four Sharing");

bx3.addItem("Select Room No");
bx4.addItem("Select Room No");


bx5.addItem("Find");


b1=new JButton("Save");
b2=new JButton("Find");
b3=new JButton("Modify");

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));
b3.setFont(new Font("Segoe Script",Font.BOLD,25));

rb1=new JRadioButton("Ac");
rb2=new JRadioButton("Non Ac",true);

rb1.setFont(new Font("Segoe Script",Font.BOLD,20));
rb2.setFont(new Font("Segoe Script",Font.BOLD,20));

ButtonGroup bg=new ButtonGroup();
bg.add(rb1);
bg.add(rb2);


add(l1);
add(l01);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(l9);


add(tf1);
add(tf2);
add(tf3);
add(tf4);
add(tf5);
add(tf6);


add(bx1);
add(bx2);
add(bx3);
add(bx4);
add(bx5);

add(rb1);
add(rb2);


add(b1);
add(b2);
add(b3);


l1.setBounds(530,20,400,30);
l01.setBounds(20,70,300,20);
tf1.setBounds(20,95,300,30);
l2.setBounds(500,70,300,20);
tf2.setBounds(500,95,300,30);
l3.setBounds(1010,70,300,20);
bx1.setBounds(1010,95,300,30);
l4.setBounds(20,270,300,20);
tf3.setBounds(20,295,300,30);
l5.setBounds(500,270,300,20);
tf4.setBounds(500,295,300,30);
l6.setBounds(1010,270,300,20);
bx2.setBounds(1010,295,300,30);
l7.setBounds(20,470,200,20);
bx3.setBounds(20,495,300,30);
l8.setBounds(500,470,50,20);
bx4.setBounds(500,495,300,30);
rb1.setBounds(1010,495,70,20);
rb2.setBounds(1090,495,100,20);
b1.setBounds(100,580,150,30);
bx5.setBounds(350,580,200,30);
b2.setBounds(460,580,150,30);
b3.setBounds(710,580,150,30);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
ResultSet rs=stm.executeQuery("select hostel_name from hostel_master");
while(rs.next())
{
bx5.addItem(rs.getString(1));
}

}
catch(Exception e)
{
e.printStackTrace();
}


bx1.addFocusListener(this);
bx2.addItemListener(this);
bx4.addFocusListener(this);
tf1.addFocusListener(this);
tf2.addFocusListener(this);
tf3.addFocusListener(this);
b1.addActionListener(this);  
tf4.setEditable(false);

setVisible(true);
}

public void focusGained(FocusEvent fe)
{
try
{
int size_bx2=0;
if(fe.getSource()==bx4)
{
for(size_bx2=bx3.getSelectedIndex();size_bx2<=Integer.parseInt(tf3.getText());size_bx2++)
{
bx4.addItem(size_bx2);
}
}
}
catch(NumberFormatException nu)
{
JOptionPane.showMessageDialog(this,"Please Enter Valid No. Of Rooms");
}
}
public void focusLost(FocusEvent fe)
{
try
{
int block_size=0;
if(fe.getSource()==tf1)
{
ResultSet rs0=stm.executeQuery("select * from hostel_master where hostel_name='"+tf1.getText()+"'");
if(rs0.next())
{
JOptionPane.showMessageDialog(this,"Hostel Already Axist Please Change the Name of the hostel");
}

}



if(fe.getSource()==tf2)
{
if(!((tf1.getText().equals(""))||(tf2.getText().equals(""))))
{
for(block_size=1;block_size<=Integer.parseInt(tf2.getText());block_size++)
{
bx1.addItem(tf1.getText()+" "+String.valueOf(block_size));
}
}
else
{ 
JOptionPane.showMessageDialog(this,"Kindly Enter Hostel Name And No. Of Blocks First");
tf1.requestFocus();
}
} 
}
catch(NumberFormatException ne)
{
JOptionPane.showMessageDialog(this,"Please Enter Valid No. Of Blocks");
}
catch(Exception ee)
{
ee.printStackTrace();
}

if(fe.getSource()==tf3)
{
tf4.setText(tf3.getText());
}
}

int room_no=0;
String room_status="";
public void itemStateChanged(ItemEvent ie)
{
try
{
if((ie.getSource()==bx2)&&ie.getStateChange()==ItemEvent.SELECTED)
{
for(room_no=1;room_no<=Integer.parseInt(tf3.getText());room_no++)
{
bx3.addItem(room_no);
}
}

if((ie.getSource()==bx5)&&(ie.getStateChange()==ItemEvent.SELECTED))
{
b2.setEnabled(true);
}

}

catch(NumberFormatException ne1)
{
JOptionPane.showMessageDialog(this,"Kindly Enter Valid No. Of Rooms");
}
}

int count=0;
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b1)
{
if((tf1.getText().equals(""))||(tf2.getText().equals(""))||(tf3.getText().equals(""))||(bx1.getSelectedIndex()==0)||(bx2.getSelectedIndex()==0)||(bx3.getSelectedIndex()==0)||(bx4.getSelectedIndex()==0))
{
count=1;
JOptionPane.showMessageDialog(this,"All Fields Are Necessary");
}
if(count==0)
{
if(rb1.isSelected())
room_status="Ac";
else 
room_status="Non Ac";

String si="insert into hostel_master values('"+tf1.getText()+"' , '"+bx1.getSelectedItem()+"' ,"+Integer.parseInt(tf3.getText())+","+Integer.parseInt(tf4.getText())+",'"+bx2.getSelectedItem()+"' , '"+room_status+"' ,"+bx3.getSelectedItem()+","+bx4.getSelectedItem()+" )";
stm.executeUpdate(si);
JOptionPane.showMessageDialog(this,"Successfully Saved");
}
}

if(ae.getSource()==b2)
{
ResultSet rse=stm.executeQuery("select * from hostel_master where hostel name ");
while(rse.next())
{




}
}
}
catch(Exception e)
{
e.printStackTrace();
}
}

public static void main(String jk[])
{
new hostel_master();
}
}