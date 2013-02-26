/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseClasses;

/**
 *
 * @author rey
 */
public abstract class Behaviour extends NXTComponent {
    
    public void update() {}
    public void awake() {}
    public void reset() {}
    public void start() {}
    public void onEnable() {}
    public void onDisable() {}

    public boolean isEnable() {
        return isEnable;
    }

    public void enable() {
        isEnable = true;
    }
    
    public void disable() {
        isEnable = false;
    }
    
    private boolean isEnable;
    
}
