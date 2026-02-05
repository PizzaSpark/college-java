public class printPlanet {
	public static void main(String[] args) {

		String[] planet = {
				"Mercury",
				"Venus",
				"Mars",
				"Earth",
				"Jupiter",
				"Saturn",
				"Uranus",
				"Neptune",
				"Pluto"
		};

		for (int i = 0; i < planet.length; i++) {
			System.out.print(planet[i] + " ");
		}
	}
}
