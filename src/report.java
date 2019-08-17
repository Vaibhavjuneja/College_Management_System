import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;
class fee_report extends JInternalFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
JButton b1;
JTable jt,jt1;
JScrollPane sp,sp1;
Connection con;
Statement stm;
Container con1=getContentPane();
ImageIcon i1;
fee_report()
{
super("Report",true,true,true,true);
setSize(1000,1000);
setLayout(null);


i1=new ImageIcon("fee_rprt.jpg");
l3=new JLabel(i1);

jt=new JTable();
sp1=new JScrollPane(jt);

l1=new JLabel("Fee Report");
l2=new JLabel("Roll No");

l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l1.setFont(new Font("Segoe Script",Font.BOLD,30));

l1.setForeground(Color.white);
l2.setForeground(Color.white);


tf1=new JTextField(50);

b1=new JButton("Show");

b1.setFont(new Font("Segoe Script",Font.BOLD,25));

add(l1);
add(l2);

add(tf1);

add(b1);

l3.setBounds(0,0,1370,750);
l1.setBounds(20,20,300,30);
l2.setBounds(20,70,150,20);
tf1.setBounds(20,100,300,30);
b1.setBounds(50,140,150,30);

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

add(l3);
setVisible(true);

}

int size=0;
int prsent=0;
public void actionPerformed(ActionEvent ae)
{
int o=0;
try
{
if(ae.getSource()==b1)
{
ResultSet rs=stm.executeQuery("select count(*) from fee_detail where roll_no='"+tf1.getText()+"'");
if(rs.next())
size=rs.getInt(1);

if(size>0)
{
String so[]={"Reciept No","Reciept Date","Deposited Fee","Semester"};
Object obj[][]=new Object[size][4];

if(sp!=null)
remove(sp);


ResultSet rs0=stm.executeQuery("select * from fee_detail where roll_no='"+tf1.getText()+"'");
while(rs0.next())
{
obj[o][2]=rs0.getInt(3);
obj[o][1]=rs0.getString(4);
obj[o][0]=rs0.getInt(5);
obj[o][3]=rs0.getInt(6);
o++;
}


DefaultTableModel model=new DefaultTableModel(obj,so);
jt1=new JTable(model)
{
public boolean isCellEditable(int r,int c)
{
if((c==1)&&(c==2)&&(c==3)&&(c==4))
return true;
else 
return false;
}
};

sp1=new JScrollPane(jt1);
sp1.setBounds(400,20,700,300);
add(sp1);
}
else
JOptionPane.showMessageDialog(this,"Record Not Found");

}





}
catch(Exception e)
{
//System.out.println(e);
e.printStackTrace();
}
}
public static void main(String kj[])
{
new fee_report();
}
}