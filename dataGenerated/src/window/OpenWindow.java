package window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class OpenWindow {

	private Shell shell;
	
	public static void main(String[] args){
		OpenWindow window = new OpenWindow();
		window.open();
	}
	
	private void open(){
		Display display = new Display();
		createContents();
		shell.open();
		shell.layout();
		while(!shell.dispose()){
			if(!){
				
			}
		}
	}
	
	private void createContents(){
		
	}
}
