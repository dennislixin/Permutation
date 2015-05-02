import java.util.*;

public class PermutationTest{
  public static void main(String[] args){
    test("a");
    test("ab");
    test("abc");
    test("abcd");
  }

  public static void test(String str){
    System.out.println("Find permutation for " + str);

    Permutation permutationFinder = new Permutation(str);
    permutationFinder.print();
  }
}

class Permutation{
  Set<String> permutatedStrings;

  public Permutation(String str){
    if(str == null)
      throw new IllegalArgumentException("string cannot be null");
    permutatedStrings = permutate(str);
  }

  private static Set<String> permutate(String str){
    Set<String> permutatedStrings = new HashSet<>();

    if(str.length() == 1){
      permutatedStrings.add(str);
      return permutatedStrings;
    }

    for(int i=0; i<str.length(); i++){
      char aChar = str.charAt(i);
      String remainStr = str.substring(0, i) + str.substring(i+1);
      Set<String> permuatatedRemainStrings = permutate(remainStr);
      for(String permutatedStr : permuatatedRemainStrings){
        permutatedStrings.add(aChar + permutatedStr);
      }
    }
    return permutatedStrings;
  }

  public void print(){
    for(String str : permutatedStrings){
      System.out.println(str);
    }
  }
}
