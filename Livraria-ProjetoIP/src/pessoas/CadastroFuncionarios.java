package pessoas;

import dados.RepositorioFuncionarios;

public class CadastroFuncionarios {
	private RepositorioFuncionarios funcionarios;
	
	public CadastroFuncionarios(RepositorioFuncionarios funcionarios){
		this.funcionarios = funcionarios;
	}
	
	public void cadastrar(Funcionario funcionario) throws PessoaJaCadastradaException{
		if(!funcionarios.existe(funcionario.getCpf())){
			funcionarios.inserir(funcionario);
		}else{
			throw new PessoaJaCadastradaException();
		}
	}
	
	public void demitir(Funcionario funcionario) throws PessoaNaoEncontradaException{
		if(funcionarios.existe(funcionario.getCpf())){
			funcionarios.remover(funcionario);
		}else{
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public void atualizar(Funcionario funcionario, Funcionario funcionarioAtualizado) throws PessoaNaoEncontradaException{
		if(funcionarios.existe(funcionario.getCpf())){
			funcionarios.atualizar(funcionario, funcionarioAtualizado);
		}else{
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public Funcionario procurar(String cpf) throws PessoaNaoEncontradaException{
		if(funcionarios.existe(cpf)){
			return funcionarios.procurar(cpf);
		}else{
			throw new PessoaNaoEncontradaException();
		}
	}

}
