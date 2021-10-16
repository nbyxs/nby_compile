package parser;

import java.io.IOException;

public class Parser {
    static int lookahead;
    public Parser() throws IOException {
        lookahead=System.in.read();
    }
    void expr() throws IOException {
        term();
        while (true){
            if(lookahead=='+'){
                match('+');
                term();
                System.out.write('+');
            }
            else  if(lookahead=='-'){
                match('-');
                term();
                System.out.write('-');
            }
            else  if(lookahead=='/'){
                match('/');
                term();
                System.out.write('/');
            }
            else  if(lookahead=='*'){
                match('*');
                term();
                System.out.write('*');
            }
            else return;
        }
    }

    private void term() throws IOException {
        if(Character.isDigit((char)lookahead)){
            System.out.write((char)lookahead);
            match(lookahead);
        }
        else throw new Error("格式错误");
    }

    private void match(int t) throws IOException {
        if (t==lookahead)lookahead=System.in.read();
        else throw new Error("格式错误");
    }

    public static void main(String[] args) throws IOException {
        Parser parser=new Parser();
        parser.expr();
        System.out.write('\n');
    }
}
