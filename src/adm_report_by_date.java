import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.*;
class adm_report_by_date extends JInternalFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2;
JButton b1;
JTable jt;
JScrollPane sp;
Connection con;
Statement stm;
Container con1=getContentPane();
ImageIcon i1;
Date d1=new Date();
Date d2=new Date();
Date d3=new Date();
java.text.SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
java.text.SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
adm_report_by_date()
{

super("Admission Report By Date",true,true,true,true);
setSize(1000,1000);
setLayout(null);

con1.setBackground(Color.yellow); 

i1=new ImageIcon("rept.jpg");
l6=new JLabel(i1);

jt=new JTable();
sp=new JScrollPane(jt);

l1=new JLabel("Admission Report");
l2=new JLabel("Start Date");
l3=new JLabel("End Date");
l4=new JLabel("(dd/mm/yyyy)");
l5=new JLabel("(dd/mm/yyyy)");


l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,10));
l5.setFont(new Font("Segoe Script",Font.BOLD,10));

l1.setForeground(Color.white);
l2.setForeground(Color.white);
l3.setForeground(Color.white);
l4.setForeground(Color.white);
l5.setForeground(Color.white);

tf1=new JTextField(50);
tf2=new JTextField(50);

tf1=new JTextField(50);
tf2=new JTextField(50);

tf1.setFont(new Font("Times New Roman",Font.BOLD,15));
tf2.setFont(new Font("Times New Roman",Font.BOLD,15));

b1=new JButton("Show");
b1.setFont(new Font("Segoe Script",Font.BOLD,25));

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);

add(tf1);
add(tf2);

add(b1);

l6.setBounds(0,0,1370,750);
l1.setBounds(400,50,300,30);
l2.setBounds(100,100,150,20);
tf1.setBounds(250,100,200,30);
l3.setBounds(700,100,150,20);
tf2.setBounds(850,100,200,30);
b1.setBounds(520,150,150,30);
l4.setBounds(450,100,200,20);
l5.setBounds(1050,100,200,20);

add(sp);

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

add(l6);
setVisible(true);
JOptionPane.showMessageDialog(this,"Fill The Dates In Between You Require The Report If Report Of A Particular Date Is Required Then Fill Same Date In Both Fields");
}

String dt="";
int size=0;
String sd1="",sd2="";
public void actionPerformed(ActionEvent ae)
{
int j=0;
try
{
if(ae.getSource()==b1)
{
if(sp!=null)
remove(sp);

sd1=sdf1.format(sdf.parse(tf1.getText()));
sd2=sdf1.format(sdf.parse(tf2.getText()));

ResultSet rs=stm.executeQuery("select count(*) from student_data where admission_date between '"+sd1+"' and '"+sd2+"'");
if(rs.next())
size=rs.getInt(1);
rs.close();

String s1[]={"Serial No","Admission No","Department","Roll No","Name","Admission Date"};
Object obj[][]=new Object[size][6];

ResultSet rs1=stm.executeQuery("select admission_number , stream, roll_no , first_name , last_name ,admission_date from student_data where admission_date between '"+sd1+"' and '"+sd2+"'");
while(rs1.next())
{
obj[j][0]=j+1;
obj[j][1]=rs1.getInt(1);
obj[j][2]=rs1.getString(2);
obj[j][3]=rs1.getString(3);
obj[j][4]=rs1.getString(4)+" "+rs1.getString(5);
obj[j][5]=rs1.getString(6);
j++;
}


jt=new JTable(obj,s1);
sp=new JScrollPane(jt);
sp.setBounds(100,200,1000,30*(size+1));
add(sp);
}
}
catch(ParseException pe)
{
JOptionPane.showMessageDialog(this,"Please Enter Valid Dates");
}
catch(Exception e)
{
System.out.println(e);
//e.printStackTrace();
}
}





public static void main(String oi[])
{
new adm_report_by_date();
}
}