package Commands;

public class Controller {

    private ICommand command;
    
    public void setCommand(ICommand command) {
        this.command=command;
    }
    
    public void activateButton() {
        command.execute();
    }
    
    public void unactivateButton() {
        command.unexecute();
    }
    
}
