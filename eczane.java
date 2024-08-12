import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class eczane {

    private static final Scanner giris = new Scanner(System.in);

    private static ArrayList<String> TıbbiİlacAdiListesi = new ArrayList<String>();
    private static ArrayList<String> TıbbiİlacKoduListesi = new ArrayList<String>();
    private static ArrayList<Integer> TıbbiİlacAdediListesi = new ArrayList<Integer>();
    private static ArrayList<Integer> TıbbiİlacDozuListesi = new ArrayList<Integer>();
    private static ArrayList<Integer> TıbbiİlacsonKullanmaTarihiListesi = new ArrayList<Integer>();
    private static ArrayList<Integer> TıbbiİlacFiyatiListesi = new ArrayList<Integer>();

    private static ArrayList<String> EkTakviyeAdiListesi = new ArrayList<String>();
    private static ArrayList<String> EkTakviyeKoduListesi = new ArrayList<String>();
    private static ArrayList<Integer> EkTakviyeAdediListesi = new ArrayList<Integer>();
    private static ArrayList<Integer> EkTakviyeDozuListesi = new ArrayList<Integer>();
    private static ArrayList<Integer> EkTakviyesonKullanmaTarihiListesi = new ArrayList<Integer>();
    private static ArrayList<Integer> EkTakviyeFiyatiListesi = new ArrayList<Integer>();

    private static ArrayList<String> musteriAdiListesi = new ArrayList<String>();
    private static ArrayList<String> musteriSoyAdiListesi = new ArrayList<String>();
    private static ArrayList<String> musteriCinsiyetiListesi = new ArrayList<String>();
    private static ArrayList<Long> musteriTcListesi = new ArrayList<Long>();
    private static ArrayList<Integer> musteriDogumTarihiListesi = new ArrayList<Integer>();


    private static File depoTıbbiFile = new File("d:\\Eczane\\Depo İşlemleri\\Tıbbiİlaçlar.txt");
    private static File depoEkTakviyeFile = new File("d:\\Eczane\\Depo İşlemleri\\EkTakviyeler.txt");
    private static File musteriBilgileriFile = new File("d:\\Eczane\\Müşteri İşlemleri\\MüsteriBilgileri.txt");
    private static File musteriFaturaFile = new File("d:\\Eczane\\Müşteri İşlemleri\\MusteriFaturalari.txt");
    public static void main(String[] args) {
        EkranYokEtme();
        klasorVeDosyaOlustur();
        TıbbiİlacDepoDosyasiniYukle();
        EkTakviyeDepoDosyasiniYukle();
        musteriBilgileriDosyasiniYukle();
        anaMenu();
    }

    public static void anaMenu(){

        System.out.println("1) Depo İşlemleri");
        System.out.println("2) Müşteri İşlemleri");
        System.out.println("3) Ana Menü");
        System.out.println("4) Çıkış");
        System.out.println("Yapacağını İşlem Numarasını Giriniz :");
        int secim = giris.nextInt();
        giris.nextLine();

        if(secim == 1)
        {
            EkranYokEtme();
            depoİslemleri();
            
        }
        else if(secim == 2)
        {
            EkranYokEtme();
            musteriİslemleri();

        }
        else if(secim == 3)
        {
            EkranYokEtme();
            anaMenu();
        }
        else if(secim == 4)
        {
            EkranYokEtme();
            System.out.println("Sistem Sonlandırılıyor..");
        }
        else
        {
            EkranYokEtme();
            System.out.println("Geçersiz Seçim Yaptınız.    ");
            System.out.println("Ana Menüye Yönlendiriliyorsunuz..");
            anaMenu();
        }
        
    }

    public static void depoİslemleri(){

       System.out.println("[1] Tıbbi İlaç İşlemleri");
       System.out.println("[2] Ek Takviye İşlemleri");
       System.out.println("Yapacağınız İşlemi Seçiniz :");
       int secim = giris.nextInt();
       giris.nextLine();

       if(secim == 1)
       {
        EkranYokEtme();
        System.out.println("[1] İlaç Tanımlama");
        System.out.println("[2] İlaç Adedi Düşme");
        System.out.println("[3] İlaç Adedi Girme");
        System.out.println("[4] Stok Görüntüleme");
        
        System.out.println("Yapacağınız İşlem Numarasını Giriniz");
        int islem = giris.nextInt();
        giris.nextLine();

        if(islem == 1)
        {
            EkranYokEtme();
            tıbbiİlacTanimlama();
            
        }
        else if(islem == 2)
        {
            EkranYokEtme();
            TıbbiilacAdediDusme();

        }
        else if(islem == 3)
        {
            EkranYokEtme();
            TıbbiİlacAdediGirme();
        }
        else if(islem == 4)
        {
            EkranYokEtme();
            TıbbiİlacStokGörüntüleme();
        }
        else
        {
            EkranYokEtme();
            System.out.println("Geçersiz İşlem Seçtiniz.");
            System.out.println("Ana Menüye Yönlendiriliyorsunuz..");
            anaMenu();

        }
       }
       else if(secim == 2)
       {
        EkranYokEtme();
        System.out.println("[1] İlaç Tanımlama");
        System.out.println("[2] İlaç Adedi Düşme");
        System.out.println("[3] İlaç Adedi Girme");
        System.out.println("[4] Stok Görüntüleme");
        
        System.out.println("Yapacağınız İşlem Numarasını Giriniz");
        int islem = giris.nextInt();
        giris.nextLine();

        if(islem == 1)
        {
            EkranYokEtme();
            ekTakviyeTanimlama();
            
        }
        else if(islem == 2)
        {
            EkranYokEtme();
            ekTakviyeAdediDusme();
            

        }
        else if(islem == 3)
        {
            EkranYokEtme();
            EkTakviyeAdediGirme();
            
        }
        else if(islem == 4)
        {
            EkranYokEtme();
            EkTakviyeStokGörüntüleme();
            
        }
        else
        {
            EkranYokEtme();
            System.out.println("Geçersiz İşlem Seçtiniz.");
            System.out.println("Ana Menüye Yönlendiriliyorsunuz..");
            anaMenu();

        }
       }
       else
       {
        EkranYokEtme();
        System.out.println("Geçersiz İşlem Seçtiniz");
        System.out.println("Ana Menüye Yönlendiriliyorsunuz");
        anaMenu();
       }

    }

    public static void ekTakviyeTanimlama() {

        char devam = 'h';
        do {
            EkranYokEtme();
            System.out.println("İlaç Adını Giriniz :");
            String ilacAdi = giris.nextLine();
    
            
            if (EkTakviyeAdiListesi.contains(ilacAdi)) {
                EkranYokEtme();
                System.out.println("Hatalı İşlem");
                System.out.println("İşlem Notu : Zaten girmek istediğiniz ilaç depoda mevcut.");
                continue;
            }
    
            EkTakviyeAdiListesi.add(ilacAdi);
    
            int ilacAdedi = 0;
            while (true) {
                System.out.println("İlaç Adetini Giriniz :");
                if (giris.hasNextInt()) {
                    ilacAdedi = giris.nextInt();
                    giris.nextLine();
                    break;
                } else {
                    System.out.println("Hatalı giriş! Lütfen bir sayısal değer giriniz.");
                    giris.nextLine();
                }
            }
            EkTakviyeAdediListesi.add(ilacAdedi);
    
            int ilacDozu = 0;
            while (true) {
                System.out.println("İlacın Dozunu Giriniz : (Sadece Sayısal Değer)");
                if (giris.hasNextInt()) {
                    ilacDozu = giris.nextInt();
                    giris.nextLine();
                    break;
                } else {
                    System.out.println("Hatalı giriş! Lütfen bir sayısal değer giriniz.");
                    giris.nextLine();
                }
            }
            EkTakviyeDozuListesi.add(ilacDozu);
    
            int sonKullanmaTarihi = 0;
            while (true) {
                System.out.println("İlacın Son Kullanma Tarihini Giriniz : (Sadece Yıl Olarak)");
                if (giris.hasNextInt()) {
                    sonKullanmaTarihi = giris.nextInt();
                    giris.nextLine();
                    break;
                } else {
                    System.out.println("Hatalı giriş! Lütfen bir yıl giriniz.");
                    giris.nextLine();
                }
            }
            EkTakviyesonKullanmaTarihiListesi.add(sonKullanmaTarihi);
    
            int ilacFiyati = 0;
            while (true) {
                System.out.println("İlacın Fiyatını Giriniz : (Sadece Sayısal Değer)");
                if (giris.hasNextInt()) {
                    ilacFiyati = giris.nextInt();
                    giris.nextLine();
                    break;
                } else {
                    System.out.println("Hatalı giriş! Lütfen bir sayısal değer giriniz.");
                    giris.nextLine();
                }
            }
            EkTakviyeFiyatiListesi.add(ilacFiyati);
    
            String ilacKodu = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            EkTakviyeKoduListesi.add(ilacKodu);
    
            try (FileWriter fw = new FileWriter(depoEkTakviyeFile, true)) {
                fw.write("İlaç Adı: " + ilacAdi + "\n");
                fw.write("İlaç Kodu: " + ilacKodu + "\n");
                fw.write("İlaç Adedi: " + ilacAdedi + "\n");
                fw.write("İlaç Dozu: " + ilacDozu + " mg\n");
                fw.write("Son Kullanma Tarihi: " + sonKullanmaTarihi + "\n");
                fw.write("İlaç Fiyatı: " + ilacFiyati + " TL\n");
                fw.write("-----------------------------\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            System.out.println("İlaç girişine devam etmek istiyor musunuz? (E/e - devam, diğer tuş - çıkış):");
            devam = giris.next().charAt(0);
            giris.nextLine();

        }while(devam == 'e' || devam == 'E');
    
        EkranYokEtme();
        System.out.println("Devam etmek istemediğiniz için ana menüye yönlendiriliyorsunuz..");
        anaMenu();
    } 

    public static void tıbbiİlacTanimlama() {

        char devam = 'N';
        do {
            EkranYokEtme();
            System.out.println("İlaç Adını Giriniz :");
            String ilacAdi = giris.nextLine();
    
            if (TıbbiİlacAdiListesi.contains(ilacAdi)) {
                EkranYokEtme();
                System.out.println("Hatalı İşlem");
                System.out.println("İşlem Notu : Zaten Girmek İstediğiniz İlaç Depoda Mevcut.");
                continue;
            }
    
            TıbbiİlacAdiListesi.add(ilacAdi);
    
            int ilacAdedi = 0;
            while (true) {
                System.out.println("İlaç Adetini Giriniz :");
                if (giris.hasNextInt()) {
                    ilacAdedi = giris.nextInt();
                    giris.nextLine();
                    break; 
                } else {
                    System.out.println("Hatalı giriş! Lütfen bir sayısal değer giriniz.");
                    giris.nextLine();
                }
            }
            TıbbiİlacAdediListesi.add(ilacAdedi);
    
            int ilacDozu = 0;
            while (true) {
                System.out.println("İlacın Dozunu Giriniz : (Sadece Sayısal Değer)");
                if (giris.hasNextInt()) {
                    ilacDozu = giris.nextInt();
                    giris.nextLine();
                    break;
                } else {
                    System.out.println("Hatalı giriş! Lütfen bir sayısal değer giriniz.");
                    giris.nextLine();
                }
            }
            TıbbiİlacDozuListesi.add(ilacDozu);
    
            int sonKullanmaTarihi = 0;
            while (true) {
                System.out.println("İlacın Son Kullanma Tarihini Giriniz : (Sadece Yıl Olarak)");
                if (giris.hasNextInt()) {
                    sonKullanmaTarihi = giris.nextInt();
                    giris.nextLine();
                    break;
                } else {
                    System.out.println("Hatalı giriş! Lütfen bir yıl giriniz.");
                    giris.nextLine();
                }
            }
            TıbbiİlacsonKullanmaTarihiListesi.add(sonKullanmaTarihi);
    
            int ilacFiyati = 0;
            while (true) {
                System.out.println("İlacın Fiyatını Giriniz : (Sadece Sayısal Değer)");
                if (giris.hasNextInt()) {
                    ilacFiyati = giris.nextInt();
                    giris.nextLine();
                    break;
                } else {
                    System.out.println("Hatalı giriş! Lütfen bir sayısal değer giriniz.");
                    giris.nextLine();
                }
            }
            TıbbiİlacFiyatiListesi.add(ilacFiyati);
    
            String ilacKodu = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            TıbbiİlacKoduListesi.add(ilacKodu);
    
            try (FileWriter fw = new FileWriter(depoTıbbiFile, true)) {
                fw.write("İlaç Adı: " + ilacAdi + "\n");
                fw.write("İlaç Kodu: " + ilacKodu + "\n");
                fw.write("İlaç Adedi: " + ilacAdedi + "\n");
                fw.write("İlaç Dozu: " + ilacDozu + " mg\n");
                fw.write("Son Kullanma Tarihi: " + sonKullanmaTarihi + "\n");
                fw.write("İlaç Fiyatı: " + ilacFiyati + " TL\n");
                fw.write("-----------------------------\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            System.out.println("İlaç girişine devam etmek istiyor musunuz? (E/e - devam, diğer tuş - çıkış):");
            String devamInput = giris.nextLine().trim();
            devam = devamInput.isEmpty() ? 'H' : devamInput.charAt(0);
    
        } while (devam == 'E' || devam == 'e');
    
        EkranYokEtme();
        System.out.println("Devam etmek istemediğiniz için ana menüye yönlendiriliyorsunuz..");
        anaMenu();
    }

    public static void ekTakviyeAdediDusme() {
    System.out.println("İlacın Adını veya Kodunu Giriniz:");
    String girdi = giris.nextLine().trim();
    int index = -1;

    if (EkTakviyeAdiListesi.contains(girdi)) {
        index = EkTakviyeAdiListesi.indexOf(girdi);
    } else if (EkTakviyeKoduListesi.contains(girdi)) {
        index = EkTakviyeKoduListesi.indexOf(girdi);
    } else {
        System.out.println("Girdiğiniz İlaç Adı veya Kodu Mevcut Değil.");
        anaMenu();
        return;
    }

    int dusulecekAdet = 0;
    boolean gecerliGiris = false;

    while (!gecerliGiris) {
        System.out.println("Düşülecek Adet Sayısını Giriniz:");
        try {
            dusulecekAdet = giris.nextInt();
            giris.nextLine(); 

            if (dusulecekAdet <= 0) {
                System.out.println("Lütfen 0'dan büyük bir değer girin.");
            } else {
                gecerliGiris = true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Geçersiz giriş! Lütfen bir sayı girin.");
            giris.nextLine(); 
        }
    }

    int mevcutAdet = EkTakviyeAdediListesi.get(index);

    if (dusulecekAdet > mevcutAdet) {
        System.out.println("Yeterli Stok Yok! Ana Menüye Yönlendiriliyorsunuz..");
        anaMenu();
        return;
    } else {
        EkTakviyeAdediListesi.set(index, mevcutAdet - dusulecekAdet);
        System.out.println("İlaç Adedi Başarıyla Düşürüldü. Yeni Adet: " + EkTakviyeAdediListesi.get(index));
        guncelleEkTakviyeDepoDosyasi();
    }

    anaMenu();
}

    public static void TıbbiilacAdediDusme() {
    System.out.println("İlacın Adını veya Kodunu Giriniz:");
    String girdi = giris.nextLine();
    int index = -1;

    if (TıbbiİlacAdiListesi.contains(girdi)) {
        index = TıbbiİlacAdiListesi.indexOf(girdi);
    } else if (TıbbiİlacKoduListesi.contains(girdi)) {
        index = TıbbiİlacKoduListesi.indexOf(girdi);
    } else {
        System.out.println("Girdiğiniz İlaç Adı veya Kodu Mevcut Değil.");
        anaMenu();
        return;
    }

    int dusulecekAdet = 0;
    boolean gecerliGiris = false;
    while (!gecerliGiris) {
        System.out.println("Düşülecek Adet Sayısını Giriniz:");
        if (giris.hasNextInt()) {
            dusulecekAdet = giris.nextInt();
            if (dusulecekAdet > 0) {
                gecerliGiris = true;
            } else {
                System.out.println("Hatalı Giriş! Lütfen pozitif bir sayı girin.");
            }
        } else {
            System.out.println("Hatalı Giriş! Lütfen sayısal bir değer girin.");
            giris.next();
        }
        giris.nextLine();
    }

    int mevcutAdet = TıbbiİlacAdediListesi.get(index);

    if (dusulecekAdet > mevcutAdet) {
        System.out.println("Yeterli Stok Yok! Ana Menüye Yönlendiriliyorsunuz..");
        anaMenu();
    } else {
        TıbbiİlacAdediListesi.set(index, mevcutAdet - dusulecekAdet);
        System.out.println("İlaç Adedi Başarıyla Düşürüldü. Yeni Adet: " + TıbbiİlacAdediListesi.get(index));
        guncelleTıbbiİlacDepoDosyasi();
    }

    anaMenu();
}

    public static void guncelleEkTakviyeDepoDosyasi(){
        try (FileWriter fw = new FileWriter(depoEkTakviyeFile, false)) { 
            for (int i = 0; i < EkTakviyeAdiListesi.size(); i++) {
                fw.write("İlaç Adı: " + EkTakviyeAdiListesi.get(i) + "\n");
                fw.write("İlaç Kodu: " + EkTakviyeKoduListesi.get(i) + "\n");
                fw.write("İlaç Adedi: " + EkTakviyeAdediListesi.get(i) + "\n");
                fw.write("İlaç Dozu: " + EkTakviyeDozuListesi.get(i) + " mg\n");
                fw.write("Son Kullanma Tarihi: " + EkTakviyesonKullanmaTarihiListesi.get(i) + "\n");
                fw.write("İlaç Fiyatı: " + EkTakviyeFiyatiListesi.get(i) + " TL\n");
                fw.write("-----------------------------\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guncelleTıbbiİlacDepoDosyasi() {
        try (FileWriter fw = new FileWriter(depoTıbbiFile, false)) { 
            for (int i = 0; i < TıbbiİlacAdiListesi.size(); i++) {
                fw.write("İlaç Adı: " + TıbbiİlacAdiListesi.get(i) + "\n");
                fw.write("İlaç Kodu: " + TıbbiİlacKoduListesi.get(i) + "\n");
                fw.write("İlaç Adedi: " + TıbbiİlacAdediListesi.get(i) + "\n");
                fw.write("İlaç Dozu: " + TıbbiİlacDozuListesi.get(i) + " mg\n");
                fw.write("Son Kullanma Tarihi: " + TıbbiİlacsonKullanmaTarihiListesi.get(i) + "\n");
                fw.write("İlaç Fiyatı: " + TıbbiİlacFiyatiListesi.get(i) + " TL\n");
                fw.write("-----------------------------\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    public static void EkTakviyeAdediGirme() {
        System.out.println("İlacın Adını veya Kodunu Giriniz:");
        String girdi = giris.nextLine();
        int index = -1;
    
        if (EkTakviyeAdiListesi.contains(girdi)) {
            index = EkTakviyeAdiListesi.indexOf(girdi);
        } else if (EkTakviyeKoduListesi.contains(girdi)) {
            index = EkTakviyeKoduListesi.indexOf(girdi);
        } else {
            System.out.println("Girdiğiniz İlaç Adı veya Kodu Mevcut Değil.");
            anaMenu();
            return;
        }
    
        int arttirilacakAdet = 0;
        boolean gecerliGiris = false;
        while (!gecerliGiris) {
            System.out.println("Arttırılacak Adet Sayısını Giriniz:");
            if (giris.hasNextInt()) {
                arttirilacakAdet = giris.nextInt();
                if (arttirilacakAdet > 0) {
                    gecerliGiris = true;
                } else {
                    System.out.println("Hatalı Giriş! Lütfen pozitif bir sayı girin.");
                }
            } else {
                System.out.println("Hatalı Giriş! Lütfen sayısal bir değer girin.");
                giris.next();
            }
            giris.nextLine();
        }
    
        int mevcutAdet = EkTakviyeAdediListesi.get(index);

        EkTakviyeAdediListesi.set(index, mevcutAdet + arttirilacakAdet);
        System.out.println("İlaç Adedi Başarıyla Arttırıldı. Yeni Adet: " + EkTakviyeAdediListesi.get(index));
        guncelleEkTakviyeDepoDosyasi();
    
        anaMenu();
    }

    public static void TıbbiİlacAdediGirme() {
        System.out.println("İlacın Adını veya Kodunu Giriniz:");
        String girdi = giris.nextLine();
        int index = -1;
    
        if (TıbbiİlacAdiListesi.contains(girdi)) {
            index = TıbbiİlacAdiListesi.indexOf(girdi);
        } else if (TıbbiİlacKoduListesi.contains(girdi)) {
            index = TıbbiİlacKoduListesi.indexOf(girdi);
        } else {
            System.out.println("Girdiğiniz İlaç Adı veya Kodu Mevcut Değil.");
            anaMenu();
            return; 
        }
    
        int arttirilacakAdet = 0;
        boolean gecerliGiris = false;
        while (!gecerliGiris) {
            System.out.println("Arttırılacak Adet Sayısını Giriniz:");
            if (giris.hasNextInt()) {
                arttirilacakAdet = giris.nextInt();
                giris.nextLine();
                if (arttirilacakAdet > 0) {
                    gecerliGiris = true;
                } else {
                    System.out.println("Hatalı Giriş! Lütfen pozitif bir sayı girin.");
                }
            } else {
                System.out.println("Hatalı Giriş! Lütfen sayısal bir değer girin.");
                giris.next();
            }
        }
    
        int mevcutAdet = TıbbiİlacAdediListesi.get(index);
    
        TıbbiİlacAdediListesi.set(index, mevcutAdet + arttirilacakAdet);
        System.out.println("İlaç Adedi Başarıyla Arttırıldı. Yeni Adet: " + TıbbiİlacAdediListesi.get(index));
        guncelleTıbbiİlacDepoDosyasi();
    
        anaMenu();
    }

    public static void EkTakviyeStokGörüntüleme(){

        System.out.println("Depodaki Tüm Ek Takviyelerin Listesi");
        System.out.println("-------------------------");
        for (int i = 0; i < EkTakviyeAdediListesi.size(); i++) 
        {
            System.out.println("İlaç Adı: " + EkTakviyeAdiListesi.get(i) + "\n");
            System.out.println("İlaç Kodu: " + EkTakviyeKoduListesi.get(i) + "\n");
            if(EkTakviyeAdediListesi.get(i)==0)
            {
                System.out.println("Stok Tükendi "+"\n");
            }
            else
            {
                System.out.println("İlaç Adedi: " + EkTakviyeAdediListesi.get(i) + "\n");
            }
            System.out.println("İlaç Dozu: " + EkTakviyeDozuListesi.get(i) + " mg\n");
            System.out.println("Son Kullanma Tarihi: " + EkTakviyesonKullanmaTarihiListesi.get(i) + "\n");
            System.out.println("İlaç Fiyatı: " + EkTakviyeFiyatiListesi.get(i) + " TL\n");
            System.out.println("-----------------------------\n");
             
        }
        anaMenu();

    }

    public static void TıbbiİlacStokGörüntüleme(){
        EkranYokEtme();
        System.out.println("Depodaki Tüm İlaçların Listesi");
        System.out.println("-------------------------");
        for (int i = 0; i < TıbbiİlacAdediListesi.size(); i++) 
        {
            System.out.println("İlaç Adı: " + TıbbiİlacAdiListesi.get(i) + "\n");
            System.out.println("İlaç Kodu: " + TıbbiİlacKoduListesi.get(i) + "\n");
            if(TıbbiİlacAdediListesi.get(i)==0)
            {
                System.out.println("Stok Tükendi "+"\n");
            }
            else
            {
                System.out.println("İlaç Adedi: " + TıbbiİlacAdediListesi.get(i) + "\n");
            }
            System.out.println("İlaç Dozu: " + TıbbiİlacDozuListesi.get(i) + " mg\n");
            System.out.println("Son Kullanma Tarihi: " + TıbbiİlacsonKullanmaTarihiListesi.get(i) + "\n");
            System.out.println("İlaç Fiyatı: " + TıbbiİlacFiyatiListesi.get(i) + " TL\n");
            System.out.println("-----------------------------\n");
             
        }
        anaMenu();
    }

    public static void klasorVeDosyaOlustur() {
        try {
            Files.createDirectories(Paths.get("d:\\Eczane\\Depo İşlemleri"));
            Files.createDirectories(Paths.get("d:\\Eczane\\Müşteri İşlemleri"));
    
            if (!depoTıbbiFile.exists()) {
                depoTıbbiFile.createNewFile(); 
            }
            if (!depoEkTakviyeFile.exists()) {
                depoEkTakviyeFile.createNewFile(); 
            }
            if (!musteriBilgileriFile.exists()) {
                musteriBilgileriFile.createNewFile(); 
            }
            if (!musteriFaturaFile.exists()) {
                musteriFaturaFile.createNewFile(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void EkTakviyeDepoDosyasiniYukle() {
        try (Scanner scanner = new Scanner(depoEkTakviyeFile)) {
            while (scanner.hasNextLine()) {
                String ilacAdi = scanner.nextLine().split(": ")[1];
                EkTakviyeAdiListesi.add(ilacAdi);
    
                String ilacKodu = scanner.nextLine().split(": ")[1];
                EkTakviyeKoduListesi.add(ilacKodu);
    
                int ilacAdedi = Integer.parseInt(scanner.nextLine().split(": ")[1]);
                EkTakviyeAdediListesi.add(ilacAdedi);
    
                int ilacDozu = Integer.parseInt(scanner.nextLine().split(": ")[1].split(" ")[0]);
                EkTakviyeDozuListesi.add(ilacDozu);
    
                int sonKullanmaTarihi = Integer.parseInt(scanner.nextLine().split(": ")[1]);
                EkTakviyesonKullanmaTarihiListesi.add(sonKullanmaTarihi);
    
                int ilacFiyati = Integer.parseInt(scanner.nextLine().split(": ")[1].split(" ")[0]);
                EkTakviyeFiyatiListesi.add(ilacFiyati);
    
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void TıbbiİlacDepoDosyasiniYukle() {
        try (Scanner scanner = new Scanner(depoTıbbiFile)) {
            while (scanner.hasNextLine()) {
                String ilacAdi = scanner.nextLine().split(": ")[1];
                TıbbiİlacAdiListesi.add(ilacAdi);
    
                String ilacKodu = scanner.nextLine().split(": ")[1];
                TıbbiİlacKoduListesi.add(ilacKodu);
    
                int ilacAdedi = Integer.parseInt(scanner.nextLine().split(": ")[1]);
                TıbbiİlacAdediListesi.add(ilacAdedi);
    
                int ilacDozu = Integer.parseInt(scanner.nextLine().split(": ")[1].split(" ")[0]);
                TıbbiİlacDozuListesi.add(ilacDozu);
    
                int sonKullanmaTarihi = Integer.parseInt(scanner.nextLine().split(": ")[1]);
                TıbbiİlacsonKullanmaTarihiListesi.add(sonKullanmaTarihi);
    
                int ilacFiyati = Integer.parseInt(scanner.nextLine().split(": ")[1].split(" ")[0]);
                TıbbiİlacFiyatiListesi.add(ilacFiyati);
    
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void EkranYokEtme(){
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void musteriİslemleri(){
        System.out.println("[1] Müşteri Bilgilerini Kaydet");
        System.out.println("[2] Kayıtlı Müşteri Görüntüle");
        System.out.println("[3] Kayıtlı Müşteri Ara");
        System.out.println("[4] Kayıtlı Müşteri Fatura İşlemleri");
        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int secim = giris.nextInt();
        giris.nextLine();

        if(secim == 1)
        {
            EkranYokEtme();
            musteriBilgileriKaydet();
        }
        else if(secim == 2)
        {
            EkranYokEtme();
            kayitliMusterileriGoruntule();
        }
        else if( secim == 3)
        {
            EkranYokEtme();
            kayitliMusteriAra();
        }
        else if( secim == 4)
        {
            EkranYokEtme();
            kayıtlıMusteriFaturaIslemleri();
        }
        else
        {
            EkranYokEtme();
            System.out.println("Geçersiz İşlem Seçtiniz.");
            System.out.println("Ana Menüye Yönlendiriliyorsunuz..");
            anaMenu();
        }
    }

    public static void musteriBilgileriKaydet() {

        System.out.println("Müşterinin Adını Giriniz :");
        String musteriAdi = giris.nextLine();
        musteriAdiListesi.add(musteriAdi);
    
        System.out.println("Müşterinin Soyadını Giriniz :");
        String musteriSoyadi = giris.nextLine();
        musteriSoyAdiListesi.add(musteriSoyadi);
    
        System.out.println("Müşterinin Cinsiyetini Giriniz :");
        String musteriCinsiyeti = giris.nextLine();
        musteriCinsiyetiListesi.add(musteriCinsiyeti);
    
        Long musteriTc = null;
        while (true) {
            System.out.println("Müşterinin TC Kimlik Bilgilerini Giriniz :");
            if (giris.hasNextLong()) {
                musteriTc = giris.nextLong();
                giris.nextLine();
                if (musteriTcListesi.contains(musteriTc)) {
                    EkranYokEtme();
                    System.out.println("Hatalı İşlem");
                    System.out.println("İşlem Notu : Zaten girmek istediğiniz TC sistemde kayıtlı.");
                    System.out.println("Ana Menüye yönlendiriliyorsunuz..");
                    anaMenu();
                    return;
                } else {
                    musteriTcListesi.add(musteriTc);
                    break;
                }
            } else {
                System.out.println("Hatalı giriş! Lütfen bir sayısal değer giriniz.");
                giris.nextLine();
            }
        }
    
        int musteriDogumTarihi = 0;
        while (true) {
            System.out.println("Müşterinin Doğum Yılını Giriniz :");
            if (giris.hasNextInt()) {
                musteriDogumTarihi = giris.nextInt();
                giris.nextLine();
                musteriDogumTarihiListesi.add(musteriDogumTarihi);
                break;
            } else {
                System.out.println("Hatalı giriş! Lütfen bir yıl giriniz.");
                giris.nextLine();
            }
        }
    
        try (FileWriter fw = new FileWriter(musteriBilgileriFile, true)) {
            fw.write("Müşteri Adı: " + musteriAdi + "\n");
            fw.write("Müşteri Soyadı: " + musteriSoyadi + "\n");
            fw.write("Müşteri Cinsiyeti: " + musteriCinsiyeti + "\n");
            fw.write("Müşteri TC: " + musteriTc + " \n");
            fw.write("Müşteri Doğum Yılı: " + musteriDogumTarihi + "\n");
            fw.write("-----------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        try (FileWriter fw = new FileWriter(musteriFaturaFile, true)) {
            fw.write("Müşteri Adı: " + musteriAdi + "\n");
            fw.write("Müşteri Soyadı: " + musteriSoyadi + "\n");
            fw.write("Müşteri Cinsiyeti: " + musteriCinsiyeti + "\n");
            fw.write("Müşteri TC: " + musteriTc + " \n");
            fw.write("Müşteri Doğum Yılı: " + musteriDogumTarihi + "\n");
            fw.write("-----------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        EkranYokEtme();
        System.out.println("Müşteri Bilgileri Başarıyla Kaydedilmiştir.");
        System.out.println("Faturalandırma İşlemine Yönlendiriliyorsunuz..");
        musteriFaturaİslemleri();
    }
   
    public static void musteriFaturaİslemleri() {
        int mevcutAdet = 0;
        char devam;
        double toplamFiyat = 0;
        DateTimeFormatter tarihSaatFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
        do {
            System.out.println("Lütfen Almak İstediğiniz İlacın Adını Giriniz");
            String receteliİlac = giris.nextLine();
    
            int index = -1;
            boolean ilacBulundu = false;
            double kdvTıbbiİlacOrani = 0.18;
            double kdvEkTakviyeOrani = 0.36;
    
            if (EkTakviyeAdiListesi.contains(receteliİlac)) {
                index = EkTakviyeAdiListesi.indexOf(receteliİlac);
                ilacBulundu = true;
    
                int alinacakAdet = 0;
                while (true) {
                    System.out.println("Kaç Adet Alacağınızı Giriniz:");
                    if (giris.hasNextInt()) {
                        alinacakAdet = giris.nextInt();
                        giris.nextLine();
    
                        mevcutAdet = EkTakviyeAdediListesi.get(index);
                        if (alinacakAdet > mevcutAdet) {
                            System.out.println("Yeterli Stok Yok! Ana Menüye Yönlendiriliyorsunuz..");
                            anaMenu();
                            return;
                        } else if (alinacakAdet <= 0) {
                            System.out.println("Geçersiz Adet Girdiniz! Lütfen 1 veya daha fazla bir değer giriniz.");
                        } else {
                            EkTakviyeAdediListesi.set(index, mevcutAdet - alinacakAdet);
                            System.out.println("İlaç Adedi Başarıyla Düşürüldü. Yeni Adet: " + EkTakviyeAdediListesi.get(index));
                            guncelleEkTakviyeDepoDosyasi();
    
                            double birimFiyat = EkTakviyeFiyatiListesi.get(index);
                            double araToplam = birimFiyat * alinacakAdet;
                            double kdvTutariEkTakviye = araToplam * kdvEkTakviyeOrani;
                            double toplam = araToplam + kdvTutariEkTakviye;
                            toplamFiyat += toplam;
    
                            LocalDateTime simdikiZaman = LocalDateTime.now();
                            String formatliZaman = simdikiZaman.format(tarihSaatFormatter);
    
                            try (FileWriter fw = new FileWriter(musteriFaturaFile, true)) {
                                fw.write("Alınan İlaç Adı: " + receteliİlac + "\n");
                                fw.write("Alınan İlacın Adedi: " + alinacakAdet + "\n");
                                fw.write("İlacın Birim Fiyatı: " + birimFiyat + " TL\n");
                                fw.write("Ara Toplam: " + araToplam + " TL\n");
                                fw.write("KDV Tutarı (%36): " + kdvTutariEkTakviye + " TL\n");
                                fw.write("Toplam Fiyat: " + toplam + " TL\n");
                                fw.write("İşlem Tarihi ve Saati: " + formatliZaman + "\n");
                                fw.write("-----------------------------\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    } else {
                        System.out.println("Hatalı giriş! Lütfen geçerli bir sayı giriniz.");
                        giris.nextLine();
                    }
                }
            } else if (TıbbiİlacAdiListesi.contains(receteliİlac)) {
                index = TıbbiİlacAdiListesi.indexOf(receteliİlac);
                ilacBulundu = true;
    
                int alinacakAdet = 0;
                while (true) {
                    System.out.println("Kaç Adet Alacağınızı Giriniz:");
                    if (giris.hasNextInt()) {
                        alinacakAdet = giris.nextInt();
                        giris.nextLine();
    
                        mevcutAdet = TıbbiİlacAdediListesi.get(index);
                        if (alinacakAdet > mevcutAdet) {
                            System.out.println("Yeterli Stok Yok! Ana Menüye Yönlendiriliyorsunuz..");
                            anaMenu();
                            return;
                        } else if (alinacakAdet <= 0) {
                            System.out.println("Geçersiz Adet Girdiniz! Lütfen 1 veya daha fazla bir değer giriniz.");
                        } else {
                            TıbbiİlacAdediListesi.set(index, mevcutAdet - alinacakAdet);
                            System.out.println("İlaç Adedi Başarıyla Düşürüldü. Yeni Adet: " + TıbbiİlacAdediListesi.get(index));
                            guncelleTıbbiİlacDepoDosyasi();
    
                            double birimFiyat = TıbbiİlacFiyatiListesi.get(index);
                            double araToplam = birimFiyat * alinacakAdet;
                            double kdvTutariTıbbiİlac = araToplam * kdvTıbbiİlacOrani;
                            double toplam = araToplam + kdvTutariTıbbiİlac;
                            toplamFiyat += toplam;
    
                            LocalDateTime simdikiZaman = LocalDateTime.now();
                            String formatliZaman = simdikiZaman.format(tarihSaatFormatter);
    
                            try (FileWriter fw = new FileWriter(musteriFaturaFile, true)) {
                                fw.write("Alınan İlaç Adı: " + receteliİlac + "\n");
                                fw.write("Alınan İlacın Adedi: " + alinacakAdet + "\n");
                                fw.write("İlacın Birim Fiyatı: " + birimFiyat + " TL\n");
                                fw.write("Ara Toplam: " + araToplam + " TL\n");
                                fw.write("KDV Tutarı (%18): " + kdvTutariTıbbiİlac + " TL\n");
                                fw.write("Toplam Fiyat: " + toplam + " TL\n");
                                fw.write("İşlem Tarihi ve Saati: " + formatliZaman + "\n");
                                fw.write("-----------------------------\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    } else {
                        System.out.println("Hatalı giriş! Lütfen geçerli bir sayı giriniz.");
                        giris.nextLine();
                    }
                }
            } else {
                EkranYokEtme();
                System.out.println("Girdiğiniz İlaç Adı Mevcut Değil.");
                anaMenu();
                return;
            }
    
            System.out.println("Reçeteyi Yazdırmaya Devam Etmek İçin (E/e) Basınız");
            devam = giris.next().charAt(0);
            giris.nextLine();
    
        } while (devam == 'E' || devam == 'e');
    
        try (FileWriter fw = new FileWriter(musteriFaturaFile, true)) {
            fw.write("\nToplam Ücret: " + toplamFiyat + " TL\n");
            fw.write("=============================\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        System.out.println("Fatura başarıyla yazdırıldı. Toplam Ücret: " + toplamFiyat + " TL");
        anaMenu();
    }
    
    

    public static void musteriBilgileriDosyasiniYukle(){
        try (Scanner scanner = new Scanner(musteriBilgileriFile)) {
            while (scanner.hasNextLine()) {
                String musteriAdi = scanner.nextLine().split(": ")[1];
                musteriAdiListesi.add(musteriAdi);
    
                String musteriSoyadi = scanner.nextLine().split(": ")[1];
                musteriSoyAdiListesi.add(musteriSoyadi);

                String musteriCinsiyeti = scanner.nextLine().split(": ")[1];
                musteriCinsiyetiListesi.add(musteriCinsiyeti);
    
                String input = scanner.nextLine();
                String musteriTcStr = input.split(": ")[1].trim();
                Long musteriTc = Long.parseLong(musteriTcStr);
                musteriTcListesi.add(musteriTc);

                int musteriDogumTarihi = Integer.parseInt(scanner.nextLine().split(": ")[1].split(" ")[0]);
                musteriDogumTarihiListesi.add(musteriDogumTarihi);
    
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void kayitliMusterileriGoruntule(){

        EkranYokEtme();
        System.out.println("Kayıtlı Tüm Müşterilerin Listesi");
        System.out.println("-------------------------");
        for (int i = 0; i < musteriTcListesi.size(); i++) 
        {
            System.out.println("Müşteri Adı: " + musteriAdiListesi.get(i) + "\n");
            System.out.println("Müşteri Soyadı: " + musteriSoyAdiListesi.get(i) + "\n");
            System.out.println("İlaç Cinsiyet: " + TıbbiİlacDozuListesi.get(i) + " mg\n");
            System.out.println("Müşteri Tc: " + musteriTcListesi.get(i) + "\n");
            System.out.println("Müşteri Doğum Yılı: " + musteriDogumTarihiListesi.get(i) + " TL\n");
            System.out.println("-----------------------------\n");
             
        }
        anaMenu();
        
    }

    public static void kayitliMusteriAra() {
        System.out.println("Aramak İstediğiniz Müşterinin TC kimlik Bilgilerini Giriniz:");
        Long arananTc = giris.nextLong();
        giris.nextLine();
        
        boolean bulunma = false;
    
        for (int i = 0; i < musteriTcListesi.size(); i++) {
            if (musteriTcListesi.get(i).equals(arananTc)) {
                EkranYokEtme();
                System.out.println("Kayıtlı Müşterimizin Bilgileri");
                System.out.println("Ad: " + musteriAdiListesi.get(i));
                System.out.println("Soyad: " + musteriSoyAdiListesi.get(i));
                System.out.println("Cinsiyet: " + musteriCinsiyetiListesi.get(i));
                System.out.println("Doğum Yılı: " + musteriDogumTarihiListesi.get(i));
                System.out.println("TC Kimlik: " + musteriTcListesi.get(i));
                System.out.println("-------------------------");
                System.out.println("Ana Menüye Yönlendiriliyorsunuz..");
                anaMenu();
                bulunma = true;
                break;
            }
        }
    
        if (!bulunma) {
            System.out.println("Müşteri bulunamadı.");
            anaMenu();
        }
    }
  
    public static void kayıtlıMusteriFaturaIslemleri() {

        System.out.println("Kayıtlı Müşterinin TC Kimlik Numarasını Giriniz :");
        Long arananTc = giris.nextLong();
        giris.nextLine();
    
        boolean bulunma = false;
    
        for (int i = 0; i < musteriTcListesi.size(); i++) {
            if (musteriTcListesi.get(i).equals(arananTc)) {
                EkranYokEtme();
                System.out.println("Kayıtlı Müşterimizin Bilgileri");
                System.out.println("Ad: " + musteriAdiListesi.get(i));
                System.out.println("Soyad: " + musteriSoyAdiListesi.get(i));
                System.out.println("Cinsiyet: " + musteriCinsiyetiListesi.get(i));
                System.out.println("Doğum Yılı: " + musteriDogumTarihiListesi.get(i));
                System.out.println("TC Kimlik: " + musteriTcListesi.get(i));
                System.out.println("-------------------------");
                System.out.println("Faturalandırma İşlemiyle Devam Ediyoruz..");
                
                try (FileWriter fw = new FileWriter(musteriFaturaFile, true)) {
                    fw.write("Müşteri Adı: " + musteriAdiListesi.get(i) + "\n");
                    fw.write("Müşteri Soyadı: " + musteriSoyAdiListesi.get(i) + "\n");
                    fw.write("Müşteri Cinsiyeti: " + musteriCinsiyetiListesi.get(i) + "\n");
                    fw.write("Müşteri TC: " + musteriTcListesi.get(i) + " \n");
                    fw.write("Müşteri Doğum Yılı: " + musteriDogumTarihiListesi.get(i) + "\n");
                    fw.write("-----------------------------\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                musteriFaturaİslemleri();
                bulunma = true;
                break;
            }
        }
    
        if (!bulunma) {
            EkranYokEtme();
            System.out.println("Müşteri bulunamadı.");
            anaMenu();
        }
    }
    
}