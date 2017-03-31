package oneliners;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jeff
 */
public class OneLinerUtil {

    String filepath;

    public OneLinerUtil(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<String> getLine() {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner s = new Scanner(new File(filepath))) {
            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound for file: " + filepath);
        }

        return list;
    }

}
