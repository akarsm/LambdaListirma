import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.

         */
        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printEtStuructured(sayi);
        System.out.println("\n ******  ");
        printEtFunctional(sayi);
        System.out.println("\n ******  ");
        printEtFunctional1(sayi);
        System.out.println("\n ******  ");
        printEtFunctional2(sayi);
        System.out.println("\n ******  ");
        printCiftElSturctured(sayi);
        System.out.println("\n ******  ");
        printCiftElSturctured(sayi);
        System.out.println("\n ******  ");
        ciftVeOtuzdrtdenKucukOlan(sayi);




    }
    //task:Structured Programming kullanarak list elemanlarını aralarında bosluk olacak sekilde print ediniz.

    public static void printEtStuructured(List<Integer> sayi) {
        for (Integer w : sayi) {
            System.out.print(w + " ");


        }
    }
    //task:functional Programming kullanarak list elemanlarını aralarında bosluk olacak sekilde print ediniz.

    public static void printEtFunctional(List<Integer> sayi) {
        sayi.stream().forEach(t-> System.out.print(t+" "));

        //stream selale demek akıs yapar işlem akısı
        //sayi.stream ile sayi elemanlarını dikey akısa sunduk
        //forEach her biri demek her bir elemanı aksiyona sok
        //içerde yazdırma aksiyonu olddan yazdır demek her elemanı
        //34 ü aldı t ye atadı t yi yazdırdı 34
        //22 yi aldı t ye atadı t yi yazdırdı 22
        //işlem bitene kadar tek tek yapar
        //streamde datalar daha güvenli
        //streamde ekstra 30 kadar method var
    }
    /*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
 tric::: Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir.

 */
    public static void printEtFunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);//method referencedir.System.out yapısından print
                                                 //methodu refere et dedik.Araya bosluk koyamayız bu yazısta.
                                                 //soruda araya bosluk koy dedigi için bunu kullanmak olmaz normlade hazır method kullanacagız
                                                //ama sorudaki ihtiyaca karsılık vermedıgınde method refere etmiyoruz expration kullanırız
                                               //expration yapmak istemiyorsakda



    }
        public static void yazdir(int a){//verilen int degeri yazdıran method creat edildi
                                         //degeri aynı satırda bosluk yazdırarak yapan bir method olusturdum
                                         //bunu depoya atar cagırır cagırır kullanırım
        System.out.print(a+" ");
        }
    public static void printEtFunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir);//util mantıgı denir.aletler mantıgı drive class olustur oraya koy ihtiyac dahilinde cagir
    }


    //structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    //sart var if demek lambdada if nasıl çalısır bakalım
    //amele olarak bi yazalım

    public static void printCiftElSturctured(List<Integer> sayi) {
        for (Integer w : sayi
        ) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }

    }
    //functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    //amele hali olmadan tek satırda yaptıgımız halide bu
    public static void printCiftElFunctional(List<Integer>sayi){
        sayi.stream().
                filter(t->t%2==0 && t<34).
                forEach(Lambda01::yazdir);

    }
    public static boolean ciftBul(int a){//bu seed (tohum)method kendisine verilen int degerin cift olmasını kontrol eder

        return a%2==0;

    }
    public static void printCiftElFunctional1(List<Integer>sayi){
        sayi.
                stream().//list elemanları akısa alındı
                filter(Lambda01::ciftBul).//cift bul method refere edilerek akısdaki elemanlar filtrelendi
                forEach(Lambda01::yazdir);//filtreden gelen elemanlar yazdır method refer edilerek print edildi
    }
    //Task : functional Programming ile list elemanlarinin 34 den kucuk cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.

public static void ciftVeOtuzdrtdenKucukOlan(List<Integer>sayi){
    sayi.
            stream().
            filter(t->t<34 && t%2==0).//filter(t%2==0) bi filter(t<34) daha yapıp iki tanedede olur
            //filter(Lambda01::ciftBul) bunu yazıp sadece filter a < 34 ude ekleyebilirdik
            forEach(Lambda01::yazdir);



}


    public static void yazdir(Double aDouble) {
    }
}