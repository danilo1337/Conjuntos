/**
 * 
 */
package br.conjuntos.interfaces;

import java.net.URL;
import java.util.ResourceBundle;

import br.conjuntos.classes.Conjunto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author Danilo
 *
 */
public class TelaController implements Initializable {

	@FXML
	private TextField tamConjA;

	@FXML
	private TextField tamConjB;

	@FXML
	private Button criarA;

	@FXML
	private Button criarB;

	@FXML
	private TextField incluirConjA;

	@FXML
	private Button incluirA;

	@FXML
	private TextField incluirConjB;

	@FXML
	private Button incluirB;

	@FXML
	private TextField elementosA;

	@FXML
	private Button aUniaoB;

	@FXML
	private Button aInterB;

	@FXML
	private Button aMenosB;

	@FXML
	private Button bMenosA;

	@FXML
	private TextField resultado;

	@FXML
	private TextField elementosB;
	
    @FXML
    private Button aSubB;

	Conjunto a = null;
	Conjunto b = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		elementosA.setDisable(true);
		elementosB.setDisable(true);
		incluirConjA.setDisable(true);
		incluirConjB.setDisable(true);
		incluirA.setDisable(true);
		incluirB.setDisable(true);
		aUniaoB.setDisable(true);
		aInterB.setDisable(true);
		aMenosB.setDisable(true);
		bMenosA.setDisable(true);
		resultado.setDisable(true);
	}

	@FXML
	private void botaoAUniaoB(ActionEvent event) {
		try {
			resultado.setText(a.uniao(b).getConjunto());
		} catch (Exception e) {
		}
	}

	@FXML
	private void botaoAInterB(ActionEvent event) {
		try {
			resultado.setText(a.intersecao(b).getConjunto());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void botaoAMenosB(ActionEvent event) {
		try {
			resultado.setText(a.diferenca(b).getConjunto());
		} catch (Exception e) {
		}
	}

	@FXML
	private void botaoBMenosA(ActionEvent event) {
		try {
			resultado.setText(b.diferenca(a).getConjunto());
		} catch (Exception e) {
		}
	}

	@FXML
	private void botaoCriarA(ActionEvent event) {
		try {
			if (tamConjA.getText().isEmpty())
				throw new Exception("Não é permitido fazer essa operação!");
			tamConjA.setDisable(true);
			criarA.setDisable(true);
			incluirA.setDisable(false);
			incluirConjA.setDisable(false);
			aUniaoB.setDisable(false);
			aInterB.setDisable(false);
			aMenosB.setDisable(false);
			bMenosA.setDisable(false);
			a = new Conjunto(Integer.parseInt(tamConjA.getText()));

		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
		}
	}

	@FXML
	private void botaoCriarB(ActionEvent event) {
		try {
			if (tamConjB.getText().isEmpty())
				throw new Exception("Não é permitido fazer essa operação!");
			tamConjB.setDisable(true);
			criarB.setDisable(true);
			incluirB.setDisable(false);
			incluirConjB.setDisable(false);
			aUniaoB.setDisable(false);
			aInterB.setDisable(false);
			aMenosB.setDisable(false);
			bMenosA.setDisable(false);
			b = new Conjunto(Integer.parseInt(tamConjB.getText()));

		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
		}
	}

	@FXML
	private void botaoIncluirA(ActionEvent event) {
		try {
			int elemento = Integer.parseInt(incluirConjA.getText());
			a.setElemento(elemento);
			elementosA.setText(elementosA.getText() + " " + String.valueOf(elemento));
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
		}
	}

	@FXML
	private void botaoIncluirB(ActionEvent event) {
		try {
			int elemento = Integer.parseInt(incluirConjB.getText());
			b.setElemento(elemento);
			elementosB.setText(elementosB.getText() + " " + String.valueOf(elemento));
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
		}
	}

    @FXML
    private void botaoASubB(ActionEvent event) {
    	try {
    		
    		String saida = ""+a.eSubConjunto(b);
    		resultado.setText(saida);
		} catch (Exception e) {
			//exeception
		}
    }
    
    @FXML
    private void botaoBSubA(ActionEvent event) {
    	try {
			String saida = ""+ b.eSubConjunto(a);
			resultado.setText(saida);
		} catch (Exception e) {
		}
    }
}
