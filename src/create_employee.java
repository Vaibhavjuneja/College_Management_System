import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
class create_employee extends JInternalFrame implements ActionListener,FocusListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13;
JPasswordField pf1,pf2;
JButton b1,b2,b3,b4,b5;
JComboBox bx1,bx2,bx3,bx4,bx5,bx6,bx7,bx8;
Container con1;//=getContentPane();
Connection con;
Statement stm;
ImageIcon mg1=new ImageIcon("275367.jpg");
JLabel j2=new JLabel(mg1);

Date d0=new Date();
java.text.SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
java.text.SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
java.text.SimpleDateFormat sdf2=new SimpleDateFormat("dd/MMM/yyyy");


create_employee()
{
super("Create New Employee",true,true,true,true);

setSize(1200,1000);
setLayout(null);
//setExtendedState(JFrame.MAXIMIZED_BOTH);

l1=new JLabel("Employee Information");
l2=new JLabel("Name");
l3=new JLabel("First Name");
l4=new JLabel("Middle Name");
l5=new JLabel("Last Name");
l6=new JLabel("Address");
l7=new JLabel("Street Address");
l8=new JLabel("City");
l9=new JLabel("State");
l10=new JLabel("Phone Number");
l11=new JLabel("Email");
l12=new JLabel("Birth Date");
l13=new JLabel("Marital Status");
l14=new JLabel("Job Information");
l15=new JLabel("Title");
l16=new JLabel("Department");
l17=new JLabel("Start Date");
l18=new JLabel("Salary");
l19=new JLabel("Employee Id");
l20=new JLabel("Password");
l21=new JLabel("Re-Enter");
l22=new JLabel("(Date Of Birth) in (dd/mm/yyyy)");
l23=new JLabel("Find Employee Id");


l1.setFont(new Font("Segoe Script",Font.BOLD,30));
l2.setFont(new Font("Segoe Script",Font.BOLD,20));
l3.setFont(new Font("Segoe Script",Font.BOLD,10));
l4.setFont(new Font("Segoe Script",Font.BOLD,10));
l5.setFont(new Font("Segoe Script",Font.BOLD,10));
l6.setFont(new Font("Segoe Script",Font.BOLD,20));
l7.setFont(new Font("Segoe Script",Font.BOLD,10));
l8.setFont(new Font("Segoe Script",Font.BOLD,10));
l9.setFont(new Font("Segoe Script",Font.BOLD,10));
l10.setFont(new Font("Segoe Script",Font.BOLD,20));
l11.setFont(new Font("Segoe Script",Font.BOLD,20));
l12.setFont(new Font("Segoe Script",Font.BOLD,20));
l13.setFont(new Font("Segoe Script",Font.BOLD,20));
l14.setFont(new Font("Segoe Script",Font.BOLD,30));
l15.setFont(new Font("Segoe Script",Font.BOLD,20));
l16.setFont(new Font("Segoe Script",Font.BOLD,20));
l17.setFont(new Font("Segoe Script",Font.BOLD,20));
l18.setFont(new Font("Segoe Script",Font.BOLD,20));
l19.setFont(new Font("Segoe Script",Font.BOLD,20));
l20.setFont(new Font("Segoe Script",Font.BOLD,20));
l21.setFont(new Font("Segoe Script",Font.BOLD,20));
l22.setFont(new Font("Segoe Script",Font.BOLD,20));
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
tf13=new JTextField(50);

tf1.setOpaque(false);
tf2.setOpaque(false);
tf3.setOpaque(false);
tf4.setOpaque(false);
tf5.setOpaque(false);
tf6.setOpaque(false);
tf7.setOpaque(false);
tf8.setOpaque(false);
tf9.setOpaque(false);
tf10.setOpaque(false);
tf11.setOpaque(false);
tf13.setOpaque(false);


tf1.setFont(new Font("Times New Roman",Font.BOLD,20));
tf2.setFont(new Font("Times New Roman",Font.BOLD,20));
tf3.setFont(new Font("Times New Roman",Font.BOLD,20));
tf4.setFont(new Font("Times New Roman",Font.BOLD,20));
tf5.setFont(new Font("Times New Roman",Font.BOLD,20));
tf6.setFont(new Font("Times New Roman",Font.BOLD,20));
tf7.setFont(new Font("Times New Roman",Font.BOLD,20));
tf8.setFont(new Font("Times New Roman",Font.BOLD,20));
tf9.setFont(new Font("Times New Roman",Font.BOLD,20));
tf10.setFont(new Font("Times New Roman",Font.BOLD,20));
tf11.setFont(new Font("Times New Roman",Font.BOLD,20));
tf13.setFont(new Font("Times New Roman",Font.BOLD,20));

tf1.setForeground(Color.white);
tf2.setForeground(Color.white);
tf3.setForeground(Color.white);
tf4.setForeground(Color.white);
tf5.setForeground(Color.white);
tf6.setForeground(Color.white);
tf7.setForeground(Color.white);
tf8.setForeground(Color.white);
tf9.setForeground(Color.white);
tf10.setForeground(Color.white);
tf11.setForeground(Color.white);
tf13.setForeground(Color.white);



pf1=new JPasswordField(50);
pf2=new JPasswordField(50);

pf1.setOpaque(false);

pf1.setEditable(false);
tf11.setEditable(false);

bx1=new JComboBox();
bx2=new JComboBox();
bx3=new JComboBox();
bx4=new JComboBox();
bx5=new JComboBox();
bx6=new JComboBox();
bx7=new JComboBox();
bx8=new JComboBox();

bx1.setFont(new Font("Segoe Script",Font.BOLD,20));
bx2.setFont(new Font("Segoe Script",Font.BOLD,20));
bx3.setFont(new Font("Segoe Script",Font.BOLD,20));
bx4.setFont(new Font("Segoe Script",Font.BOLD,20));
bx5.setFont(new Font("Segoe Script",Font.BOLD,20));
bx6.setFont(new Font("Segoe Script",Font.BOLD,20));
bx7.setFont(new Font("Segoe Script",Font.BOLD,20));
bx8.setFont(new Font("Segoe Script",Font.BOLD,20));



b1=new JButton("Sign Up");
b2=new JButton("Add New");
b3=new JButton("Modify");
b4=new JButton("Back");
b5=new JButton("Search");

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));
b3.setFont(new Font("Segoe Script",Font.BOLD,25));
b4.setFont(new Font("Segoe Script",Font.BOLD,25));
b5.setFont(new Font("Segoe Script",Font.BOLD,25));


bx4.addItem("Select");
bx4.addItem("Married");
bx4.addItem("Single");
bx4.addItem("In A Relationship");


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
bx2.addItem(i);
}

bx3.addItem("Year");
int j;
for(j=1980;j<=(d0.getYear()+1900-30);j++)
{
bx3.addItem(j);
}

bx6.addItem("Month");
bx6.addItem("Jan");
bx6.addItem("Feb");
bx6.addItem("Mar");
bx6.addItem("Apr");
bx6.addItem("May");
bx6.addItem("Jun");
bx6.addItem("Jul");
bx6.addItem("Aug");
bx6.addItem("Sep");
bx6.addItem("Oct");
bx6.addItem("Nov");
bx6.addItem("Dec");

bx7.addItem("Day");
int k;
for(k=1;k<=31;k++)
{
bx7.addItem(k);
}

bx8.addItem("Year");
int l;
for(l=(d0.getYear()+1900-1);l<=(d0.getYear()+1900+1);l++)
{
bx8.addItem(l);
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
//add(l21);
add(l22);
add(l23);

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
add(tf13);
add(pf1);
//add(pf2);

add(bx1);
add(bx2);
add(bx3);
add(bx4);
add(bx5);
add(bx6);
add(bx7);
add(bx8);

add(b1);         
add(b2);
add(b3);
add(b4);
add(b5);

j2.setBounds(0,0,1366,720);
l1.setBounds(20,20,400,40);
l2.setBounds(20,70,300,20);
tf1.setBounds(20,95,150,30);
tf2.setBounds(180,95,150,30);
tf3.setBounds(340,95,150,30);
l3.setBounds(20,125,150,10);
l4.setBounds(180,125,150,10);
l5.setBounds(340,125,150,10);
l6.setBounds(20,145,300,20);
tf4.setBounds(20,170,400,30);
l7.setBounds(20,200,300,10);
tf5.setBounds(20,215,195,30);
tf6.setBounds(225,215,195,30);
l8.setBounds(20,245,100,10);
l9.setBounds(225,245,100,10);
l10.setBounds(20,265,200,20);
l11.setBounds(230,265,200,20);
tf7.setBounds(20,290,200,30);
tf8.setBounds(230,290,190,30);
l12.setBounds(20,330,150,20);
l13.setBounds(350,330,200,20);
bx1.setBounds(20,355,100,30);
bx2.setBounds(130,355,70,30);
bx3.setBounds(210,355,100,30);
bx4.setBounds(350,355,200,30);
l14.setBounds(700,20,300,30);
l15.setBounds(700,60,150,20);
tf9.setBounds(700,85,250,30);
l16.setBounds(700,125,150,20);
bx5.setBounds(700,150,250,30);
l17.setBounds(700,190,150,20);
l18.setBounds(700,255,150,20);
bx6.setBounds(700,215,100,30);
bx7.setBounds(810,215,70,30);
bx8.setBounds(890,215,100,30);
tf10.setBounds(700,280,200,30);
l19.setBounds(700,320,200,20);
tf11.setBounds(700,345,300,30);
l20.setBounds(700,385,200,20);
pf1.setBounds(700,410,300,30);
l21.setBounds(700,450,300,20);
pf2.setBounds(700,475,300,30);
b1.setBounds(20,600,170,30);
b2.setBounds(230,600,170,30);
l22.setBounds(700,440,400,20);
l23.setBounds(20,635,250,20);
tf13.setBounds(270,635,200,30);
b3.setBounds(440,600,170,30);
b4.setBounds(650,600,170,30);
b5.setBounds(480,635,150,30);


b3.setEnabled(false);
b5.setEnabled(false);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
tf8.addFocusListener(this);
tf13.addFocusListener(this);
b5.addActionListener(this);

bx5.addItem("Select");
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();
ResultSet rs=stm.executeQuery("select department_name from department_master");
while(rs.next())
{
bx5.addItem(rs.getString(1));
}
}
catch(Exception e)
{
System.out.println(e);
}


add(j2);



setVisible(true);
}
int g=0;
String edob="";
String ssdate="";

public void actionPerformed(ActionEvent ae)
{
int count=0;
try
{
if((ae.getSource()==b1)||(ae.getSource()==b3))
{

if((tf1.getText().equals(""))||(tf3.getText().equals(""))||(tf4.getText().equals(""))||(tf5.getText().equals(""))||(tf6.getText().equals(""))||(tf7.getText().equals(""))||(tf8.getText().equals(""))||(tf9.getText().equals(""))||(tf10.getText().equals(""))||(bx1.getSelectedIndex()==0)||(bx2.getSelectedIndex()==0)||(bx3.getSelectedIndex()==0)||(bx4.getSelectedIndex()==0)||(bx5.getSelectedIndex()==0)||(bx6.getSelectedIndex()==0)||(bx7.getSelectedIndex()==0)||(bx8.getSelectedIndex()==0))
{
JOptionPane.showMessageDialog(this,"All Fields Are Necessary");
count=7;
}
else if(!((validation.checkString(tf1.getText()))&&(validation.checkString(tf2.getText()))&&(validation.checkString(tf3.getText()))))
{
count=1;
JOptionPane.showMessageDialog(this,"Please Enter A Valid Name");
}

else if(!((validation.checkAddress(tf4.getText()))&&(validation.checkAddress(tf5.getText()))&&(validation.checkAddress(tf6.getText()))))
{
count=2;
JOptionPane.showMessageDialog(this,"Please Enter A Valid Address");
}

else if(!(validation.checkPhoneNumber(tf7.getText())))
{
count=3;
JOptionPane.showMessageDialog(this,"Please Enter A Valid Phone Number");
}

else if(!(validation.checkTittel(tf9.getText())))
{
count=4;
JOptionPane.showMessageDialog(this,"You Have To Input Eigther Accountant or Faculy In Tittel Box Bcz We Have A Small Project");
}


String temp2=bx2.getSelectedItem().toString()+"/"+bx1.getSelectedItem().toString()+"/"+bx3.getSelectedItem().toString();
pf1.setText(String.valueOf(sdf.format(sdf2.parse(temp2))));


String temp=bx2.getSelectedItem().toString()+"/"+bx1.getSelectedItem().toString()+"/"+bx3.getSelectedItem().toString();
edob=String.valueOf(sdf1.format(sdf2.parse(temp)));

String temp1=bx7.getSelectedItem().toString()+"/"+bx6.getSelectedItem().toString()+"/"+bx8.getSelectedItem().toString();
ssdate=String.valueOf(sdf1.format(sdf2.parse(temp1)));



if(ae.getSource()==b1)
{
if(count==0)
{

String s1="insert into employee_data values( '"+tf1.getText()+"' , '"+tf2.getText()+"' , '"+tf3.getText()+"' , '"+tf4.getText()+"' , '"+tf5.getText()+"' , '"+tf6.getText()+"' , '"+tf7.getText()+"' , '"+tf8.getText()+"' , '"+edob+"' , '"+bx4.getSelectedItem().toString()+"' , '"+tf9.getText()+"' , '"+bx5.getSelectedItem().toString()+"' ,'"+ssdate+"' , "+Integer.parseInt(tf10.getText())+" , '"+tf11.getText()+"' , '"+pf1.getText()+"' )";
stm.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"Successfuly Signed Up");
b1.setEnabled(false);
}

}

if(ae.getSource()==b3)
{
if(count==0)
{
String su="update employee_data set first_name='"+tf1.getText()+"', middle_name='"+tf2.getText()+"', last_name='"+tf3.getText()+"', street='"+tf4.getText()+"', city='"+tf5.getText()+"', state='"+tf6.getText()+"', phone_no='"+tf7.getText()+"', email='"+tf8.getText()+"', dob='"+edob+"', marital_status='"+bx4.getSelectedItem().toString()+"', etitle='"+tf9.getText()+"', department='"+bx5.getSelectedItem().toString()+"', start_date='"+ssdate+"', salary='"+Integer.parseInt(tf10.getText())+"' where user_id='"+tf13.getText()+"'"+"";
stm.executeUpdate(su);
JOptionPane.showMessageDialog(this,"Successfully Modified");
g=1;
}
}
}


if((ae.getSource())==b2||((ae.getSource()==b3)&&(g==1)))
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
tf13.setText("");
pf1.setText("");
bx1.setSelectedIndex(0);
bx2.setSelectedIndex(0);
bx3.setSelectedIndex(0);
bx4.setSelectedIndex(0);
bx5.setSelectedIndex(0);
bx6.setSelectedIndex(0);
bx7.setSelectedIndex(0);
bx8.setSelectedIndex(0);
b3.setEnabled(false);
b2.setEnabled(true);
b1.setEnabled(true);



}
if(ae.getSource()==b5)
{
ResultSet rs0=stm.executeQuery("select user_id from employee_data where email='"+tf13.getText()+"'"+"");
if(rs0.next())
{
Date df=new Date();
Date st_date=new Date();
String ems="",ed="";
ResultSet rs=stm.executeQuery("select * from employee_data where user_id='"+tf13.getText()+"'"+"");
while(rs.next())
{
tf1.setText(rs.getString(1));
tf2.setText(rs.getString(2));
tf3.setText(rs.getString(3));
tf4.setText(rs.getString(4));
tf5.setText(rs.getString(5));
tf6.setText(rs.getString(6));
tf7.setText(rs.getString(7));
tf8.setText(rs.getString(8));
df=rs.getDate(9);
ems=rs.getString(10);
tf9.setText(rs.getString(11));
ed=rs.getString(12);
st_date=rs.getDate(13);
tf10.setText(rs.getString(14));
tf11.setText(rs.getString(15));
pf1.setText(rs.getString(16));

}
int m=df.getMonth();
bx1.setSelectedIndex(m+2);
int d=df.getDate();
bx2.setSelectedItem(d);
int y=df.getYear();
bx3.setSelectedItem(1900+y);

bx4.setSelectedItem(ems);


bx5.setSelectedItem(ed);

int j=st_date.getMonth();
bx6.setSelectedIndex(j+2);

int k=st_date.getDate();
bx7.setSelectedItem(k);

int l=st_date.getYear();
bx8.setSelectedItem(1900+l);
b3.setEnabled(true);
}
else 
JOptionPane.showMessageDialog(this,"Employee Id Does Not Exist");
}


}
catch(ParseException pe)
{
JOptionPane.showMessageDialog(this,"Please Enter Valid Dates");
}
catch(NumberFormatException ne)
{
JOptionPane.showMessageDialog(this,"Please Enter A Valid Salary");
}
catch(Exception e)
{
//System.out.println(e);
e.printStackTrace();
}
}
public void focusGained(FocusEvent fe)
{
if(fe.getSource()==tf13)
{
b5.setEnabled(true);

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
pf1.setText("");
bx1.setSelectedIndex(0);
bx2.setSelectedIndex(0);
bx3.setSelectedIndex(0);
bx4.setSelectedIndex(0);
bx5.setSelectedIndex(0);
bx6.setSelectedIndex(0);
bx7.setSelectedIndex(0);
bx8.setSelectedIndex(0);




}
}
public void focusLost(FocusEvent fe)
{
if(fe.getSource()==tf8)
{
if(!(validation.checkEmail(tf8.getText())))
JOptionPane.showMessageDialog(this,"Please Enter A Valid Email");
else
tf11.setText(tf8.getText());

}
}
public static void main(String hj[])
{
new create_employee();
}
} 
