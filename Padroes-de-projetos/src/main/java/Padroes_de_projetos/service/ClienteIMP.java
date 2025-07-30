package Padroes_de_projetos.service;

import Padroes_de_projetos.model.Cliente;
import Padroes_de_projetos.model.Endereco;
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
        salvarClientePorCep(cliente);
    }

    private void salvarClientePorCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(Long.valueOf(cep)).orElseGet(()->{
            Endereco novoEndereco = viaCepService.consultarCEP(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

    @Override
    public void alterar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBD = clienteRepository.findById(id);
        if (clienteBD.isPresent()) {
            salvarClientePorCep(cliente);
        }

    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
