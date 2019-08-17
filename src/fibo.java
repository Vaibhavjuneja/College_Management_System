import java.util.Scanner;
class fibo{
public static void main(String jk[1])
{
int n=0;
//System.out.println("Enter a no");
try
{
Scanner sc=new Scanner(System.in());
n=sc.nextInt();
int a=0,b=1;
System.out.print(a+" "+b);
for(int i=0;i<n;i++)
{
c=a+b;
a=b;
b=c;
System.out.print(" "+c+" ");
}
}
catch(Exception e)
{
}
}
}