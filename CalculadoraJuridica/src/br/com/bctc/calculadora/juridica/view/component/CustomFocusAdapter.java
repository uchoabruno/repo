package br.com.bctc.calculadora.juridica.view.component;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.text.JTextComponent;

public class CustomFocusAdapter extends FocusAdapter{
	
	public CustomFocusAdapter() {
		super();
	}

	@Override
	public void focusGained(FocusEvent focusevent) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusLost(FocusEvent evt) {
		final JTextComponent comp = (JTextComponent) evt.getSource();

		try {
			Double.parseDouble(comp.getText());
		} catch (Exception e) {
			comp.setText("Este campo só aceita números.");
		}
	}

}
