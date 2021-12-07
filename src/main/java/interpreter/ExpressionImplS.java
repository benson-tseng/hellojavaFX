package interpreter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExpressionImplS implements Expression{
    public boolean interpret(String expression,IContext context)
    {
        List seqList = context.getSeqList();
        Map contentMap = context.getMap();
        for (int i = 0; i < seqList.size(); i++) {
            if(!contentMap.get(seqList.get(i)).toString().substring(0,1).equals(expression.substring(1,2))){
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
