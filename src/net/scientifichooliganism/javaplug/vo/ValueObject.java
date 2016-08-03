package net.scientifichooliganism.javaplug.vo;

import java.util.Collection;
import java.util.Vector;

public class ValueObject {
	private int id;
	private String label;
	private Collection<MetaData> metadata;

	public ValueObject () {
		id = -1;
		label = null;
		metadata = new Vector<MetaData>();
	}

	public int getID () {
		return id;
	}

	public void setID (int in) throws IllegalArgumentException, RuntimeException {
		if (in < 0) {
			throw new IllegalArgumentException("setID(int) was called with a value less than zero");
		}

		/**This is intentional. This property is only intended to be set once, ever, and by the data layer at that.*/
		if (id != -1) {
			throw new RuntimeException("setID(int) has already been called, it may not be called again.");
		}

		id = in;
	}

	public String getLabel () {
		return label;
	}

	public void setLabel (String in) throws IllegalArgumentException {
		if (in == null) {
			throw new IllegalArgumentException("setMethod(String) was called with a null string");
		}

		if (in.length() <= 0) {
			throw new IllegalArgumentException("setMethod(String) was called with an empty string");
		}

		label = in;
	}

	public Collection<MetaData> getMetaData () {
		return metadata;
	}

	public void addMetaData (MetaData md) throws IllegalArgumentException {
		removeMetaData(md);
		metadata.add(md);
	}

	public void removeMetaData (MetaData md) throws IllegalArgumentException {
		if (md == null) {
			throw new IllegalArgumentException("removeMetaData(MetaData) was called with a null object");
		}

		if (metadata.contains(md)) {
			metadata.remove(md);
		}
	}

	public String toString () {
		String ret = "label: " + String.valueOf(label) + "\n";
		ret = ret + "id: " + String.valueOf(id) + "\n";
		ret = ret + "metadata:\n";

		//TODO: clean up the (lack of) formatting this will cause
		for (MetaData md : metadata) {
			ret = ret + "	" + md.toString();
		}

		return ret;
	}
}