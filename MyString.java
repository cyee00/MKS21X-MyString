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
    String ans = "";
    if (start<0||end<0||end>cs.length()||start>end){
      throw new IndexOutOfBoundsException();
    }else{
      for (int i=0;i<cs.length();i++){
        if (i>=start&&i<end){
          ans+=cs.charAt(i);
        }
      }
    }
    return ans;
  }

  public String toString(){
    String ans = "";
    for (int i=0;i<cs.length();i++){
      ans+=cs.charAt(i);
    }
    return ans;
  }

}
