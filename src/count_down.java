import java.awt.*;
import javax.swing.*;
class count_down extends JFrame implements Runnable
{
JLabel l1;
Thread t1;
count_down()
{
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
l1=new JLabel("10");

l1.setFont(new Font("Arial Rounded MT",Font.BOLD,50));

add(l1);

l1.setBounds(400,300,100,100);


t1=new Thread(this);

setVisible(true);

t1.start();
}
public void run()
{
try
{
int i=0;
for(i=10;i>=0;i--)
{
l1.setText(String.valueOf(i));
Thread.sleep(1000);
}
new create_student();
this.dispose();
}
catch(Exception e)
{}

}
public static void main(String ui[])
{
new count_down();
}
}