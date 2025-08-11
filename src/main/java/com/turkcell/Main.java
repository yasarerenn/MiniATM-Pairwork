/*
10.08.2025
Takım 2
Eliz Kurtuluş
Abdullah Yavuz
Yaşar Eren
Ferdanur Armutlu
*/
package com.turkcell;
import java.util.Scanner;

public class Main {
    private static final String username = "user";
    private static final String password = "1234";
    private static double balance = 0.0;
    private static int sumDeposits = 0;
    private static int sumWithdraws = 0;
    private static int sumBillCount = 0;
    public static void main(String[] args) {
        int a = 0;
        while (a < 3) {
            a++;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mini-ATM");
            System.out.println("Kullanıcı adınızı giriniz:");
            String username1 = scanner.nextLine();
            System.out.println("Şifrenizi giriniz:");
            String password1 = scanner.nextLine();
            if (username.equals(username1) && password.equals(password1)) {
                SurekliMenu();
                a=3;
            } else {
                int b = 3 - a;
                System.out.println("Kullanıcı adı veya şifre hatalı! Kalan deneme hakkı:" +b);
            }
        }
    }
    public static void SurekliMenu(){
        System.out.println(" --------------- Ana Menü --------------- ");
        System.out.println(" | 1- Para Yatır                        | ███╗░░░███╗██╗███╗░░██╗██╗  ░█████╗░████████╗███╗░░░███╗");
        System.out.println(" | 2- Para Çek                          | ████╗░████║██║████╗░██║██║  ██╔══██╗╚══██╔══╝████╗░████║");
        System.out.println(" | 3- Bakiye Görüntüle                  | ██╔████╔██║██║██╔██╗██║██║  ███████║░░░██║░░░██╔████╔██║");
        System.out.println(" | 4- Fatura Öde (Elektrik/Su/İnternet) | ██║╚██╔╝██║██║██║╚████║██║  ██╔══██║░░░██║░░░██║╚██╔╝██║");
        System.out.println(" | 5- Çıkış                             | ██║░╚═╝░██║██║██║░╚███║██║  ██║░░██║░░░██║░░░██║░╚═╝░██║");
        System.out.println(" ---------------------------------------- ╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝  ╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░░░░╚═╝");
        System.out.println("Yapmak istediğiniz işlemin numarasını girin. (Seçiminiz 1-5 arasında olmalıdır.)");
        while(true){
            Scanner scanner= new Scanner(System.in);
            int SurekliMenuDeger = scanner.nextInt();
            switch (SurekliMenuDeger){
                case 1:
                    //para yatırma
                    System.out.println("Yatırılacak Para Tutarını Giriniz:");
                    double depositAmount=scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 2:
                    //para çekme
                    System.out.println("Çekilecek Para Tutarını Giriniz:");
                    double withdrawAmount=scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    //bakiye görüntüleme
                    System.out.println("Bakiye:" + balance);
                    break;
                case 4:
                    //fatura öde
                    System.out.println("Fatura Menüsü :");
                    System.out.println("1- Elektrik\n" +
                            "2- Su\n" +
                            "3- İnternet\n");
                    System.out.println("Ödeyeceğiniz Fatura Tipini Seçiniz:");
                    int billType = scanner.nextInt();
                    System.out.println("Ödeyeceğiniz Fatura Tutarını Giriniz:");
                    double billAmount = scanner.nextDouble();
                    payBill(billType, billAmount);
                    break;

                case 5:
                    // çıkış
                    //raporlama al.
                    printSummary();
                    scanner.close();
                    return;
                default:
                    System.out.println("Yanlış bir numara seçtiniz! (Seçiminiz 1-5 arasında olmalıdır.)");
                    break;//geçersiz değerler
            }
        }
    }

    public static void deposit(double amount ){
        if(amount<=0){
            System.out.println("Geçersiz bir tutar girdiniz!");
            return;
        }
        balance+=amount;
        System.out.println("Hesabınıza " + amount + " TL başarıyla yatırıldı. Yeni hesap bakiyesi: " + balance);
        sumDeposits++;
    }
    public static void withdraw(double amount ){
        if(amount<=0){
            System.out.println("Geçersiz bir tutar girdiniz!");
            return;
        }
        double komisyon = amount > 5000 ? amount * 0.02 : 0;
        double sumAmount  = amount + komisyon;
        if(sumAmount >balance){
            System.out.println("Bu işlemi yapabilmek için hesabınızda yeterli bakiye bulunmamaktadır!");
            return;
        }

        balance-=sumAmount;
        System.out.println("Hesabınızdan " + amount + " TL para çekildi. Bu işlem için kesilen komisyon: "+komisyon+" TL Yeni hesap bakiyesi : "+balance);
        sumWithdraws++;
    }
    public static void payBill(int billType,double amount ){
        if(amount<=0){
            System.out.println("Geçersiz bir tutar girdiniz!");
            return;
        }
        double indirim=0;
        String billName = "";
        switch(billType){
            case 1:// elektrik
                indirim = amount*0.05;
                billName = "Elektrik";
                break;
            case 2:// su
                indirim = amount*0.03;
                billName = "Su";
                break;
            case 3://internet
                indirim = amount*0.02;
                billName = "İnternet";
                break;
            default:
                System.out.println("Geçersiz bir fatura türü seçtiniz! (Elektrik, Su veya İnternet Faturaları Seçilebilir!");
                return;
        }
        double payAmount = amount - indirim;
        if(payAmount > balance){
            System.out.println("Bu işlemi yapabilmek için hesabınızda yeterli bakiye bulunmamaktadır!");
            return;
        }
        balance-=payAmount;
        sumBillCount++;
        System.out.println("Fatura ödeme başarıyla gerçekleştirildi! Fatura için uygulanan indirim: " +indirim+ " TL Ödenen tutar: "+payAmount + " TL");
    }
    public static void printSummary(){
        System.out.println("---- Çıkış Raporu ----");
        System.out.println("Bakiye:" +balance);
        System.out.println("Toplam Para Yatırma Sayısı:" +sumDeposits);
        System.out.println("Toplam Para Çekme Sayısı:" +sumWithdraws);
        System.out.println("Toplam Ödenen Fatura Sayısı:" +sumBillCount);
        int sumCount = sumDeposits+sumWithdraws+sumBillCount;
        System.out.println("Toplam Yapılan İşlem Sayısı:" +sumCount);
        System.out.println("Program Sonlandırılıyor..");
    }
}
