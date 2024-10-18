package br.itb.tcc.educai.model;

import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import jakarta.persistence.*;

import java.util.Objects;

import java.time.LocalDate;


@Entity
@Table(name ="Laudo")
public class Laudo {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_laudo;

@Column(nullable = false, length = 4)
    private String cod_cid;

@Column(nullable = false, length = 50)
    private String nome_laudo;

@Column(nullable = false, length = 150)
    private String obs_laudo;

@Column(nullable = false, length = 35)
    private String tipo_defic;

@Column(nullable = false, length = 10)
    private LocalDate data_laudo;

@Column(nullable = false, length = 5)
    private int rm_aluno;

@Column(nullable = false, length = 3)
    private int cod_prof;

    @Transient
    private String mensagemErro = "";

    @Transient
    private boolean isValid = true;


    //


    public Long getCod_laudo() {
        return cod_laudo;
    }

    public void setCod_laudo(Long cod_laudo) {
        this.cod_laudo = cod_laudo;
    }

    public String getCod_cid() {
        return cod_cid;
    }

    public void setCod_cid(String cod_cid) {
        this.cod_cid = cod_cid;
    }

    public String getNome_laudo() {
        return nome_laudo;
    }

    public void setNome_laudo(String nome_laudo) {
        this.nome_laudo = nome_laudo;
    }

    public String getObs_laudo() {
        return obs_laudo;
    }

    public void setObs_laudo(String obs_laudo) {
        this.obs_laudo = obs_laudo;
    }

    public String getTipo_defic() {
        return tipo_defic;
    }

    public void setTipo_defic(String tipo_defic) {
        this.tipo_defic = tipo_defic;
    }

    public LocalDate getData_laudo() {
        return data_laudo;
    }

    public void setData_laudo(LocalDate data_laudo) {
        this.data_laudo = data_laudo;
    }

    public int getRm_aluno() {
        return rm_aluno;
    }

    public void setRm_aluno(int rm_aluno) {
        this.rm_aluno = rm_aluno;
    }

    public int getCod_prof() {
        return cod_prof;
    }

    public void setCod_prof(int cod_prof) {
        this.cod_prof = cod_prof;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laudo laudo = (Laudo) o;
        return Objects.equals(cod_laudo, laudo.cod_laudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_laudo);
    }

    public boolean validarLaudo() {
        if (rm_aluno < 10000) {
            isValid = false;
            rm_aluno = 10000;
            mensagemErro += "O RM do aluno não pode ser menor do que 5 algarismos!";
        }

        if (cod_prof < 100) {
            isValid = false;
            cod_prof = 100;
            mensagemErro += "O código do professor não pode ser menor do que 3 algarismos!";
        }
        return isValid;
    }
}
