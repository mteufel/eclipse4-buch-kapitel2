package net.teufel.e4.helloworld.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class ExitHandler {

	@Execute
	public void execute(IWorkbench workbench) {
		workbench.close();
	}
	
}
