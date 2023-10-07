
public class ToolStore extends  NormalLoc {

    public ToolStore(Player player) {
        super(player, "Magaza");

    }

    @Override
    public boolean onLocation() {
        System.out.println("---------- Magazaya Hosgeldiniz ! ----------");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zirhlar");
            System.out.println("3 - Cikis Yap");
            System.out.println("Seciminiz : ");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Gecersiz deger , Tekrar deneyiniz : ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz !");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----- Silahlar -----");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() +
                    " <Para : " + w.getPrice() +
                    " , Hasar : " + w.getDamage());
        }
        System.out.println("0 - Cikis Yap ! ");
    }

    public void buyWeapon() {
        System.out.println("Bir silah seciniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Gecersiz deger , Tekrar deneyiniz : ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponOblByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paraniz bulunmamaktadir !! ");
                } else {
                    //Satın almanın gerçekleştiği alan.
                    System.out.println(selectedWeapon.getName() + " Silahini satin aldiniz ! ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiye : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }

        }
    }

    public void printArmor() {
        System.out.println("----- Zirhlar -----");
        for(Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() +
                    " <Para : " + a.getPrice() + " <Zirh : " + a.getBlock() + " >");

        }
        System.out.println("0 - Cikis Yap ! ");
    }

    public void buyArmor(){
        System.out.println("Bir Zirh seciniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
            System.out.println("Gecersiz deger , Tekrar deneyiniz : ");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorOblByID(selectArmorID);
            if (selectedArmor != null) {
                if ( selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paraniz bulunmamaktadır !");
                }else{
                    System.out.println(selectedArmor.getName() + " Zirhini satin aldiniz !");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiye : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }

    }
}
