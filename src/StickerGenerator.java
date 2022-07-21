import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {


    public void create(InputStream inputStream, String fileName, String title) throws Exception{

        // leitura da imagem
        BufferedImage originalImage = ImageIO.read(inputStream); 

        // cria uma nova imagem em memória com transparência e com tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        //configurar a fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.yellow);
        graphics.setFont(font);

        int fontWidth = graphics.getFontMetrics().stringWidth(title) / 2;

        // esrever uma frase na nova imagem
        graphics.drawString(title, width / 2 - fontWidth, newHeight - 100);
    

        // escrever a nova imagem em um arquivo
        File path = new File("output");
        if (!path.exists()) {
            path.mkdir();
        }

        ImageIO.write(newImage, "png", new File("output/" + fileName));

    }

}
