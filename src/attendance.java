import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.Date;
import java.text.*;
class attendance extends JInternalFrame implements ItemListener,ActionListener,FocusListener
{
JLabel l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2,tf3;
JComboBox bx2;
JButton b1,b2;
Connection con;
Statement stm;
JTable jt;
JScrollPane sp;
ImageIcon i1;
java.util.Date d1=new Date();
java.text.SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
java.text.SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy"); 
String user="";
Container con1=getContentPane();
attendance(String id)
{

super("Attendence",true,true,true,true);
user=id;

i1=new ImageIcon("attendence.jpg");
l6=new JLabel(i1);
jt=new JTable();
sp=new JScrollPane();

setSize(1000,1000);
setLayout(null);


con1.setBackground(Color.green);
l1=new JLabel("Attendance");
l2=new JLabel("Date");
l3=new JLabel("Department");
l4=new JLabel("Subject");
l5=new JLabel("Semester");


l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));

tf1=new JTextField(50);
tf2=new JTextField(50);
tf3=new JTextField(50);

tf1.setOpaque(false);
tf2.setOpaque(false);
tf3.setOpaque(false);


tf1.setFont(new Font("Times New Roman",Font.BOLD,15));
tf2.setFont(new Font("Times New Roman",Font.BOLD,15));
tf3.setFont(new Font("Times New Roman",Font.BOLD,15));

l1.setForeground(Color.black);
l2.setForeground(Color.white);
l3.setForeground(Color.white);
l4.setForeground(Color.white);
l5.setForeground(Color.white);

tf1.setForeground(Color.white);
tf2.setForeground(Color.white);
tf3.setForeground(Color.white);


bx2=new JComboBox();

b1=new JButton("Show");
b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2=new JButton("Save");
b2.setFont(new Font("Segoe Script",Font.BOLD,25));

bx2.setFont(new Font("Segoe Script",Font.BOLD,25));


bx2.addItem("Select");
int u=0;
for(u=1;u<=8;u++)
{
bx2.addItem(u);
}


add(l1);
add(l2);
add(l3);
add(l4);
add(l5);

add(tf1);
add(tf2);
add(tf3);

add(bx2);

add(b1);
add(b2);
l6.setBounds(0,0,1370,750);
l1.setBounds(20,20,400,30);
l2.setBounds(20,90,200,20);
tf1.setBounds(20,115,300,30);
l3.setBounds(20,155,200,20);
tf2.setBounds(20,180,300,30);
l4.setBounds(20,285,200,20);
tf3.setBounds(20,310,300,30);
l5.setBounds(20,220,200,20);
bx2.setBounds(20,245,300,30);
b1.setBounds(70,350,150,30);
b2.setBounds(900,670,150,30);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
ResultSet rs=stm.executeQuery("select department from subject_allotment where faculty_id='"+user+"'");
if(rs.next())
{
tf2.setText(rs.getString(1));
b1.setEnabled(true);


bx2.setEnabled(true);
}
else
{
JOptionPane.showMessageDialog(this,"Subjects Are Not Alloted To You Kindly Ask To Admin to Allot YOU Your Subjects");
b1.setEnabled(false);
b2.setEnabled(false);
bx2.setEnabled(false);
}
}
catch(Exception e)
{
System.out.println(e);
}

bx2.addItemListener(this);
b1.addActionListener(this);
b2.addActionListener(this);

tf1.setText(sdf2.format(d1));
bx2.addFocusListener(this);

tf1.setEditable(false);
tf2.setEditable(false);
tf3.setEditable(false);

add(sp);
add(l6);

b2.setVisible(false);
setVisible(true);
}
int size=0;
int x=0;
public void itemStateChanged(ItemEvent ie)
{
try
{
if(ie.getSource()==bx2)
{
String jk="";
ResultSet rse=stm.executeQuery("select subject_name from subject_allotment where faculty_id='"+user+"' and semester="+bx2.getSelectedIndex());
if(rse.next())
tf3.setText(rse.getString(1));
else 
JOptionPane.showMessageDialog(this,"Subjects Are Not Alloted To you Of  "+tf2.getText()+" semester "+bx2.getSelectedIndex()+"");


if(bx2.getSelectedIndex()==1)
{
ResultSet rs0=stm.executeQuery("select count(*) from student_data where stream='"+tf2.getText()+"'");
if(rs0.next())
size=rs0.getInt(1);
if(size>0)
x=1;
else
JOptionPane.showMessageDialog(this,"Record Not Found For 1st Semester");
}
else 
{
ResultSet rs01=stm.executeQuery("select count(*) from regeneration where stream='"+tf2.getText()+"' and semester='"+bx2.getSelectedItem()+"'");
if(rs01.next())
size=rs01.getInt(1);
if(size>0)
x=2;
else
JOptionPane.showMessageDialog(this,"Record Not Found For Semester  "+bx2.getSelectedIndex());
}

}
}
catch(Exception e)
{
//System.out.println(e);
e.printStackTrace();
}
}

public void focusGained(FocusEvent fe)
{

}
public void focusLost(FocusEvent fe)
{






}

public void actionPerformed(ActionEvent ae)
{
int o=0;
try
{
if(ae.getSource()==b1)
{
String s1[]={"Roll No","Name","Presence"};
Object obj[][]=new Object[size][3];

if(sp!=null)
remove(sp);


if(x==1)
{
ResultSet rs00=stm.executeQuery("select roll_no , first_name , last_name from student_data where stream='"+tf2.getText()+"'");
while(rs00.next())
{
obj[o][0]=rs00.getString(1);
obj[o][1]=rs00.getString(2)+" "+rs00.getString(3);
obj[o][2]=true;
o++;
}
}
else
{
String op="";
ResultSet rs00=stm.executeQuery("select roll_no  from regeneration where stream='"+tf2.getText()+"' and semester='"+bx2.getSelectedItem()+"'");
if(rs00.next())
op=rs00.getString(1);
ResultSet rs001=stm.executeQuery("select roll_no, first_name,last_name from student_data where roll_no='"+op+"'");
while(rs001.next())
{
obj[o][0]=rs001.getString(1);
obj[o][1]=rs001.getString(2)+" "+rs001.getString(3);
obj[o][2]=true;
o++;
}
}





DefaultTableModel model1=new DefaultTableModel(obj,s1);
jt=new JTable(model1) 	
{
public Class getColumnClass(int col)
{
if(col==2)
return Boolean.class;
else 
return String.class;
}
public boolean isCellEditable(int r,int c)
{
if(c==2)
return true;
else 
return false;
}

};

//jt.setOpaque(false);
//((DefaultTableCellRenderer)jt.getDefaultRenderer(Object.class)).setOpaque(false);
sp=new JScrollPane(jt);
//sp.setOpaque(false);
//sp.getViewport().setOpaque(false);
sp.setBounds(400,50,800,30*(size+1));
add(sp);
b2.setVisible(true);
}
if(ae.getSource()==b2)
{
String check="";
for(int w=0;w<size;w++)
{
if((boolean)jt.getValueAt(w,2))
check="P";
else 
check="A";
String sa="insert into attendance values('"+sdf1.format(d1)+"' , '"+tf3.getText()+"', '"+jt.getValueAt(w,0)+"' , '"+jt.getValueAt(w,1)+"' , '"+check+"' )";
stm.executeUpdate(sa);
}
JOptionPane.showMessageDialog(this,"Successfully Saved");
b2.setEnabled(false);
}

}
catch(Exception e)
{
//System.out.println(e);
e.printStackTrace();
}
}
public static void main(String po[])
{
new attendance("");
}
}



