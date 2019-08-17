import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;
class create_student extends JPanel implements ActionListener,ItemListener,FocusListener
{

JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30,l31,l32,l33,l34;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,tf20;
JPasswordField pf1,pf2;
JButton b1,b2,b3,b4,b5,b6;
JRadioButton rb1,rb2;
JPanel p1;
JComboBox bx1,bx2,bx3,bx4,bx5;
//Container con1=getContentPane();
Connection con;
Statement stm;
java.util.Date d1=new Date();
java.util.Date d2=new Date();

java.text.SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
java.text.SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
java.text.SimpleDateFormat sdf2=new SimpleDateFormat("dd/MMM/yyyy");
ImageIcon mg,mg2,mg3;
ImageIcon mg1=new ImageIcon("64.jpg");
JLabel j2=new JLabel(mg1);
JLabel j0=new JLabel("");
create_student()
{


//setSize(1000,1000);
setLayout(null);

mg2=new ImageIcon("dummy.png");
j0.setIcon(mg2);
p1=new JPanel();

l1=new JLabel("Personal Information");
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
l18=new JLabel("Category");
l19=new JLabel("Academic Information");
l20=new JLabel("10th Marks");
l21=new JLabel("12th Marks");
l22=new JLabel("Previous School");
l23=new JLabel("College Related");
l24=new JLabel("Admission No");
l25=new JLabel("Admission Date");
l26=new JLabel("Select Degree Programme");
l27=new JLabel("User Id");
l28=new JLabel("Password");
l29=new JLabel("Re-Enter");
l30=new JLabel("Roll No");
l31=new JLabel("Per Sem Fee");
l32=new JLabel("Find Adm_No.");
l33=new JLabel("(Date Of Birth)/(dd/mm/yyyy)");
l34=new JLabel("Session");


l1.setFont(new Font("Segoe Script",Font.BOLD,30));
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
l19.setFont(new Font("Segoe Script",Font.BOLD,30));
l20.setFont(new Font("Segoe Script",Font.BOLD,20));
l21.setFont(new Font("Segoe Script",Font.BOLD,20));
l22.setFont(new Font("Segoe Script",Font.BOLD,20));
l23.setFont(new Font("Segoe Script",Font.BOLD,30));
l24.setFont(new Font("Segoe Script",Font.BOLD,20));
l25.setFont(new Font("Segoe Script",Font.BOLD,20));
l26.setFont(new Font("Segoe Script",Font.BOLD,20));
l27.setFont(new Font("Segoe Script",Font.BOLD,20));
l28.setFont(new Font("Segoe Script",Font.BOLD,20));
l29.setFont(new Font("Segoe Script",Font.BOLD,20));
l30.setFont(new Font("Segoe Script",Font.BOLD,20));
l31.setFont(new Font("Segoe Script",Font.BOLD,20));
l32.setFont(new Font("Segoe Script",Font.BOLD,20));
l33.setFont(new Font("Segoe Script",Font.BOLD,20));
l34.setFont(new Font("Segoe Script",Font.BOLD,20));

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
l24.setForeground(Color.white);
l25.setForeground(Color.white);
l26.setForeground(Color.white);
l27.setForeground(Color.white);
l28.setForeground(Color.white);
l29.setForeground(Color.white);
l30.setForeground(Color.white);
l31.setForeground(Color.white);
l32.setForeground(Color.white);
l33.setForeground(Color.white);
l34.setForeground(Color.white);









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
tf15=new JTextField(50);
tf16=new JTextField(50);
tf17=new JTextField(50);
tf18=new JTextField(50);
tf19=new JTextField(50);
tf20=new JTextField(50);

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
tf12.setOpaque(false);
tf13.setOpaque(false);
tf14.setOpaque(false);
tf15.setOpaque(false);
tf16.setOpaque(false);
tf17.setOpaque(false);
tf18.setOpaque(false);
tf19.setOpaque(false);
tf20.setOpaque(false);





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
tf12.setFont(new Font("Times New Roman",Font.BOLD,20));
tf13.setFont(new Font("Times New Roman",Font.BOLD,20));
tf14.setFont(new Font("Times New Roman",Font.BOLD,20));
tf15.setFont(new Font("Times New Roman",Font.BOLD,20));
tf16.setFont(new Font("Times New Roman",Font.BOLD,20));
tf17.setFont(new Font("Times New Roman",Font.BOLD,20));
tf18.setFont(new Font("Times New Roman",Font.BOLD,20));
tf19.setFont(new Font("Times New Roman",Font.BOLD,20));
tf20.setFont(new Font("Times New Roman",Font.BOLD,20));


pf1=new JPasswordField(50);
pf2=new JPasswordField(50);

pf1.setOpaque(false);

b1=new JButton("Save");
b2=new JButton("Add New");
b3=new JButton("Modify");
b4=new JButton("Search");
b5=new JButton("Back");
b6=new JButton("Upload");


rb1=new JRadioButton("Male",true);
rb2=new JRadioButton("Female");
ButtonGroup bg=new ButtonGroup();
bg.add(rb1);
bg.add(rb2);

b1.setFont(new Font("Segoe Script",Font.BOLD,25));
b2.setFont(new Font("Segoe Script",Font.BOLD,25));
b3.setFont(new Font("Segoe Script",Font.BOLD,25));
b4.setFont(new Font("Segoe Script",Font.BOLD,25));
b5.setFont(new Font("Segoe Script",Font.BOLD,25));
b6.setFont(new Font("Segoe Script",Font.BOLD,25));


rb1.setFont(new Font("Segoe Script",Font.BOLD,20));
rb2.setFont(new Font("Segoe Script",Font.BOLD,20));

rb1.setOpaque(false);
rb2.setOpaque(false);


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
for(j=1980;j<=(d1.getYear()+1900-16);j++)
{
bx3.addItem(String.valueOf(j));
}

bx4.addItem("Category");
bx4.addItem("General");
bx4.addItem("SC");
bx4.addItem("OBC");
bx4.addItem("ST");

bx5.addItem("Choose Stream");
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
add(l24);
add(l25);
add(l26);
add(l27);
add(l28);
add(l29);
add(l30);
add(l31);
add(l32);
add(l33);
add(l34);

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
add(tf15);
add(tf16);
add(tf17);
add(tf18);
add(tf19);
add(tf20);

add(rb1);
add(rb2);

add(pf1);
add(pf2);

add(bx1);
add(bx2);
add(bx3);
add(bx4);
add(bx5);

add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);

j2.setBounds(0,0,1366,720);
l1.setBounds(20,20,400,30);
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
l18.setBounds(20,550,150,20);
bx4.setBounds(20,575,200,30);
l19.setBounds(500,20,400,30);
l20.setBounds(500,60,150,20);
l21.setBounds(660,60,150,20);
tf11.setBounds(500,85,150,30);
tf12.setBounds(660,85,150,30);
l22.setBounds(500,125,300,20);
tf13.setBounds(500,150,300,30);
l23.setBounds(500,190,300,30);
l24.setBounds(500,230,200,20);
l25.setBounds(710,230,200,20);
tf14.setBounds(500,255,150,30);
tf15.setBounds(710,255,150,30);
l26.setBounds(500,295,400,20);
bx5.setBounds(500,320,300,30);
l27.setBounds(500,360,150,20);
tf16.setBounds(500,385,200,30);
l28.setBounds(500,425,150,20);
pf1.setBounds(500,450,200,30);
//l29.setBounds(800,490,200,20);
//pf2.setBounds(800,515,200,30);
l30.setBounds(500,490,200,20);
tf17.setBounds(500,515,200,30);
b1.setBounds(10,650,100,30);
b2.setBounds(120,650,170,30);
b3.setBounds(860,650,150,30);
l31.setBounds(500,555,150,20);
tf18.setBounds(500,580,300,30);
l32.setBounds(300,650,200,30);
tf19.setBounds(490,650,200,30);
b4.setBounds(700,650,150,30);
l33.setBounds(710,450,400,20);
b5.setBounds(1020,650,150,30);
b6.setBounds(1100,250,130,25);
l34.setBounds(1050,290,150,20);
tf20.setBounds(1050,315,200,30);
j0.setBounds(1100,35,200,200);

add(j0);

add(j2);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b6.addActionListener(this);
rb1.addItemListener(this);
rb2.addItemListener(this);
bx1.addItemListener(this);
bx2.addItemListener(this);
bx3.addItemListener(this);
bx4.addItemListener(this);
bx5.addItemListener(this);

tf19.addFocusListener(this);

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
tf15.setEditable(false);
tf16.setEditable(false);
tf17.setEditable(false);
tf18.setEditable(false);
tf20.setEditable(false);

pf1.setEditable(false);
pf2.setEditable(false);

tf1.setEditable(false);
b1.setEnabled(false);
b3.setEnabled(false);
b4.setEnabled(false);

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









setVisible(true);
}
String scategory="";
String sstream="";
String sdate="";
String sgender="";
String ds="";

public void itemStateChanged(ItemEvent ie)
{
try
{
if((ie.getSource()==bx5)&&(x==0))
{
int check_vacant_seat=0;
ResultSet rs2=stm.executeQuery("select vacant_seats from department_master where department_name='"+bx5.getSelectedItem().toString()+" ' "+"");
if(rs2.next())
check_vacant_seat=rs2.getInt(1);



if(check_vacant_seat>0)
{
String ty="";
ResultSet rs=stm.executeQuery("select department_code from department_master where department_name='"+bx5.getSelectedItem().toString()+" ' "+"");
if(rs.next())
{
ty=rs.getString(1);
ResultSet rs1=stm.executeQuery("select count(*) from student_data where stream='"+bx5.getSelectedItem()+"'");
if(rs1.next())
tf16.setText((d1.getYear()-100)+ty+"00"+String.valueOf(rs1.getInt(1)+1));
tf17.setText(tf16.getText());
}

ResultSet rs1=stm.executeQuery("select sem_fee from department_master where department_name='"+bx5.getSelectedItem().toString()+" ' "+"");
if(rs1.next())
tf18.setText(rs1.getString(1));

String temp1=bx2.getSelectedItem().toString()+"/"+bx1.getSelectedItem().toString()+"/"+bx3.getSelectedItem().toString();
pf1.setText(String.valueOf(sdf.format(sdf2.parse(temp1))));
}
else
{
JOptionPane.showMessageDialog(this,"Sorry ! Seats Are Not Available In This Stream You Can Choose Another");
}
}

if(rb1.isSelected())
sgender="Male";

if(rb2.isSelected())
sgender="Female";

if(ie.getSource()==bx4)
scategory=bx4.getSelectedItem().toString();

if(ie.getSource()==bx5)
sstream=bx5.getSelectedItem().toString();



}
catch(Exception e)
{
System.out.println(e);
}
}


public void focusGained(FocusEvent fe)
{
x=1;
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
tf16.setText("");
tf17.setText("");
tf18.setText("");
tf19.setText("");

pf1.setText("");
pf2.setText("");
bx1.setSelectedIndex(0);
bx2.setSelectedIndex(0);
bx3.setSelectedIndex(0);
bx4.setSelectedIndex(0);
bx5.setSelectedIndex(0);
x=0;

b4.setEnabled(true);
}
public void focusLost(FocusEvent fe)
{}

int x=0;
public void actionPerformed(ActionEvent ae)
{
int count=0;
try
{
if((ae.getSource()==b1)||(ae.getSource()==b3))
{
if((tf1.getText().equals(""))||(tf3.getText().equals(""))||(tf4.getText().equals(""))||(tf5.getText().equals(""))||(tf6.getText().equals(""))||(tf7.getText().equals(""))||(tf8.getText().equals(""))||(tf9.getText().equals(""))||(tf10.getText().equals(""))||(tf11.getText().equals(""))||(tf12.getText().equals(""))||(tf13.getText().equals(""))||(bx1.getSelectedIndex()==0)||(bx2.getSelectedIndex()==0)||(bx3.getSelectedIndex()==0)||(bx4.getSelectedIndex()==0)||(bx5.getSelectedIndex()==0))
{
JOptionPane.showMessageDialog(this,"All Fields Are Necessary");
count=7;
}

else if(!((validation.checkString(tf1.getText()))&&(validation.checkString(tf3.getText()))&&(validation.checkString(tf4.getText()))&&(validation.checkString(tf5.getText()))))
{
count=1;
JOptionPane.showMessageDialog(this,"Please Enter A Valid Name");
}

else if(!((validation.checkAddress(tf6.getText()))&&(validation.checkString(tf7.getText()))&&(validation.checkString(tf8.getText()))))
{
count=2;
JOptionPane.showMessageDialog(this,"Please Enter A Valid Address");
}

else if(!(validation.checkPinNumber(tf9.getText())))
{
count=3;
JOptionPane.showMessageDialog(this,"Please Enter A Valid Pin");
}

else if(!(validation.checkPhoneNumber(tf10.getText())))
{
count=4;
JOptionPane.showMessageDialog(this,"Please Enter A Valid Phone Number");
}
else if(!((validation.checkMarks(tf11.getText()))&&(validation.checkMarks(tf12.getText()))))
{
count=8;
JOptionPane.showMessageDialog(this,"Marks Are Not Valid");
}
else if(!(validation.checkSchool(tf13.getText())))
{
count=6;
JOptionPane.showMessageDialog(this,"School Is Not Valid");
}


else if(!((validation.checkMarks(tf11.getText()))&&(validation.checkMarks(tf12.getText()))))
{
count=5;
JOptionPane.showMessageDialog(this,"Marks Are Not Valid");
}


if(count==0)
{


String temp=bx2.getSelectedItem().toString()+"/"+bx1.getSelectedItem().toString()+"/"+bx3.getSelectedItem().toString();
sdate=String.valueOf(sdf1.format(sdf2.parse(temp)));
if(ae.getSource()==b1)
{

String s1="insert into student_data values( '"+tf1.getText()+"' , '"+tf2.getText()+"' , '"+tf3.getText()+"' , '"+tf4.getText()+"', '"+tf5.getText()+"', '"+sdate+"' , '"+sgender+"' , '"+tf6.getText()+"' , '"+tf7.getText()+"' , '"+tf8.getText()+"' , '"+tf9.getText()+"' , '"+tf10.getText()+"' , '"+scategory+"' , '"+tf11.getText()+"' , '"+tf12.getText()+"' , '"+tf13.getText()+"' , "+tf14.getText()+" , '"+tf15.getText()+"' , '"+sstream+"' , '"+tf16.getText()+"' , '"+pf1.getText()+"' , '"+tf17.getText()+"' , "+tf18.getText()+", '1' , '"+tf20.getText()+"' , '"+ds+"' )";
stm.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"Successfully Saved");


/*String sb="insert into fee_detail values('"+tf17.getText()+"',"+Integer.parseInt(tf18.getText())+","+0+",'"+sdf1.format(d1)+"' )";
stm.executeUpdate(sb);*/


int v_seats=0;
ResultSet rs=stm.executeQuery("select vacant_seats from department_master");
if(rs.next())
v_seats=rs.getInt(1)-1;

String s2="update department_master set vacant_seats="+v_seats+"  where department_name='"+bx5.getSelectedItem().toString()+"'";
stm.executeUpdate(s2);



b1.setEnabled(false);
new pay_fee(tf16.getText(),bx5.getSelectedItem().toString(),1);
}
if(ae.getSource()==b3)
{

String su="update student_data set first_name= '"+tf1.getText()+"' , middle_name='"+tf2.getText()+"', last_name='"+tf3.getText()+"', father_name='"+tf4.getText()+"', mother_name='"+tf5.getText()+"', dob= '"+sdate+"' , gender='"+sgender+"' , address_street='"+tf6.getText()+"' , address_city='"+tf7.getText()+"' , address_state='"+tf8.getText()+"' , pin_code='"+tf9.getText()+"' , phone_number='"+tf10.getText()+"' , category='"+scategory+"' , 10th_marks='"+tf11.getText()+"' , 12th_marks='"+tf12.getText()+"' , previous_school='"+tf13.getText()+"' , stream='"+sstream+"' where admission_number='"+tf19.getText()+"'"+"";
stm.executeUpdate(su);
JOptionPane.showMessageDialog(this,"Successfully Modified");
}

}
}
if((ae.getSource()==b2)||(ae.getSource()==b4))
{
tf1.setEditable(true);
tf2.setEditable(true);
tf3.setEditable(true);
tf4.setEditable(true);
tf5.setEditable(true);
tf6.setEditable(true);
tf7.setEditable(true);
tf8.setEditable(true);
tf9.setEditable(true);
tf10.setEditable(true);
tf11.setEditable(true);
tf12.setEditable(true);
tf13.setEditable(true);
}
if(ae.getSource()==b2)
{
x=1;
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
tf16.setText("");
tf17.setText("");
tf18.setText("");
tf19.setText("");

pf1.setText("");
pf2.setText("");
bx1.setSelectedIndex(0);
bx2.setSelectedIndex(0);
bx3.setSelectedIndex(0);
bx4.setSelectedIndex(0);
bx5.setSelectedIndex(0);
x=0;
tf15.setText(String.valueOf(sdf1.format(d1)));
b1.setEnabled(true);
b4.setEnabled(false);
bx5.setEnabled(true);
ResultSet rs=stm.executeQuery("select count(*) from student_data");
int adm_no=0;

if(rs.next()) 
adm_no=rs.getInt(1)+1;

tf14.setText(String.valueOf(adm_no));
String jk=String.valueOf(d2.getYear()+1900)+"-"+String.valueOf(d2.getYear()+1900+1);
tf20.setText(jk);

j0.setIcon(mg2);
}
if(ae.getSource()==b4)
{
bx5.setEnabled(false);
Date d1=new Date();
String gen="";
String strm="";
String cat="";
ResultSet rs0=stm.executeQuery("select * from student_data where admission_number="+Integer.parseInt(tf19.getText()));
if(rs0.next())
{
ResultSet rs=stm.executeQuery("select * from student_data where admission_number="+Integer.parseInt(tf19.getText()));
while(rs.next())
{
tf1.setText(rs.getString(1));
tf2.setText(rs.getString(2));
tf3.setText(rs.getString(3));
tf4.setText(rs.getString(4));
tf5.setText(rs.getString(5));
d1=rs.getDate(6);
gen=rs.getString(7);
tf6.setText(rs.getString(8));
tf7.setText(rs.getString(9));
tf8.setText(rs.getString(10));
tf9.setText(rs.getString(11));
tf10.setText(rs.getString(12));
cat=(rs.getString(13));
tf11.setText(rs.getString(14));
tf12.setText(rs.getString(15));
tf13.setText(rs.getString(16));
tf14.setText(rs.getString(17));
tf15.setText(sdf1.format(rs.getDate(18)));
strm=(rs.getString(19));
tf16.setText(rs.getString(20));
pf1.setText(rs.getString(21));
tf17.setText(rs.getString(22));
tf18.setText(rs.getString(23));
tf20.setText(rs.getString(25));
mg3=new ImageIcon(rs.getString(26));
j0.setIcon(mg3);
b1.setEnabled(false);
}

if(gen.equals("Male"))
rb1.setSelected(true);
else if(gen.equals("Female"))
rb2.setSelected(true);

int m=0;
m=d1.getMonth();
bx1.setSelectedIndex(m+2);
int y=0;
y=d1.getYear();

bx3.setSelectedItem(String.valueOf(y+1900));

int d=d1.getDate();
bx2.setSelectedItem(String.valueOf(d));

bx4.setSelectedItem(cat);
bx5.setSelectedItem(strm);
}
else 
JOptionPane.showMessageDialog(this,"Admission no doesnt exist");


b3.setEnabled(true);
}

if(ae.getSource()==b6)
{
JFileChooser fs=new JFileChooser();
fs.showOpenDialog(this);
ds=fs.getSelectedFile().getName();
System.out.println(ds);
mg=new ImageIcon(ds);

j0.setIcon(mg);
//add(j0);

//add(p1);
//p1.setBounds(480,10,130,130);
//p1.setBackground(Color.red);
j0.setBounds(1100,35,200,200);
}
}
catch(ParseException pe)
{
JOptionPane.showMessageDialog(this,"Please Enter A Valid Date");
}
catch(NumberFormatException ne)
{
JOptionPane.showMessageDialog(this,"Kindy Input First Admission Number In Find Box");
}
catch(Exception e)
{
//JOptionPane.showMessageDialog(this,e);
e.printStackTrace();
}
}
public static void main(String lk[])
{
new create_student();
}
}