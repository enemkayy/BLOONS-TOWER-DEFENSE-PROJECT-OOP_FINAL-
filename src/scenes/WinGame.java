package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Game;
import ui.MyButton;
import static main.GameStates.*;

public class WinGame extends GameScene implements SceneMethods {

    private MyButton bMenu;

    public WinGame(Game game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        int w = 200;
        int h = w / 4;
        int x = 640 / 2 - w / 2;
        int y = 300;

        bMenu = new MyButton("Menu", x, y, w, h);
    }

    @Override
    public void render(Graphics g) {
        // Background
        g.setColor(Color.black);
        g.fillRect(0, 0, 640, 800);

        // Win text
        g.setFont(new Font("LucidaSans", Font.BOLD, 50));
        g.setColor(Color.green);
        g.drawString("You Win!", 200, 150);

        g.setFont(new Font("LucidaSans", Font.BOLD, 25));
        g.drawString("Congratulations on defending successfully!", 70, 200);

        // Button
        g.setFont(new Font("LucidaSans", Font.BOLD, 20));
        bMenu.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            SetGameState(MENU);
            resetAll();
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);

        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);
    }

    @Override
    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();
    }

    @Override
    public void mouseDragged(int x, int y) {
        // Not needed for this scene
    }

    private void resetAll() {
        game.getPlaying().resetEverything();
    }
}
