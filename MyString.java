public class MyString implements CharSequence{

  private char[] chars;

  public MyString(CharSequence cs){
    chars = new char[cs.length()];
    for (int i;i<cs.length();i++){
      chars[i]=cs.charAt(i);
    }
  }

  public char charAt(int index){
    for (int i=0;i<chars.length();i++){
      if (i==index){
        return chars[i];
      }
    }
    throw new IndexOutOfBoundsException();
  }

  public int length(){
    
  }

}
