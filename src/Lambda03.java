import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menü=new ArrayList<String>(Arrays.asList("Küşleme","adana","trileçe","trilece","havucDilim",
                "buryan","yaglama","kokorec","arabasi","güvec"));

        System.out.println("\n   ***   ");
        alfabetikBuyukHarfTekrarsız(menü); //ADANA ARABASİ BURYAN GÜVEC HAVUCDİLİM KOKOREC KÜŞLEME TRİLEÇE YAGLAMA
        System.out.println("\n   ***   ");
        tersSiralıTekrarsizYaz(menü);//10 7 6 5
        System.out.println("\n   ***   ");
        karakterKucuktenBuyuge(menü);
        System.out.println("\n   ***   ");
        sonHarfineGöreTersSirali(menü);

    }
    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBuyukHarfTekrarsız( List<String> yemek){
        yemek.
                stream().//akıs
                map(t->t.toUpperCase()).//elemanlar buyuk harf oldu
                //map(String::toUpperCase)//yukardakini method kullanarak bu sekildede yapabilirdik
                sorted().//alfabetik sıraladı natural
                distinct().//benzersiz hale getirdi tekrarsız hale getirdi 3 tane trilece varsa 1 tanesini yazdırır
                forEach(t-> System.out.print(t+" "));//yazdırdık

    //akıstan gelen data degisime ugraca için map kullandık
        //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır. Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
// Sıralı akışlar için, farklı elemanın seçimi sabittir
// (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
// Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez.
// Stream return eder.
    }


    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void tersSiralıTekrarsizYaz(List<String> yemek){
        //tekrarsız distinc demek ters sırala reverseolder karakter sayısıda stringi dönüştür karakterlerine
        //cıktı karakter sayısına göre buyukten kucuge yazdıracak 10 karkterli 5 karakterli 3 karakterli
        yemek.
                stream().//akıs
                map(t->t.length()).//karakter sayısı alındı
                //map(String::length)//yukardaki uerine buda olur
                sorted(Comparator.reverseOrder()).//ters sıra yapıldı
                distinct().//tekrarsız yapıldı
                forEach(t-> System.out.print(t+" "));//print edilddi
                //forEach(Lambda01::yazdir)



    }

// Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void karakterKucuktenBuyuge(List<String> yemek) {
        yemek.
                stream().//akıs
                sorted(Comparator.comparing(String::length)).//stringlerin karakter sayılarını al ona göre sırala demek lengte cevir
                forEach(t -> System.out.print(t + " "));//yazdırdık
    }

// Task : list elemanlarinin son harfine gore ters sirali print ediniz.
        public static void sonHarfineGöreTersSirali(List<String> yemek){
        yemek.
                stream().//akıs
                sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).
                reversed()).//ters sırala işlemi yapar
                forEach(t-> System.out.print(t+" "));

        //elemanlarda degisim yok map kullanmadık
            //son harfi buldur önce sonra ters sıralat
            //son harfe göre ters sıra demek alfabetik sırada sondan basladık




        }

// Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
// Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
// Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
// Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
// Task : Karakter sayisi en buyuk elemani yazdiriniz.
// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
}
