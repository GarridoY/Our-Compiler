package dk.aau.cs.d703e20.uppaal.structures;

import com.uppaal.model.core2.*;

import java.util.ArrayList;
import java.util.List;

public class UPPTemplate extends Template {
    // Store all local declarations before setting them, TODO: consider using this for mutex
    private final StringBuilder declSB = new StringBuilder();
    // 0 is always start
    private final List<Location> locationList = new ArrayList<>();
    String Name;
    int locationX = 75;
    int locationY = 0;
    int locationCoordIncr = 140;
    // ID of template, used in conjunction with lock
    int id;
    String localReturnLock = "int returnLock; ";

    public UPPTemplate(Element prototype) {
        super(prototype);
    }

    public static void setNail(Edge e, int x, int y) {
        Nail nail = e.createNail();
        nail.setProperty("x", x);
        nail.setProperty("y", y);
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
     * Sets controllable value on an edge.
     */
    public static void setLabel(Edge e, EKind kind, Boolean value) {
        e.setProperty(kind.name(), value);
        e.getProperty(kind.name());
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

    public List<Location> getLocationList() {
        return locationList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocalReturnLock(String localReturnLock) {
        this.localReturnLock = localReturnLock;
    }

    public void addVar(String varDecl) {
        declSB.append(varDecl).append(";\n");
    }

    /**
     * Flush StringBuilder into property for template. Required to set variable declarations.
     */
    private void setDeclaration() {
        declSB.append(localReturnLock);
        this.setProperty("declaration", declSB.toString());
    }

    public void setLooping() {
        Location firstLoc = locationList.get(0);
        Location lastLoc = locationList.get(locationList.size() - 1);
        Edge e;
        if (Name.startsWith("At"))
            e = addFreeEdge(lastLoc, firstLoc, null, null, "lock = returnLock, atNotRunning = true");
        else
            e = addFreeEdge(lastLoc, firstLoc, null, null, "lock = returnLock");
        setNail(e, lastLoc.getX(), lastLoc.getY() - 70);
        setNail(e, firstLoc.getX(), firstLoc.getY() - 70);

        setDeclaration();
    }

    /**
     * Adds an edge to the template, this edge will have a lock guard
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
            setLabel(e, EKind.guard, guard + " && id == lock", x - 15, y - 28);
        } else {
            setLabel(e, EKind.guard, "id == lock", x - 15, y - 28);
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
     * Adds an edge without a lock to the template
     *
     * @param source the source location
     * @param target the target location
     * @param guard  guard expression
     * @param sync   synchronization expression
     * @param update update expression
     * @return e     the edge
     */
    public Edge addFreeEdge(Location source, Location target, String guard, String sync, String update) {
        Edge e = addEdge(source, target, null, sync, update);
        if (guard != null) {
            // Set the new guard
            setLabel(e, EKind.guard, guard, ((source.getX() + target.getX()) / 2) - 15, ((source.getY() + target.getY()) / 2) - 28);
        } else
            // Remove lock guard
            e.setProperty("guard", " ");
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
        locationList.add(l);

        // Update placement of next location by input
        locationX = x + locationCoordIncr;

        return l;
    }

    /**
     * Wrapper for addLocation to avoid manual spacing. <P></P>
     * Creates and adds Location to template with automatic spacing.
     *
     * @param name Name of location
     * @return l the new Location
     */
    public Location addLocation(String name) {
        Location l = addLocation(name, locationX, locationY);

        //Increment x placement for next location
        locationX += locationCoordIncr;

        return l;
    }


    /**
     * Adds new locked edge from last location to new location
     *
     * @param newLocName name of the new location
     * @param guard      guard expression
     * @param sync       sync expression
     * @param update     update expression
     */
    public void edgeFromLastLoc(String newLocName, String guard, String sync, String update) {
        //TODO: This should prop return new location

        // Save current last location of template
        Location lastLoc = this.locationList.get(this.getLocationList().size() - 1);
        // Add edge to new location
        Location newLoc = this.addLocation(newLocName, lastLoc.getX() + locationCoordIncr, lastLoc.getY());
        this.addEdge(lastLoc, newLoc, guard, sync, update);
    }

    @Override
    public String toString() {
        return Name + "(" + id + ')';
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
        select, guard, synchronisation, assignment, comments, controllable
    }
}
