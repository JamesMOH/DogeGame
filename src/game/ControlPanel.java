package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlPanel {
    public JPanel mainPanel;
    private JButton stopButton;
    private JButton playButton;
    private JButton quitButton;
    private JButton saveButton;
    private JButton loadButton;
    private Game game;

    public ControlPanel(Game game) {
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getLevel().start();
                Game.getTimer().start();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getLevel().stop();
                Game.getTimer().stop();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SaverLoader.save(Game.getLevel(),"data/savefile.txt");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameLevel level = SaverLoader.load(game,"data/savefile.txt");
                    game.setLevel(level);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}