import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
class subject_allotment extends JInternalFrame implements FocusListener,ActionListener,ItemListener
{
JLabel l1,l2,l3,l4;
JTextField tf1;
JComboBox bx1,bx2,bx3;
JTable jt;
JScrollPane sp;
JButton b1,b2;
Connection con;
Statement stm;
Container con1=getContentPane();
subject_allotment()
{
super("Subject Allotment",true,true,true,true);
setSize(1000,1000);
setLayout(null);

con1.setBackground(Color.pink);
l1=new JLabel("Subject Allotment");
l2=new JLabel("Employee Id");
l3=new JLabel("Department");
l4=new JLabel("Semester");


l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
//l5.setFont(new Font("Segoe Script",Font.BOLD,20));


bx1=new JComboBox();
bx2=new JComboBox();
bx3=new JComboBox();

bx1.setFont(new Font("Segoe Script",Font.BOLD,25));
bx2.setFont(new Font("Segoe Script",Font.BOLD,25));
bx3.setFont(new Font("Segoe Script",Font.BOLD,25));


bx1.addItem("Department");
bx2.addItem("Semester");
bx2.addItem("1st");
bx2.addItem("2nd");
bx2.addItem("3rd");
bx2.addItem("4th");
bx2.addItem("5th");
bx2.addItem("6th");
bx2.addItem("7th");
bx2.addItem("8th");

bx3.addItem("select");

b1=new JButton("Search Subjects");
b2=new JButton("Save Subjects");

bx1.setFont(new Font("Segoe Script",Font.BOLD,25));
bx2.setFont(new Font("Segoe Script",Font.BOLD,25));

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));



add(l1);
add(l2);
add(l3);
add(l4);


add(bx1);
add(bx2);
add(bx3);


add(b1);
add(b2);


l1.setBounds(20,50,300,30);
l2.setBounds(20,100,150,20);
bx3.setBounds(20,125,300,30);
l3.setBounds(20,165,150,20);
bx1.setBounds(20,190,300,30);
l4.setBounds(20,230,150,20);
bx2.setBounds(20,255,300,30);
b1.setBounds(20,295,200,30);
b2.setBounds(570,450,200,30);

bx3.addItemListener(this);
b2.setVisible(false);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
ResultSet rs=stm.executeQuery("select department_name from department_master");
while(rs.next())
{
bx1.addItem(rs.getString(1));
}
ResultSet rs1=stm.executeQuery("select user_id from employee_data where etitle='Faculty'");
while(rs1.next())
{
bx3.addItem(rs1.getString(1));
}

}
catch(Exception e)
{
System.out.println(e);
}

b1.addActionListener(this);
b2.addActionListener(this);


setVisible(true);

}

public void focusGained(FocusEvent fe)
{}
public void focusLost(FocusEvent fe)
{}


public void itemStateChanged(ItemEvent ie)
{
try
{
if(ie.getSource()==bx3)
{
String uy="";
ResultSet rs=stm.executeQuery("select department from employee_data where user_id='"+bx3.getSelectedItem()+"'");
if(rs.next())
uy=rs.getString(1);
bx1.setSelectedItem(uy);
}

}
catch(Exception e)
{
System.out.println(e);
}

}

int size=0;
int z=0;
public void actionPerformed(ActionEvent ae)
{
String dcode="";
int k=0;
try
{
if(ae.getSource()==b1)
{
ResultSet rs0=stm.executeQuery("select department_code from department_master where department_name='"+bx1.getSelectedItem()+"'");
if(rs0.next())
dcode=rs0.getString(1);
ResultSet rs=stm.executeQuery("select count(*) from subject_master where department_code='"+dcode+"' and semester='"+bx2.getSelectedItem()+"'");
if(rs.next())
size=rs.getInt(1);


if(size==0)
JOptionPane.showMessageDialog(this,"Subjects Doesn't Exists For "+bx1.getSelectedItem().toString()+"  "+bx2.getSelectedItem().toString());
else if(size>0)
{
if(sp!=null)
remove(sp);

String s1[]={"Subject Code","Subject Name","Allotment"};

Object obj[][]=new Object[size][3];
int i=0;



ResultSet rs1=stm.executeQuery("select subject_code , subject_name from subject_master where department_code='"+dcode+"' and semester='"+bx2.getSelectedItem()+"'");
String ss="";
while(rs1.next())
{
ss=rs1.getString(1);
obj[k][0]=ss;
obj[k][1]=rs1.getString(2);

k++;
}
int q=0;
while(q<k)
{
String s3="select count(*) from subject_allotment where faculty_id='"+bx3.getSelectedItem()+"' and subject_code='"+obj[q][0]+"'";

ResultSet rs00=stm.executeQuery(s3);
int n=0;
if(rs00.next())
n=rs00.getInt(1);
rs00.close();
if(n>0)
{
obj[q][2]=true;
}
else
{
obj[q][2]=false;
}
q++;
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

sp=new JScrollPane(jt);
sp.setBounds(350,50,800,300);
add(sp);


b2.setEnabled(true);
b2.setVisible(true);
}
}

if(ae.getSource()==b2)
{



for(z=0;z<size;z++)
{
ResultSet rs00=stm.executeQuery("select * from subject_allotment where faculty_id='"+bx3.getSelectedItem()+"' and subject_code='"+jt.getValueAt(z,0)+"'");
if(rs00.next())
{
String sd="delete from subject_allotment where faculty_id='"+bx3.getSelectedItem()+"' and subject_code='"+jt.getValueAt(z,0)+"'";
stm.executeUpdate(sd);
}
if((Boolean)(jt.getValueAt(z,2)))
{
String sb="insert into subject_allotment values('"+bx3.getSelectedItem()+"' , '"+bx1.getSelectedItem()+"' , '"+bx2.getSelectedIndex()+"', '"+jt.getValueAt(z,1)+"', '"+jt.getValueAt(z,0)+"' )";
stm.executeUpdate(sb);
}
}
JOptionPane.showMessageDialog(this,"Successfully saved");
b2.setEnabled(false);
}
}

catch(Exception e)
{
//System.out.println(e);
e.printStackTrace();
}

}

public static void main(String kl[])
{
new subject_allotment();
}
}