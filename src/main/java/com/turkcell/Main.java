/*
10.08.2025
Takım 2
Eliz Kurtuluş
Abdullah Yavuz
Yaşar Eren
Ferdanur Armutlu
*/
package com.turkcell; // Paket tanımlaması - kodun hangi pakette olduğunu belirtiyoruz.
import java.util.Scanner; // Kullanıcıdan veri alabilmek için Scanner sınıfını import ediyoruz.

public class Main { // Main sınıfını tanımlıyoruz.
    private static final String username = "user";   // Sabit kullanıcı bilgilerini belirliyoruz. Final kullanarak bu bilgileri sabit hale getiriyoruz.
    private static final String password = "1234";

    private static double balance = 0.0; // ATM bilgilerini static ile tüm metodlarda erişilebilir yapıyoruz.
    private static int sumDeposits = 0;
    private static int sumWithdraws = 0;
    private static int sumBillCount = 0;
    public static void main(String[] args) {
        int a = 0; // Deneme sayısını tutan değişkeni tanımlıyor, 0'dan başlatıyoruz.
        while (a < 3) { // While döngüsü oluşturuyoruz 3 deneme hakkı olmasını sağlıyoruz.
            a++; // Deneme sayısını 1 artırıyoruz.
            Scanner scanner = new Scanner(System.in); // Kullanıcıdan veri okuyabilmek için, Scanner nesnesi oluşturuyoruz.
            System.out.println("Mini-ATM"); // Program başlığını ekrana yazdırıyoruz.
            System.out.println("Kullanıcı adınızı giriniz:");
            String username1 = scanner.nextLine(); // Kullanıcı adını okuyoruz.
            System.out.println("Şifrenizi giriniz:");
            String password1 = scanner.nextLine(); // Şifreyi okuyoruz.
            if (username.equals(username1) && password.equals(password1)) { // Kullanıcı bilgilerini kontrol ediyoruz.
                SurekliMenu(); // Başarılı bir girişte menüyü açıyoruz.
                a=3; //Döngünün sonlanması için a değerini 3 yapıyoruz.
            } else {
                int b = 3 - a; //Başarısız girişte kalan deneme hakkını hesaplıyoruz.
                System.out.println("Kullanıcı adı veya şifre hatalı! Kalan deneme hakkı:" +b);
            }
        }
    }
    public static void SurekliMenu(){ // Ana menü metodunu tanımlıyoruz.
        System.out.println(" --------------- Ana Menü --------------- ");
        System.out.println(" | 1- Para Yatır                        | ███╗░░░███╗██╗███╗░░██╗██╗  ░█████╗░████████╗███╗░░░███╗");
        System.out.println(" | 2- Para Çek                          | ████╗░████║██║████╗░██║██║  ██╔══██╗╚══██╔══╝████╗░████║");
        System.out.println(" | 3- Bakiye Görüntüle                  | ██╔████╔██║██║██╔██╗██║██║  ███████║░░░██║░░░██╔████╔██║");
        System.out.println(" | 4- Fatura Öde (Elektrik/Su/İnternet) | ██║╚██╔╝██║██║██║╚████║██║  ██╔══██║░░░██║░░░██║╚██╔╝██║");
        System.out.println(" | 5- Çıkış                             | ██║░╚═╝░██║██║██║░╚███║██║  ██║░░██║░░░██║░░░██║░╚═╝░██║");
        System.out.println(" ---------------------------------------- ╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝  ╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝");
        System.out.println("Yapmak istediğiniz işlemin numarasını girin. (Seçiminiz 1-5 arasında olmalıdır.)");
        while(true){ // Sonsuz döngü oluşturuyoruz.
            Scanner scanner= new Scanner(System.in); // Scanner nesnesi oluşturuyoruz.
            int SurekliMenuDeger = scanner.nextInt(); // Kullanıcıdan menü seçimini alıyoruz.
            switch (SurekliMenuDeger){ // Switch-case ile menü seçeneklerini kontrol ediyoruz.
                case 1: // Para yatırma seçeneği
                    System.out.println("Yatırılacak Para Tutarını Giriniz:");
                    double depositAmount=scanner.nextDouble(); // Tutarı okuyoruz.
                    deposit(depositAmount); // Para yatırma metodunu çağırıyoruz.
                    System.out.println("\n" + " --------------- Ana Menü --------------- ");
                    System.out.println(" | 1- Para Yatır                        | ███╗░░░███╗██╗███╗░░██╗██╗  ░█████╗░████████╗███╗░░░███╗");
                    System.out.println(" | 2- Para Çek                          | ████╗░████║██║████╗░██║██║  ██╔══██╗╚══██╔══╝████╗░████║");
                    System.out.println(" | 3- Bakiye Görüntüle                  | ██╔████╔██║██║██╔██╗██║██║  ███████║░░░██║░░░██╔████╔██║");
                    System.out.println(" | 4- Fatura Öde (Elektrik/Su/İnternet) | ██║╚██╔╝██║██║██║╚████║██║  ██╔══██║░░░██║░░░██║╚██╔╝██║");
                    System.out.println(" | 5- Çıkış                             | ██║░╚═╝░██║██║██║░╚███║██║  ██║░░██║░░░██║░░░██║░╚═╝░██║");
                    System.out.println(" ---------------------------------------- ╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝  ╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝");
                    System.out.println("Yapmak istediğiniz işlemin numarasını girin. (Seçiminiz 1-5 arasında olmalıdır.)");
                    break; // Switch'ten çıkıyoruz.
                case 2: // Para çekme seçeneği
                    System.out.println("Çekilecek Para Tutarını Giriniz:");
                    double withdrawAmount=scanner.nextDouble(); // Tutarı okuyoruz.
                    withdraw(withdrawAmount); // Para çekme metodunu çağırıyoruz.
                    System.out.println("\n" + " --------------- Ana Menü --------------- ");
                    System.out.println(" | 1- Para Yatır                        | ███╗░░░███╗██╗███╗░░██╗██╗  ░█████╗░████████╗███╗░░░███╗");
                    System.out.println(" | 2- Para Çek                          | ████╗░████║██║████╗░██║██║  ██╔══██╗╚══██╔══╝████╗░████║");
                    System.out.println(" | 3- Bakiye Görüntüle                  | ██╔████╔██║██║██╔██╗██║██║  ███████║░░░██║░░░██╔████╔██║");
                    System.out.println(" | 4- Fatura Öde (Elektrik/Su/İnternet) | ██║╚██╔╝██║██║██║╚████║██║  ██╔══██║░░░██║░░░██║╚██╔╝██║");
                    System.out.println(" | 5- Çıkış                             | ██║░╚═╝░██║██║██║░╚███║██║  ██║░░██║░░░██║░░░██║░╚═╝░██║");
                    System.out.println(" ---------------------------------------- ╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝  ╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝");
                    System.out.println("Yapmak istediğiniz işlemin numarasını girin. (Seçiminiz 1-5 arasında olmalıdır.)");
                    break; // Switch'ten çıkıyoruz.
                case 3: // Bakiye görüntüleme seçeneği
                    System.out.println("Bakiye:" + balance); // Mevcut bakiyeyi gösteriyoruz.
                    System.out.println("\n" + " --------------- Ana Menü --------------- ");
                    System.out.println(" | 1- Para Yatır                        | ███╗░░░███╗██╗███╗░░██╗██╗  ░█████╗░████████╗███╗░░░███╗");
                    System.out.println(" | 2- Para Çek                          | ████╗░████║██║████╗░██║██║  ██╔══██╗╚══██╔══╝████╗░████║");
                    System.out.println(" | 3- Bakiye Görüntüle                  | ██╔████╔██║██║██╔██╗██║██║  ███████║░░░██║░░░██╔████╔██║");
                    System.out.println(" | 4- Fatura Öde (Elektrik/Su/İnternet) | ██║╚██╔╝██║██║██║╚████║██║  ██╔══██║░░░██║░░░██║╚██╔╝██║");
                    System.out.println(" | 5- Çıkış                             | ██║░╚═╝░██║██║██║░╚███║██║  ██║░░██║░░░██║░░░██║░╚═╝░██║");
                    System.out.println(" ---------------------------------------- ╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝  ╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝");
                    System.out.println("Yapmak istediğiniz işlemin numarasını girin. (Seçiminiz 1-5 arasında olmalıdır.)");
                    break; // Switch'ten çıkıyoruz.
                case 4: // Fatura ödeme seçeneği
                    System.out.println("Fatura Menüsü :");
                    System.out.println("1- Elektrik\n" +
                            "2- Su\n" +
                            "3- İnternet\n");
                    System.out.println("Ödeyeceğiniz Fatura Tipini Seçiniz:");
                    int billType = scanner.nextInt(); // Fatura türünü okuyoruz.
                    System.out.println("Ödeyeceğiniz Fatura Tutarını Giriniz:");
                    double billAmount = scanner.nextDouble(); // Tutarı okuyoruz.
                    payBill(billType, billAmount); // Fatura ödeme metodunu çağırıyoruz.
                    System.out.println("\n" + " --------------- Ana Menü --------------- ");
                    System.out.println(" | 1- Para Yatır                        | ███╗░░░███╗██╗███╗░░██╗██╗  ░█████╗░████████╗███╗░░░███╗");
                    System.out.println(" | 2- Para Çek                          | ████╗░████║██║████╗░██║██║  ██╔══██╗╚══██╔══╝████╗░████║");
                    System.out.println(" | 3- Bakiye Görüntüle                  | ██╔████╔██║██║██╔██╗██║██║  ███████║░░░██║░░░██╔████╔██║");
                    System.out.println(" | 4- Fatura Öde (Elektrik/Su/İnternet) | ██║╚██╔╝██║██║██║╚████║██║  ██╔══██║░░░██║░░░██║╚██╔╝██║");
                    System.out.println(" | 5- Çıkış                             | ██║░╚═╝░██║██║██║░╚███║██║  ██║░░██║░░░██║░░░██║░╚═╝░██║");
                    System.out.println(" ---------------------------------------- ╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝  ╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝");
                    System.out.println("Yapmak istediğiniz işlemin numarasını girin. (Seçiminiz 1-5 arasında olmalıdır.)");
                    break; // Switch'ten çıkıyoruz.

                case 5: // Çıkış seçeneği
                    printSummary(); // Çıkış raporu yazdırıyoruz.
                    return; // Programı sonlandırıyoruz.
                default: // Geçersiz seçim durumu
                    System.out.println("Yanlış bir numara seçtiniz! (Seçiminiz 1-5 arasında olmalıdır.)");
                    System.out.println("\n" + " --------------- Ana Menü --------------- ");
                    System.out.println(" | 1- Para Yatır                        | ███╗░░░███╗██╗███╗░░██╗██╗  ░█████╗░████████╗███╗░░░███╗");
                    System.out.println(" | 2- Para Çek                          | ████╗░████║██║████╗░██║██║  ██╔══██╗╚══██╔══╝████╗░████║");
                    System.out.println(" | 3- Bakiye Görüntüle                  | ██╔████╔██║██║██╔██╗██║██║  ███████║░░░██║░░░██╔████╔██║");
                    System.out.println(" | 4- Fatura Öde (Elektrik/Su/İnternet) | ██║╚██╔╝██║██║██║╚████║██║  ██╔══██║░░░██║░░░██║╚██╔╝██║");
                    System.out.println(" | 5- Çıkış                             | ██║░╚═╝░██║██║██║░╚███║██║  ██║░░██║░░░██║░░░██║░╚═╝░██║");
                    System.out.println(" ---------------------------------------- ╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝  ╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝");
                    System.out.println("Yapmak istediğiniz işlemin numarasını girin. (Seçiminiz 1-5 arasında olmalıdır.)");
                    break; // Switch'ten çıkıyoruz.
            }
        }
    }

    public static void deposit(double amount ){ // Para yatırma metodunu double amount parametresi ile tanımlıyoruz.
        if(amount<=0){ // Negatif veya 0 kontrolü yapıyoruz.
            System.out.println("Geçersiz bir tutar girdiniz!");
            return; // Metodu sonlandırıyoruz.
        }
        balance+=amount; // Bakiyeye tutarı ekliyoruz.
        System.out.println("Hesabınıza " + amount + " TL başarıyla yatırıldı. Yeni hesap bakiyesi: " + balance);
        sumDeposits++; // Para yatırma işlemi sayısını 1 artırıyoruz.
    }
    public static void withdraw(double amount ){ // Para çekme metodunu double amount parametresi ile tanımlıyoruz.
        if(amount<=0){ // Negatif veya 0 kontrolü yapıyoruz.
            System.out.println("Geçersiz bir tutar girdiniz!");
            return; // Metodu sonlandırıyoruz.
        }
        double komisyon = amount > 5000 ? amount * 0.02 : 0; // Komisyon hesaplaması yapıyoruz. Komisyon hesaplarken ternary operatör kullanıyoruz.
        double sumAmount  = amount + komisyon; // Komisyon ile birlikte toplam çekilecek tutarı hesaplıyoruz.
        if(sumAmount >balance){ // Para çekebilmek için bakiye kontrolü yapıyoruz.
            System.out.println("Bu işlemi yapabilmek için hesabınızda yeterli bakiye bulunmamaktadır!");
            return; // Metodu sonlandırıyoruz.
        }

        balance-=sumAmount; // Bakiyeden toplam çekilecek tutarı çıkarıyoruz.
        System.out.println("Hesabınızdan " + amount + " TL para çekildi. Bu işlem için kesilen komisyon: "+komisyon+" TL Yeni hesap bakiyesi : "+balance);
        sumWithdraws++; // Para çekme işlemi sayısını 1 arttırıyoruz.
    }
    public static void payBill(int billType,double amount ){ // int billType ve double amount parametreleriyle fatura ödeme metodunu tanımlıyoruz.
        if(amount<=0){ // Negatif veya 0 kontrolü yapıyoruz.
            System.out.println("Geçersiz bir tutar girdiniz!");
            return; // Metodu sonlandırıyoruz.
        }
        double indirim=0;
        String billName = "";
        switch(billType){ // Switch-case ile fatura türüne göre indirim hesaplıyoruz.
            case 1: // elektrik
                indirim = amount*0.05; //%5 indirim uyguluyoruz.
                billName = "Elektrik";
                break; // Switch'ten çıkıyoruz.
            case 2: // su
                indirim = amount*0.03; //%3 indirim uyguluyoruz.
                billName = "Su";
                break; // Switch'ten çıkıyoruz.
            case 3: //internet
                indirim = amount*0.02; //%2 indirim uyguluyoruz.
                billName = "İnternet";
                break; // Switch'ten çıkıyoruz.
            default: // Geçersiz fatura türü
                System.out.println("Geçersiz bir fatura türü seçtiniz! (Elektrik, Su veya İnternet Faturaları Seçilebilir!");
                return;  // Metodu sonlandırıyoruz.
        }
        double payAmount = amount - indirim; // İndirimli tutarı hesaplıyoruz.
        if(payAmount > balance){ // Fatura ödeme yapabilmek için bakiye kontrolü yapıyoruz.
            System.out.println("Bu işlemi yapabilmek için hesabınızda yeterli bakiye bulunmamaktadır!");
            return; // Metodu sonlandırıyoruz.
        } else {
            balance-=payAmount; // Bakiyeden indirimli tutarı çıkarıyoruz.
            sumBillCount++; // Fatura ödeme işlem sayısını 1 arttırıyoruz.
            System.out.println("Fatura ödeme başarıyla gerçekleştirildi! Fatura için uygulanan indirim: " +indirim+ " TL Ödenen tutar: "+payAmount + " TL");
        }
    }
    public static void printSummary(){ // Özet yazdırma metodunu tanımlıyoruz.
        System.out.println("---- Çıkış Raporu ----");
        System.out.println("Bakiye:" +balance); // Mevcut bakiyeyi gösteriyoruz. (Bakiye başlangıçta 0 ile başladığı için en son gözüken, bakiyedeki net değişim olarak düşünülebilir.)
        System.out.println("Toplam Para Yatırma Sayısı:" +sumDeposits); // Toplam para yatırma sayısını gösteriyoruz.
        System.out.println("Toplam Para Çekme Sayısı:" +sumWithdraws); // Toplam para çekme sayısını gösteriyoruz.
        System.out.println("Toplam Ödenen Fatura Sayısı:" +sumBillCount); // Toplam ödenen fatura sayısını gösteriyoruz.
        int sumCount = sumDeposits+sumWithdraws+sumBillCount; // Toplam işlem sayısını hesaplıyoruz.
        System.out.println("Toplam Yapılan İşlem Sayısı:" +sumCount); // Toplam işlem sayısını gösteriyoruz.
        System.out.println("Program Sonlandırılıyor..");
    }
}
