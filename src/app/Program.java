package app;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Veiculo carro = new Veiculo();
        List<Veiculo> lista = new ArrayList<>();

        System.out.print("Digite o total de Veículos na sua concessionária: ");
        int qtdVeiculo = Integer.parseInt(input.nextLine());

        for (int i = 0; i < qtdVeiculo; i++) {

            int id = i + 1;

            System.out.print("Modelo do Veículo: ");
            String modelo = input.nextLine();

            System.out.print("Marca do Veículo: ");
            String marca = input.nextLine();

            System.out.print("Placa do Veículo: ");
            String placa = input.nextLine().toUpperCase();

            System.out.print("Cor do Veículo: ");
            String cor = input.nextLine();

            System.out.println("Escolha a categoria do Veículo: ");
            System.out.println("1 -  NOVO");
            System.out.println("2 -  USADO");
            int opcao = Integer.parseInt(input.nextLine());

            String categoria = "";

            switch (opcao){
                case 1:
                    categoria = "novo";
                break;
                case 2:
                    categoria = "usado";
                break;
            }

            System.out.print("Estado de origem do Veículo: ");
            String localizacao = input.nextLine();

            System.out.print("Ano de Fabricação do Veículo: ");
            int anoFabricacao = Integer.parseInt(input.nextLine());

            System.out.print("Kilometragem do Veículo: ");
            int kilometragem = Integer.parseInt(input.nextLine());

            System.out.print("Valor do Veículo: ");
            double preco = Double.parseDouble(input.nextLine());

            System.out.print("Tipo do Veículo (ÁLCOOL OU GASOLINA): ");
            String tipo = input.nextLine().toUpperCase();

            carro = new Veiculo(id,modelo,marca,placa,cor,categoria,localizacao,anoFabricacao,kilometragem,preco,tipo);

            lista.add(carro);
        }

        char continuar;

        do {

            System.out.println("Digite S para entrar no sistema de estacionamento");
            System.out.println("Digite N para encerrar");

            System.out.println("Escolha uma das opções: ");
            continuar = input.nextLine().toUpperCase().charAt(0);

            if(continuar != 'N' && continuar == 'S') {

                System.out.println("DADOS DE VEICULOS DO ESTACIONAMENTO: ");
                System.out.println("DIGITE 1 -> CONSULTAR"); // READ
                System.out.println("DIGITE 2 -> FILTRAR POR ID "); // CONSULTAR
                System.out.println("DIGITE 3 -> ATUALIZAR"); // UPDATE
                System.out.println("DIGITE 4 -> DELETAR"); // DELETE

                System.out.print("Digite o código do filtro que você deseja: ");
                int codigo = Integer.parseInt(input.nextLine());

                switch(codigo) {

                    case 1:
                        System.out.println("CONSULTA DE VEÍCULOS:\n");
                        carro.consultar(lista);
                        break;

                    case 2:
                        System.out.print("Digite o id do carro que você deseja encontrar: ");
                        int buscarId = input.nextInt();

                        Integer id = carro.findById(lista,buscarId);

                        if(id == null){
                            System.out.println("Id Inexistente!!!");
                        }
                        else{
                            System.out.println(lista.get(id));
                        }
                        break;

                    case 3:
                        System.out.print("Digite o id do carro que você deseja atualizar: ");
                        int findId = input.nextInt();

                        Integer update = carro.findById(lista,findId);

                        System.out.println("Novo valor do carro: ");
                        double preco = input.nextDouble();

                        if(update == null){
                            System.out.println("Id inválido!");
                        }
                        else{
                            lista.get(update).setPreco(preco);
                            System.out.println("Atualizado com Sucesso!");
                        }
                        break;

                    case 4:
                        System.out.println("Digite o Id do carro que você deseja deletar: ");
                        int delId = Integer.parseInt(input.nextLine());

                        carro.deleteById(lista,delId);
                        break;

                    default:
                        System.out.println("Código de Filtro Inválido");
                        break;
                }
            }
        }while(continuar != 'N');

        System.out.println("SISTEMA ENCERRADO!!!");
    }
}
