/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseClasses;

/**
 *
 * @author rey
 */
class TransformComponent {

    public NXTVector getPosition() {
        return position;
    }

    public void setPosition(NXTVector position) {
        this.position = position;
    }

    public NXTVector getRotation() {
        return rotation;
    }

    public void setRotation(NXTVector rotation) {
        this.rotation = rotation;
    }

    public NXTVector getScale() {
        return scale;
    }

    public void setScale(NXTVector scale) {
        this.scale = scale;
    }
    
    private NXTVector position;
    private NXTVector rotation;
    private NXTVector scale;
}
