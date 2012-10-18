package netInvaders2;


import java.io.File;
import java.io.FileDescriptor;
import java.net.URL;
import java.util.HashMap;

public abstract class ResourceCache {
	protected HashMap resources;

	public ResourceCache() {
		resources = new HashMap();
	}

	public void limpiarCache (){
		resources.clear();
	}
	
	
	protected Object loadResource(String name) {
		URL url=null;
		java.io.File file = new File(name);
		try {
			url = getClass().getClassLoader().getResource(name);//file.toURL();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return loadResource(url);
	}

	protected Object getResource(String name) {
		Object res = resources.get(name);
		if (res == null) {
			res = loadResource("res/"+name);
			resources.put(name,res);
		}
		return res;
	}

	protected abstract Object loadResource(URL url);
  
}