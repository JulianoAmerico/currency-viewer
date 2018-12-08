package br.com.juliano.gui;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controls fields of fxml document.
 * 
 * @author Juliano R. Américo
 *
 */
public class ControllerViewer {

	@FXML
	TextField textFieldValue;

	@FXML
	ChoiceBox<String> choiceBoxLocale;

	@FXML
	Label labelResult;
	

	/**
	 * Initialize when load ViewerLayout.fxml.
	 */
	public void initialize() {
		loadLanguageCountry();
	}

	/**
	 * Load all locales of java.util.Locale to Choice Box.
	 */
	public void loadLanguageCountry() {
			
		List<String> locales = Stream.of(Locale.getAvailableLocales())
				.filter(e -> !e.getCountry().isEmpty())
				.map(e -> e.getLanguage() + "-" + e.getCountry())
				.sorted()
				.collect(Collectors.toList());
		
		choiceBoxLocale.setItems(FXCollections.observableArrayList(locales));
	
		choiceBoxLocale.getSelectionModel().select(0);
		
		choiceBoxLocale.valueProperty().addListener((e, ov, nv) -> formatCurrency());
		
		textFieldValue.textProperty().addListener((e, ov, nv) -> formatCurrency());
	}

	/**
	 * Format a number to locale currency. This method gets value from text field
	 * value and gets the selected item from choice box and formats to locale
	 * currency. The choice box defines the locale.
	 */
	public void formatCurrency() {
		String value = textFieldValue.getText();

		Locale locale = Locale.forLanguageTag(choiceBoxLocale.getSelectionModel().getSelectedItem());
		NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);

		try {
			labelResult.setText(formatter.format(Double.parseDouble(value)));
		} catch (Exception e) {
			textFieldValue.setText("");
		}
	}

}
