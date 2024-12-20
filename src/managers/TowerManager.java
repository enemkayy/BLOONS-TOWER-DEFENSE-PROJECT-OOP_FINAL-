package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Enemy;
import helpz.Constants.Towers;
import helpz.LoadSave;
import objects.Tower;
import scenes.Playing;

import static helpz.Constants.Towers.*;

public class TowerManager {

	private Playing playing;
	private BufferedImage[] towerImgs;
	private BufferedImage[] monkeyImgs;
	private ArrayList<Tower> towers = new ArrayList<>();
	private int towerAmount = 0;

	public TowerManager(Playing playing) {
		this.playing = playing;

		loadTowerImgs();
		loadMonkeyImgs();
	}

	private void loadTowerImgs() {
		towerImgs = new BufferedImage[3];
		towerImgs[0] = LoadSave.getDartTower();
		towerImgs[1] = LoadSave.getNinjaTower();
		towerImgs[2] = LoadSave.getSuperTower();

	}

	private void loadMonkeyImgs() {
		monkeyImgs = new BufferedImage[3];
		monkeyImgs[0] = LoadSave.getDartMonkey();
		monkeyImgs[1] = LoadSave.getNinjaMonkey();
		monkeyImgs[2] = LoadSave.getSuperMonkey();
	}

	public void addTower(Tower selectedTower, int xPos, int yPos) {
		towers.add(new Tower(xPos, yPos, towerAmount++, selectedTower.getTowerType()));

	}
	
	public void removeTower(Tower displayedTower) {
		for (int i = 0; i < towers.size(); i++)
			if (towers.get(i).getId() == displayedTower.getId())
				towers.remove(i);
	}
	
	public void upgradeTower(Tower displayedTower) {
		for(Tower t : towers)
			if(t.getId() == displayedTower.getId())
				t.upgradeTower();
	}

	public void update() {
		for (Tower t : towers) {
			t.update();
			attackEnemyIfClose(t);
		}
	}

	private void attackEnemyIfClose(Tower t) {
		for (Enemy e : playing.getEnemyManager().getEnemies()) {
			if (e.isAlive())
				if (isEnemyInRange(t, e)) {
					if (t.isCoolDownOver()) {
						playing.shootEnemy(t, e);
						t.resetCooldown();
					}
				} else {
					// we do nothing

				}
		}

	}

	private boolean isEnemyInRange(Tower t, Enemy e) {
		int range = helpz.Utilz.GetHypoDistance(t.getX(), t.getY(), e.getX(), e.getY());
		return range < t.getRange();
	}

	public void draw(Graphics g) {
		for (Tower t : towers) {
			g.drawImage(towerImgs[t.getTowerType()], t.getX(), t.getY(), null);
			// g.drawImage(towerImgs[DART_TOWER], tower.getX(), tower.getY(), null);
		}
	}

	// Disable tower on tower placement
	public Tower getTowerAt(int x, int y) {

		for (Tower t : towers)
			if (t.getX() == x)
				if (t.getY() == y)
					return t;

		return null;
	}

	public BufferedImage[] getMonkeyImgs() {
		return monkeyImgs;
	}

	public BufferedImage[] getTowerImgs() {
		return towerImgs;
	}
	
	public void reset() {
		towers.clear();
		towerAmount = 0;
	}
}
