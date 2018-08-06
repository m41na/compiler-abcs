package works.hop.basic.ast;

public class Interpreter extends NodeVisitor{

    public final Parser parser;

    public Interpreter(Parser parser) {
        this.parser = parser;
    }
    
    public int interpret(){
        AstNode result = parser.parse();
        return visit(result);
    }

    @Override
    public int visitNum(Num node) {
        return node.value;
    }

    @Override
    public int visitBinOp(BinOp node) {
        if(null == node.token.type){
            throw new RuntimeException("binop token cannot be null");
        }
        else switch (node.token.type) {
            case ADD:
                return visit(node.left) + visit(node.right);
            case SUB:
                return visit(node.left) - visit(node.right);
            case MUL:
                return visit(node.left) * visit(node.right);
            case DIV:
                return visit(node.left) / visit(node.right);
            default:
                throw new RuntimeException("unknown binop token encountered");
        }
    }
}
