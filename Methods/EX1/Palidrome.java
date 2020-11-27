public class Palidrome{

    public static void main(String args[]){
        
        System.out.println("Is aba palidrome:" + isPalidrome("aba"));
        
        System.out.println("Is ab ba palidrome:" + isPalidrome("ab ba"));
        
        System.out.println("Is baac palidrome:" + isPalidrome("baac"));

  }

  public static boolean isPalidrome(String word){
    StringBuilder reverse = new StringBuilder();
    
    for (int i = 0; i < word.length(); i++)
        if(word.charAt(i) != ' ')reverse.append(word.charAt(i));

    StringBuilder temp = new StringBuilder(reverse.toString());
    
    temp.reverse();
    
    if (reverse.toString().equals(temp.toString()))
        return true;
    else return false;
  }
}