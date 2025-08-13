<h3 dir="auto"><strong><img src="https://glyapi.turkcell.com.tr/CdnApi/file/images/gy_svg.svg" alt="" /></strong></h3>
<h3 dir="auto"><strong>Takım 2 'ye ait &ccedil;alışmadır.</strong></h3>
<ul>
<li dir="auto">Eliz Kurtuluş</li>
<li dir="auto">Abdullah Yavuz</li>
<li dir="auto">Yaşar Eren</li>
<li dir="auto">Ferdanur Armutlu</li>
</ul>
<h3 dir="auto"><strong>&Ouml;dev: Mini-ATM (men&uuml; tabanlı konsol uygulaması)</strong></h3>
<p dir="auto">Hedef: Değişkenler, operat&ouml;rler, d&ouml;ng&uuml;ler, koşul blokları ve fonksiyonları tek bir k&uuml;&ccedil;&uuml;k projede kullanmak.</p>
<p dir="auto"><strong>İstenen &Ouml;zellikler:</strong></p>
<p dir="auto"><strong>1. Giriş (Login) &ndash; 3 deneme hakkı </strong></p>
<ul>
<li dir="auto">username ve password sabit değişkenlerde dursun (&ouml;rn. "user" / "1234").</li>
<li dir="auto">While d&ouml;ng&uuml;s&uuml;yle 3 hakkı sayın. Başarısızsa program sonlansın.</li>
</ul>
<p dir="auto"><strong>2. S&uuml;rekli Men&uuml; (while true + switch) </strong></p>
<p dir="auto">1- Para Yatır <br />2- Para &Ccedil;ek <br />3- Bakiye G&ouml;r&uuml;nt&uuml;le <br />4- Fatura &Ouml;de (Elektrik/Su/İnternet) <br />5- &Ccedil;ıkış</p>
<ul>
<li dir="auto">Se&ccedil;im dışı girişte uyarı verip men&uuml;ye d&ouml;n&uuml;n (do-while veya continue).</li>
</ul>
<p dir="auto"><strong>3. Fonksiyonlar (method&rsquo;lar) zorunlu </strong></p>
<ul>
<li dir="auto">deposit(double amount) : void</li>
<li dir="auto">withdraw(double amount) : void (bakiye yetersizse &ccedil;ekme)</li>
<li dir="auto">payBill(int billType, double amount) : void</li>
<li dir="auto">printSummary() : void (&ccedil;ıkışta istatistik)</li>
<li dir="auto">Her biri giriş doğrulaması yapmalı (negatif tutar, 0, vs. reddedilsin).</li>
</ul>
<p dir="auto"><strong>4. Operat&ouml;rler ve k&uuml;&ccedil;&uuml;k kurallar</strong></p>
<ul>
<li dir="auto">Para &ccedil;ekmede 5000&rsquo;den b&uuml;y&uuml;k tutarlara %2 komisyon uygulayın(komisyon = amount &gt; 5000 ? amount * 0.02 : 0).</li>
<li dir="auto">Faturalarda Elektrik %5 indirim, Su %3, İnternet %2.(indirim sonra bakiyeden d&uuml;şs&uuml;n.)</li>
<li dir="auto">İşlem saya&ccedil;ları tutun: totalDeposit, totalWithdraw,totalBillsPaidCount.</li>
</ul>
<p dir="auto"><strong>5. &Ccedil;ıkışta &Ouml;zet</strong></p>
<ul>
<li dir="auto">Bakiye, toplam yatırılan, toplam &ccedil;ekilen, &ouml;denen fatura adedi ve net hareketi yazdırın.</li>
</ul>
<p dir="auto"><strong>Kabul Kriterleri (tik listesi):</strong></p>
<ul>
<li dir="auto">Login 3 denemeden sonra kapanıyor; başarılı girişte men&uuml; a&ccedil;ılıyor.</li>
<li dir="auto">Men&uuml; sonsuz d&ouml;ng&uuml;de; hatalı se&ccedil;im tekrar soruluyor.</li>
<li dir="auto">T&uuml;m işlemler metotlar ile yapılıyor.</li>
<li dir="auto">Negatif/0 tutarlara izin verilmiyor.</li>
<li dir="auto">Para &ccedil;ekmede komisyon kuralı uygulanıyor.</li>
<li dir="auto">Faturalarda indirim uygulanıp, indirimli tutar d&uuml;ş&uuml;yor.</li>
<li dir="auto">&Ccedil;ıkışta &ouml;zet yazdırılıyor.</li>
</ul>
<p dir="auto"><strong>&Ouml;rnek Test Senaryoları:</strong></p>
<ul>
<li dir="auto">Login 2 yanlış + 1 doğru &rarr; men&uuml; a&ccedil;ılmalı.</li>
<li dir="auto">Bakiye 0 iken 1000 yatır &rarr; bakiye 1000.</li>
<li dir="auto">6000 &ccedil;ek &rarr; komisyon 120, toplam d&uuml;ş&uuml;ş 6120; yetersiz bakiye hatası beklenir.</li>
<li dir="auto">1000 yatır, 6000 &ccedil;ek &rarr; yine yetersiz.</li>
<li dir="auto">10000 yatır, 6000 &ccedil;ek &rarr; bakiye 10000 - 6120 = 3880.</li>
<li dir="auto">İnternet faturasına 100 &ouml;de &rarr; 2 indirim, 98 d&uuml;şmeli.</li>
</ul>
