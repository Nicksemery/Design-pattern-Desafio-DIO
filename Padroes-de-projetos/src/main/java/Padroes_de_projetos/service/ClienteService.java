package Padroes_de_projetos.service;

import Padroes_de_projetos.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscartodos();
    Cliente buscarPorId(Long id);

    void salvar(Cliente cliente);
    void alterar(Long id ,Cliente cliente);
    void excluir(Long id);

}
