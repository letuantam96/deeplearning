package preprocessing;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String imagePath = "D:/eclipse-workspace/preprocessing/src/preprocessing/source_images/demo_image.jpg";
		String resizedImagePath = "D:/eclipse-workspace/preprocessing/src/preprocessing/target_images/resized_image.jpg";
		String cropImagePath = "D:/eclipse-workspace/preprocessing/src/preprocessing/target_images/crop_image.jpg";
		BufferedImage originalImage;
		
		try {
			originalImage = ImageIO.read(new File(imagePath));
			
			BufferedImage resizedImage = resizeImage(originalImage, originalImage.getType(), 256, 256);
			ImageIO.write(resizedImage, "jpg", new File(resizedImagePath));
			
			BufferedImage cropImage = originalImage.getSubimage(0, 0, 256, 256);
			ImageIO.write(cropImage, "jpg", new File(cropImagePath));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
    private static BufferedImage resizeImage(BufferedImage originalImage, int type, int imgWidth, int imgHeight){
    		BufferedImage resizedImage = new BufferedImage(imgWidth, imgHeight, type);
    		Graphics2D g = resizedImage.createGraphics();
    		g.drawImage(originalImage, 0, 0, imgWidth, imgHeight, null);
    		g.dispose();
    		
    		return resizedImage;
    }
    

}
