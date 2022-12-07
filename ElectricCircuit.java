//PROGRAMMER: JOHN PHAM
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class ElectricCircuit extends Application
{
    //INSTANCE  VARIABLES
    private final int WINDOW_WIDTH = 960;
    private final int WINDOW_HEIGHT = 540;
    private final int GRID_SPACING = 20;
    
    private GridPane windowPane;
    private Scene windowScene;
    
    private Label currentLabel;
    private TextField currentInput;
    private Label currentUnits;
    private Label voltageLabel;
    private TextField voltageInput;
    private Label voltageUnits;
    
    //CONSTRUCTORS
    public ElectricCircuit()
    {
        //column and row layout
        windowPane = new GridPane();
        windowPane.setAlignment(Pos.CENTER);
        windowPane.setHgap(GRID_SPACING);
        windowPane.setVgap(GRID_SPACING);
        
        //window content 
        windowScene = new Scene(windowPane, WINDOW_WIDTH, WINDOW_HEIGHT); 
        
        //row 1 components
        currentLabel = new Label("Current");
        currentInput = new TextField("0.5");
        currentUnits = new Label("Ampere");
        
        //row 2 components
        voltageLabel = new Label("Voltage");
        voltageInput = new TextField("5.0");
        voltageUnits = new Label("Volts");
        
        //Specify Components Column and Row
        windowPane.add(currentLabel, 0, 0);
        windowPane.add(currentInput, 1, 0);
        windowPane.add(currentUnits, 2, 0);
        windowPane.add(voltageLabel, 0, 1);
        windowPane.add(voltageInput, 1, 1);
        windowPane.add(voltageUnits, 2, 1);
    }   
    
    //INSTANCE METHODS
    @Override
    public void start(Stage windowStage)
    {
        windowStage.setScene(windowScene);
        windowStage.setTitle("ElectricCircuit");
        windowStage.show();
    }
}
