package enemies;

import static helpz.Constants.Enemies.Sbl;

import managers.EnemyManager;
public class Sbl extends Enemy {

	public Sbl(float x, float y, int ID, EnemyManager en) {
		super(x, y, ID, Sbl, en);
	}

}