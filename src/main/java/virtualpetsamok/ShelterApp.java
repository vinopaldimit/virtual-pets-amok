package virtualpetsamok;

import java.util.Scanner;

public class ShelterApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Shelter shelter = new Shelter();
		
		shelter.addPet(new VirtualCat("Bob", "Fluffy cat, very cute.", shelter.getBox()));
		shelter.addPet(new VirtualCat("Demon", "Definitely evil.", shelter.getBox()));
		shelter.addPet(new VirtualDog("Ben", "Fluffy little puppy!"));
		shelter.addPet(new VirtualDog("Cheddar", "A big happy dog."));
		shelter.addPet(new RobotPet("Martin","A very talkative robot cat.","Cat"));
		shelter.addPet(new RobotPet("Lemon","Glowing yellow eyes.","Cat"));
		shelter.addPet(new RobotPet("Ms. Marshmallow m300","A quiet robot who follows you around.","Dog"));
		
		String userChoice;
		do {
			System.out.println();
			for(VirtualPet pet: shelter.getPets() ) {
				System.out.println(pet.toString());
			}
			System.out.println("Litter Box Full: " + shelter.getBox().getFull());
			
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. feed\n2. water\n3. clean box\n4. clean cage\n5. play\n6. walk\n7. oil\n8. quit");
			userChoice = in.nextLine();
			
			switch(userChoice) {
			case "1":
				System.out.println("You feed all the pets that eat!");
				shelter.feedAll();
				break;
			case "2":
				System.out.println("You water all the pets that drink!");
				shelter.waterAll();
				break;
			case "3":
				System.out.println("You clean the box!");
				shelter.cleanBox();
				break;
			case "4":
				System.out.println("Which dog's cage?");
				String dogCage = in.nextLine();
				System.out.println("You clean the cage!");
				shelter.cleanACage(dogCage);
				break;
			case "5":
				System.out.println("Which pet?");
				String playName = in.nextLine();
				System.out.println("You play!");
				shelter.playWithPet(playName);
				break;
			case "6":
				System.out.println("You walk all the pets that go on walks!");
				shelter.walkAll();
				break;
			case "7":
				System.out.println("You oil all of the robot pets!");
				shelter.oilAll();
				break;
			case "8":
				System.out.println("Bye!");
				break;
			default:
				System.out.println("I didn't understand that.");
				break;	
			}
			
			tickAll(shelter);
			
			userChoice = checkIfShutDown(shelter, userChoice);
			
		}while(!userChoice.equals("8"));
		in.close();
	}

	private static void tickAll(Shelter shelter) {
		for(VirtualPet pet: shelter.getPets() ) {
			if(pet instanceof VirtualCat) {
				((VirtualCat)pet).tick(1);
			}
			if(pet instanceof VirtualDog) {
				((VirtualDog)pet).tick(1);
			}
			if(pet instanceof RobotPet) {
				((RobotPet)pet).tick(1);
			}
		}
	}

	private static String checkIfShutDown(Shelter shelter, String userChoice) {
		int unhealthyPetCount = 0;
		for(VirtualPet pet: shelter.getPets() ) {
			if(pet.getHealth()<10) {
				unhealthyPetCount++;
			}
		}
		if(unhealthyPetCount>4) {
			System.out.println("You aren't taking care of your pets! \nThe shelter got shut down.");
			userChoice = "8";
		}
		return userChoice;
	}

}
