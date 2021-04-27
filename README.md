# Sweet Home 3D Console Photo Generator
Render your [Sweet Home 3D](http://www.sweethome3d.com/) files headless on computers without a GPU like VPS.

Using [ConsolePhotoGenerator](http://www.sweethome3d.com/support/forum/viewthread_thread,2918#13298)

## How to use
1. Install Java Development Kit for compilation and Java Runtime Environment for rendering. `sudo apt install openjdk-8-jre-headless openjdk-8-jdk-headless`
2. Modify ConsolePhotoGenerator.java to change width and height of the picture.
3. Compile ConsolePhotoGenerator.java `javac -cp SweetHome3D-6.5.2.jar:sunflow-0.07.3i.jar -d . ConsolePhotoGenerator.java`
4. Render your SH3D file. (Replace userGuideExample.sh3d with your file) `java -Dj3d.rend=noop -cp .:SweetHome3D-6.5.2.jar:sunflow-0.07.3i.jar:j3dcore.jar:vecmath.jar:j3dutils.jar:batik-svgpathparser-1.7.jar com.eteks.sweethome3d.utilities.ConsolePhotoGenerator userGuideExample.sh3d photo.png`