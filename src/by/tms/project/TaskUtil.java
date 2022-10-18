package by.tms.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public final class TaskUtil {

    private TaskUtil() {}

    public static String textInput() {
        Path path = Paths.get("resources","file.csv");
        String str;
        try (FileInputStream inputStream = new FileInputStream(path.toFile())) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            str = new String(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    public static Map<String,Document> addMap(){
        String line = TaskUtil.textInput();
        String[] array = line.split("\n");
        Map<String,Document> list = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            String[] arr = array[i].split(",");
            Document document = new Document(arr[1], arr[2], arr[3].replace("\r",""));
            String count = arr[0];
            list.put(count,document);
        }
        return list;
    }

    public static String genRandomWord(){
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l",
                "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < (random.nextInt(5) + 3); i++) {
            String count = alphabet[random.nextInt(26)];
            builder.append(count);
        }
        return builder.toString();
    }

    public static int genRandomAge(){
        Random random = new Random();
        int age = random.nextInt(90) + 10;
        return age;
    }

    public  static List<User> CreateList(){
        List<User> list = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            String name = TaskUtil.genRandomWord();
            int age = TaskUtil.genRandomAge();
            User user = new User(name, age);
            list.add(user);
        }
        return list.stream().sorted(Comparator.comparingInt(User::getAge).reversed()).collect(Collectors.toList());
    }


}
