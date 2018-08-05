package works.hop.basic.lox.core;

abstract class Expr {

    abstract <T>T accept(Visitor<T> expr);

    static interface Visitor<T>{
        
        String print(Expr expr);
        
        String visitBinaryExpr(Expr.Binary expr);
    }
    
    static class Binary extends Expr {

        Binary(Expr left, Token operator, Expr right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

        final Expr left;
        final Token operator;
        final Expr right;

        @Override
        <T> T accept(Visitor<T> expr) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
