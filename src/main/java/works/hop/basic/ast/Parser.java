package works.hop.basic.ast;

import works.hop.basic.calc.Lexer;
import works.hop.basic.calc.Token;

public class Parser {
    
    public Lexer lexer;
    public Token token;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.token = lexer.nextToken();
    }
    
    public void eat(Token.TokenType type) {
        if (token.type.equals(type)) {
            token = lexer.nextToken();
        } else {
            throw new RuntimeException("unexpected token type");
        }
    }

    public AstNode factor() {
        if (token.type == Token.TokenType.INTEGER) {
            Token<Integer> curr = token;
            eat(Token.TokenType.INTEGER);
            return new Num(curr);
        } else if (token.type == Token.TokenType.OPAREN) {
            eat(Token.TokenType.OPAREN);
            AstNode node = expr();
            eat(Token.TokenType.CPAREN);
            return node;
        }
        throw new RuntimeException("unexpected token encountered");
    }

    public AstNode term() {
        AstNode node = factor();

        while (token.type == Token.TokenType.MUL || token.type == Token.TokenType.DIV) {
            Token<Integer> curr = token;
            if (token.type == Token.TokenType.MUL) {
                eat(Token.TokenType.MUL);
            } else if (token.type == Token.TokenType.DIV) {
                eat(Token.TokenType.DIV);
            }
            node = new BinOp(node, token, factor());
        }
        return node;
    }

    public AstNode expr() {
        AstNode node = term();

        while (token.type == Token.TokenType.ADD || token.type == Token.TokenType.SUB) {
            Token<Integer> curr = token;
            if (token.type == Token.TokenType.ADD) {
                eat(Token.TokenType.ADD);
            } else if (token.type == Token.TokenType.SUB) {
                eat(Token.TokenType.SUB);
            }
            node = new BinOp(node, token, term());
        }
        return node;
    }
    
    public AstNode parse() {
        return expr();
    }
}
