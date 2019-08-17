public class validation
{
static boolean checkString(String ab)
{
int i;
for(i=0;i<ab.length();i++)
{
char ch=ab.charAt(i);
if(!((ch>=65&&ch<=90)||(ch>=97&&ch<=122)||(ch==32)))
{
return false;
}
}
return true;
}
static boolean checkPhoneNumber(String as)
{
int i;
for(i=0;i<as.length();i++)
{
char ch=as.charAt(i);
if(!(ch>=48&&ch<=57))
{
return false;
}
}
if(!(as.length()==10))
{
return false;
}
return true;
}
static boolean checkPinNumber(String as)
{
int i;
for(i=0;i<as.length();i++)
{
char ch=as.charAt(i);
if(!(ch>=48&&ch<=57))
{
return false;
}
}
if(!(as.length()==6))
{
return false;
}
return true;
}

static boolean checkAddress(String ab)
{
int i;
for(i=0;i<ab.length();i++)
{
char ch=ab.charAt(i);
if(!((ch>=65&&ch<=90)||(ch>=97&&ch<=122)||(ch==32)||(ch>=48&&ch<=57)||(ch==46)))
{
return false;
}
}
return true;
}
static boolean checkMarks(String as)
{
int i;
for(i=0;i<as.length();i++)
{
char ch=as.charAt(i);
if(!((ch>=48&&ch<=57)||(ch==46)))
{
return false;
}
}
return true;
}
static boolean checkSchool(String ab)
{
int i;
for(i=0;i<ab.length();i++)
{
char ch=ab.charAt(i);
if(!((ch>=65&&ch<=90)||(ch>=97&&ch<=122)||(ch==32)||(ch==46)))
{
return false;
}
}
return true;
}
static boolean checkEmail(String ab)
{
int i=0,p=0,q=0,w=0;
for(i=0;i<ab.length();i++)
{
char ch=ab.charAt(i);
if((ch>=65&&ch<=90)||(ch>=97&&ch<=122)||(ch>=48&&ch<=57))
p=1;

if(ch==64)
q=1;

if(ch==46)
w=1;
}
if((p==1)&&(q==1)&&(w==1))
return true;
else
return(false);

}
static boolean checkTittel(String kl)
{
if(!((kl.equals("Accountant"))||(kl.equals("Faculty"))))
{
return false;
}
return true;
}
static boolean checkAdhaarNumber(String as)
{
int i;
for(i=0;i<as.length();i++)
{
char ch=as.charAt(i);
if(!(ch>=48&&ch<=57))
{
return false;
}
}
if(!(as.length()==12))
{
return false;
}
return true;
}

static boolean checkPassword(String ab)
{
int i=0,p=0,q=0,w=0;
for(i=0;i<ab.length();i++)
{
char ch=ab.charAt(i);
if((ch>=65&&ch<=90)||(ch>=97&&ch<=122)||(ch>=48&&ch<=57))
p=1;

if((ch>=33&&ch<=47)||(ch>=58&&ch<=64))
q=1;

if(ab.length()>=8)
w=1;
}
if((p==1)&&(q==1)&&(w==1))
return true;
else
return(false);

}
/*public static void main(String kl[])
{
validation v1=new validation();
System.out.println(v1.checkPassword("IT001.raldu"));
}*/

}