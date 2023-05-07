/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

/**
 *
 * @author erdem
 */
public class GITLinkedFloat {
    private NodeDouble head;
    private NodeDouble t;
    private int size=0;
    private class NodeDouble{
            private Float nf;
            private NodeDouble next;
            private NodeDouble prev;
            
            NodeDouble(){
                
            }
            NodeDouble(Float f){
                    nf=f;
                    next=null;
                    prev=null;
            }
    }
    public boolean find(String s){
        NodeDouble n=new NodeDouble();
        n=head;
        for(;n!=null;n=n.next)
            if(n.nf.getL().equals(s))
                return true;
        return false;
    }
    public int findIndex(String a){
        NodeDouble node=new NodeDouble();
        node=head;int res=0;
        for(;node!=null;node=node.next)
            ++res;
        
        return res;
    }
    public void changeFloat(int a,double val){
        int i;
        NodeDouble node=new NodeDouble();
        node=head;
        for(i=0;i<a;++i)
            node=node.next;
        node.nf.setN(val);
    }
            public void add(Float f){
                if(head==null){
                    head=new NodeDouble(f);
                    ++size;
                    t=head;
                    
                }
                else{
                    t.next=new NodeDouble(f);
                    t.next.prev=t;
                    t=t.next;
                    ++size;
                }
            }
    
    
    
}
