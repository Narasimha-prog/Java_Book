import  java.util.*;
import java.util.stream.Collectors;

public class FrequencyOfEachCharacter{
  public  static void main(String[] a){
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter a String to Find first Non Repeating character:");
  String given=sc.nextLine();

  
 Character result=   given.chars().mapToObj(c->(char)c)
               .collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
               .entrySet()
               .stream()
               .filter(e->e.getValue()==1)
               .map(Map.Entry::getKey)
               .findFirst().orElse(null);

System.out.println(result);
}
}
