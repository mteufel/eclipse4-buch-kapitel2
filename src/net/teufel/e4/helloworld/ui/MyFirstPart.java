package net.teufel.e4.helloworld.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MyFirstPart {

	private Text text;
	
	@Inject
	public MyFirstPart(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		text = new Text(composite, SWT.BORDER);
		Button datumButton = new Button(composite, SWT.NONE); 	
		datumButton.setText("Datum");
		datumButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText(new SimpleDateFormat ("dd.MM.yyyy").format(new Date()));
			}
		});
		Button zeitButton = new Button(composite, SWT.PUSH);
		zeitButton.setText("Zeit");
		zeitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		});
	}
	
	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new MyFirstPart(shell);
		shell.open();
		
		while ( !shell.isDisposed() ) {
			if( ! display.readAndDispatch() ) {
					display.sleep();
			}
		}
		
	}
}
