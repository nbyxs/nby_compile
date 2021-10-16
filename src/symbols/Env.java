package symbols;

import java.util.HashMap;
import java.util.Map;

public class Env {
    private Map map;
    protected Env prev;
    public Env(Env p){
        map=new HashMap();
        prev=p;
    }
    public void put(String s,Symbol sym){
        map.put(s,sym);
    }
    public Symbol get(String s){

    Symbol found=null;
    for(Env e=this;e!=null;e=e.prev){
       found=(Symbol)(e.map.get(s));
      if(found!=null) return found;
    }
    return null;
    }
}
