package dados;

import classesNegocio.Pessoa;
import exceptions.PessoaJaCadastradaException;
import exceptions.PessoaNaoEncontradaException;

public class RepositorioPessoasArray implements RepositorioPessoas {
	private Pessoa[] pessoas;
	private int tamanho;

	public RepositorioPessoasArray() {
		pessoas = new Pessoa[100];
		tamanho = 0;
	}

	public void inserir(Pessoa pessoa) throws PessoaJaCadastradaException {

		if (!this.existe(pessoa.getCpf())) {
			this.pessoas[tamanho] = pessoa;
			if (this.tamanho >= this.pessoas.length - 1) {
				Pessoa[] pessoasNovo = new Pessoa[2 * this.pessoas.length];
				for (int i = 0; i < pessoasNovo.length; i++) {
					pessoasNovo[i] = this.pessoas[i];
				}
				this.pessoas = pessoasNovo;
			}
			this.tamanho++;
		} else {
			throw new PessoaJaCadastradaException();
		}
	}

	public void remover(String cpf) throws PessoaNaoEncontradaException {
		if (this.existe(cpf)) {
			this.pessoas[this.getIndice(cpf)] = this.pessoas[this.tamanho - 1];
			this.tamanho -= 1;
		} else {
			throw new PessoaNaoEncontradaException();
		}
	}

	public void atualizar(Pessoa pessoa, Pessoa pessoaAtualizado) throws PessoaNaoEncontradaException {
		this.pessoas[getIndice(pessoa.getCpf())] = pessoaAtualizado;
	}

	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
		return this.pessoas[this.getIndice(cpf)];
	}

	public boolean existe(String cpf) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.pessoas[i].getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	public int getIndice(String cpf) throws PessoaNaoEncontradaException {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.pessoas[i].getCpf().equals(cpf)) {
				return i;
			}
		}
		throw new PessoaNaoEncontradaException();
	}

	public Pessoa chamarProximo(String cpf) throws PessoaNaoEncontradaException {
		if (cpf.equals("")) {
			return this.pessoas[0];
		} else {
			int posicaoPessoa = this.getIndice(cpf);
			if (posicaoPessoa + 1 < this.tamanho) {
				return this.pessoas[posicaoPessoa + 1];
			} else {
				return null;
			}
		}
	}

}
