/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StrucMain;

/**
 *
 * @author abhiramj
 */
class stateHandler {
    public int state=0;
    String input;
    String reply;
    stateHandler(){
    }
public String processInput(String input){
if (input!=null){
    this.input=input;
    state=(state+1)%5;
return input;
}
else return null;
}
}
