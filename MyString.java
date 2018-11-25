public class MyString implements CharSequence,Comparable<CharSequence>{

  private char[] chars;
  private CharSequence cs;

  public MyString(CharSequence charsequence){
    cs = charsequence;
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


  public int shorter(CharSequence a, CharSequence b){ //helpr function for compareTo; returns the length of the shorter of the two charsequences so I don't get an IndexOutOfBoundsException
    if (a.length()>b.length()){
      return a.length();
    }
    return b.length();
  }

  public int compareTo(CharSequence c){
    for (int i=0;i<shorter(cs,c);i++){
      if (cs.charAt(i)+0>c.charAt(i)){
        return 1;
      } else if (c.charAt(i)+0>cs.charAt(i)+0){
        return -1;
      }
    }
    return 0;
  }

}
