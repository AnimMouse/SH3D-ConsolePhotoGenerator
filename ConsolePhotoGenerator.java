/*
 * ConsolePhotoGenerator.java
 *
 * Sweet Home 3D, Copyright (c) 2010 Emmanuel PUYBARET / eTeks <info@eteks.com>
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place, Suite 330, Boston, MA 02111-1307 USA
 */
package com.eteks.sweethome3d.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.sunflow.system.UI;
import org.sunflow.system.ui.ConsoleInterface;
import com.eteks.sweethome3d.io.HomeFileRecorder;
import com.eteks.sweethome3d.j3d.PhotoRenderer;
import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.HomeEnvironment;
import com.eteks.sweethome3d.model.RecorderException;

/**
 * Sweet Home 3D Console photo generator.
 * @author Emmanuel Puybaret
 */
public class ConsolePhotoGenerator {
  public static void main(final String [] args) throws RecorderException, IOException {
    String homeFile = args [0];
    String homePhoto = args [1];
    Home home = new HomeFileRecorder().readHome(homeFile);
    HomeEnvironment environment = home.getEnvironment();
    PhotoRenderer renderer = new PhotoRenderer(home,
        environment.getPhotoQuality() == 3 // Set to 3 for Level 4, 4 for Level 3
            ? PhotoRenderer.Quality.HIGH
            : PhotoRenderer.Quality.LOW);
    UI.set(new ConsoleInterface());
    BufferedImage image = new BufferedImage(
        1280, 720, // Photo Resolution in Width, Height
        BufferedImage.TYPE_INT_ARGB);
    renderer.render(image, home.getCamera(), null);
    ImageIO.write(image, homePhoto.substring(homePhoto.lastIndexOf('.') + 1),
        new File(homePhoto));   
  }
}