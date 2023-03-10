package concessionaria;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;


import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private List<Carro> carros;
    // Marca da qual a concessionária vende os carros
    private Marca marcaFranquia;
    // Fábrica de carros
    private FabricaFactory fabrica;
    
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, Marca marca, FabricaFactory fabrica) {
        this.nome = nome;        
        this.marcaFranquia = marca;
        this.fabrica = fabrica;
        carros = new ArrayList<>();
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }

    //Crie então na classe `Concessionaria` a opção de mudar a marca da franquia e faça os tratamentos necessários.
    public void mudarFranquia(Marca marca, FabricaFactory fabrica) {
        this.marcaFranquia = marca;
        this.fabrica = fabrica;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }
    
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {
        Carro carro = fabrica.criarCarro(marcaFranquia, categoria, cor);
        
        if (carro != null) {
            carro.produzir();
            carro.pintar();
            carro.liberarDocumentacao();
            carros.add(carro);
            return true;
        }
        else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}
