import java.awt.*;
import javax.swing.*;
class markew extends JFrame implements Runnable
{
JLabel l1;
Thread t1;
Container con=getContentPane();
markew()
{
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
con.setBackground(Color.blue);

l1=new JLabel("Aptech");

l1.setFont(new Font("Arial Rounded MT",Font.BOLD,50));


add(l1);

l1.setBounds(0,0,400,100);


t1=new Thread(this);

setVisible(true);

t1.start();
}
public void run()
{
try
{
int i=0,j=0;
int x=1;
while(x==1)
{
l1.setBounds(i,j,400,100);
Thread.sleep(10);
i++;
if(i>1000)
i=0;
}

}
catch(Exception e)
{}

}
public static void main(String ui[])
{
new markew();
}
}