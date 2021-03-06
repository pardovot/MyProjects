import java.awt.Graphics;
import java.util.LinkedList;

/*
 * 		Main objects class.
 * 		this class handles all the objects storing them in a linked list.
 */

public class Handler {
	LinkedList<GameObject> object = new LinkedList<>();
	LinkedList<GameObject> extraObjects = new LinkedList<>();

	public void tick() { // all objects updating method.
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
		for (int i = 0; i < extraObjects.size(); i++) {
			GameObject tempObject = extraObjects.get(i);
			tempObject.tick();
		}
	}

	public void render(Graphics g) { // all objects graphics rendering method.
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
		for (int i = 0; i < extraObjects.size(); i++) {
			GameObject tempObject = extraObjects.get(i);
			tempObject.render(g);
		}
	}

	public void addObject(GameObject object) { // add an object to the linked list.
		this.object.add(object);
	}

	public void removeObject(GameObject object) { // remove an object from the linked list.
		this.object.remove(object);
	}
	
	public void addExtraObject(GameObject object) { // add an object to the linked list.
		this.extraObjects.add(object);
	}

	public void removeExtraObject(GameObject object) { // remove an object from the linked list.
		this.extraObjects.remove(object);
	}

	public void removeAllObjects() { // remove all object except for the player.
		for (int i = 0; i < this.object.size(); i++) {
			GameObject tempObject = this.object.get(i);
			if (tempObject.getId() != ID.Player) {
				this.removeObject(tempObject);
				i--;
			}
		}
	}
}
