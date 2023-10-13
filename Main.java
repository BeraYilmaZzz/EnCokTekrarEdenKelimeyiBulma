import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Kelime giriniz = ");
        String inp = scn.nextLine(); // kullanıcıdan verimizi aldık

        String[]words= inp.split(" "); // kelimeleri aralarındaki boşluklardan böldük

        Map<String, Integer> word = new HashMap<>(); // kelimelerin tekrar sayısını ölçmek için boş bir hashmap oluşturduk

        for (String kelime : words) {

            if (!kelime.isEmpty()) {
                if (word.containsKey(kelime)) {
                    // Kelime zaten HashMap'te varsa sayısını bir arttır
                    word.put(kelime, word.get(kelime) + 1);
                } else {
                    // kelime ilk kez geçiyorsa değerini 1 olarak belirle
                    word.put(kelime, 1);
                }
            }
        }

        // En çok tekrar eden kelimeyi bulduğumuz fonksiyon
        String enCokTekrarEdenKelime = "";
        int enCokTekrarSayisi = 0;

        for (Map.Entry<String, Integer> entry : word.entrySet()) {

            String kelime = entry.getKey();
            int sayi = entry.getValue();

            if (sayi > enCokTekrarSayisi) {
                enCokTekrarEdenKelime = kelime;
                enCokTekrarSayisi = sayi;
            }

        }
        // ekrana yazdırıyoruz
        if (!enCokTekrarEdenKelime.isEmpty()) {
            System.out.println("En çok tekrar eden kelime: " + enCokTekrarEdenKelime);
            System.out.println("Bu kelime " + enCokTekrarSayisi + " kez geçiyor.");
        } else {
            System.out.println("Metinde geçerli kelime bulunamadı.");
        }
    }
}