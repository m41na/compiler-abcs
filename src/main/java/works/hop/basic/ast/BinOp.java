package works.hop.basic.ast;

import works.hop.basic.calc.Token;

public class BinOp implements AstNode{
    
    public AstNode left;
    public Token token;
    public AstNode right;

    public BinOp(AstNode left, Token token, AstNode right) {
        this.left = left;
        this.token = token;
        this.right = right;
    }

    @Override
    public String print(String space) {
        String out = left.print(space);
        out += token.value;
        out += space + right.print(space);
        return out;
    }
}
