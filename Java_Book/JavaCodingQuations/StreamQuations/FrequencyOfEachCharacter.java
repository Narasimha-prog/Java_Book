import  java.util.*;
import java.util.stream.Collectors;
public class FrequencyOfEachCharacter{
  public  static void main(String[] a){
  Scanner sc=new Scanner(System.in);
System.out.println("Enter a String to Find Frequency of Each Charector in it:");
  String given=sc.nextLine();
  Map<Character,Long>  result=given.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
result.forEach((ch, count) -> System.out.println(ch + " -> " + count));

  



}
}  
