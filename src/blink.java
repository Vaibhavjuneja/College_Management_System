import java.awt.*;
import javax.swing.*;
class blink extends JFrame implements Runnable
{
JLabel l1;
Thread t1;
Container con=getContentPane();
blink()
{
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
con.setBackground(Color.blue);

l1=new JLabel("Aptech");

l1.setFont(new Font("Arial Rounded MT",Font.BOLD,200));


add(l1);

l1.setBounds(200,0,900,600);


t1=new Thread(this);

setVisible(true);

t1.start();
}
public void run()
{
try
{
int i=0;
int x=1;
while(x==1)
{
if(i%2==0)
l1.setVisible(true);
else 
l1.setVisible(false);
Thread.sleep(200);
i++;
}

}
catch(Exception e)
{}

}
public static void main(String ui[])
{
new blink();
}
}