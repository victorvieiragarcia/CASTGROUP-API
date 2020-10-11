package castgroup.codejava.TesteREST.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Curso {
	private Integer codigo;
	private String descricao_do_assunto;
	private Date data_inicio;
	private Date data_termino;
	private Integer quantidade_alunos_turma;
	private Integer codigo_categoria;
	private Categoria categoria;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@NotNull
	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	@NotNull
	public Date getData_termino() {
		return data_termino;
	}

	public void setData_termino(Date data_termino) {
		this.data_termino = data_termino;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@NotNull
	public String getDescricao_do_assunto() {
		return descricao_do_assunto;
	}

	public void setDescricao_do_assunto(String descricao_do_assunto) {
		this.descricao_do_assunto = descricao_do_assunto;
	}

	public Integer getQuantidade_alunos_turma() {
		return quantidade_alunos_turma;
	}

	public void setQuantidade_alunos_turma(Integer quantidade_alunos_turma) {
		this.quantidade_alunos_turma = quantidade_alunos_turma;
	}

	@NotNull
	public Integer getCodigo_categoria() {
		return codigo_categoria;
	}

	public void setCodigo_categoria(Integer codigo_categoria) {
		this.codigo_categoria = codigo_categoria;
	}

	public Curso(Integer codigo, String descricao_do_assunto, Date data_inicio, Date data_termino, Integer quantidade_alunos_turma,
			Integer codigo_categoria) {
		this.codigo = codigo;
		this.descricao_do_assunto = descricao_do_assunto;
		this.data_inicio = data_inicio;
		this.data_termino = data_termino;
		this.quantidade_alunos_turma = quantidade_alunos_turma;
		this.codigo_categoria = codigo_categoria;
	}

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

}
