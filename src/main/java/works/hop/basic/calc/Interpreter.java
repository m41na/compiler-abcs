package works.hop.basic.calc;

import static works.hop.basic.calc.Token.TokenType;

public class Interpreter {

    public Lexer lexer;
    public Token token;

    public Interpreter(Lexer lexer) {
        this.lexer = lexer;
        this.token = lexer.nextToken();
    }

    public void error(String msg) {
        throw new LexerException(msg);
    }

    public void eat(TokenType type) {
        if (token.type.equals(type)) {
            token = lexer.nextToken();
        } else {
            error("unexpected token type");
        }
    }

    public int factor() {
        if (token.type == TokenType.INTEGER) {
            Token<Integer> curr = token;
            eat(TokenType.INTEGER);
            return curr.value;
        } else if (token.type == TokenType.OPAREN) {
            eat(TokenType.OPAREN);
            int result = expr();
            eat(TokenType.CPAREN);
            return result;
        }
        throw new LexerException("unexpected token encountered");
    }

    public int term() {
        int result = factor();

        while (token.type == TokenType.MUL || token.type == TokenType.DIV) {
            Token<Integer> curr = token;
            if (token.type == TokenType.MUL) {
                eat(TokenType.MUL);
                result *= factor();
            } else if (token.type == TokenType.DIV) {
                eat(TokenType.DIV);
                result /= factor();
            }
        }
        return result;
    }

    public int expr() {
        int result = term();

        while (token.type == TokenType.ADD || token.type == TokenType.SUB) {
            Token<Integer> curr = token;
            if (token.type == TokenType.ADD) {
                eat(TokenType.ADD);
                result += term();
            } else if (token.type == TokenType.SUB) {
                eat(TokenType.SUB);
                result -= term();
            }
        }
        return result;
    }
}
