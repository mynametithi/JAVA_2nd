import java.util.HashSet; 
import java.util.Iterator;
public class Hashing {
public static void main(String[] args) {
//Creating
    HashSet<Integer> set = new HashSet<>();
//Insert values
set.add(1);
set.add(1);
set.add(2);
set.add(2);
//Search
if(set.contains(1)){
    System.out.println(set.contains(1));
}
if(!set.contains(3)){
    System.out.println("does not contains:");
}
//delete
set.remove(1);
//Print all elements:
System.out.println(set);
//Size
System.out.println("size of set is:"+set.size());
//Iterator
Iterator<Integer> it=set.iterator();
while(it.hasNext()){
    System.out.println(it.next());
}
}
}
