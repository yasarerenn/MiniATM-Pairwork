Ödev: Mini-ATM (menü tabanlı konsoluygulaması)

Hedef:
Değişkenler, operatörler, döngüler, koşul blokları ve fonksiyonları tek bir küçük projede kullanmak.

İstenen Özellikler:
1. Giriş (Login) – 3 deneme hakkı
  • username ve password sabit değişkenlerde dursun (örn. "user" / "1234").
  • While döngüsüyle 3 hakkı sayın. Başarısızsa program sonlansın.

2. Sürekli Menü (while true + switch)
  1- Para Yatır
  2- Para Çek
  3- Bakiye Görüntüle
  4- Fatura Öde (Elektrik/Su/İnternet)
  5- Çıkış
  • Seçim dışı girişte uyarı verip menüye dönün (do-while veya continue).

4. Fonksiyonlar (method’lar) zorunlu
  • deposit(double amount) : void
  • withdraw(double amount) : void (bakiye yetersizse çekme)
  • payBill(int billType, double amount) : void
  • printSummary() : void (çıkışta istatistik)
  • Her biri giriş doğrulaması yapmalı (negatif tutar, 0, vs. reddedilsin).

5. Operatörler ve küçük kurallar
  • Para çekmede 5000’den büyük tutarlara %2 komisyon uygulayın(komisyon = amount > 5000 ? amount * 0.02 : 0).
  • Faturalarda Elektrik %5 indirim, Su %3, İnternet %2.(indirim sonra bakiyeden düşsün.)
  • İşlem sayaçları tutun: totalDeposit, totalWithdraw,totalBillsPaidCount.

6. Çıkışta Özet
   • Bakiye, toplam yatırılan, toplam çekilen, ödenen fatura adedi ve net hareketiyazdırın.

Kabul Kriterleri (tik listesi):
  • Login 3 denemeden sonra kapanıyor; başarılı girişte menü açılıyor.
  • Menü sonsuz döngüde; hatalı seçim tekrar soruluyor.
  • Tüm işlemler metotlar ile yapılıyor.
  • Negatif/0 tutarlara izin verilmiyor.
  • Para çekmede komisyon kuralı uygulanıyor.
  • Faturalarda indirim uygulanıp, indirimli tutar düşüyor.
  • Çıkışta özet yazdırılıyor.

Örnek Test Senaryoları:
  • Login 2 yanlış + 1 doğru → menü açılmalı.
  • Bakiye 0 iken 1000 yatır → bakiye 1000.
  • 6000 çek → komisyon 120, toplam düşüş 6120; yetersiz bakiye hatası beklenir.
  • 1000 yatır, 6000 çek → yine yetersiz.
  • 10000 yatır, 6000 çek → bakiye 10000 - 6120 = 3880.
  • İnternet faturasına 100 öde → 2 indirim, 98 düşmeli.
