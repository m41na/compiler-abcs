package works.hop.basic.ast;

import works.hop.basic.calc.Token;

public class Num implements AstNode{
    
    public int value;
    public Token<Integer> token;

    public Num(Token<Integer> token) {
        this.value = token.value;
        this.token = token;
    }

    @Override
    public String print(String space) {
        return String.valueOf(value);
    }
}
