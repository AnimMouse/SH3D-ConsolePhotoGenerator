# Sweet Home 3D Console Photo Generator
Render your [Sweet Home 3D](http://www.sweethome3d.com/) files headless on computers without a GPU like VPS.

Using [ConsolePhotoGenerator](http://www.sweethome3d.com/support/forum/viewthread_thread,2918#13298)

## How to use
1. Install Java Development Kit for compilation and Java Runtime Environment for rendering. `sudo apt install openjdk-8-jre-headless openjdk-8-jdk-headless`
2. Modify ConsolePhotoGenerator.java to change the resolution (width and height) of the photo.
3. Compile ConsolePhotoGenerator.java `javac -cp SweetHome3D-6.5.2.jar:sunflow-0.07.3i.jar -d . ConsolePhotoGenerator.java`
4. Render your SH3D file. (Replace userGuideExample.sh3d with your file) `java -Dj3d.rend=noop -cp .:SweetHome3D-6.5.2.jar:sunflow-0.07.3i.jar:j3dcore.jar:vecmath.jar:j3dutils.jar:batik-svgpathparser-1.7.jar com.eteks.sweethome3d.utilities.ConsolePhotoGenerator userGuideExample.sh3d photo.png`

### Render quality
Only 2 options are available, Level 3 (Fast global illumination) & Level 4 (Global illumination). Level 1 & 2 are not available as it uses GPU rendering. (And it's fast not to bother rendering on a server.)\
Render quality are determined on the .sh3d file, to change render quality, open Create a photo from 3D view, change the render quality, and save your file.

### Viewpoint
Viewpoint are determined on the .sh3d file, to change viewpoint, open your .sh3d file, change the camera viewpoint on the 3D view, and save your file.

### Time & Date
Time & Date are determined on the .sh3d file, to change time & date, open Create a photo from 3D view, change the time & date, and save your file.

### Memory (RAM)
To change the heap size of the Java Virtual Machine, use the `-Xms` for initial heap size and `-Xmx` for maximum heap size.\
Example using an initial heap size of 10 GB and maximum heap size of 12 GB, good for PC with 16 GB RAM.\
`java -Xms10g -Xmx12g -Dj3d.rend=noop -cp .:SweetHome3D-6.5.2.jar:sunflow-0.07.3i.jar:j3dcore.jar:vecmath.jar:j3dutils.jar:batik-svgpathparser-1.7.jar com.eteks.sweethome3d.utilities.ConsolePhotoGenerator userGuideExample.sh3d photo.png`