package BaseClasses;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rey
 */
public abstract class GameObject extends ObjectBase {

    public TransformComponent getTrnsform() {
        return tc;
    }

    public void setTrnsform(TransformComponent tc) {
        this.tc = tc;
    }

    public ArrayList<NXTComponent> getComponents() {
        return components;
    }

    public void addComponent(NXTComponent component) {
        this.components.add(component);
    }
    
    /*
     * Iterate through the components the GameObject owns.
     * If the components has a tag that matches the query tag,
     * that component is removed.
     * @param queryTag 
     */
    public void removeComponent(String queryTag) {
        Iterator<NXTComponent> itr = components.iterator();
        while (itr.hasNext()) {
            NXTComponent comp = itr.next();
            if (comp.getTags().contains(queryTag)) {
                itr.remove();
            }
        }
    }
    
    private TransformComponent tc;
    private ArrayList<String> tags;
    private ArrayList<NXTComponent> components;
}
