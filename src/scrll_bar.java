import java.awt.*;
import javax.swing.*;
class scrll_bar 
{
public static void main(String kl[])
{
JInternalFrame fr=new JInternalFrame("Create New Student",true,true,true,true);
fr.setSize(1000,1000);
JPanel p1=new create_student();
p1.setPreferredSize(new Dimension(1100,1500));
JScrollPane pane=new JScrollPane(p1);
pane.setPreferredSize(p1.getPreferredSize());
fr.add(pane);
fr.setVisible(true);
}
}