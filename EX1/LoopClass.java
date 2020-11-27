public class LoopClass {

    public LoopClass(int i, char c){

        for(int j = 0; j < i; j++)
            System.out.print(c);
    }
    public LoopClass(int i, char[] cArr){

        for(int j = 0; j < i; j++)
            System.out.print(cArr[j]);
    }
    
}
