import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        // Task : Functional Programming ile listin cift elemanlarinin
        // karelerini ayni satirda aralarina bosluk bırakarak print ediniz
        ciftKarePrint(sayi);     //1156 484 256 400 1936 4356 4096 1444
        System.out.println("\n  ******   ");
        küpünBirFazlasınıAl(sayi);//1332 344 28 3376
        System.out.println("\n  ******   ");
        ciftKareKökPrintEt(sayi);
        System.out.println("\n  ******   ");
        enBuyukElemanıPrintEt(sayi);
        System.out.println("\n  ******   ");
        ciftCarpYazdir(sayi);
        System.out.println("\n  ******   ");
        minBul(sayi);
        System.out.println("\n  ******   ");
        besdenBykEnKck(sayi);
        System.out.println("\n  ******   ");
        ciftKareKbPrint(sayi);
        System.out.println("\n  ******   ");
        tekElemanlarınKareSirala(sayi);
        System.out.println("\n  ******   ");





    }
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().                  //listteki elemanları akısa koy
                filter(Lambda01::ciftBul). //ciftleri bul
                map(t->t*t).               //karelerini al
                forEach(Lambda01::yazdir); //yazdir
        //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek
        // veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.

    }
    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir
    // fazlasini ayni satirda aralarina bosluk birakarak print edi

    public static void küpünBirFazlasınıAl(List<Integer> sayi){
        sayi.
                stream().//akısa alındı
                filter(t-> t%2==1).//tek elemanlar filtrelendi
                map(t->(t*t*t)+1).//tek elemanların küplerinin bir fazlasını aldık
                forEach(Lambda01::yazdir);//hazırda olan methodla yazdırdık

        //çok kullanılan aksıyonları methıd yapıp bir yere koyarız
        //ihtiyac dahilinde kullnırz
    }
    // Task : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

       public static void ciftKareKökPrintEt(List<Integer> sayi){
            sayi.
            stream().
            filter(Lambda01::ciftBul).
            map(Math::sqrt).//karekök bulma methodu
            forEach(t-> System.out.print(t+" "));
            //foreach yazdır methodu integer calıstıgı için mapden cıkanları calıstırmadı
           //bizim cıkan sonuclarımız double olddan dolayı elimizie tekrar yazdık
    }


    // Task : list'in en buyuk elemanini yazdiriniz


    public static void enBuyukElemanıPrintEt(List<Integer> sayi) {

       Optional<Integer> maxSayi= sayi.
               stream().
               reduce(Math::max);
        //akısa giren elemanların aksiyon sonrası tek eleman haline getirir
        //tek sonuc cıkacaksa reduce methodu kullanıyoruz
        //Optional bir data tipidir
        //reduce terminal işlemidir sonrasına işlem almaz
        //ForEach de bir terminal işlemdir ondan sonra işlem almaz
        /*
      reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
      kullanımı yaygındır pratiktir.
      Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
      bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
      reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
      reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
      İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
        System.out.println(maxSayi);
        System.out.println(sayi.stream().reduce(Math::max));
    }

  // Task : List'in cift elemanlarin karelerinin
    // en buyugunu print ediniz

    public static void ciftKareEnBuyukPrint(List<Integer> sayi){
        sayi.stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).
                reduce(Math::max);

        System.out.println();


    }
          // Task : List'teki tum elemanlarin toplamini yazdiriniz.
         //Lambda Expression...
    public static void elemanTopla(List<Integer> sayi){
       int toplam= sayi.stream().reduce(0,(a,b)->a+b);//lambda expression
        //a ilk degerini her zaman atanan degerden alır idenity yani
        //b degegrini her zaman akıstan alıs
        //a ilk degerinden sonraki her degeri aksiyondan alır yani işlemden alır
        // sayi.stream().reduce(Integer::sum);
        System.out.println(toplam);
        //method ref
        Optional<Integer> topla =sayi.stream().reduce(Integer::sum);
        System.out.println("met ref : " +sayi.stream().reduce(Integer::sum));

    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarpYazdir(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact);
        //Lambda Expression

        sayi.stream().filter(Lambda01::ciftBul).reduce(1,(a,b)->(a*b));
    }

public static void minBul(List<Integer> sayi){
   // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print edin
    //1. yontem Method Reference --> Integer class

    Optional<Integer> minSayi = sayi.stream().reduce(Integer::min);

    System.out.println(minSayi);
    //2. yontem Method Reference --> Math class

    Optional<Integer>minSayiMath =sayi.stream().reduce(Integer::min);

    System.out.println(minSayiMath);
    //3. yontem Lambda Expression

    int minSayiLJambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));

    System.out.println(minSayiLJambda);
    //4. yontem Method Reference --> Haluk class
   Optional<Integer> minSayiHaluk= sayi.stream().reduce(Lambda02::byHalukMin);

    System.out.println(minSayiHaluk);
    }

    public static int byHalukMin(int a, int b){
        return a<b?a:b;

    }
//    Task : List'teki 5'ten buyuk en kucuk tek sayiyi prin
    public static void besdenBykEnKck(List<Integer> sayi){
      sayi.stream().filter(t-> t%2==1 && t>5).reduce(Lambda02::byHalukMin);

    }
    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz

    public static void ciftKareKbPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t).//filtrelenen sayıların kareleri alındı
                sorted().//sıralama yaptı naturel orded
                forEach(Lambda01::yazdir);//print edildi


        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.
    }
        // Task : list'in tek  elemanlarinin kareleri ni buyukten kucuge  pri

    public static void tekElemanlarınKareSirala(List<Integer> sayi){
        sayi.stream().
                filter(t->t%2==1).//tek elemanlar filtrelendi
                map(t->t*t).
                sorted(Comparator.reverseOrder()).//sırala fakat benim istedigim sekilde sırala
                forEach(Lambda01::yazdir);
    }
}