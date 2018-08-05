package works.hop.basic.calc;

import static works.hop.basic.calc.Token.TokenType;

public class Lexer {

    public char[] code;
    public int pos = 0;
    public Character currChar;
    public Token token = null;

    public Lexer(String input) {
        this.pos = 0;
        this.code = input.toCharArray();
        this.currChar = code[pos];
    }

    public void advance() {
        pos++;
        if (pos > code.length - 1) {
            currChar = null;
        } else {
            currChar = code[pos];
        }
    }

    public void skipWhitespace() {
        while (currChar != null && Character.isWhitespace(currChar)) {
            advance();
        }
    }

    public int integer() {
        String res = "";
        while (currChar != null && Character.isDigit(currChar)) {
            res += currChar;
            advance();
        }
        return Integer.valueOf(res);
    }

    public Token nextToken() {
        while (currChar != null) {
            if (Character.isWhitespace(currChar)) {
                skipWhitespace();
                continue;
            }

            if (Character.isDigit(currChar)) {
                return new Token(TokenType.INTEGER, integer());
            }

            if ('+' == currChar) {
                advance();
                return new Token(TokenType.ADD, '+');
            }

            if ('-' == currChar) {
                advance();
                return new Token(TokenType.SUB, '-');
            }

            if ('*' == currChar) {
                advance();
                return new Token(TokenType.MUL, '*');
            }

            if ('/' == currChar) {
                advance();
                return new Token(TokenType.DIV, '/');
            }

            if ('%' == currChar) {
                advance();
                return new Token(TokenType.MOD, '%');
            }

            if ('(' == currChar) {
                advance();
                return new Token(TokenType.OPAREN, '(');
            }

            if (')' == currChar) {
                advance();
                return new Token(TokenType.CPAREN, ')');
            }
        }
        return new Token(TokenType.EOF, null);
    }
}
