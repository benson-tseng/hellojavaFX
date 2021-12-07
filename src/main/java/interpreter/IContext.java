package interpreter;

import java.util.*;

public class IContext {
    private String mContext;
    // first integer is index of array of word
    private Map<Integer,String> contentMap = new LinkedHashMap();
    private List<Integer> seqList = new ArrayList<>();

    public IContext(String str){
        mContext = str;
    }

    public String getmContext(){
        return mContext;
    }

    public Map getMap(){
        return this.contentMap;
    }

    public void addMap(int i,String s){
        contentMap.put(i,s);
    }

    public void removeMap(int i){
        contentMap.remove(i);
    }

    public List getSeqList(){
        return this.seqList;
    }

    public void addList(int i){
        seqList.add(i);
    }

    public void removeList(int i){
        seqList.remove(i);
    }
}
