package br.com.alura.spring.data.principal;

import br.com.alura.spring.data.model.Fabricante;
import br.com.alura.spring.data.model.Produto;
import br.com.alura.spring.data.repository.FabricanteRepository;
import br.com.alura.spring.data.repository.ProdutoRepository;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Principal {
    private Boolean system = true;
    private Scanner scanner = new Scanner(System.in);
    private static ProdutoRepository produtoRepository;
    private static FabricanteRepository fabricanteRepository;

    public Principal(ProdutoRepository produtoRepository, FabricanteRepository fabricanteRepository) {
        this.produtoRepository = produtoRepository;
        this.fabricanteRepository = fabricanteRepository;
    }

    //Menu de Aplicação
    public void inicial() {
        while (system) {
            System.out.println("Escolha a opção desejada");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        var nomeDoProduto = scanner.next();
        System.out.println("Digite a descrição do produto:");
        var descricaoDoProduto = scanner.next();
        System.out.println("Digite o valor do produto:");
        var valorDoProduto = scanner.nextFloat();
        System.out.println("Digite o fabricante do produto:");
        var fabricanteDoProduto = scanner.next();
        Fabricante fabricante = new Fabricante(fabricanteDoProduto);
        fabricanteRepository.save(fabricante);
        Produto produto = new Produto(nomeDoProduto, descricaoDoProduto, valorDoProduto, fabricante);
        produtoRepository.save(produto);
        System.out.println("Produto cadastrado com sucesso.");
        inicial();
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Digite o ID do produto a ser alterado: ");
        var idDoProduto = scanner.nextInt();
        System.out.println("Digite a nova descrição do produto:");
        var descricaoDoProduto = scanner.next();
        Produto saved = produtoRepository.findById((long) idDoProduto).orElseThrow(NoSuchElementException::new);
        saved.setDescricao(descricaoDoProduto);
        produtoRepository.save(saved);
        System.out.println("Produto alterado com sucesso");
        inicial();
    }

    private void visualizar() {
        System.out.println("Produtos cadastrados:");
        List<Produto> todos = produtoRepository.findAll();
        todos.forEach(p2 -> System.out.println(p2.toString()));
        inicial();
    }

    private void deletar(Scanner scanner) {
        System.out.print("Digite o ID do produto a ser deletado: ");
        var idDoProduto = scanner.nextInt();
        produtoRepository.deleteById((long) idDoProduto);
        System.out.println("Produto excluido com sucesso");
        inicial();
    }
}
