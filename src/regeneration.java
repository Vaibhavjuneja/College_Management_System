import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
class regeneration extends JInternalFrame implements ActionListener,ItemListener,FocusListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23;
JTextField tf0,tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16;
JButton b1,b2,b3,b4,b5;
JRadioButton rb1,rb2;
JComboBox bx1,bx2,bx3,bx4,bx5;
Container con1=getContentPane();
Connection con;
Statement stm;
java.util.Date d1=new Date();
java.util.Date d2=new Date();

java.text.SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
java.text.SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
java.text.SimpleDateFormat sdf2=new SimpleDateFormat("dd/MMM/yyyy");
//sdf.setLenient(false);
//sdf1.setLenient(false);
//sdf2.setLenient(false);
ImageIcon mg1=new ImageIcon("regen.jpg");
JLabel j2=new JLabel(mg1);

regeneration()
{
super("Regenerate",true,true,true,true);
setSize(1000,1000);
setLayout(null);

l1=new JLabel("Search Roll No");
l2=new JLabel("Name");
l3=new JLabel("First Name");
l4=new JLabel("Middle Name");
l5=new JLabel("Last Name");
l6=new JLabel("Father's Name");
l7=new JLabel("Mr.");
l8=new JLabel("Mother's Name");
l9=new JLabel("Mrs.");
l10=new JLabel("Birth Date");
l11=new JLabel("Gender");
l12=new JLabel("Address");
l13=new JLabel("Street Address");
l14=new JLabel("City");
l15=new JLabel("State");
l16=new JLabel("Pin Code");
l17=new JLabel("Phone Number");
l18=new JLabel("Adm Number");
l19=new JLabel("Re-Gen Date");
l20=new JLabel("Semester Fee");
l21=new JLabel("Session");


l1.setFont(new Font("Segoe Script",Font.BOLD,20));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,10));
l4.setFont(new Font("Segoe Script",Font.BOLD,10));
l5.setFont(new Font("Segoe Script",Font.BOLD,10));
l6.setFont(new Font("Segoe Script",Font.BOLD,20));
l7.setFont(new Font("Segoe Script",Font.BOLD,20));
l8.setFont(new Font("Segoe Script",Font.BOLD,20));
l9.setFont(new Font("Segoe Script",Font.BOLD,20));
l10.setFont(new Font("Segoe Script",Font.BOLD,20));
l11.setFont(new Font("Segoe Script",Font.BOLD,20));
l12.setFont(new Font("Segoe Script",Font.BOLD,20));
l13.setFont(new Font("Segoe Script",Font.BOLD,10));
l14.setFont(new Font("Segoe Script",Font.BOLD,10));
l15.setFont(new Font("Segoe Script",Font.BOLD,10));
l16.setFont(new Font("Segoe Script",Font.BOLD,20));
l17.setFont(new Font("Segoe Script",Font.BOLD,20));
l18.setFont(new Font("Segoe Script",Font.BOLD,20));
l19.setFont(new Font("Segoe Script",Font.BOLD,20));
l20.setFont(new Font("Segoe Script",Font.BOLD,20));
l21.setFont(new Font("Segoe Script",Font.BOLD,20));
l1.setForeground(Color.white);
l2.setForeground(Color.white);
l3.setForeground(Color.white);
l4.setForeground(Color.white);
l5.setForeground(Color.white);
l6.setForeground(Color.white);
l7.setForeground(Color.white);
l8.setForeground(Color.white);
l9.setForeground(Color.white);
l10.setForeground(Color.white);
l11.setForeground(Color.white);
l12.setForeground(Color.white);
l13.setForeground(Color.white);
l14.setForeground(Color.white);
l15.setForeground(Color.white);
l16.setForeground(Color.white);
l17.setForeground(Color.white);
l18.setForeground(Color.white);
l19.setForeground(Color.white);
l20.setForeground(Color.white);
l21.setForeground(Color.white);




tf0=new JTextField(50);
tf1=new JTextField(50);
tf2=new JTextField(50);
tf3=new JTextField(50);
tf4=new JTextField(50);
tf5=new JTextField(50);
tf6=new JTextField(50);
tf7=new JTextField(50);
tf8=new JTextField(50);
tf9=new JTextField(50);
tf10=new JTextField(50);
tf11=new JTextField(50);
tf12=new JTextField(50);
tf13=new JTextField(50);
tf14=new JTextField(50);


tf1.setFont(new Font("Times New Roman",Font.BOLD,15));
tf2.setFont(new Font("Times New Roman",Font.BOLD,15));
tf3.setFont(new Font("Times New Roman",Font.BOLD,15));
tf4.setFont(new Font("Times New Roman",Font.BOLD,15));
tf5.setFont(new Font("Times New Roman",Font.BOLD,15));
tf6.setFont(new Font("Times New Roman",Font.BOLD,15));
tf7.setFont(new Font("Times New Roman",Font.BOLD,15));
tf8.setFont(new Font("Times New Roman",Font.BOLD,15));
tf9.setFont(new Font("Times New Roman",Font.BOLD,15));
tf10.setFont(new Font("Times New Roman",Font.BOLD,15));
tf11.setFont(new Font("Times New Roman",Font.BOLD,15));
tf12.setFont(new Font("Times New Roman",Font.BOLD,15));
tf13.setFont(new Font("Times New Roman",Font.BOLD,15));
tf14.setFont(new Font("Times New Roman",Font.BOLD,15));



b1=new JButton("Save");
b2=new JButton("Back");
b3=new JButton("Modify");
b4=new JButton("Search");
b5=new JButton("Back");

rb1=new JRadioButton("Male");
rb2=new JRadioButton("Female");
ButtonGroup bg=new ButtonGroup();
bg.add(rb1);
bg.add(rb2);

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));
b3.setFont(new Font("Segoe Script",Font.BOLD,25));
b4.setFont(new Font("Segoe Script",Font.BOLD,25));
b5.setFont(new Font("Segoe Script",Font.BOLD,25));


rb1.setFont(new Font("Segoe Script",Font.BOLD,20));
rb2.setFont(new Font("Segoe Script",Font.BOLD,20));


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


bx1.addItem("Month");
bx1.addItem("Jan");
bx1.addItem("Feb");
bx1.addItem("Mar");
bx1.addItem("Apr");
bx1.addItem("May");
bx1.addItem("Jun");
bx1.addItem("Jul");
bx1.addItem("Aug");
bx1.addItem("Sep");
bx1.addItem("Oct");
bx1.addItem("Nov");
bx1.addItem("Dec");

bx2.addItem("Day");
int i;
for(i=1;i<=31;i++)
{
bx2.addItem(String.valueOf(i));
}

bx3.addItem("Year");
int j;
for(j=1980;j<=2017;j++)
{
bx3.addItem(String.valueOf(j));
}

bx4.addItem("Department");

bx5.addItem("Semester");
bx5.addItem(2);
bx5.addItem(3);
bx5.addItem(4);
bx5.addItem(5);
bx5.addItem(6);
bx5.addItem(7);
bx5.addItem(8);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(l9);
add(l10);
add(l11);
add(l12);
add(l13);
add(l14);
add(l15);
add(l16);
add(l17);
add(l18);
add(l19);
add(l20);
add(l21);


add(tf0);
add(tf1);
add(tf2);
add(tf3);
add(tf4);
add(tf5);
add(tf6);
add(tf7);
add(tf8);
add(tf9);
add(tf10);
add(tf11);
add(tf12);
add(tf13);
add(tf14);


add(rb1);
add(rb2);

add(bx1);
add(bx2);
add(bx3);
add(bx4);
add(bx5);


add(b1);
add(b2);
//add(b3);
add(b4);
//add(b5);

j2.setBounds(0,0,1370,750);
l1.setBounds(20,20,200,30);
tf0.setBounds(220,20,200,30);
b4.setBounds(430,20,150,30);
l2.setBounds(20,60,200,20);
tf1.setBounds(20,85,100,30);
tf2.setBounds(130,85,100,30);
tf3.setBounds(240,85,100,30);
l3.setBounds(20,115,100,10);
l4.setBounds(130,115,100,10);
l5.setBounds(240,115,100,10);
l6.setBounds(20,135,250,20);
l7.setBounds(20,160,50,20);
tf4.setBounds(70,160,200,30);
l8.setBounds(20,200,200,20);
l9.setBounds(20,225,50,20);
tf5.setBounds(70,225,200,30);
l10.setBounds(20,265,200,20);
bx1.setBounds(20,290,150,30);
bx2.setBounds(180,290,100,30);
bx3.setBounds(290,290,100,30);
l11.setBounds(20,330,100,20);
rb1.setBounds(130,330,80,20);
rb2.setBounds(220,330,150,20);
l12.setBounds(20,360,200,20);
tf6.setBounds(20,385,300,30);
l13.setBounds(20,415,200,10);
tf7.setBounds(20,435,100,30);
tf8.setBounds(150,435,100,30);
l14.setBounds(20,465,100,10);
l15.setBounds(150,465,100,10);
l16.setBounds(20,485,150,20);
l17.setBounds(190,485,200,20);
tf9.setBounds(20,510,100,30);
tf10.setBounds(190,510,100,30);
l18.setBounds(800,60,150,20);
tf11.setBounds(800,85,180,30);
l19.setBounds(1000,60,150,20);
tf12.setBounds(1000,85,180,30);
bx4.setBounds(800,185,300,30);
bx5.setBounds(800,135,300,30);
l20.setBounds(800,230,150,20);
tf13.setBounds(800,255,150,30);
l21.setBounds(800,300,150,20);
tf14.setBounds(800,325,300,30);

b1.setBounds(10,650,100,30);
b2.setBounds(120,650,170,30);
b3.setBounds(860,650,150,30);
b5.setBounds(1020,650,150,30);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

rb1.addItemListener(this);
rb2.addItemListener(this);
bx1.addItemListener(this);
bx2.addItemListener(this);
bx3.addItemListener(this);
bx5.addItemListener(this);

tf0.addFocusListener(this);
bx4.addFocusListener(this);


bx5.setEnabled(false);
bx1.setEnabled(false);
bx2.setEnabled(false);
bx3.setEnabled(false);

rb1.setEnabled(false);
rb2.setEnabled(false);

b1.setEnabled(false);
b3.setEnabled(false);
b4.setEnabled(false);
bx4.setEnabled(false);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
ResultSet rs=stm.executeQuery("select department_name from department_master");
while(rs.next())
{
bx4.addItem(rs.getString(1));
}
}
catch(Exception e)
{
System.out.println(e);
}

add(j2);


setVisible(true);
}
public void focusGained(FocusEvent fe)
{
if(fe.getSource()==tf0)
{
b4.setEnabled(true);
tf1.setText("");
tf2.setText("");
tf3.setText("");
tf4.setText("");
tf5.setText("");
tf6.setText("");
tf7.setText("");
tf8.setText("");
tf9.setText("");
tf10.setText("");


tf1.setEditable(false);
tf2.setEditable(false);
tf3.setEditable(false);
tf4.setEditable(false);
tf5.setEditable(false);
tf6.setEditable(false);
tf7.setEditable(false);
tf8.setEditable(false);
tf9.setEditable(false);
tf10.setEditable(false);
tf11.setEditable(false);
tf12.setEditable(false);
tf13.setEditable(false);
tf14.setEditable(false);


bx1.setSelectedIndex(0);
bx2.setSelectedIndex(0);
bx3.setSelectedIndex(0);
bx5.setSelectedIndex(0);
bx4.setSelectedIndex(0);
bx4.setEnabled(false);
}

}
public void focusLost(FocusEvent fe)
{
}
String sdate="";
String sgender="";
public void itemStateChanged(ItemEvent ie)
{
try
{
if(rb1.isSelected())
sgender="Male";

if(rb2.isSelected())
sgender="Female";

}
catch(Exception e)
{
System.out.println(e);
}
}
long bal=0;
int ssem=0;
public void actionPerformed(ActionEvent ae)
{
int count=0;
try
{
if(ae.getSource()==b1)
{
String sst="";
ResultSet rse=stm.executeQuery("select stream from student_data where roll_no='"+tf0.getText()+"'");
if(rse.next())
sst=rse.getString(1);

String s1="insert into regeneration values('"+tf0.getText()+"', '"+sdf1.format(d1)+"', "+bx5.getSelectedItem()+" , "+Integer.parseInt(tf13.getText())+", "+tf14.getText()+", '"+sst+"' )";
stm.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"Successfully Saved");




}
if(ae.getSource()==b4)
{



Date rdob=new Date();
String rgen="";
String rdep="";
int bal=0;
ResultSet rs1=stm.executeQuery("select user_id from student_data where roll_no='"+tf0.getText()+"'");
if(rs1.next())
{
ResultSet rs=stm.executeQuery("select * from student_data where roll_no='"+tf0.getText()+"'");
while(rs.next())
{
tf1.setText(rs.getString(1));
tf2.setText(rs.getString(2));
tf3.setText(rs.getString(3));
tf4.setText(rs.getString(4));
tf5.setText(rs.getString(5));
rdob=rs.getDate(6);
rgen=rs.getString(7);
tf6.setText(rs.getString(8));
tf7.setText(rs.getString(9));
tf8.setText(rs.getString(10));
tf9.setText(rs.getString(11));
tf10.setText(rs.getString(12));
tf11.setText(rs.getString(17));
rdep=rs.getString(19);
tf13.setText(rs.getString(23));
tf12.setText(sdf.format(d1));
}
if(rgen.equals("Male"))
rb1.setSelected(true);
else if(rgen.equals("Female"))
rb1.setSelected(true);
bx4.setSelectedItem(rdep);

int m=0;
m=rdob.getMonth();
bx1.setSelectedIndex(m+2);

int y=0;
y=rdob.getYear();
bx3.setSelectedItem(String.valueOf(1900+y));

int d=0;
d=rdob.getDate();
bx2.setSelectedItem(String.valueOf(d));
b1.setEnabled(true);

ResultSet rs0=stm.executeQuery("select max(semester), balance from fee_detail where roll_no='"+tf0.getText()+"'");
while(rs0.next())
{
ssem=rs0.getInt(1);
bal=rs0.getInt(2);
}

if(bal==0)
bx5.setSelectedItem(ssem+1);
else
{
JOptionPane.showMessageDialog(this,"your balance is pending of semester "+ssem+" first you have to clear it then regenerate");
b1.setEnabled(false);
}

String az="";
az=String.valueOf(d2.getYear()+1900)+"-"+String.valueOf(d2.getYear()+1900+1);
tf14.setText(az);

}
else 
JOptionPane.showMessageDialog(this,"Roll Number Doesn't Exist");



}



}
catch(NumberFormatException ne)
{
JOptionPane.showMessageDialog(this,"Kindy Input First Employee Id In Find Box");
}
catch(Exception e)
{
//JOptionPane.showMessageDialog(this,e);
e.printStackTrace();
}
}

public static void main(String lk[])
{
new regeneration();
}
}