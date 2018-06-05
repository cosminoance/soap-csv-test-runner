package builder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class RequestTemplate {

	protected HashMap<String, String> properties;

	public abstract void CreateMap();

	public Iterator<Entry<String, String>> getPropertiesIterator() {
		CreateMap();
		return properties.entrySet().iterator();
	}
}
