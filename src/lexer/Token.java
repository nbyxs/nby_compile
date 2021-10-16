package lexer;

/**
 * 词法单元总类：Token
 *              /      \
 *              Num     word
 */
public class Token {
    public  final  int flag;
    public  Token(int t){
        flag=t;
    }
    @Override
    public  String toString(){
        return ""+(char)flag;
    }
}
