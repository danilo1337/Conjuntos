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
        if(tamanho <=0) throw new Exception("Tamnho não pode ser <= 0");
        array = new int[tamanho];
        this.tamanho = tamanho;
        indiceDeUso = 0;
    }
    public int getTamanho(){return tamanho;}
    public int getIndiceDeUso(){return indiceDeUso;}
    public int getElemento(int posicao)throws Exception{
        if(posicao < 0) throw new Exception("Posicao não pode ser < 0");
        if(posicao >= indiceDeUso) throw new Exception("Posicao não pode ser >= índice de Uso");
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
    
    
}
