package netInvaders2;


import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

public class SpriteCache extends ResourceCache{

	protected Object loadResource(URL url) {
		try {
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen de "+url.getPath());
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			e.printStackTrace();
			//System.exit(0);
			return null;
		}
	}
	
	public BufferedImage getSprite(String name) {
		return (BufferedImage)getResource(name);
	}
}