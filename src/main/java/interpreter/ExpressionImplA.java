package interpreter;

import java.util.List;
import java.util.Map;

public class ExpressionImplA implements Expression{
    public boolean interpret(String expression,IContext context)
    {
        List seqList = context.getSeqList();
        Map contentMap = context.getMap();
        for (int i = 0; i < seqList.size(); i++) {
            if(contentMap.get(context.getSeqList().get(i)).toString().length() != expression.length()-2 || !contentMap.get(context.getSeqList().get(i)).toString().substring(1,contentMap.get(context.getSeqList().get(i)).toString().length()-1).equals(expression.substring(2,expression.length()-2))){
                context.removeList(i);
                i-=1;
            }
        }
        if(context.getSeqList().size() != 0){
            return true;
        }else{
            return false;
        }
    }
}
