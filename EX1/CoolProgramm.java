public class CoolProgramm {
    public static void main(String[] args) {

        CharacterClass character = new CharacterClass('*');
        LoopClass row1 = new LoopClass(16, character.getCharacter());
        LoopClass newLine1 = new LoopClass(1, new CharacterClass('\n').getCharacter());
        LoopClass row2Char1 = new LoopClass(1, new CharacterClass('*').getCharacter());
        LoopClass row2 = new LoopClass(14,SchoolName.schoolName);
        LoopClass rowChar2 = new LoopClass(1, new CharacterClass('*').getCharacter());
        LoopClass newLine2 = new LoopClass(1, new CharacterClass('\n').getCharacter());
        LoopClass row3 = new LoopClass(16,character.getCharacter());
        
    }    
}
