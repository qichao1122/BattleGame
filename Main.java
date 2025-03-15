import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("How many monsters would you like to battle? \n >> ");
        int numMonsters = userInputScanner.nextInt();

        Character[] monsterList = createMonsterList(numMonsters);

        for (int i = 0; i < numMonsters; i++) {
            monsterList[i].printStats();
            System.out.println();
        }

        Scanner kbScanner = new Scanner(System.in);
        System.out.println("Press ENTER to create a HERO...");
        kbScanner.nextLine();
        Character hero = new Character("Hero", 301);

        System.out.println("\nPress ENTER to begin the battle simulation...");
        kbScanner.nextLine();

        battleSimulation(hero, monsterList);
    }

    private static Character[] createMonsterList(int numMonsters) {
        Character[] monsterList = new Character[numMonsters];
        for (int i = 0; i < numMonsters; i++) {
            String monsterName = "MONSTER " + (i + 1);
            monsterList[i] = new Character(monsterName, 50);
        }
        return monsterList;
    }

    private static void battleSimulation(Character hero, Character[] monsterList) throws InterruptedException {
        while (hero.getHealthPoints() > 0 && !allMonstersDefeated(monsterList)) {
            for (Character monster : monsterList) {
                if (monster.getHealthPoints() > 0) {
                    hero.attack(monster);
                    Thread.sleep(2000);

                    if (monster.getHealthPoints() > 0) {
                        monster.attack(hero);
                        Thread.sleep(2000);
                    }

                    printCharacterStats(hero, monsterList);

                    if (hero.getHealthPoints() <= 0) {
                        System.out.println("The HERO has been defeated! GAME OVER!");
                        return;
                    }
                }
            }
        }

        if (hero.getHealthPoints() > 0) {
            System.out.println("VICTORY! The HERO has defeated all the monsters!");
        }
    }

    private static boolean allMonstersDefeated(Character[] monsterList) {
        for (Character monster : monsterList) {
            if (monster.getHealthPoints() > 0) {
                return false;
            }
        }
        return true;
    }

    private static void printCharacterStats(Character heroObj, Character[] monsterList) throws InterruptedException {
        System.out.println("\n --- CURRENT STATS --- \n");
        heroObj.printStats();
        System.out.println("-----------------------------------");

        for (Character monster : monsterList) {
            monster.printStats();
            System.out.println();
        }
    }
}
