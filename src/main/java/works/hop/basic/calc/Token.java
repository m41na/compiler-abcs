package works.hop.basic.calc;

public class Token<T> {

    public static enum TokenType {
        INTEGER, ADD, SUB, MUL, DIV, MOD, EOF, OPAREN, CPAREN
    }

    public final TokenType type;
    public final T value;

    public Token(TokenType type, T value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" + "type=" + type + ", value=" + value + '}';
    }
}
