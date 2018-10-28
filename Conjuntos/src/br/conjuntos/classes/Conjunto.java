/**
 * 
 */
package br.conjuntos.classes;

/**
 * @author Danilo
 *
 */
public class Conjunto {
	 //Atributos
    private int tamanho = 0;
    private int indiceDeUso = 0;
    private int[] array = null;
    
    //Metodos
    public Conjunto(int tamanho)throws Exception{
        if(tamanho <=0) throw new Exception("Tamnho nao pode ser <= 0");
        array = new int[tamanho];
        this.tamanho = tamanho;
        indiceDeUso = 0;
    }
    public int getTamanho(){return tamanho;}
    public int getIndiceDeUso(){return indiceDeUso;}
    public int getElemento(int posicao)throws Exception{
        if(posicao < 0) throw new Exception("Posicao nao pode ser < 0");
        if(posicao >= indiceDeUso) throw new Exception("Posicao nao pode ser >= indice de Uso");
        return array[posicao];
    }
    public void setElemento(int elemento)throws Exception{
        if(tamanho == indiceDeUso) throw new Exception("Conjunto esta cheio");
        if(buscar(elemento)) throw new Exception("Elemento ja Existe");
        array[indiceDeUso] = elemento;
        indiceDeUso++;
    }
    public boolean buscar(int elemento){
        for(int pos = 0; pos < indiceDeUso; pos++){
            if(elemento == array[pos]) return true;
        }
        return false;
    }
    public String getConjunto(){
        String saida = "{ ";
        for(int pos=0; pos < indiceDeUso; pos++){
            saida = saida + array[pos];
            if(pos<indiceDeUso - 1) saida = saida + ", ";
        }
        saida = saida + "}";
        return saida;
    }
    public boolean eConjuntoVazio(){
        return (indiceDeUso == 0);
    }
    public Conjunto uniao(Conjunto objeto)throws Exception{
        try {
            int tamanhoConjuntoNovo = this.indiceDeUso + objeto.getIndiceDeUso();
            Conjunto aux = new Conjunto(tamanhoConjuntoNovo);
            for(int pos = 0; pos < indiceDeUso; pos++){
                aux.array[pos] = this.array[pos];
            }
            aux.indiceDeUso = this.indiceDeUso;
            for(int pos = 0; pos < objeto.getIndiceDeUso(); pos++ ){
                try {
                    aux.setElemento(objeto.array[pos]);
                } catch (Exception e) {
                }   
            }
            return aux;
        } catch (Exception erro) {
            throw erro;
        }
    }
    public Conjunto intersecao(Conjunto objeto)throws Exception{
        try {
           int tamanhoDoConjuntoNovo = this.indiceDeUso;
            if(objeto.indiceDeUso < this.indiceDeUso) 
                tamanhoDoConjuntoNovo = objeto.indiceDeUso;
            Conjunto aux = new Conjunto(tamanhoDoConjuntoNovo);
            for(int pos = 0; pos < this.indiceDeUso; pos++){
                if(objeto.buscar(this.array[pos])){
                    aux.array[aux.indiceDeUso] = this.array[pos];
                    aux.indiceDeUso++;
                }
            }
            return aux; 
        } catch (Exception erro) {
            throw erro;
        }
    }    
    public Conjunto diferenca(Conjunto objeto)throws Exception{
        try {
           int tamanhoDoConjuntoNovo = this.indiceDeUso;
            Conjunto aux = new Conjunto(tamanhoDoConjuntoNovo);
            for(int pos = 0; pos < this.indiceDeUso; pos++){
                if(!(objeto.buscar(this.array[pos]))){
                    aux.array[aux.indiceDeUso] = this.array[pos];
                    aux.indiceDeUso++;
                }
            }
            return aux; 
        } catch (Exception erro) {
            throw erro;
        }

    }
    public boolean eSubConjunto(Conjunto objeto) throws Exception {
    	try {
    		if(diferenca(objeto).eConjuntoVazio()) return true;
		} catch (Exception erro) {
			throw erro;
			
		}
    	return false;
    }
    
    public int amplitude (Conjunto objeto) throws Exception{
    	try {
    	int amplitude = 0;
    	int menor = objeto.array[0];
    	int maior = 0;
    	for (int pos = 0; pos < array.length; pos++) {
    		if(objeto.array[pos] > maior)
    		maior = objeto.array[pos];
    		if(objeto.array[pos] < menor)
    			menor = objeto.array[pos];
		}
    	amplitude = maior - menor;
    	return amplitude; 
    	}catch(Exception error) {
    		throw error;
    	}
    }
    public boolean identico(Conjunto objeto) throws Exception{
    	try {
			if(this.indiceDeUso == objeto.indiceDeUso)
				if(eSubConjunto(objeto))
				return true;
			return false;
		} catch (Exception error) {
    		throw error;
		}
    }
    
	public boolean disjunto(Conjunto objeto) throws Exception {
		try {

			if (this.indiceDeUso == objeto.indiceDeUso) {
				if (eSubConjunto(objeto))
					return true;

			}
			return false;
		} catch (Exception erro) {
			throw erro;
		}

	}
	
    public int escalar(Conjunto objeto)throws Exception{
    	try {
    		if(!(this.indiceDeUso == objeto.indiceDeUso))
    			throw new Exception("O tamanho dos conjuntos devem ser iguais");
    	int escalar = 0;
    	int valor = 0;
    	for (int pos = 0; pos < array.length; pos++) {
    		valor = array[pos] * objeto.array[pos];
    		escalar += valor;
		}
    	return escalar;
    	}catch (Exception error) {
    		throw error;
		}
    }
    
    public Conjunto subcadeiaConjuntoG(Conjunto objeto) throws Exception {
		try {

			int tamanhoDoConjuntoNovo = getIndiceDeUso();
			Conjunto crescente = new Conjunto(tamanhoDoConjuntoNovo);

			for (int pos = 0; pos < this.indiceDeUso; pos++) {
				crescente.setElemento(array[pos]);
			}
			for (int pos = 0; pos < crescente.indiceDeUso; pos++) {
				for (int prox = 0; prox < crescente.indiceDeUso - 1; prox++) {
					int aux = crescente.array[prox];
					if (crescente.array[prox] > crescente.array[prox + 1]) {
						crescente.array[prox] = crescente.array[prox + 1];
						crescente.array[prox + 1] = aux;
					}
				}
			}
			return crescente;

		} catch (Exception erro) {
			throw erro;
		}

	}
    
    public Conjunto subcadeiaConjuntoH(Conjunto objeto) throws Exception {
		try {

			int tamanhoDoConjuntoNovo = this.indiceDeUso + getIndiceDeUso();
			Conjunto decrescente = new Conjunto(tamanhoDoConjuntoNovo);

			for (int pos = 0; pos < this.indiceDeUso; pos++) {
				decrescente.setElemento(array[pos]);
			}
			for (int pos = 0; pos < decrescente.indiceDeUso; pos++) {
				for (int prox = 0; prox < decrescente.indiceDeUso - 1; prox++) {
					if (decrescente.array[prox] < decrescente.array[prox + 1]) {
						int tirar = decrescente.array[prox];
						decrescente.array[prox] = decrescente.array[prox + 1];
						decrescente.array[prox + 1] = tirar;
					}
				}
			}
			return decrescente;

		} catch (Exception erro) {
			throw erro;
		}

	}

	public Conjunto subcadeiaConjuntoAuniaoB(Conjunto objeto) throws Exception {
		try {

			int tamanhoDoConjuntoNovo = this.indiceDeUso + getIndiceDeUso();
			Conjunto crescente = new Conjunto(tamanhoDoConjuntoNovo);
			crescente = uniao(objeto).subcadeiaConjuntoG(objeto);

			return crescente;

		} catch (Exception erro) {
			throw erro;
		}
	}

	public float MediaConjuntos(Conjunto objeto) throws Exception {
		try {

			int tamanhoDoConjuntoNovo = this.indiceDeUso + objeto.getIndiceDeUso();
			Conjunto aux = new Conjunto(tamanhoDoConjuntoNovo);

			float media = 0;
			for (int pos = 0; pos < this.indiceDeUso; pos++) {
				aux.setElemento(array[pos]);
			}
			for (int pos = 0; pos < this.indiceDeUso; pos++) {
				tamanhoDoConjuntoNovo = aux.array[pos] + aux.array[pos + 1] / this.indiceDeUso;
				media += tamanhoDoConjuntoNovo;
				
			}
			
			return media;

		} catch (Exception erro) {
			throw erro;
		}

	}
	
	public Conjunto subCadeia() throws Exception{
		try {
		int tamanho = this.indiceDeUso;
		Conjunto a = new Conjunto(tamanho);
		int cadeia = 0;
		for (int pos = 0; pos < array.length; pos++) {
			a.setElemento(array[pos]);
		}
			for (int pos = 0; pos < array.length; pos++) {
				if(a.array[pos] < array[pos +1])
					cadeia = a.array[pos];
				else
					if(a.array[pos] < array[pos+1])
					cadeia = a.array[pos];
		}
		return a;
		}catch(Exception error) {
			throw error;
		}
	}

    
    
}
