package helpz;

public class Constants {

	public static class Direction {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class Enemies {
		public static final int Rbl = 0;
		public static final int Bbl = 1;
		public static final int Pbl = 2;
		public static final int Sbl = 3;

		public static int GetReward(int enemyType) {
			switch (enemyType) {
			case Rbl:
				return 5;
			case Bbl:
				return 5;
			case Pbl:
				return 10;
			case Sbl:
				return 25;
			}
			return 0;
		}

		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
			case Rbl:
				return 0.8f;
			case Bbl:
				return 0.9f;
			case Pbl:
				return 1f;
			case Sbl:
				return 1.3f;
			}
			return 0;
		}

		public static int GetStartHealth(int enemyType) {
			switch (enemyType) {
			case Rbl:
				return 10;
			case Bbl:
				return 20;
			case Pbl:
				return 100;
			case Sbl:
				return 40;

			}

			return 0;
		}
	}

	public static class Tiles {
		public static final int WATER_TILE = 0;
		public static final int GRASS_TILE = 1;
		public static final int ROAD_TILE = 2;
	}

	public static class Projectiles {
		public static final int DART = 0;
		public static final int SHURIKEN = 1;
		public static final int BOMB = 2;

		public static float GetSpeed(int type) {
			switch (type) {
			case DART:
				return 7f;
			case SHURIKEN:
				return 6f;
			case BOMB:
				return 4f;
			}
			return 0f;
		}
	}

	public static class Towers {
		public static final int DART_TOWER = 0;
		public static final int NINJA_TOWER = 1;
		public static final int SUPER_TOWER = 2;

		public static int GetTowerCost(int towerType) {
			switch (towerType) {
			case DART_TOWER:
				return 30;
			case NINJA_TOWER:
				return 45;
			case SUPER_TOWER:
				return 60;
			}
			return 0;
		}

		public static String GetName(int towerType) {
			switch (towerType) {
			case DART_TOWER:
				return "Dart Monkey";
			case NINJA_TOWER:
				return "Ninja Monkey";
			case SUPER_TOWER:
				return "Super Monkey";
			}
			return "";
		}

		public static int GetStartDmg(int towerType) {
			switch (towerType) {
			case DART_TOWER:
				return 5;
			case NINJA_TOWER:
				return 5;
			case SUPER_TOWER:
				return 10;
			}

			return 0;
		}

		public static float GetDefaultRange(int towerType) {
			switch (towerType) {
			case DART_TOWER:
				return 100;
			case NINJA_TOWER:
				return 100;
			case SUPER_TOWER:
				return 100;
			}

			return 0;
		}

		public static float GetDefaultCooldown(int towerType) {
			switch (towerType) {
			case DART_TOWER:
				return 50;
			case NINJA_TOWER:
				return 65;
			case SUPER_TOWER:
				return 80;
			}

			return 0;
		}
	}

	public static class Monkeys {
		public static final int DART_MONKEY = 0;
		public static final int NINJA_MONKEY = 1;
		public static final int SUPER_MONKEY = 2;
	}

}
