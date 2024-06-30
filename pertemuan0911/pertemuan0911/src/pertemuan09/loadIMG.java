package pertemuan09;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
/**
 *
 * @author DIANSARIANI 2201010254
 * TGL : 2024-06-21
 */
public class loadIMG {
    public static BufferedImage loadImage(String img){
        BufferedImage bimg = null;
        
        //pembacaan file
        try{
            bimg = ImageIO.read(new File(img));
        }catch(Exception e){
            
        }
        
        return bimg;
    }
}
