import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
class subject_master extends JInternalFrame implements ItemListener, ActionListener
{
JLabel l1,l2,l3,l4,l5,l6;
JTextField tf1,tf2,tf3;
JButton b1,b2,b3,b4,b5;
JComboBox bx1,bx2;
JTable jt,jt1;
JScrollPane sp,sp1;
Container con1=getContentPane();
Connection con;
Statement stm;

subject_master()
{
super("Subject Master",true,true,true,true);
setSize(1300,600); 
setTitle("Subject Master");

setLayout(null);

con1.setBackground(Color.cyan);

l1=new JLabel("Subject_Master");
l2=new JLabel("Department");
l3=new JLabel("Department Code");
l4=new JLabel("Semester");
l5=new JLabel("No. of Subjects");
l6=new JLabel("No. of Subjects");


l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,20));
l4.setFont(new Font("Segoe Script",Font.BOLD,20));
l5.setFont(new Font("Segoe Script",Font.BOLD,20));
l6.setFont(new Font("Segoe Script",Font.BOLD,20));


tf1=new JTextField(30);
tf2=new JTextField(30);
tf3=new JTextField(30);


tf1.setFont(new Font("Times New Roman",Font.BOLD,15));
tf2.setFont(new Font("Times New Roman",Font.BOLD,15));
tf3.setFont(new Font("Times New Roman",Font.BOLD,15));


bx1=new JComboBox();
bx2=new JComboBox();

bx1.setFont(new Font("Segoe Script",Font.BOLD,25));
bx2.setFont(new Font("Segoe Script",Font.BOLD,25));


b1=new JButton("Add Subject");
b2=new JButton("Save");
b3=new JButton("Modify");
b4=new JButton("Add Subjects");
b5=new JButton("save");


b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));
b3.setFont(new Font("Segoe Script",Font.BOLD,25));
b4.setFont(new Font("Segoe Script",Font.BOLD,25));
b5.setFont(new Font("Segoe Script",Font.BOLD,25));


bx1.addItem("Select");





bx2.addItem("Select");
bx2.addItem("1st");
bx2.addItem("2nd");
bx2.addItem("3rd");
bx2.addItem("4th");
bx2.addItem("5th");
bx2.addItem("6th");
bx2.addItem("7th");
bx2.addItem("8th");


add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);


add(tf1);
add(tf2);
add(tf3);


add(bx1);
add(bx2);

add(b1);
add(b2);
add(b3);
add(b4);
add(b5);


l1.setBounds(200,30,300,30);
l2.setBounds(100,70,200,30);
bx1.setBounds(250,70,400,30);
l3.setBounds(100,110,200,30);
tf1.setBounds(310,110,200,30);
l4.setBounds(100,150,200,30);
bx2.setBounds(310,150,200,30);
l5.setBounds(100,190,200,30);
tf2.setBounds(310,190,200,30);
b1.setBounds(260,230,200,30);
b2.setBounds(900,350,100,25);
b3.setBounds(1010,350,150,25);
l6.setBounds(20,280,200,20);
tf3.setBounds(20,305,300,30);
b4.setBounds(325,305,150,30);


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
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e);
}


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);

	
bx1.addItemListener(this);
bx2.addItemListener(this);

tf1.setEditable(false);

b2.setVisible(false);
b3.setVisible(false);
l6.setVisible(false);
tf3.setVisible(false);
b4.setVisible(false);



setVisible(true);
}
int sz=0;
int op=0;
public void itemStateChanged(ItemEvent ie)
{
op=0;
try
{
if(ie.getSource()==bx1)
{
ResultSet rs=stm.executeQuery("select department_code from department_master where department_name='"+bx1.getSelectedItem().toString()+"'"+"");
if(rs.next())
tf1.setText(rs.getString(1));

b2.setVisible(false);
b3.setVisible(false);


}
if(ie.getSource()==bx2)
{
ResultSet rs0=stm.executeQuery("select count(*) from subject_master where department_code='"+tf1.getText()+"' and semester='"+bx2.getSelectedItem()+"'");
if(rs0.next())
sz=rs0.getInt(1);
if(sz>0)
{
tf2.setText(String.valueOf(sz));
b1.setText("Show Subjects");
b2.setEnabled(false);
b3.setEnabled(true);
op=1;
}
else
{
tf2.setText("");
b1.setText("Add Subjects");
b3.setEnabled(false);
b2.setEnabled(true);
l6.setVisible(false);
tf3.setVisible(false);
b4.setVisible(false);

}
}




}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e);
}
}


int size=0;
int count=0;
int size1=0;

int p=0;
String hj="";
int jl=0;
public void actionPerformed(ActionEvent ae)
{
int m=0;
int y=0;
int k=0;
int i=0;
try
{
if(ae.getSource()==b1)
{



if(sp!=null)
remove(sp);

size=Integer.parseInt(tf2.getText());

String s1[]={"Subject Code","Subject Name"};

size=Integer.parseInt(tf2.getText());

Object obj[][]=new Object[size][2];


String scode=tf1.getText()+bx2.getSelectedIndex()+"0";

DefaultTableModel model1=new DefaultTableModel(obj,s1);
jt=new JTable(model1) 	
{
public boolean isCellEditable(int r,int c)
{
if(c==1)
return true;
else 
return false;
}
};


sp=new JScrollPane(jt);
sp.setBounds(700,50,500,300);
add(sp);

jt.setVisible(true);
b2.setVisible(true);
b3.setVisible(true);



if(op==1)
{
l6.setVisible(true);
tf3.setVisible(true);
b4.setVisible(true);
}

ResultSet rs=stm.executeQuery("select count(*) from subject_master where department_code='"+tf1.getText()+"' and semester='"+bx2.getSelectedItem()+"'");
if(rs.next())
y=rs.getInt(1);
if(y>0)
{
ResultSet rs1=stm.executeQuery("select subject_code,subject_name from subject_master where  department_code='"+tf1.getText()+"' and semester='"+bx2.getSelectedItem()+"'");
while(rs1.next())
{
jt.setValueAt((rs1.getString(1)),k,0);
jt.setValueAt((rs1.getString(2)),k,1);
k++;
}
jl=k;
}
else
{
while(i<size)
{
jt.setValueAt((scode+(i+1)),i,0);
i++;
}
}




b2.setVisible(true);
b3.setVisible(true);
}

if(ae.getSource()==b2)
{
/*for(m=0;m<size;m++)
{
hj=jt.getValueAt(m,1).toString();
if((hj==null)||(hj.equals("")))
{
count=1;
}
}*/


if(count==1)
JOptionPane.showMessageDialog(this,"Please Enter All The Subjects First");


if(count==0)
{
for(i=0;i<size;i++)
{
String s1="insert into subject_master values('"+tf1.getText()+"', '"+bx2.getSelectedItem()+"', '"+jt.getValueAt(i,0)+"', '"+jt.getValueAt(i,1)+"' )";
stm.executeUpdate(s1);
}
JOptionPane.showMessageDialog(this,"Successfully Saved");
}
}


if(ae.getSource()==b3)
{
int o=0;
for(o=0;o<size;o++)
{
String sup="update subject_master set subject_name='"+jt.getValueAt(o,1)+"' where subject_code='"+jt.getValueAt(o,0)+"'";
stm.executeUpdate(sup);
}
JOptionPane.showMessageDialog(this,"Successfully Modified");
}

if(ae.getSource()==b4)
{
size1=Integer.parseInt(tf3.getText());
String s1[]={"Subject Code","Subject Name"};
Object obj[][]=new Object[size1][2];

String scode=tf1.getText()+bx2.getSelectedIndex()+"0";

while(p<size1)
{
obj[p][0]=scode+(jl+1);
p++;
jl++;
}

DefaultTableModel model1=new DefaultTableModel(obj,s1);
jt1=new JTable(model1) 	
{
public boolean isCellEditable(int r,int c)
{
if(c==1)
return true;
else 
return false;
}
};

sp1=new JScrollPane(jt1);
sp1.setBounds(20,400,500,150);
b5.setBounds(200,570,100,30);
add(sp1);

}


if(ae.getSource()==b5)
{
int u=0;
for(u=0;u<Integer.parseInt(tf3.getText());u++)
{
String si="insert into subject_master values('"+tf1.getText()+"', '"+bx2.getSelectedItem()+"', '"+jt1.getValueAt(u,0)+"', '"+jt1.getValueAt(u,1)+"' )";
stm.executeUpdate(si);
}
JOptionPane.showMessageDialog(this,"Successfully Saved");

}



}
catch(NumberFormatException ne)
{
JOptionPane.showMessageDialog(this,"Please Enter Valid No. Of Subjects");
}
catch(Exception e)
{
e.printStackTrace();
}
}


public static void main(String kl[])
{
new subject_master();
}
}