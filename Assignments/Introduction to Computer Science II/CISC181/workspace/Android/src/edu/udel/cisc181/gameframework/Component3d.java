package edu.udel.cisc181.gameframework;

/**
 * An abstraction of a component in 3 dimensions.
 * 
 * @author jatlas
 */
public abstract class Component3d {
    protected float x;
    protected float y;
    protected float z;
    
    protected Component3d(float x, float y) {
        this(x, y, 0);
    }
    
    protected Component3d(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * You can safely ignore this method. It allows Components to be
     * used in specific Java Collections.
     * 
     * This code was auto-generated by Eclipse
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        int temp;
        temp = Float.floatToIntBits(x);
        result = prime * result +  (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(y);
        result = prime * result +  (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(z);
        result = prime * result +  (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Any Component3d is equivalent to another Component3d
     * if they are both the same class (which could be a subclass
     * of Component3d) and they have the same x, y, and z values.
     * 
     * This code was auto-generated by Eclipse
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Component3d other = (Component3d) obj;
        if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
            return false;
        if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
            return false;
        if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
            return false;
        return true;
    }   
    
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    public float getZ() {
        return z;
    }
    
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }
    
    public String toString() {
        return getClass().getSimpleName() + " [x=" + x + ", y=" + y + ", z=" + z + "]";
    }    
}
