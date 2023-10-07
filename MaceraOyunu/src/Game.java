import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hosgeldiniz !");
        System.out.println("Lutfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayin " + player.getName() + " Bu karanlik ve sisli Adaya Hosgeldiniz !! Burada yasananlarin hepsi gercek :)");
        System.out.println("Lutfen bir karakter seciniz ! ");
        System.out.println("---------------------------------------------------------------------------------");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("#########  Bolgeler  #########");
            System.out.println();
            System.out.println("1 - Guvenli Ev ---> Burasi sizin icin guvenli bir ev, düsman yok !");
            System.out.println("2 - Esya Dukkani ---> Silah veya Zirh satin alabilirsiniz !");
            System.out.println("3 - Magara ---> Odul <Yemek> , Dikkatli ol Zombi Cikabilir !");
            System.out.println("4 - Orman  ---> Odul <Odun> , Dikkatli ol Vampir Cikabilir !");
            System.out.println("5 - Nehir  ---> Odul <Su> , Dikkatli ol Ayi Cikabilir !");
            System.out.println("0 - Cikis Yap ---> Oyunu sonlandir !");
            System.out.println("Lutfen gitmek istediginiz bolgeyi seciniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lutfen gecerli bir bolge giriniz !");
            }

            if (location == null){
                System.out.println("Bu karanlik ve sisli adadan cabuk vazgectiniz !!");
                break;
            }
            if (!location.onLocation()){
                System.out.println("! GAME OVER !");
                break;
            }

        }
    }
}
