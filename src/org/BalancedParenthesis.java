package org;

public class BalancedParenthesis {
    static void main() {
        int n = 5;
        printBalancedParenthesis(n);
    }

    private static void printBalancedParenthesis(int n) {
        if(n<1) return;
        int open=0;
        int close=0;
        printParenthesis(open,close,n, new StringBuilder());
    }

    private static void printParenthesis(int open, int close,int n, StringBuilder sb) {
        if(open==close && open==n){
            System.out.println(sb.toString());
            return;
        }
        if(open<n && open>=close){
            //str = str+"(";
            printParenthesis(open+1,close,n,sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }
        if (close<open){
            printParenthesis(open, close+1, n, sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }



    }
}
