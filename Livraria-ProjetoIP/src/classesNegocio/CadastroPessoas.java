package classesNegocio;

import dados.RepositorioPessoas;
import exceptions.PessoaJaCadastradaException;
import exceptions.PessoaNaoEncontradaException;

public class CadastroPessoas {
	private RepositorioPessoas pessoas;
	
	public CadastroPessoas(RepositorioPessoas pessoas){
		this.pessoas = pessoas;
	}
	
	public void cadastrar(Pessoa pessoa) throws PessoaJaCadastradaException{
		if(!pessoas.existe(pessoa.getCpf())){
			pessoas.inserir(pessoa);
		}else{
			throw new PessoaJaCadastradaException();
		}
	}
	
	public void remover(String cpf) throws PessoaNaoEncontradaException{
			pessoas.remover(cpf);
	}
	
	public void atualizar(Pessoa pessoa, Pessoa pessoaAtualizada) throws PessoaNaoEncontradaException{
		if(pessoas.existe(pessoa.getCpf())){
			pessoas.atualizar(pessoa, pessoaAtualizada);
		}else{
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException{
		if(pessoas.existe(cpf)){
			return pessoas.procurar(cpf);
		}else{
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public Pessoa proximaPessoa(String cpf) throws PessoaNaoEncontradaException{
		return pessoas.chamarProximo(cpf);
	}
	
}
