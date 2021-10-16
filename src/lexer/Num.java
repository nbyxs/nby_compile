package lexer;
/**
*常量存储
*存储形式：<终结符号,value>
 **/
public class Num extends Token {
    public  final  int value;

    public Num(int t) {
        super(Tag.NUM);
        value=t;
    }
    public  String toString(){
        return  ""+value;
    }
}
