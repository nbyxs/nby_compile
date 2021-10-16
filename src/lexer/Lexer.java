package lexer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Lexer {

    public int line=1;
    private char peek=' ';
    private Map<String, Word> words=new HashMap();
    void reserve(Word t){
        words.put(t.lexeme,t);
    }
    public Lexer(){
        reserve(new Word(Tag.TRUE,"true"));
        reserve(new Word(Tag.FALSE,"false"));
    }
    public void clean() throws IOException {
        for(;;peek=(char)System.in.read()){
            if(peek==' '||peek=='\t')continue;
            else if(peek=='\n')++line;

            else break;
        }
    }
    public Token scan() throws IOException {
             clean();
            StringBuffer s_ann=new StringBuffer("/");
            if(peek=='/'){
                char a= (char) System.in.read();
                if(a=='/'){
                do {
                    s_ann.append(peek);
                    peek=(char)System.in.read();
                }while (peek!='\n');
                }
                else if(a=='*'){
                    for(peek=a;peek!='/';peek=(char)System.in.read())s_ann.append(peek);
                    s_ann.append("/");
                    peek=(char)System.in.read();
                }
                else throw new Error("注解格式错误！");
            }System.out.println(s_ann);
        System.out.println(peek);

        clean();

        if(Character.isDigit(peek)){

            int v=0;
            do{
                v=10*v+Character.digit(peek,10);
                peek=(char)System.in.read();
            }
            while (Character.isDigit(peek));

            Num num=new Num(v);
            return num;
        }
        if(Character.isLetter(peek)){
            StringBuffer b=new StringBuffer();
            do{
                b.append(peek);
                peek=(char)System.in.read();
            }while (Character.isLetter(peek));
            String s=b.toString();
            Word w=(Word)words.get(s);
            if(w!=null)return w;
            w=new Word(Tag.ID,s);
            words.put(s,w);
            return w;
        }
        Token t=new Token(peek);
        peek=' ';
        return t;
    }

    public static void main(String[] args) throws IOException {
        Lexer lexer=new Lexer();

          while (true){
              lexer.scan();


              for(Map.Entry<String, Word> entry : lexer.words.entrySet()){
                  System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue().lexeme);
              }

          }
    }
}
