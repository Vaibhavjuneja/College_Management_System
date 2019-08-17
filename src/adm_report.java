import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class adm_report extends JInternalFrame implements ActionListener
{
JLabel l1,l2,l3,l4;
JComboBox bx1,bx2;
JButton b1;
Connection con;
Statement stm;
Container con1=getContentPane();
JTable jt;
JScrollPane sp;
ImageIcon i1;
adm_report()
{
super("Admission Report",true,true,true,true);

setLayout(null);
setSize(1000,1000);
con1.setBackground(Color.cyan);


l1=new JLabel("Admission Report");
l2=new JLabel("Session");
l3=new JLabel("Department");

i1=new ImageIcon("report.png");
l4=new JLabel(i1);

l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));


bx1=new JComboBox();
bx2=new JComboBox();
bx1.setFont(new Font("Segoe Script",Font.BOLD,20));
bx2.setFont(new Font("Segoe Script",Font.BOLD,20));

b1=new JButton("Show");
b1.setFont(new Font("Segoe Script",Font.BOLD,25));

add(l1);
add(l2);
add(l3);

bx1.addItem("Select");


bx2.addItem("Department");

add(bx1);
add(bx2);

add(b1);

l4.setBounds(0,0,1370,750);
l1.setBounds(20,20,400,30);
l2.setBounds(20,90,200,20);
bx1.setBounds(20,115,300,30);
l3.setBounds(20,155,200,20);
bx2.setBounds(20,180,300,30);
b1.setBounds(70,220,150,30);


try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
ResultSet rs0=stm.executeQuery("select distinct session from student_data");
while(rs0.next())
{
bx1.addItem(rs0.getString(1));
}


ResultSet rs=stm.executeQuery("select department_name from department_master");
while(rs.next())
{
bx2.addItem(rs.getString(1));
}
}
catch(Exception e)
{
System.out.println(e);
}

b1.addActionListener(this);

add(l4);
setVisible(true);
}
int size=0;
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b1)
{
ResultSet rs=stm.executeQuery("select count(*) from student_data where session='"+bx1.getSelectedItem()+"'");
if(rs.next())
size=rs.getInt(1);

if(sp!=null)
remove(sp);

String sjt[]={"Adm No","Roll No","Name","Father Name","Date Of Birth"};
Object obj[][]=new Object[size][5];
int t=0;

jt=new JTable(obj,sjt);
sp=new JScrollPane(jt);
jt.setOpaque(false);
//sp.setOpaque(false);
sp.setBounds(400,30,800,20*size);
add(sp);

ResultSet rs1=stm.executeQuery("select admission_number , roll_no , first_name , father_name ,dob from student_data where session='"+bx1.getSelectedItem()+"' and stream='"+bx2.getSelectedItem()+"'");
while(rs1.next())
{
jt.setValueAt((rs1.getString(1)),t,0);
jt.setValueAt((rs1.getString(2)),t,1);
jt.setValueAt((rs1.getString(3)),t,2);
jt.setValueAt((rs1.getString(4)),t,3);
jt.setValueAt((rs1.getString(5)),t,4);
t++;
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
new adm_report();
}
}