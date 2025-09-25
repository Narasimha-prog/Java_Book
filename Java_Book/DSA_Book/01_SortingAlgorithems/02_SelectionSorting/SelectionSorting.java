import java.util.*;
public class SelectionSorting{


private static int[] selectionSorting(int[] given){

for()
return given;
}
public static void main(String[] a){

Scanner sc=new Scanner(System.in);

int size=0;

//get array size
while(true){
try{
System.out.println("Enter size of array...");
size = Integer.parseInt(sc.nextLine());
if(size <=0){
   throw new IllegalArgumentException();
}

break;

}catch(IllegalArgumentException  e){
System.out.println("Invalid Input "+e.getMessage());
System.out.println("Enter valid size: \n");
}

}
System.out.println("Given size: "+size);
int[] arr=new int[size];

while(true ){

try{
for(int i=0;i<size;i++){

System.out.println("Enter "+i+" Element value");

arr[i]=Integer.parseInt(sc.nextLine());
}//for  
break;

}catch(IllegalArgumentException e){

System.out.println("Invalid Input "+e.getMessage());
System.out.println("Enter valid size: \n");

}//catch

}//while



System.out.println("Given array "+Arrays.toString(arr));

sc.close();
}//main method
}//class
