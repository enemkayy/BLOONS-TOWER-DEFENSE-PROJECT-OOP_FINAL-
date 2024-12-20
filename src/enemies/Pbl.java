package enemies;
import static helpz.Constants.Enemies.Pbl;

import managers.EnemyManager;

public class Pbl extends Enemy{

	public Pbl(float x, float y, int ID, EnemyManager en) {
		super(x, y, ID, Pbl, en);
	}

}
