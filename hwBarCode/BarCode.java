public class BarCode implements Comparable{
// instance variables
   private String _zip;
   private int _checkDigit;
   public static final String[] codes={"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|", "|::|:", "|:|::"};
// constructors
//precondtion: zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
public BarCode(String zip) {
    _zip=zip;
    _checkDigit=checkSum();
}

// postcondition: Creates a copy of a bar code.
public BarCode(BarCode x){
    _zip=x._zip;
    _checkDigit=checkSum();
}

//post: computes and returns the check sum for _zip
private int checkSum(){
    int zip=_zip.parseInt();
    int sum=0;
    while(zip!=0){
	sum+=zip%10;
	zip/=10;
    }
    return sum%10;
}

//postcondition: format zip + check digit + barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
public String toString(){
    String s="|";
    for(int x=1;x<7;x++){
	s+=codes[_zip.substring(x-1,x).parseInt()];
    }
    return s+"|";
}


public boolean equals(Object other){
    return this==other || ((other instanceof BarCode) && (((BarCode) other)._zip.equals(_zip));
}
// postcondition: false if the object is not a BarCode, 
// false if it is a non-matching barcode
// true when they match.


public int compareTo(Comparable other){
    
}
// postcondition: compares the zip + checkdigit 

}