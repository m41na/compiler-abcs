package works.hop.basic.ast;

public abstract class NodeVisitor {
    
    public int visit(AstNode node){
        if(node instanceof BinOp){
            return visitBinOp((BinOp)node);
        }
        else if(node instanceof Num){
            return visitNum((Num)node);
        }
        else{
            throw new RuntimeException("unknown node encountered");
        }
    }

    public abstract int visitNum(Num node);

    public abstract int visitBinOp(BinOp node);
}
