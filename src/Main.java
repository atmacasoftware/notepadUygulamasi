import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            File file = new File("notepad.txt");
            System.out.print("Metin giriniz (Okumak için o - Çıkmak için q) : ");
            String time = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
            text = scanner.nextLine();

            if (text.equals("q")) {
                System.out.println("Çıkış yapıldı.");
                return;
            }

            if (text.equals("o")) {
                try {
                    FileReader fReader = new FileReader(file);
                    BufferedReader bReader = new BufferedReader(fReader);
                    String line = bReader.readLine();

                    if (line == null) {
                        System.out.println("Kayıtlı veri bulunmamaktadır.");
                    } else {
                        System.out.println("Veriler başarıyla getirildi !");
                        while (line != null) {
                            System.out.println(line);
                            line = bReader.readLine();
                        }
                    }
                    bReader.close();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fWriter = new FileWriter(file, true);
                BufferedWriter bWriter = new BufferedWriter(fWriter);
                bWriter.write("(" + time + ") ");
                bWriter.write(text);
                bWriter.newLine();
                bWriter.close();

            }

        }


    }
}