package Commands;

import Game.GameController;

public class FileCommand implements ICommand {
    
    private GameController game = GameController.getInstance();

	
	@Override
	public void execute() {
		game.Save();
		}

	@Override
	public void unexecute() {
		game.Load();
		}
    
}
