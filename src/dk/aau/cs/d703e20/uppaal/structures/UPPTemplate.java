package dk.aau.cs.d703e20.uppaal.structures;

import com.uppaal.model.core2.*;

public class UPPTemplate extends Template {
    // Store all declarations before setting them
    private StringBuilder declSB;// = new StringBuilder();

    public UPPTemplate(Element prototype) {
        super(prototype);
    }

    public StringBuilder getDeclSB() {
        return declSB;
    }

    /**
     * Sets a label on an edge.
     *
     * @param e     the edge
     * @param kind  the kind of the label
     * @param value the content of the label
     * @param x     the x coordinate of the label
     * @param y     the y coordinate of the label
     */
    public static void setLabel(Edge e, EKind kind, String value, int x, int y) {
        e.setProperty(kind.name(), value);
        Property p = e.getProperty(kind.name());
        p.setProperty("x", x);
        p.setProperty("y", y);
    }

    /**
     * Sets a label on a location.
     *
     * @param l     the location on which the label is going to be attached
     * @param kind  a kind of the label
     * @param value the label value (either boolean or String)
     * @param x     the x coordinate of the label
     * @param y     the y coordinate of the label
     */
    public static void setLabel(Location l, LKind kind, Object value, int x, int y) {
        l.setProperty(kind.name(), value);
        Property p = l.getProperty(kind.name());
        p.setProperty("x", x);
        p.setProperty("y", y);
    }

    /**
     * Adds an edge to the template
     *
     * @param source the source location
     * @param target the target location
     * @param guard  guard expression
     * @param sync   synchronization expression
     * @param update update expression
     * @return e     the edge
     */
    public Edge addEdge(Location source, Location target, String guard, String sync, String update) {
        Edge e = createEdge();
        insert(e, null);
        e.setSource(source);
        e.setTarget(target);
        int x = (source.getX() + target.getX()) / 2;
        int y = (source.getY() + target.getY()) / 2;
        if (guard != null) {
            setLabel(e, EKind.guard, guard, x - 15, y - 28);
        }
        if (sync != null) {
            setLabel(e, EKind.synchronisation, sync, x - 15, y - 14);
        }
        if (update != null) {
            setLabel(e, EKind.assignment, update, x - 15, y);
        }
        return e;
    }

    /**
     * Adds a location to a template.
     *
     * @param name a name for the new location
     * @param x    the x coordinate of the location
     * @param y    the y coordinate of the location
     * @return the new location instance
     */
    public Location addLocation(String name, int x, int y) {
        Location l = createLocation();
        insert(l, null);
        l.setProperty("x", x);
        l.setProperty("y", y);
        if (name != null)
            setLabel(l, LKind.name, name, x, y - 28);
        return l;
    }

    /**
     * Valid kinds of labels on locations.
     */
    public enum LKind {
        name, init, urgent, committed, invariant, exponentialrate, comments
    }

    /**
     * Valid kinds of labels on edges.
     */
    public enum EKind {
        select, guard, synchronisation, assignment, comments
    }
}
