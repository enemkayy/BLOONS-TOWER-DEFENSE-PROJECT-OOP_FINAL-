package enemies;

import static helpz.Constants.Enemies.Bbl;

import managers.EnemyManager;
public class Bbl extends Enemy {

	public Bbl(float x, float y, int ID, EnemyManager en) {
		super(x, y, ID, Bbl, en);
	}

}
