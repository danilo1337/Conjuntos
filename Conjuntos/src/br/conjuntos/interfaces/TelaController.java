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
    
    @FXML
    private Button bSubA;
    
    
    @FXML
    private Button amplitude;
    
    @FXML
    private Button escalar;
    
    @FXML
    private Button dijunto;
    
    @FXML
    private Button identicos;
    
    @FXML
    private Button conjuntoG;
    
    @FXML
    private Button conjuntoH;
    
    @FXML
    private Button subcadeia;
    
    @FXML
    private Button media;
	Conjunto a = null;
	Conjunto b = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		desabilitarBotoes(true);
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
				throw new Exception("Não é permitido fazer operação");
			tamConjA.setDisable(true);
			criarA.setDisable(true);
			desabilitarBotoes(false);
			
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
				throw new Exception("Não é permitido fazer operação");
			tamConjB.setDisable(true);
			criarB.setDisable(true);
			desabilitarBotoes(false);
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
			e.getMessage();
		}
    }
    @FXML
    private void botaoAmplitude(ActionEvent event) {
    	try {
    	String saida = ""+ a.amplitude(b);
    	resultado.setText(saida);
    	}catch(Exception e) {
    		e.getMessage();
    	} 
    }
    
    @FXML
    private void botaoEscalar(ActionEvent event) {
    	try {
    	String saida = ""+ a.escalar(b);
    	resultado.setText(saida);
    	}catch(Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
    	} 
    }
    
    @FXML
    private void botaoIdenticos(ActionEvent event) {
    	try {
    	String saida = ""+ a.identico(b);
    	resultado.setText(saida);
    	}catch(Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
    	} 
    }
    
    @FXML
    private void botaoDijunto(ActionEvent event) {
    	try {
    	String saida = ""+ a.disjunto(b);
    	resultado.setText(saida);
    	}catch(Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
    	} 
    }
    
    @FXML
    private void botaoConjuntoG(ActionEvent event) {
    	try {
    	String saida = ""+ a.subcadeiaConjuntoG(a).getConjunto();
    	resultado.setText(saida);
    	}catch(Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
    	} 
    }
    
    @FXML
    private void botaoConjuntoH(ActionEvent event) {
    	try {
    	String saida = ""+ b.subcadeiaConjuntoH(b).getConjunto();
    	resultado.setText(saida);
    	}catch(Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
    	} 
    }
    
    @FXML
    private void botaoSubCadeia(ActionEvent event) {
    	try {
    	String saida = ""+ a.subcadeiaConjuntoAuniaoB(b).getConjunto();
    	resultado.setText(saida);
    	}catch(Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
    	} 
    }
    
    @FXML
    private void botaoMedia(ActionEvent event) {
    	try {
    	String saida = ""+ a.MediaConjuntos(b);
    	resultado.setText(saida);
    	}catch(Exception e) {
			Alert a = new Alert(AlertType.ERROR, e.getMessage());
			a.show();
    	} 
    }
    
    //desabilitar e habilitarbotoes da interface
    public void desabilitarBotoes(Boolean valor) {
    	elementosA.setDisable(valor);
		elementosB.setDisable(valor);
		incluirConjA.setDisable(valor);
		incluirConjB.setDisable(valor);
		incluirA.setDisable(valor);
		incluirB.setDisable(valor);
		aUniaoB.setDisable(valor);
		aInterB.setDisable(valor);
		aMenosB.setDisable(valor);
		bMenosA.setDisable(valor);
		resultado.setDisable(valor);
		aSubB.setDisable(valor);
		bSubA.setDisable(valor);
		identicos.setDisable(valor);
		amplitude.setDisable(valor);
		conjuntoG.setDisable(valor);
		conjuntoH.setDisable(valor);
		subcadeia.setDisable(valor);
		media.setDisable(valor);
		dijunto.setDisable(valor);
		escalar.setDisable(valor);
    }
}
