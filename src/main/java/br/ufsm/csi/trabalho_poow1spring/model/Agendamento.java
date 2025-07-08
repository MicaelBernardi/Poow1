package br.ufsm.csi.trabalho_poow1spring.model;

import java.util.Date;

public class Agendamento {

    private Integer id;
    private Date data;
    private Funcionario funcionario;
    private Cliente cliente;
    private Servico servico;
    private String status;

    public Agendamento(Integer id, Date data, Funcionario funcionario, Cliente cliente, String status, Servico servico) {
        this.id = id;
        this.data = data;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.status = status;
        this.servico = servico;
    }

    public Agendamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
