import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
class admin_window extends JFrame implements ActionListener
{
JLabel l1;
JMenuBar mb;
JMenu mn1,mn2,mn3,mn4,mn5,mn6;
JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15,mi16,mi17,mi18;
ImageIcon i1,i2,i3,i4,i5;
JLabel l2,l3,l4,l5,l6;
String user="";
JPanel p1;
Date d1=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");

JDesktopPane pane=new JDesktopPane();


admin_window(String kl)
{
user=kl;
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);

setContentPane(pane);





i1=new ImageIcon("qwer.jpg");
l2=new JLabel(i1);
l3=new JLabel("Good Morning");

l3.setFont(new Font("Segoe Print",Font.BOLD,20));
l3.setForeground(Color.white);

int i=d1.getHours();

if(i<6)
l3.setText("Early Good Morning Admin");
else if((i>=6)&&(i<12))
l3.setText("Good Morning Admin");
else if((i>=12)&&(i<13))
l3.setText("Good Noon Admin");
else if((i>=13)&&(i<17))
l3.setText("Good After Noon");
else if((i>=17)&&(i<20))
l3.setText("Good Evening Admin");
else
l3.setText("Good Night Admin");



mb=new JMenuBar();

mn1=new JMenu("User");
mn2=new JMenu("Master Entry");
mn3=new JMenu("Admission");
mn4=new JMenu("Adm_Report");
mn5=new JMenu("Student");
mn6=new JMenu("Student_Report");

mi1=new JMenuItem("New Employee");
mi2=new JMenuItem("Drop User");
mi3=new JMenuItem("Change Password");
mi4=new JMenuItem("Department Master");
mi5=new JMenuItem("Subject Master");
mi6=new JMenuItem("Subject Allotment");
mi7=new JMenuItem("New Admission");
mi8=new JMenuItem("Re-Registration");
mi9=new JMenuItem("Pay Fee");
mi10=new JMenuItem("Session Wise Report");
mi11=new JMenuItem("Date Wise Report");
mi13=new JMenuItem("Attendence");
mi14=new JMenuItem("Marks");
mi15=new JMenuItem("Attendence_report");
mi16=new JMenuItem("Marks_Report");
mi17=new JMenuItem("Fee_Report");
mi18=new JMenuItem("Logout");

mn1.setFont(new Font("Segoe Print",Font.BOLD,15));
mn2.setFont(new Font("Segoe Print",Font.BOLD,15));
mn3.setFont(new Font("Segoe Print",Font.BOLD,15));
mn4.setFont(new Font("Segoe Print",Font.BOLD,15));
mn5.setFont(new Font("Segoe Print",Font.BOLD,15));
mn6.setFont(new Font("Segoe Print",Font.BOLD,15));


mi1.setFont(new Font("Segoe Print",Font.BOLD,15));
mi2.setFont(new Font("Segoe Print",Font.BOLD,15));
mi3.setFont(new Font("Segoe Print",Font.BOLD,15));
mi4.setFont(new Font("Segoe Print",Font.BOLD,15));
mi5.setFont(new Font("Segoe Print",Font.BOLD,15));
mi6.setFont(new Font("Segoe Print",Font.BOLD,15));
mi7.setFont(new Font("Segoe Print",Font.BOLD,15));
mi8.setFont(new Font("Segoe Print",Font.BOLD,15));
mi9.setFont(new Font("Segoe Print",Font.BOLD,15));
mi10.setFont(new Font("Segoe Print",Font.BOLD,15));
mi11.setFont(new Font("Segoe Print",Font.BOLD,15));
mi13.setFont(new Font("Segoe Print",Font.BOLD,15));
mi14.setFont(new Font("Segoe Print",Font.BOLD,15));
mi15.setFont(new Font("Segoe Print",Font.BOLD,15));
mi16.setFont(new Font("Segoe Print",Font.BOLD,15));
mi17.setFont(new Font("Segoe Print",Font.BOLD,15));
mi18.setFont(new Font("Segoe Print",Font.BOLD,15));


mi1.setBackground(Color.white);
mi2.setBackground(Color.white);
mi3.setBackground(Color.white);
mi4.setBackground(Color.white);
mi5.setBackground(Color.white);
mi6.setBackground(Color.white);
mi7.setBackground(Color.white);
mi8.setBackground(Color.white);
mi9.setBackground(Color.white);
mi10.setBackground(Color.white);
mi11.setBackground(Color.white);
mi13.setBackground(Color.white);
mi14.setBackground(Color.white);
mi15.setBackground(Color.white);
mi16.setBackground(Color.white);
mi17.setBackground(Color.white);
mi18.setBackground(Color.white);




mn1.add(mi1);
mn1.add(mi2);
mn1.add(mi3);
mn1.add(mi18);


mn2.add(mi4);
mn2.add(mi5);
mn2.add(mi6);

mn3.add(mi7);
mn3.add(mi8);
mn3.add(mi9);

mn4.add(mi10);
mn4.add(mi11);


mn5.add(mi13);
mn5.add(mi14);

mn6.add(mi15);
mn6.add(mi16);
mn6.add(mi17);

mb.add(mn1);
mb.add(mn2);
mb.add(mn3);
//mb.add(mn5);
mb.add(mn4);
mb.add(mn6);


l2.setBounds(0,0,1370,640);
l3.setBounds(0,635,300,20);
mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);
mi7.addActionListener(this);
mi8.addActionListener(this);
mi9.addActionListener(this);
mi10.addActionListener(this);
mi11.addActionListener(this);
mi13.addActionListener(this);
mi14.addActionListener(this);
mi15.addActionListener(this);
mi16.addActionListener(this);
mi17.addActionListener(this);
mi18.addActionListener(this);


mb.setBackground(Color.white);
setJMenuBar(mb);
add(l2);
setVisible(true);
JOptionPane.showMessageDialog(this,l3.getText());
}

int g=1;
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==mi1)
{
create_employee objc=new create_employee();
pane.add(objc);
objc.moveToFront();
objc.setMaximum(true);

}

if(ae.getSource()==mi2)
{
drop_user objd=new drop_user();
pane.add(objd);
objd.moveToFront();
objd.setMaximum(true);

}

if(ae.getSource()==mi3)
{
new change_password(user,g);
}

if(ae.getSource()==mi4)
{
department_master objm=new department_master();
pane.add(objm);
objm.moveToFront();
objm.setMaximum(true);

}

if(ae.getSource()==mi5)
{
subject_master objs=new subject_master();
pane.add(objs);
objs.moveToFront();
objs.setMaximum(true);

}

if(ae.getSource()==mi6)
{
subject_allotment objsa=new subject_allotment();
//objsa.setMaximum(true);
pane.add(objsa);

}

if(ae.getSource()==mi7)
{
/*scrll_bar objcs=new scrll_bar();
pane.add(objcs,"Center");
objcs.moveToFront();
objcs.setMaximum(true);
*/
JInternalFrame fr=new JInternalFrame("Create New Student",true,true,true,true);
fr.setSize(1365,630);
JPanel p2=new create_student();
p2.setPreferredSize(new Dimension(1370,690));
JScrollPane pane1=new JScrollPane(p2);
pane1.setPreferredSize(p2.getPreferredSize());
fr.add(pane1);
fr.setVisible(true);
pane.add(fr,"Center");
fr.moveToFront();
fr.setMaximum(true);



}

if(ae.getSource()==mi8)
{
regeneration objr=new regeneration();
pane.add(objr);
objr.moveToFront();
objr.setMaximum(true);
}

if(ae.getSource()==mi10)
{
adm_report objar=new adm_report();
pane.add(objar);
objar.moveToFront();
objar.setMaximum(true);
}

if(ae.getSource()==mi11)
{
adm_report_by_date objad=new adm_report_by_date();
pane.add(objad);
objad.moveToFront();
objad.setMaximum(true);
}

if(ae.getSource()==mi15)
{
attendence_report objer=new attendence_report();
pane.add(objer);
objer.moveToFront();
objer.setMaximum(true);

}

if(ae.getSource()==mi16)
{
marks_report objmr=new marks_report();
pane.add(objmr);
objmr.moveToFront();
objmr.setMaximum(true);

}

if(ae.getSource()==mi17)
{
fee_report objfr=new fee_report();
pane.add(objfr);
objfr.moveToFront();
objfr.setMaximum(true);

}

if(ae.getSource()==mi18)
{
int i=JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Logout");
if(i==0)
{
new login();
this.dispose();
}
}

}
catch(Exception eee)
{
System.out.println(eee);
eee.printStackTrace();
}



}

public static void main(String lk[])
{
new admin_window("");
}
}






