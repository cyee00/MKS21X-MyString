public class MyString implements CharSequence{

  private char[] chars;
  private CharSequence cs;

  public MyString(CharSequence cs){
    cs = cs;
    chars = new char[cs.length()];
    for (int i=0;i<cs.length();i++){
      chars[i]=cs.charAt(i);
    }
  }

  public char charAt(int index){
    for (int i=0;i<cs.length();i++){
      if (i==index){
        return chars[i];
      }
    }
    throw new IndexOutOfBoundsException();
  }

  public int length(){
    return cs.length();
  }

  public CharSequence subSequence(int start, int end){
    CharSequence ans = "";
    return ans;
  }

  public String toString(){
    String ans = "";
    return ans;
  }

}
