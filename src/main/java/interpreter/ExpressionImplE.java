package interpreter;

import java.util.List;
import java.util.Map;

public class ExpressionImplE implements Expression{
    public boolean interpret(String expression,IContext context)
    {
        List seqList = context.getSeqList();
        Map contentMap = context.getMap();
        for (int i = 0; i < seqList.size(); i++) {
            if(!contentMap.get(seqList.get(i)).toString().substring(contentMap.get(seqList.get(i)).toString().length()-1).equals(expression.substring(expression.length()-2,expression.length()-1))){
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
