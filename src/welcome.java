import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class welcome extends JFrame implements Runnable,ActionListener
{
JLabel l1,l2,l3;
ImageIcon i1,i2,i3,i4,i5,i6;
Thread t1,t2;
JButton b1;
Container con=getContentPane();
welcome()
{
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
con.setBackground(Color.white);

String source="welcome.jpg";
i1=new ImageIcon(source);
l1=new JLabel(i1);


b1=new JButton("Continue");

b1.setFont(new Font("Segoe Print",Font.BOLD,25));

add(b1);
add(l1);
b1.setEnabled(false);
l1.setBounds(0,0,0,0);

t1=new Thread(this);
t2=new Thread(this);
b1.addActionListener(this);
setVisible(true);

t1.setPriority(10);
t1.start();
t2.start();
}
synchronized public void run()
{
try
{
if(Thread.currentThread()==t1)
{
int i=0,j=0,k=0,l=0;
int x=1;
for(i=100;i<=1370;i++)
{
if(j<=750)
j=i;
if(k<=350)
k=i;

if(i<=685)
l1.setBounds((685-i),(350-k),i*2,j+20);
//else
//l1.setBounds(0,0,i,j);
Thread.sleep(1);
}
for(l=0;l<=1200;l++)
{
b1.setBounds(l,660,150,30);
Thread.sleep(1);
}
b1.setEnabled(true);
}



}
catch(Exception e)
{}

}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
new login();
this.dispose();
}
}


public static void main(String ui[])
{
new welcome();
}
}