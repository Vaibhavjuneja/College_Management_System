import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
class pay_fee extends JInternalFrame implements ActionListener,FocusListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23;
JTextField tf0,tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16;
JButton b1,b2,b3,b4,b5;
JRadioButton rb1,rb2;
JComboBox bx1,bx2,bx3,bx4,bx5;
Container con1=getContentPane();
Connection con;
Statement stm;
int f_check=0;
ImageIcon mg1=new ImageIcon("rupee.jpg");
JLabel j2=new JLabel(mg1);
java.util.Date d1=new Date();
java.text.SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
java.text.SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
java.text.SimpleDateFormat sdf2=new SimpleDateFormat("dd/MMM/yyyy");
pay_fee(String userid,String dep,int f)
{

super("Pay Fee",true,true,true,true);
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
l18=new JLabel("Current Balance");
l19=new JLabel("Deposit Fee");
l20=new JLabel("New Balance");
l21=new JLabel("Receipt Date");
l22=new JLabel("(Press Tab After Filling)");
l23=new JLabel("Receipt No");


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
l22.setFont(new Font("Segoe Script",Font.BOLD,15));
l23.setFont(new Font("Segoe Script",Font.BOLD,20));

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
l22.setForeground(Color.white);
l23.setForeground(Color.white);



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
tf16=new JTextField(50);


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
tf16.setFont(new Font("Times New Roman",Font.BOLD,15));


rb1=new JRadioButton("Male");
rb2=new JRadioButton("Female");


rb1.setFont(new Font("Segoe Script",Font.BOLD,20));
rb2.setFont(new Font("Segoe Script",Font.BOLD,20));

b1=new JButton("Search");
b2=new JButton("Deposit");

b1.setFont(new Font("Segoe Script",Font.BOLD,30));
b2.setFont(new Font("Segoe Script",Font.BOLD,30));


bx1=new JComboBox();
bx2=new JComboBox();
bx3=new JComboBox();
bx4=new JComboBox();
bx5=new JComboBox();


bx1.setFont(new Font("Segoe Script",Font.BOLD,25));
bx2.setFont(new Font("Segoe Script",Font.BOLD,25));
bx3.setFont(new Font("Segoe Script",Font.BOLD,25));
bx4.setFont(new Font("Segoe Script",Font.BOLD,25));


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
for(int t=1;t<=8;t++)
{
bx5.addItem(t);
}

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
add(l22);
add(l23);


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
add(tf16);

add(rb1);
add(rb2);

add(b1);
add(b2);

add(bx1);
add(bx2);
add(bx3);
add(bx4);
add(bx5);

j2.setBounds(0,0,1366,720);
l1.setBounds(20,20,200,30);
tf0.setBounds(220,20,200,30);
b1.setBounds(430,20,150,30);
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
bx4.setBounds(600,250,300,30);
bx5.setBounds(600,290,300,30);
l18.setBounds(600,330,200,20);
tf11.setBounds(600,355,300,30);
l19.setBounds(600,400,200,20);
tf12.setBounds(600,425,300,30);
l22.setBounds(910,425,200,20);
l20.setBounds(600,470,200,20);
tf13.setBounds(600,495,300,30);
l21.setBounds(600,185,200,20);
tf14.setBounds(600,210,300,30);
b2.setBounds(700,580,170,30);
l23.setBounds(600,100,150,20);
tf16.setBounds(600,125,300,30);



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
tf16.setEditable(false);



bx1.setEnabled(false);
bx2.setEnabled(false);
bx3.setEnabled(false);
rb1.setEnabled(false);
rb2.setEnabled(false);


tf0.requestFocus(true);
tf0.addFocusListener(this);
tf12.addFocusListener(this);

b1.addActionListener(this);
b2.addActionListener(this);


bx4.setEnabled(false);
bx5.setEnabled(false);


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

if(f==1)
{
tf0.setText(userid);
bx4.setSelectedItem(dep);
tf0.setEditable(false);
}
else if(f==0)
{
tf0.setText("");
tf0.setEditable(true);
}

add(j2);




setVisible(true);
}
public void focusGained(FocusEvent fe)
{
if(fe.getSource()==tf0)
{
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
tf11.setText("");
tf12.setText("");
tf13.setText("");
tf14.setText("");





bx1.setSelectedIndex(0);
bx2.setSelectedIndex(0);
bx3.setSelectedIndex(0);
bx4.setSelectedIndex(0);
bx5.setSelectedIndex(0);

b2.setVisible(false);
}
}
public void focusLost(FocusEvent fe)
{
try
{
if(fe.getSource()==tf12)
{
if(Integer.parseInt(tf12.getText())<=Integer.parseInt(tf11.getText()))
{
bal=(Integer.parseInt(tf11.getText())-Integer.parseInt(tf12.getText()));
tf13.setText(String.valueOf(bal));
tf14.setText(sdf1.format(d1));
}
else 
JOptionPane.showMessageDialog(this,"Actually You Are Depositing More Than Balance Which Is Not Allowed Acc To College Policy");

b2.setVisible(true);
}
}
catch(NumberFormatException ne)
{
JOptionPane.showMessageDialog(this,"Please Input Some Deposit");
}
}
int count=0;
int rcp_no=0;
int sem=0;
int bal=0;
String deput="",sfee="";
int rsem=0,fsem=0;
int chk=0;
public void actionPerformed(ActionEvent ae)
{
try
{
if((ae.getSource()==b1)||(ae.getSource()==b2))
{
if(tf0.getText().equals(""))
{
count=1;
JOptionPane.showMessageDialog(this,"Please Fill Up The Fields Correctly");
}
if(count==0)
{
if(ae.getSource()==b1)
{
ResultSet rs00=stm.executeQuery("select max(semester) , balance from fee_detail where roll_no='"+tf0.getText()+"'");
while(rs00.next())
{
sem=rs00.getInt(1);
bal=rs00.getInt(2);
}

if(bal==0)
{
ResultSet rs001=stm.executeQuery("select max(semester) from regeneration where roll_no='"+tf0.getText()+"'");
if(rs001.next())
rsem=rs001.getInt(1);

ResultSet rs002=stm.executeQuery("select max(semester) from fee_detail where roll_no='"+tf0.getText()+"'");
if(rs002.next())
fsem=rs002.getInt(1);

if((rsem>0)&&(fsem>0))
chk=1;

if((rsem<=fsem)&&(chk==1))
{
JOptionPane.showMessageDialog(this,"Your Current Balance For semester "+fsem+" is Zero Now You Have To Regenerate First To Pay For "+(fsem+1));
b2.setEnabled(false);
}
else
{
bx5.setSelectedItem(sem+1);
ResultSet rs02=stm.executeQuery("select stream , per_sem_fee from student_data where roll_no='"+tf0.getText()+"'");
while(rs02.next())
{
deput=rs02.getString(1);
sfee=rs02.getString(2);
}
bx4.setSelectedItem(deput);
tf11.setText(sfee);
}
}
else
{
bx5.setSelectedItem(sem);
tf11.setText(String.valueOf(bal));
}









Date rdob=new Date();
String rgen="";
ResultSet rs1=stm.executeQuery("select user_id from student_data where roll_no='"+tf0.getText()+"'");
if(rs1.next())
{
ResultSet rs0=stm.executeQuery("select count(*) from fee_detail");
if(rs0.next())
rcp_no=rs0.getInt(1)+1;
else
rcp_no=1;
tf16.setText(String.valueOf(rcp_no));
tf12.setEditable(true);
String dept="";
Date d4=new Date();
tf14.setText(sdf1.format(d4));
ResultSet rs01=stm.executeQuery("select * from student_data where roll_no='"+tf0.getText()+"'");
if(rs01.next())
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
dept=rs.getString(19);
}
if(rgen.equals("Male"))
rb1.setSelected(true);
else if(rgen.equals("Female"))
rb1.setSelected(true);


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
bx4.setSelectedItem(dept);

}
else
JOptionPane.showMessageDialog(this,"Roll no doesn't found");

}

else  
JOptionPane.showMessageDialog(this,"Roll Number Doesn't Exist");

}

if(ae.getSource()==b2)
{
if(Integer.parseInt(tf12.getText())>0)
{
String si="insert into fee_detail values('"+tf0.getText()+"', "+Integer.parseInt(tf11.getText())+", '"+Integer.parseInt(tf12.getText())+"','"+tf14.getText()+"', "+tf16.getText()+", "+bx5.getSelectedItem()+")";
stm.executeUpdate(si);
JOptionPane.showMessageDialog(this,"Successfully Paid");

String sp="update fee_detail set balance="+bal+" where roll_no='"+tf0.getText()+"'";
stm.executeUpdate(sp);
}
else
JOptionPane.showMessageDialog(this,"Kindly Deposit Some Fee");

b2.setEnabled(false);
}

}

}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e);
//e.printStackTrace();
}
}

public static void main(String lk[])
{
new pay_fee("","",0);
}
}
