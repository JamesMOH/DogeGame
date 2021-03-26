package game;

import java.io.*;

/**
 * Defines the saving and loading functions for the game
 */
public class SaverLoader {
    /**
     * The save class takes the current level the player is on and the file the data will be written to
     * The file will be opened in append mode with the writer variable
     * The class will fetch the level name and the values for the player's coins and bonks
     * The values will be written to the file
     * The writer will be checked and the file will be closed if it has been opened
     * @param level
     * @param file
     * @throws IOException
     */
    public static void save(GameLevel level, String file) throws IOException {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, append);
            writer.write(level.getLevelName() + "," + Game.getSeconds() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * The load class will take the game and the name of the file that the save data was written to
     * The fr variable will be filled with the file that is being read from
     * The file's data will be read and the data will be split into multiple tokens
     * The level name is the first token while the coins and the bonks are the second and third tokens
     * The variable GameLevel is created to create a level that is being loaded
     * A level is started depending on which level name is returned
     * The parameters of the player are returned to their previous states
     * The level is returned and if the files were read and the tokens were split the file is closed
     * @param game
     * @param file
     * @return
     * @throws IOException
     */
    public static GameLevel load(Game game, String file) throws IOException{
                FileReader fr = null;
                BufferedReader reader = null;
                try {
                    System.out.println("Reading " + file + " ...");
                    fr = new FileReader(file);
                    reader = new BufferedReader(fr);
                    String line = reader.readLine();
                    String[] tokens = line.split(",");
                    String name = tokens[0];
                    int secondCount = Integer.parseInt(tokens[1]);
                    GameLevel level = null;
                    if (name.equals("Level1")){
                        level = new Level1(game);
                    } else if (name.equals("Level2")){
                        level = new Level2(game);
                    } else if (name.equals("Level3")){
                        level = new Level3(game);
                    }
                    //level.getDoge().setBonks(bonkCount);
                    //evel.getDoge().setCoin(coinCount);
                    Game.setSeconds(secondCount);
                    MyView.setMvseconds(secondCount);
                    return level;
                } finally {
                    if (reader != null) {
                        reader.close();
                    }
                    if (fr != null) {
                        fr.close();
                    }
                }
            }

}