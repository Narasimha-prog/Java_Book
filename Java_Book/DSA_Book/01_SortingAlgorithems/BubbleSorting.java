import java.util.*;
public  class  BubbleSorting{

private static  int[] bubbleSorting(int[] n){

for(int i=0;i<n.length;i++){

for(int j=0;j<n.length-1;j++){
 if(n[j]>n[j+1]){
   int temp=n[j];
    n[j]=n[j+1];
    n[j+1]=temp;
}//if


}//inner loop
}//outer loop
   return n;
} 


public static void main(String[] a){

System.out.println("Enter number of element in array: ");
Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
int []  arr=new int[n];

    for(int i=0;i<n;i++){
System.out.println("Enter "+i+" element..");
   arr[i]=sc.nextInt();
             }//loop

System.out.println("Given array: "+Arrays.toString(arr) );

System.out.println(Arrays.toString(bubbleSorting(arr)));


}//main method

}//class
