package dev.denny.pattern.utils;

import cn.nukkit.entity.data.Skin;
import dev.denny.pattern.exception.EntityException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    public static Skin from(final Path skinPath) {
        Skin skin = new Skin();

        if (Files.notExists(skinPath) || !Files.isRegularFile(skinPath)) {
            throw new EntityException("Invalid Skin Data");
        }

        BufferedImage skinData;

        try {
            skinData = ImageIO.read(skinPath.toFile());
        } catch (IOException e) {
            throw new EntityException("Invalid Skin Data: " + e.getMessage());
        }

        skin.setSkinData(skinData);
        skin.setPremium(true);
        skin.setSkinId("Standard_Custom");
        skin.setGeometryName("geometry.humanoid.custom");
        skin.setTrusted(true);

        return skin;
    }
}