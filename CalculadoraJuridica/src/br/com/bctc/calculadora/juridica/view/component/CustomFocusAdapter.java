package br.com.bctc.calculadora.juridica.view.component;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.text.JTextComponent;

import br.com.bctc.calculadora.juridica.view.MainWindow;

public class CustomFocusAdapter extends FocusAdapter{
	
	public CustomFocusAdapter() {
		super();
	}

	@Override
	public void focusGained(FocusEvent focusevent) {

		final JTextComponent comp = (JTextComponent) focusevent.getSource();
		String txt = comp.getText();

		txt = txt.replace(",", ".");

		try {
			Double.parseDouble(txt);
			MainWindow.limpaErros();
		} catch (Exception e) {
			MainWindow.exibeErros(e.getMessage());
		}
	}

	@Override
	public void focusLost(FocusEvent evt) {

		final JTextComponent comp = (JTextComponent) evt.getSource();
		String txt = comp.getText();

		txt = txt.replace(",", ".");

		try {
			Double.parseDouble(txt);
			MainWindow.limpaErros();
		} catch (Exception e) {
			MainWindow.exibeErros("Este campo só aceita números.");
		}
	}

}
