public class Pattern{ 
    public static void main(String []args){ 
    System.out.println("PATTERN NO: 1"); 
    for (int i= 5; i>= 1; i--) 
    {
    for (int j=5; j>i;j--) 
    {
    System.out.print(" "); 
    }
    for (int k=1;k<=i;k++) 
    {
    System.out.print("*"); 
    }
    System.out.println(""); 
    }
    System.out.println("\n\nPATTERN NO: 2"); 
    for (int i = 1; i <= 5; i++) 
    {
    for (int j = 5; j > i; j--) 
    {
    System.out.print(" "); 
    }
    for (int k = 1; k <= i; k++) 
    {
    System.out.print("*"); 
    }
    System.out.println(); 
    }
    for (int i = 1; i <= 5-1; i++) 
    {
    for (int j = 1; j <= i; j++) 
    {
    System.out.print(" "); 
    }
    for (int k = 5-1; k >= i; k--) 
    {
    System.out.print("*"); 
    }    System.out.println(); 
    }
    }
    }
    