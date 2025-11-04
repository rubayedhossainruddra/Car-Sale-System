
package Project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserDataManager {
    private static final String BASE_DIR = "Users";

    public static void saveUser(User user) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File userDir = new File(BASE_DIR + "/" + user.getUsername());
        if (!userDir.exists()) {
            userDir.mkdirs();
        }

        File infoFile = new File(userDir, "info.json");
        File credFile = new File(userDir, "credentials.json");

        try (FileWriter infoWriter = new FileWriter(infoFile);
             FileWriter credWriter = new FileWriter(credFile)) {

            // Write full user info
            gson.toJson(user, infoWriter);

            // Write only credentials info
            Credential credential = new Credential(user.getUsername(), user.getPassword(), user.getStatus());
            gson.toJson(credential, credWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Inner class for credentials
    static class Credential {
        String username;
        String password;
        String status;

        Credential(String username, String password, String status) {
            this.username = username;
            this.password = password;
            this.status = status;
        }
    }
}
