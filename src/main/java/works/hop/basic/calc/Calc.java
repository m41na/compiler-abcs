package works.hop.basic.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
    
    public static void main(String...args){
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("$> ");
            String input;
            while(!(input = reader.readLine()).equals("exit")){  
                Lexer lexer = new Lexer(input);
                Interpreter calc = new Interpreter(lexer);
                int result = calc.expr();
                System.out.printf("$> %d%n", result);
                System.out.print("$> ");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }
}
