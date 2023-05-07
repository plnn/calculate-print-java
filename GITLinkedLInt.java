/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.util.LinkedList;

/**
 *
 * @author erdem
 */
public class GITLinkedLInt {
    private NodeInt head=null;
    private NodeInt tail=null;
    private int size=0;
    private LinkedList<NodeInt> l=new LinkedList();
     
    private  class NodeInt{
        private Int nodeInt;
        private NodeInt next;
        private NodeInt prev;
       
        
        NodeInt(){
       
        }
       
        NodeInt(Int i){
            nodeInt=i;
            next=null;
            prev=null;
        }
    }
    public boolean find(String a){
        NodeInt n=new NodeInt();
        n=head;
        for(;n!=null;n=n.next)
            if(n.nodeInt.getL().equals(a))
                return true;
        return false;
    }
    public int findIndex(String a){
        NodeInt node=new NodeInt();
        node=head;
        int res=0;
        for(;node!=null;node=node.next)
            ++res;
        
        return res;
    }
 
    public void changeVal(int n,int a){
      int i;
      NodeInt node=new NodeInt();
      node=head;
      for(i=0;i<n;++i)
          node=node.next;
      
      node.nodeInt.setN(a);
    }
        public void addNode(Int i){
            /*if(head==null){
                head=new NodeInt(i);
                ++size;
                tail=head;
               
            }**/
            /*else{
                 tail.next=new NodeInt(i);
                 tail.next.prev=tail;
                 tail=tail.next;
                 ++size;
            }*/
        }
        

}
