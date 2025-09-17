package br.edu.iffarroupilha.autocentersb.controller;

import br.edu.iffarroupilha.autocentersb.model.Cliente;
import br.edu.iffarroupilha.autocentersb.model.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private ClienteService servico;

    public ClienteController(ClienteService servico) {
        this.servico = servico;
    }


    @GetMapping("clientes")
    public String teste(){

        Cliente cliente = new Cliente();
        cliente.setNome("Pedro");
        cliente.setCpf(123456789);
        servico.salvar(cliente);
        return "Funcionou a api e o id gerado" + cliente.getIdCliente();
    }

    @GetMapping("list")
    public List<Cliente> listarCliente(){
        return servico.buscarTodos();
    }
}
