package hotel.zyclus;

import java.util.HashSet;

public class ZyklusPruefer {
    /**
     * Prueft in einer einfach verketteten Liste mit Elementen vom Typ IListElement,
     * ob ein Zyklus vorhanden ist.
     *
     * @param erstesElement der verketteten Liste
     * @return true kein Zyklus, false Zyklus vorhanden
     */

    public boolean pruefe(MyListElement erstesElement){
        if (erstesElement == null) {
            return true;
        }

        HashSet<IListElement> visited = new HashSet<>();
        MyListElement current = erstesElement;

        while (current != null) {
            if (visited.contains(current)) {
                // If the current element is already in the set, there's a cycle.
                return false;
            }

            visited.add(current);
            current = current.getNext();
        }

        return true;
    }

    }




