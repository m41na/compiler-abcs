package works.hop.basic.ast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import works.hop.basic.calc.Lexer;
import works.hop.basic.calc.Token;

public class Main {
    
    public static void main(String...args){
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("$> ");
            String input;
            while(!(input = reader.readLine()).equals("exit")){  
                Lexer lexer = new Lexer(input);
                Parser parser = new Parser(lexer);
                Interpreter calc = new Interpreter(parser);
                int result = calc.interpret();
                System.out.printf("$> %s%n", result);
                System.out.print("$> ");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }
    
    public static void sample(){
        Token times = new Token(Token.TokenType.MUL, '*');
        Token plus = new Token(Token.TokenType.ADD, '+');
        
        AstNode mul = new BinOp(new Num(new Token(Token.TokenType.INTEGER, 2)), times, new Num(new Token(Token.TokenType.INTEGER, 7)));
        AstNode add = new BinOp(mul, plus, new Num(new Token(Token.TokenType.INTEGER, 3)));
        
        System.out.println(add.print(" "));
    }
}
