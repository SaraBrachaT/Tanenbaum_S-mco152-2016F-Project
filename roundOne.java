import java.util.ArrayList;
import java.util.Scanner;

public class roundOne {
	

	public static void main(String[] args){
		Game game = new Game();
		
		Person placeHolder = new Person(null, null, 0, null, false, null, null, null);
		
		ArrayList<Restriction> r = new ArrayList();
		r.add(Restriction.Want_Head);
		Person a = new Person("Abba", "Levi", 30, Gender.MALE, true, r, null, placeHolder);
		System.out.println(a.toString());
		
		r = new ArrayList();
		Person b = new Person("Ima", "Levi", 29, Gender.FEMALE, true, null, null, a);
		a.setSpouse(b);
		System.out.println(b.toString());
		
		
		r = new ArrayList();
		r.add(Restriction.Not_Window);
		Person c = new Person("Mrs.", "Kar", 29, Gender.FEMALE, true, r, null, placeHolder);
		r = new ArrayList();
		r.add(Restriction.See_Abba);
		Person d = new Person("Mr.", "Kar", 32, Gender.MALE, true, r, null, c);
		d.setSpouse(c);
		
		r = new ArrayList();
		Person e = new Person("Mrs.", "Stein", 35, Gender.FEMALE, true, null, null, placeHolder);
		
		r = new ArrayList();
		Person f = new Person("Dr.", "Stein", 35, Gender.MALE, true, null, null, e);
		f.setSpouse(e);
		
		r = new ArrayList();
		Person g = new Person("Shloimy", "Stein", 4, Gender.MALE, false, null, null, null);
		
		r = new ArrayList();
		r.add(Restriction.Bro_Fight);
		Person h = new Person("Yitzy", "Stein", 8, Gender.MALE, false, r, null, null);
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
		System.out.println(f.toString());
		System.out.println(g.toString());
		System.out.println(h.toString());
		
		int solution1 = 12756834;
		int solution2 = 12584376;
		int solution3 = 16752834;
		int solution4 = 12856734;
		int solution5 = 12574386;
		int solution6 = 16852734;
		
		StringBuilder s = new StringBuilder();
		s.append("The table looks like this:");
		s.append("\n	Windows");
		s.append("\n	__ __ __");
		s.append("\n      __	__");
		s.append("\n	__ __ __");
		
		s.append("\nEnter the person # (Ex: Abba is 1) for each seat starting on the left (the head) and move clockwise. Do not put a space between numbers");
		
		System.out.println(s.toString());
		
		Scanner i = new Scanner(System.in);
		int answer = i.nextInt();
		if(answer == solution1 || answer == solution2 || answer == solution3 ||answer == solution4 || answer == solution5 || answer == solution6){
			System.out.println("You Won!");
		}
		else{
			System.out.println("Sorry, try again");
		}
	
		
				
		
		
	}
}
