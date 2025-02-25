package com.generation.blogpessoal.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity						   // Indica que a Classe é uma Tabela.
@Table (name = "tb_postagens") // Indica o nome da Tabela no Banco de Dados.
public class Postagem {
		
		@Id // É a Chave Primária (PRIMARY KEY).
		@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Incremento (AUTO_INCREMENT).
		private Long id;
		
		@NotBlank(message = "O atributo título é Obrigatório!") // Indica que o Campo é Obrigatório a digitação de um Título
		@Size(min = 5, max = 100, message = "Digite no mínimo 5 e no máximo 100 caracteres")
		private String titulo; 
		
		@NotBlank(message = "O atributo texto é Obrigatório!") // Indica que o Campo é Obrigatório a digitação de um Texto
		@Size(min = 10, max = 1000, message = "Digite no mínimo 10 e no máximo 1000 caracteres")
		private String texto;
		
		@UpdateTimestamp
		private LocalDateTime data; //10/10/25 18:25:58
		
		@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Tema tema;
		
		@ManyToOne
		@JsonIgnoreProperties("postagem")
		private Usuario usuario;
		
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		} 
		
		public String getTitulo() {
			return titulo;
		}
		
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		public String getTexto() {
			return texto;
		}
		
		public void setTexto(String texto) {
			this.texto = texto;
		}
	
		public LocalDateTime getData() {
			return data;
		}
		
		public void setData(LocalDateTime data) {
			this.data = data;
		}

		public Tema getTema() {
			return tema;
		}

		public void setTema(Tema tema) {
			this.tema = tema;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		
}

