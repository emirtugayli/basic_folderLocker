/**
 * HideFolder
 */
import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributeView;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class HideFolder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the file path : ");
        String folderPath = s.nextLine();
        String truePass = "password";
        File folder = new File(folderPath);
        try {
            hideFolder(folder);
        } catch (IOException e) {
            e.printStackTrace();
        }
            if(folder.isHidden()){
                System.out.println("Folder is hidden enter the password for unlock it");
                String pass = s.nextLine();
                if(pass.equals(truePass))
                {
                    try {
                        unhideFolder(folder);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                System.out.println("Folder looks available");
            }

    }

    private static void hideFolder(File folder) throws IOException {
        DosFileAttributeView folderStatus = Files.getFileAttributeView(folder.toPath(), DosFileAttributeView.class);
        if (folderStatus != null)
        {
            folderStatus.setHidden(true);
            System.out.println("Folder is hidden");
        }
    }

    private static void unhideFolder(File folder) throws IOException {
        DosFileAttributeView folderStatus = Files.getFileAttributeView(folder.toPath(), DosFileAttributeView.class);
        if(folderStatus != null)
        {
             folderStatus.setHidden(false);
             System.out.println("Folder available");
        }
    }
}