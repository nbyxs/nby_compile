package lexer;
/**
 * 关键字和标识符
存储形式：<终结符,终结符字符串>
 **/
/*123/

 */
public class Word  extends Token {
    public final String lexeme;
    public Word(int t,String name){
        super(t);
        lexeme=new String(name);
    }
}
