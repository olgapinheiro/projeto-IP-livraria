package dados;

import classesNegocio.Pessoa;
import exceptions.PessoaJaCadastradaException;
import exceptions.PessoaNaoEncontradaException;

public class RepositorioPessoasTAD implements RepositorioPessoas {
	private Pessoa pessoa;
	private RepositorioPessoasTAD proximo;

	public RepositorioPessoasTAD() {
		this.pessoa = null;
		this.proximo = null;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public RepositorioPessoasTAD getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioPessoasTAD proximo) {
		this.proximo = proximo;
	}

	public void inserir(Pessoa pessoa) throws PessoaJaCadastradaException {
		if (!this.existe(pessoa.getCpf())) {
			if (this.proximo == null) {
				this.pessoa = pessoa;
				this.proximo = new RepositorioPessoasTAD();
			} else {
				this.proximo.inserir(pessoa);
			}
		} else {
			throw new PessoaJaCadastradaException();
		}
	}

	public void remover(String cpf) throws PessoaNaoEncontradaException {
		Pessoa pessoa = this.procurar(cpf);
		if (this.existe(cpf)) {
			if (this.pessoa.equals(pessoa)) {
				this.pessoa = this.proximo.pessoa;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cpf);
			}
		} else {
			throw new PessoaNaoEncontradaException();
		}
	}

	public void atualizar(Pessoa pessoa, Pessoa pessoaAtualizado) throws PessoaNaoEncontradaException {
		if (this.existe(pessoa.getCpf())) {
			if (this.pessoa.equals(pessoa)) {
				this.pessoa = pessoaAtualizado;
			} else {
				this.proximo.atualizar(pessoa, pessoaAtualizado);
			}
		} else {
			throw new PessoaNaoEncontradaException();
		}
	}

	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
		if (this.existe(cpf)) {
			if (this.pessoa.getCpf().equals(cpf)) {
				return this.pessoa;
			} else {
				return this.proximo.procurar(cpf);
			}
		} else {
			throw new PessoaNaoEncontradaException();
		}
	}

	public boolean existe(String cpf) {
		boolean achou = false;
		if (this.pessoa != null) {
			if (this.pessoa.getCpf().equals(cpf)) {
				achou = true;
			} else {
				this.proximo.existe(cpf);
			}
		}
		return achou;
	}

	public Pessoa chamarProximo(String cpf) throws PessoaNaoEncontradaException{
		if (cpf.equals("")) {
			return this.pessoa;
		} else {
			if (this.proximo.pessoa == null) {
				return null;
			} else if (this.pessoa.getCpf().equals(cpf)) {
				return this.proximo.pessoa;
			} else {
				return this.proximo.chamarProximo(pessoa.getCpf());
			}
		}
	}

}
