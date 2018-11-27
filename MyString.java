public class MyString implements CharSequence,Comparable<CharSequence>{

  private char[] chars;

  public MyString(CharSequence charsequence){
    chars = new char[charsequence.length()];
    for (int i=0;i<charsequence.length();i++){//loop through the charsequence and make an array of each individual character
      chars[i]=charsequence.charAt(i);
    }
  }

  public char charAt(int index){
    for (int i=0;i<chars.length;i++){
      if (i==index){//loop through the charsequence until you get to the desired index (if it exists)
        return chars[i];
      }
    }
    throw new IndexOutOfBoundsException();//if the desired index doesn't exist, throw the exception
  }

  public int length(){
    return chars.length;
  }

  public CharSequence subSequence(int start, int end){
    String ans = "";
    if (start<0||end<0||end>chars.length||start>end){//covers all the cases stated on docs.oracle.com
      throw new IndexOutOfBoundsException();
    }else{
      for (int i=0;i<chars.length;i++){
        if (i>=start&&i<end){//restricts the answer so that it only contains chars from indexes within the boundaries given by user, thus "subsequencing" it
          ans+=chars[i];
        }
      }
    }
    return ans;
  }

  public String toString(){
    String ans = "";
    for (int i=0;i<chars.length;i++){
      ans+=chars[i];
    }
    return ans;
  }


  public int shorter(char[] a, CharSequence b){ //helpr function for compareTo; returns the length of the shorter of the two charsequences so I don't get an IndexOutOfBoundsException
    if (a.length>b.length()){
      return b.length();
    }
    return a.length;
  }

  public int compareTo(CharSequence c){
    if (chars==null||c==null){
      throw new NullPointerException(); //covers the NullPointerException thrown by compareTo
    } else if (chars.length==0&&c!=""){ //since an empty string will lead to an error in my for loop, I covered the specific cases here
      return -1;
    } else if (c!=""&&chars.length==0){
      return 1;
    } else if (chars.length==0&&c==""){
      return 0;
    } else for (int i=0;i<shorter(chars,c);i++){ //loops through the shorter of the two charsequences
      if (chars[i]+0>c.charAt(i)+0){//the +0 converts the char to its int value
        return 1;
      } else if (c.charAt(i)+0>chars[i]+0){
        return -1;
      }//if the characters are =, nothing happens
    }
    //if the code has made it to this point, it means one of three things:
    if (chars.length>c.length()){//identical up to a point, but THIS charsequence has more characters
      return 1;
    } else if (c.length()>chars.length){//identical up to a point, but OTHER charsequence has more characters
      return -1;
    }
    return 0;//the two charsequences are identical.
  }

}
