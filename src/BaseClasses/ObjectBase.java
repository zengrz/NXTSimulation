/**
 * All classes used in the simulation inherits from this class.
 * The list of tags acts as a filter for the system to query.
 */
package BaseClasses;

import java.util.ArrayList;

/**
 *
 * @author rey
 */
public abstract class ObjectBase {

    public ObjectBase() {
        isVisible = false;
        tags = new ArrayList<String>();
    }
    
    public ObjectBase(boolean flag, String tag) {
        isVisible = flag;
        tags = new ArrayList<String>();
        tags.add(tag);
    }
    
    public ArrayList<String> getTags() {
        return tags;
    }
    
    public void addTag(String tag) {
        tags.add(tag);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisibility(boolean flag) {
        this.isVisible = flag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    private boolean isVisible;
    private String type;
    private ArrayList<String> tags;
}
