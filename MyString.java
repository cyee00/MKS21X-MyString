public class MyString implements CharSequence,Comparable<CharSequence>{

  private char[] chars;
  private CharSequence cs;

  public MyString(CharSequence charsequence){
    cs = charsequence;
    chars = new char[cs.length()];
    for (int i=0;i<cs.length();i++){//loop through the charsequence and make an array of each individual character
      chars[i]=cs.charAt(i);
    }
  }

  public char charAt(int index){
    for (int i=0;i<cs.length();i++){
      if (i==index){//loop through the charsequence until you get to the desired index (if it exists)
        return chars[i];
      }
    }
    throw new IndexOutOfBoundsException();//if the desired index doesn't exist, throw the exception
  }

  public int length(){
    int ans = 0;
    for (int i=0;i<chars.length;i++){//loop through the array and add 1 for every char in it
      ans++;
    }
    return ans;
  }

  public CharSequence subSequence(int start, int end){
    String ans = "";
    if (start<0||end<0||end>cs.length()||start>end){//covers all the cases stated on docs.oracle.com
      throw new IndexOutOfBoundsException();
    }else{
      for (int i=0;i<cs.length();i++){
        if (i>=start&&i<end){//restricts the answer so that it only contains chars from indexes within the boundaries given by user, thus "subsequencing" it
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
      return b.length();
    }
    return a.length();
  }

  public int compareTo(CharSequence c){
    if (cs==null||c==null){
      throw new NullPointerException(); //covers the NullPointerException thrown by compareTo
    } else if (cs==""&&c!=""){ //since an empty string will lead to an error in my for loop, I covered the specific cases here
      return -1;
    } else if (c!=""&&cs==""){
      return 1;
    } else if (cs==""&&c==""){
      return 0;
    } else for (int i=0;i<shorter(cs,c);i++){ //loops through the shorter of the two charsequences
      if (cs.charAt(i)+0>c.charAt(i)+0){//the +0 converts the char to its int value
        return 1;
      } else if (c.charAt(i)+0>cs.charAt(i)+0){
        return -1;
      }//if the characters are =, nothing happens
    }
    //if the code has made it to this point, it means one of three things:
    if (cs.length()>c.length()){//identical up to a point, but THIS charsequence has more characters
      return 1;
    } else if (c.length()>cs.length()){//identical up to a point, but OTHER charsequence has more characters
      return -1;
    }
    return 0;//the two charsequences are identical.
  }

}
