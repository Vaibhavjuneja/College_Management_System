import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class marks extends JInternalFrame implements ItemListener,ActionListener
{
JLabel l0,l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2,tf3;
JComboBox bx1,bx2;
JButton b1,b2;
Connection con;
Statement stm;
JTable jt;
JScrollPane sp;
String user="";
Container con1=getContentPane();
ImageIcon i1;
marks(String id)
{
super("Create New Employee",true,true,true,true);
user=id;
setSize(1000,1000);
setLayout(null);

con1.setBackground(Color.yellow);

i1=new ImageIcon("marks.jpg");
l6=new JLabel(i1);

jt=new JTable();
sp=new JScrollPane(jt);

l0=new JLabel("Allot Marks");
l1=new JLabel("Department");
l2=new JLabel("Semester");
l3=new JLabel("Subjects");
l4=new JLabel("Type");
l5=new JLabel("Out Of");

l0.setFont(new Font("Segoe Script",Font.BOLD,30));
l1.setFont(new Font("Segoe Script",Font.BOLD,20));
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


tf1.setFont(new Font("Segoe Script",Font.BOLD,15));
tf2.setFont(new Font("Segoe Script",Font.BOLD,15));
tf3.setFont(new Font("Segoe Script",Font.BOLD,15));


bx1=new JComboBox();
bx2=new JComboBox();

bx1.setFont(new Font("Segoe Script",Font.BOLD,25));
bx2.setFont(new Font("Segoe Script",Font.BOLD,25));



bx1.addItem("Select Sem");
for(int z=1;z<=8;z++)
{
bx1.addItem(z);
}

bx2.addItem("Select Type");
bx2.addItem("Sessional 1");
bx2.addItem("Sessional 2");
bx2.addItem("Internal");


b1=new JButton("Show");
b2=new JButton("Save");

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));

add(l0);
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);

add(tf1);
add(tf2);
add(tf3);

add(bx1);
add(bx2);

add(b1);
add(b2);

l6.setBounds(0,0,1370,750);
l0.setBounds(20,20,400,30);
l1.setBounds(20,90,200,20);
tf1.setBounds(20,115,300,30);
l2.setBounds(20,155,200,20);
bx1.setBounds(20,180,300,30);
l3.setBounds(20,220,200,20);
tf2.setBounds(20,245,300,30);
l4.setBounds(20,285,200,20);
bx2.setBounds(20,310,300,30);
l5.setBounds(20,350,150,20);
tf3.setBounds(20,375,300,30);
b1.setBounds(100,415,150,30);
b2.setBounds(750,670,100,30);
b2.setVisible(true);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
ResultSet rs=stm.executeQuery("select distinct department from subject_allotment where faculty_id='"+user+"'");
if(rs.next())
tf1.setText(rs.getString(1));
}
catch(Exception e)
{
System.out.println(e);
}

bx1.addItemListener(this);
bx2.addItemListener(this);

b1.addActionListener(this);
b2.addActionListener(this);

b2.setVisible(false);
add(sp);
add(l6);
setVisible(true);
}

int size=0;
int x=0;
public void itemStateChanged(ItemEvent ie)
{
try
{
if(ie.getSource()==bx1)
{
ResultSet rs=stm.executeQuery("select subject_name from subject_allotment where faculty_id='"+user+"' and semester="+bx1.getSelectedIndex());
if(rs.next())
tf2.setText(rs.getString(1));
else 
{
tf2.setText("");
JOptionPane.showMessageDialog(this,"You Dont Have Allowance To Access "+tf1.getText()+" "+bx1.getSelectedIndex()+" semester ");
}
}

if((bx2.getSelectedIndex()==1)||(bx2.getSelectedIndex()==2))
tf3.setText(String.valueOf(40));
else if(bx2.getSelectedIndex()==3)
tf3.setText(String.valueOf(20));

if(bx1.getSelectedIndex()==1)
{
ResultSet rs0=stm.executeQuery("select count(*) from student_data where stream='"+tf1.getText()+"'");
if(rs0.next())
{
size=rs0.getInt(1);
x=1;
}
}
else 
{
ResultSet rs1=stm.executeQuery("select count(*) from regeneration where stream='"+tf1.getText()+"' and semester="+bx1.getSelectedIndex());
if(rs1.next())
size=rs1.getInt(1);
}




}
catch(Exception e)
{
System.out.println(e);
}

}


public void actionPerformed(ActionEvent ae)
{
Double se=0.0,s2=0.0,i1=0.0;
int i=0;
String rl="";
try
{
if(ae.getSource()==b1)
{
b2.setEnabled(true);

String s1[]={"Roll_no","Name","Marks"};
Object obj[][]=new Object[size][3];


if(sp!=null)
remove(sp);

if(x==1)
{
ResultSet rs00=stm.executeQuery("select roll_no , first_name , last_name from student_data where stream='"+tf1.getText()+"'");
while(rs00.next())
{
rl=rs00.getString(1);
obj[i][1]=rs00.getString(2)+rs00.getString(3);
obj[i][0]=rl;
i++;
}

int type=bx2.getSelectedIndex();
int j=0;
while(j<i)
{
ResultSet rs2=stm.executeQuery("select * from student_record where roll_no='"+obj[j][0]+"' and semester="+bx1.getSelectedIndex());
while(rs2.next())
{
se=rs2.getDouble(5);
s2=rs2.getDouble(6);
i1=rs2.getDouble(7);
}
rs2.close();

if(type==1)
{
if(se>0)
{
obj[j][2]=se;
b2.setEnabled(false);
}
}
else if(type==2)
{
if(s2>0)
{
obj[j][2]=s2;
b2.setEnabled(false);
}
}
else if(type==3)
{
if(i1>0)
{
obj[j][2]=i1;
b2.setEnabled(false);
}
}

j++;
}

}
else
{
String op="";
ResultSet rs00=stm.executeQuery("select roll_no  from regeneration where stream='"+tf1.getText()+"' and semester='"+bx1.getSelectedItem()+"'");
if(rs00.next())
op=rs00.getString(1);
ResultSet rs001=stm.executeQuery("select roll_no, first_name,last_name from student_data where roll_no='"+op+"'");
while(rs001.next())
{
obj[i][0]=rs001.getString(1);
obj[i][1]=rs001.getString(2)+rs001.getString(3);
i++;
}
int type=bx2.getSelectedIndex();
int j=0;
while(j<i)
{
ResultSet rs2=stm.executeQuery("select * from student_record where roll_no='"+obj[j][0]+"' and semester="+bx1.getSelectedIndex());
while(rs2.next())
{
se=rs2.getDouble(5);
s2=rs2.getDouble(6);
i1=rs2.getDouble(7);
}
rs2.close();

if(type==1)
{
if(se>0)
{
obj[j][2]=se;
b2.setEnabled(false);
}
}
else if(type==2)
{
if(s2>0)
{
obj[j][2]=s2;
b2.setEnabled(false);
}
}
else if(type==3)
{
if(i1>0)
{
obj[j][2]=i1;
b2.setEnabled(false);
}
}

j++;
}

}








DefaultTableModel model1=new DefaultTableModel(obj,s1);
jt=new JTable(model1) 	
{
public boolean isCellEditable(int r,int c)
{
if(c==2)
return true;
else 
return false;
}
};

sp=new JScrollPane(jt);
sp.setBounds(400,50,800,30*(size+1));
add(sp);
b2.setVisible(true);

}
if(ae.getSource()==b2)
{
if(bx2.getSelectedIndex()==1)
{
for(int k=0;k<size;k++)
{
String si="insert into student_record values('"+user+"', "+bx1.getSelectedIndex()+" , '"+tf2.getText()+"' , '"+jt.getValueAt(k,0)+"' ,  "+Double.parseDouble(jt.getValueAt(k,2).toString())+" , "+0+", "+0+")";
stm.executeUpdate(si);
}
JOptionPane.showMessageDialog(this,"Successfully Saved");
}
else if(bx2.getSelectedIndex()==2)
{
for(int j=0;j<size;j++)
{
String su="update  student_record set sessional_2_40="+Double.parseDouble(jt.getValueAt(j,2).toString())+" where roll_no='"+jt.getValueAt(j,0)+"'";
stm.executeUpdate(su);
}
JOptionPane.showMessageDialog(this,"Successfully Saved");
}
else if(bx2.getSelectedIndex()==3)
{
for(int y=0;y<size;y++)
{
String su2="update student_record set internal_20="+Double.parseDouble(jt.getValueAt(y,2).toString())+" where roll_no='"+jt.getValueAt(y,0)+"'";
stm.executeUpdate(su2);
}
JOptionPane.showMessageDialog(this,"Successfully Saved");
}


}
}
catch(Exception e)
{
e.printStackTrace();
}
}
public static void main(String kj[])
{
new marks("");
}
}


