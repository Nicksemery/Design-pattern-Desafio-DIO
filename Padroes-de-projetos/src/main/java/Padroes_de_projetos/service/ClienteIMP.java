package Padroes_de_projetos.service;

import Padroes_de_projetos.model.Cliente;
import Padroes_de_projetos.repository.ClienteRepository;
import Padroes_de_projetos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteIMP implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private viaCepService viaCepService;




    @Override
    public Iterable<Cliente> buscartodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void salvar(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        enderecoRepository.findById(Long.valueOf(cep)).orElseGet(()->{
            return null;
        });
    }

    @Override
    public void alterar(Long id, Cliente cliente) {

    }

    @Override
    public void excluir(Long id) {

    }
}
